package Tema3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FicherosTexto {
    /*
    *Este ejemplo es similar al anterior, pero en lugar de escribir un objeto, escribe texto en un archivo.
    *Una vez seleccionado el archivo, se abre un FileWriter en ese archivo, y se usa para escribir una cadena de texto en el archivo.
    *Al igual que en el ejemplo anterior, se muestra un mensaje de éxito una vez que se ha escrito el texto, o un mensaje de error si ocurre una excepción.
     */
    public static void escribirFichero(String nomFic, List<Persona> listaPersonas) {
        try (BufferedWriter brFich = new BufferedWriter(new FileWriter(new File(nomFic)))) {
            for (Persona persona : listaPersonas) {
                // Formato: nombre,apellido,edad
                String linea = persona.getNombre() + "," + persona.getApellido() + "," + persona.getEdad();
                brFich.write(linea);
                brFich.newLine(); // Para separar cada persona en una nueva línea
            }
            System.out.println("Archivo escrito correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo.");
            e.printStackTrace();
        }
    }

    /*
    *Este ejemplo es similar al anterior, pero en lugar de leer un objeto, lee texto de un archivo.
    *Una vez seleccionado el archivo, se abre un FileReader en ese archivo, y se usa un BufferedReader para leer el contenido del archivo línea por línea.
    *Al igual que en el ejemplo anterior, se muestra un mensaje de éxito una vez que se ha leído todo el texto, o un mensaje de error si ocurre una excepción.
     */

    public static void leerFichero(String ruta){
        File archivo = new File(ruta);
        try {
            FileReader reader = new FileReader(archivo);//Arriba el proceso de el buffer esta en una sola linea compacto.
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] partes = line.split(",");
                String nombre = partes[0];
                String apellido = partes[1];
                int edad = Integer.parseInt(partes[2]);
                Persona usuario = new Persona(nombre, apellido, edad);
                System.out.println(usuario); // Imprime el objeto usuario
            }
            reader.close();
            System.out.println("Archivo leído correctamente.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
    }

    public static void main(String[] args) {
        List<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("Juan", "Perez", 20));
        listaPersonas.add(new Persona("Ana", "Garcia", 30));
        //escribirFichero("src/Recursos/personas.txt", listaPersonas);
        //leerFichero("src/Recursos/personas.txt");
    }
}
