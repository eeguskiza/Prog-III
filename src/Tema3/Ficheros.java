package Tema3;

import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;

public class Ficheros {

    /**
     * clase File, que es un objeto de este tipò y sus metodos mas comunes
     */
    public static void claseFile() {
        // File es un objeto que representa un fichero o directorio
        File archivo = new File("fichero.txt");

        // Intenta crear el archivo si no existe
        try {
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName());
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error.");
            e.printStackTrace();
        }

        // Muestra información sobre el archivo
        System.out.println("Nombre del archivo: " + archivo.getName());
        System.out.println("Ruta absoluta: " + archivo.getAbsolutePath());
        System.out.println("URI del archivo: " + archivo.toURI());

        // Verifica si el archivo existe, si es un directorio o un archivo regular
        System.out.println("Existe: " + archivo.exists());
        System.out.println("Es un directorio: " + archivo.isDirectory());
        System.out.println("Es un archivo: " + archivo.isFile());

        // Otros métodos útiles
        System.out.println("Oculto: " + archivo.isHidden());
        System.out.println("Última modificación: " + archivo.lastModified());
        System.out.println("Tamaño (bytes): " + archivo.length());

        // Para listar archivos (si es un directorio)
        if (archivo.isDirectory()) {
            String[] archivos = archivo.list(); // Aquí podrías aplicar un filtro
            for (String nombreArchivo : archivos) {
                System.out.println(nombreArchivo);
            }
        }

        // Renombrar o eliminar archivos
        // File nuevoArchivo = new File("nuevo_nombre.txt");
        // archivo.renameTo(nuevoArchivo);
        // archivo.delete(); // ¡Cuidado! Esto eliminará el archivo permanentemente

        // Crear un directorio
        // File directorio = new File("nuevo_directorio");
        // directorio.mkdir(); // Crea un solo directorio
        // directorio.mkdirs(); // Crea directorios anidados si es necesario
    }

    public static void ejemploIO() {
        String inputPath = "input.txt"; // Define la ruta del archivo de entrada --> Escibe algo aqui para ver como cambia
        String outputPath = "output.txt"; // Define la ruta del archivo de salida

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath)); // Crea un BufferedReader para leer el archivo
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) { // Crea un BufferedWriter para escribir en el archivo

            String line;
            while ((line = reader.readLine()) != null) { // Lee el archivo línea por línea
                writer.write(line); // Escribe la línea leída en el archivo de salida
                writer.newLine(); // Añade un salto de línea después de cada línea escrita
            }
        } catch (IOException e) {
            e.printStackTrace(); // Maneja cualquier excepción de E/S
        }
    }

    public static void ejemploNIO() {
        String inputPath = "input.txt"; // Define la ruta del archivo de entrada --> Escibe algo aqui para ver como cambia
        String outputPath = "output.txt"; // Define la ruta del archivo de salida

        try {
            List<String> lines = Files.readAllLines(Paths.get(inputPath)); // Lee todas las líneas del archivo de entrada de una vez
            Files.write(Paths.get(outputPath), lines); // Escribe todas las líneas en el archivo de salida de una vez
        } catch (IOException e) {
            e.printStackTrace(); // Maneja cualquier excepción de E/S
        }
    }

        /*
        *33. VAYA NUMERIN
        * En resumen, la clase File es útil para crear, renombrar, eliminar y obtener información sobre archivos y directorios.
        * Nio es útil para leer y escribir archivos de una manera más concisa.
        * Io es útil para leer y escribir archivos de una manera más tradicional.
        * Su uso depende de la situación y de las preferencias personales.
        * Usaremos IO para trabajos sencillos o que necesitemos un control detallado linea por linea.
        * Usaremos NIO para trabajos mas complejos que requieran trabajar con ficheros muy grandes.
         */


/*
* 1. En el main descomenta el metodo que quieras llamar.
 */

    public static void main(String[] args) {
        //claseFile();
        //ejemploIO();
        //ejemploNIO();
    }
}





