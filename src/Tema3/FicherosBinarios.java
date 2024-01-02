package Tema3;

import javax.swing.*;
import java.io.*;
import java.util.logging.Logger;

/*
Para leer un archivo en Java, puedes usar varias clases como:
FileReader, BufferedReader, FileInputStream, ObjectInputStream, etc.
Dependiendo del tipo de datos que quieras leer (texto, bytes, objetos, etc.), utilizarás diferentes clases.
 */

//Ficheros binarios, normalmente utilizada para almacenar objetos. --> UTILIZAREMOS data.dat
public class FicherosBinarios{
    protected static Logger logger = Logger.getLogger(FicherosBinarios.class.getName());
    //ESCRITURA DE FICHEROS BINARIOS
    /*
    En este ejemplo, un JFileChooser se utiliza para permitir al usuario seleccionar un archivo para guardar.
    Si el usuario selecciona un archivo y hace clic en el botón "Guardar", se intenta escribir un objeto en ese archivo.
    El objeto se escribe utilizando un ObjectOutputStream que se construye a partir de un FileOutputStream del archivo seleccionado.
    Una vez escrito el objeto, se cierran los flujos y se muestra un mensaje de éxito.
    Si ocurre una excepción durante este proceso, como una IOException, se muestra un mensaje de error.
     */
    public static void escribirObjeto(Persona persona) {
        JFileChooser fileChooser = new JFileChooser(); //FIlechoser no es necesario pero queda bien.
        int resultado = fileChooser.showSaveDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            try (FileOutputStream fileOut = new FileOutputStream(archivo);
                 ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(persona);
                logger.info(String.format("Datos guardados en el fichero '%s'", archivo.getName()));
            } catch (IOException i) {
                logger.warning(String.format("Error al guardar datos en el fichero '%s'", archivo.getName()));
            }
        }
    }

    //LECTURA DE FICHEROS BINARIOS
    /*
El objeto se lee utilizando un ObjectInputStream que se construye a partir de un FileInputStream del archivo seleccionado.
Una vez leído el objeto, se cierran los flujos y se muestra un mensaje de éxito.
Si ocurre una excepción durante este proceso, como una IOException o una ClassNotFoundException (qué ocurre si la clase del objeto que se está leyendo no se encuentra), se muestra un mensaje de error.
 */
    public static void leerObjeto() {
        File archivo = new File("src/Recursos/datos.dat");
        try (FileInputStream fileIn = new FileInputStream(archivo);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            Persona persona = (Persona) in.readObject();
            //Aqui se podria meter logica qu elo añada a un Mapa, Array o lo que sea.
            logger.info(String.format("Datos leídos del fichero '%s'", archivo.getName()));
            System.out.printf("Nombre: %s\nApellido: %s\nEdad: %d\n", persona.getNombre(), persona.getApellido(), persona.getEdad());
        } catch (IOException i) {
            logger.warning(String.format("Error al leer datos del fichero '%s'", archivo.getName()));
        } catch (ClassNotFoundException c) {
            logger.warning("Clase no encontrada.");
        }
    }


    public static void main(String[] args) {
        //Descomenta el metodo que quieras probar.
       Persona persona = new Persona("Juan", "Pérez", 25);
        //escribirObjeto(persona);
        //leerObjeto();
    }

}
