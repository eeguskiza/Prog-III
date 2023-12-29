package Tema1.Sockets;

import java.io.*; // Importa las clases de Java para manejar la entrada/salida.
import java.net.Socket; // Importa la clase Socket para conectar al servidor.

public class Client {
    public static void main(String[] args) throws IOException {
        // Dirección IP del servidor. Reemplaza con la dirección IP del servidor.
        String serverAddress = "10.166.58.154";

        // El puerto al que se conectará el cliente, debe coincidir con el del servidor.
        int port = 6666;

        // Crea un nuevo socket conectándose al servidor en la dirección y puerto especificados.
        Socket socket = new Socket(serverAddress, port);

        // PrintWriter para enviar mensajes al servidor.
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // BufferedReader para leer respuestas del servidor.
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // BufferedReader para leer la entrada del usuario desde la consola.
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        // Variable para almacenar la entrada del usuario.
        String userInput;

        // Bucle que se ejecuta mientras haya entrada del usuario (hasta que escriba 'null').
        while ((userInput = stdIn.readLine()) != null) {
            // Envía el mensaje ingresado por el usuario al servidor.
            out.println(userInput);

            // Imprime la respuesta recibida del servidor.
            System.out.println("Respuesta del servidor: " + in.readLine());
        }

        // Cierra los recursos abiertos - el socket y los streams de entrada/salida.
        socket.close();
        in.close();
        stdIn.close();
        out.close();
    }
}
