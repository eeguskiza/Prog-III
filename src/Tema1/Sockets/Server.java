package Tema1.Sockets;

import java.io.*; // Importa las clases de Java para manejar la entrada/salida.
import java.net.ServerSocket; // Importa la clase ServerSocket para crear un socket del servidor.
import java.net.Socket; // Importa la clase Socket para manejar la conexión del cliente.

public class Server {
    public static void main(String[] args) throws IOException {
        // Definir el puerto en el que el servidor escuchará. Asegúrate de que este puerto esté libre.
        int port = 6666;

        // Crea un objeto ServerSocket que escucha en el puerto especificado.
        ServerSocket serverSocket = new ServerSocket(port);

        // Imprime un mensaje indicando que el servidor está iniciado y esperando conexiones.
        System.out.println("Servidor iniciado. Esperando clientes...");

        // Un bucle infinito para que el servidor siga escuchando conexiones de clientes.
        while (true) {
            // Acepta una conexión del cliente y crea un Socket para manejarla.
            Socket clientSocket = serverSocket.accept();

            // Imprime un mensaje cuando un cliente se conecta.
            System.out.println("Cliente conectado.");

            // Crea un BufferedReader para leer datos del cliente.
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Crea un PrintWriter para enviar datos al cliente.
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Declara una variable para almacenar la entrada del cliente.
            String inputLine;

            // Un bucle para leer líneas de texto enviadas por el cliente.
            while ((inputLine = in.readLine()) != null) {
                // Imprime el mensaje recibido del cliente.
                System.out.println("Mensaje del Cliente: " + inputLine);

                // Responde al cliente si el mensaje es "hola".
                if ("hola".equals(inputLine)) {
                    out.println("Hola, cliente!");
                } else {
                    // Si el mensaje es diferente, simplemente lo devuelve al cliente.
                    out.println(inputLine);
                }
            }
        }
    }
}
