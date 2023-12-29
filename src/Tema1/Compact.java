package Tema1;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.lang.*;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Compact {

    /**
     * Una función simple que manipula una cadena y muestra un mensaje. JAVA LANG
     */
    public static void compact1() {
        try {
            String message = "Hola, Java!";
            String upperCaseMessage = message.toUpperCase();

            System.out.println("Mensaje original: " + message);
            System.out.println("Mensaje en mayúsculas: " + upperCaseMessage);
        } catch (Exception e) {
            System.err.println("Ocurrió un error: " + e.getMessage());
        }
    }

    /**
     * Una función que realiza operaciones con números grandes y criptografía.
     */
    public static void compact2() {
        try {
            // Aritmética de gran precisión con BigInteger
            // Crear dos números grandes usando la clase BigInteger
            BigInteger bigNumber1 = new BigInteger("12345678901234567890");
            BigInteger bigNumber2 = new BigInteger("98765432109876543210");

            // Sumar los dos números grandes
            BigInteger sum = bigNumber1.add(bigNumber2);

            // Imprimir el resultado de la suma
            System.out.println("Suma de grandes números: " + sum);

            // Operación criptográfica básica - Hashing con MD5
            // Definir un string para la operación de hashing
            String inputString = "Hello, Secure World!";

            // Obtener una instancia de MessageDigest para MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Realizar el hashing del string y obtener el array de bytes del hash
            byte[] messageDigest = md.digest(inputString.getBytes());

            // Convertir el array de bytes a un número BigInteger
            BigInteger no = new BigInteger(1, messageDigest);

            // Convertir el número BigInteger a una cadena hexadecimal
            String hashtext = no.toString(16);

            // Asegurar que el hash hexadecimal tenga 32 caracteres (llenar con ceros al principio si es necesario)
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            // Imprimir el hash MD5
            System.out.println("Hash MD5: " + hashtext);
        } catch (NoSuchAlgorithmException e) {
            // Capturar y manejar la excepción en caso de que el algoritmo de hash no esté disponible
            System.err.println("Error en la operación criptográfica: " + e.getMessage());
        }
    }

    //compact 3 seria sockets que esta en el paquete sockets

    /**
     * Comprueba si una cadena dada coincide con la expresión regular "p.*\\..*".
     *
     * @param s La cadena a comprobar.
     * @return true si la cadena coincide, false en caso contrario.
     */
    public static boolean compact4(String s) {
        // La expresión regular que buscamos: comienza con 'p', seguido de cualquier cosa, un punto y luego cualquier cosa.
        String expReg = "p.*\\..*";

        // Compila la expresión regular en un patrón.
        Pattern pat1 = Pattern.compile(expReg);

        // Crea un Matcher con la cadena y verifica si coincide con el patrón.
        Matcher matcher = pat1.matcher(s);

        // Devuelve true si la cadena coincide con la expresión regular.
        return matcher.matches();
    }

    public static void compact5() {
        // Utilizando la clase Date para obtener la fecha y hora actual.
        Date d1 = new Date();

        // Formateador de fecha para mostrar la fecha en el formato "dd/MM/yyyy".
        SimpleDateFormat f1 = new SimpleDateFormat("dd/MM/yyyy");

        // Imprimir la fecha actual en el formato "dd/MM/yyyy".
        System.out.println("Fecha con SimpleDateFormat: " + f1.format(d1));

        // Utilizando la API java.time para obtener la fecha actual.
        LocalDate currentDate = LocalDate.now();

        // Formateador de fecha de java.time para mostrar la fecha en diferentes formatos.
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("E, MMM dd yyyy");

        // Imprimir la fecha actual en diferentes formatos usando java.time.
        System.out.println("Fecha con java.time (formato 1): " + currentDate.format(formatter1));
        System.out.println("Fecha con java.time (formato 2): " + currentDate.format(formatter2));
    }

    //compact 6 seria Java nio e io que esta en el tema 3 en la clase Ficheros.java
    //compact 7 esta relacionado con las collections y eso es tema 5 estructuras de datos


    /**
     El logging es como llevar un diario de todo lo que hace una aplicación.
     Imagina que tu programa es una persona que te cuenta lo que hace, cómo se siente, y si tiene algún problema.
     Esta información es muy valiosa para entender y solucionar errores, o simplemente para saber qué está pasando.
     Es como tener un registro detallado de los eventos que ayudan a los programadores a "conversar" con su código y
     mantenerlo funcionando sin problemas.
     */
    public static void compact8() {
        // Crear un logger para la clase
        Logger logger = Logger.getLogger(Compact.class.getName());
        // Este es como abrir un diario específico para esta clase 'Compact'.

        // Configurar el nivel de logging
        logger.setLevel(Level.ALL);
        // Aquí decides qué tan detallado quieres que sea el diario. 'ALL' significa que quieres anotar todo.

        // Registrar un mensaje de nivel INFO
        logger.info("Empezando el proceso de logging");
        // Escribe en el diario que estás empezando el proceso. Es como un "Querido diario, hoy empiezo..."

        try {
            // Simular una operación
            int resultado = 10 / 0;
            // Aquí estás intentando hacer algo (dividir 10 entre 0), pero sabes que va a fallar.
        } catch (Exception e) {
            // Registrar un mensaje de nivel SEVERE en caso de excepción
            logger.log(Level.SEVERE, "Excepción capturada: " + e.toString(), e);
            // Aquí, cuando las cosas salen mal (como se esperaba), escribes en el diario que hubo un problema grave, describiendo exactamente qué pasó.
        }

    }

    public static void compact8_2(){
        // Crear un logger para la clase
        Logger logger = Logger.getLogger(Compact.class.getName());

        // Configurar el nivel de logging
        logger.setLevel(Level.INFO);
        // Aquí solo se registrarán mensajes informativos y de mayor severidad.

        // Registrar el inicio del proceso de inicio de sesión
        logger.info("Inicio del proceso de inicio de sesión");

        try {
            // Simular un inicio de sesión exitoso
            String usuario = "usuarioEjemplo";
            logger.info("Intento de inicio de sesión para el usuario: " + usuario);
            // Registrar que un usuario está intentando iniciar sesión.

            // Simulando verificación de credenciales
            boolean exito = false; // Supongamos que la verificación es exitosa
            if (exito) {
                logger.info("Inicio de sesión exitoso para el usuario: " + usuario);
                // Registrar que el inicio de sesión fue exitoso.
            } else {
                logger.warning("Inicio de sesión fallido para el usuario: " + usuario);
                // Registrar un intento fallido de inicio de sesión.
            }
        } catch (Exception e) {
            // Registrar un mensaje de nivel SEVERE en caso de una excepción
            logger.log(Level.SEVERE, "Error durante el proceso de inicio de sesión", e);
            // Si ocurre un error durante el proceso, se registra como un evento grave.
        }

    }

    public static void compact9() {
        // Crear un servicio de ejecución con un número fijo de hilos
        // Este servicio permite ejecutar tareas de forma concurrente.
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Enviar tareas para ejecución concurrente
        // Aquí se envían dos tareas simples a ejecutar por los hilos del executor.
        executor.submit(() -> System.out.println("Tarea 1 en ejecución"));
        executor.submit(() -> System.out.println("Tarea 2 en ejecución"));

        try {
            // Utilizar reflexión para inspeccionar la clase String
            // Reflexión se utiliza aquí para obtener información sobre la clase String en tiempo de ejecución.
            Class<?> stringClass = Class.forName("java.lang.String");
            Method[] methods = stringClass.getDeclaredMethods();

            // Imprimir todos los métodos de la clase String
            // Este bucle recorre e imprime los nombres de todos los métodos de la clase String.
            for (Method method : methods) {
                System.out.println("Método encontrado: " + method.getName());
            }
        } catch (ClassNotFoundException e) {
            // Capturar y manejar la excepción ClassNotFoundException
            e.printStackTrace();
        }

        // Cerrar el servicio de ejecución
        // Es importante cerrar el ExecutorService para liberar recursos.
        executor.shutdown();
    }

    public static void compact10() { //Hay una opcion de crear un jara ejecutable pero es un porro, ya lo metere
        // Crear un archivo ZIP con una clase
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream("example.zip"));
             FileInputStream fileIn = new FileInputStream("src/Tema3/Propiedades.java")) {
            ZipEntry zipEntry = new ZipEntry("src/Tema3/Propiedades.java");
            zipOut.putNextEntry(zipEntry);

            fileIn.transferTo(zipOut); // Transfiere el contenido del archivo de clase al ZIP

            zipOut.closeEntry();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void compact11() {
        // Crear un "gerente" para manejar diferentes lenguajes de script
        ScriptEngineManager manager = new ScriptEngineManager();
        // Pedirle al "gerente" un motor de script para JavaScript
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        try {
            // Pedirle al motor de script que calcule algo, como si fuera una calculadora
            Object result = engine.eval("10 * 5");
            // Mostrar el resultado del cálculo
            System.out.println("Resultado del script: " + result);
        } catch (ScriptException e) {
            // Si algo sale mal con el script, imprimir el error
            e.printStackTrace();
        }

        // Crear una herramienta para dar formato a los números con dos decimales
        NumberFormat formatter = new DecimalFormat("#0.00");

        // Dar formato a un número para que se vea bonito y tenga solo dos decimales
        System.out.println("Número formateado: " + formatter.format(123.456789));
    }

    public static void compact12() {
        // Lista de números para demostración
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Expresión lambda para imprimir cada elemento de la lista
        // Esto reemplaza la necesidad de crear una clase anónima para implementar una interfaz
        numbers.forEach(number -> System.out.println(number));

        // Referencia a método para imprimir cada elemento
        // Es otra forma más concisa de hacer lo mismo que la expresión lambda anterior
        numbers.forEach(System.out::println);

        // Un ejemplo más de una expresión lambda que suma dos números
        // Aquí definimos una operación que toma dos enteros y devuelve su suma
        Operacion suma = (a, b) -> a + b;
        // Imprimimos el resultado de la suma
        System.out.println("Resultado de la suma: " + suma.operar(5, 3));
    }

    // Esta es una interfaz funcional porque solo tiene un método abstracto
    @FunctionalInterface
    interface Operacion {
        int operar(int a, int b);
    }

    //Luego tendriamos compact 2 que es sql tema 3 y xml y otros ficheros que se trata muy por encima en el 3 tambien
    //Compact 3  son metodos muys especificos que no nos haran falta en el examen, sino para eso esta GPT

    public static void main(String[] args) {
        //compact1();
        //compact2();

        /*
        // Ejemplo de uso de la función compact4.
        String prueba = "prueba.ejemplo";
        System.out.println("¿La cadena '" + prueba + "' coincide? " + compact4(prueba)); // Debería devolver true.
         */

        //compact5();
        //compact8();
        //compact8_2();
        //compact9();
        //compact10();
        //compact11();
        //compact12();


    }
}
