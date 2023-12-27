package Tema3;

//Descargamos el jar y lo añadimos a las librerias del proyecto
//Hay que descargar sqlite --> https://sqlitestudio.pl/
//Hay que importar el .jar de sqlite --> https://github.com/xerial/sqlite-jdbc/releases
//Y dos focking drivers que sino no va bien
// 1 --> https://alud.deusto.es/mod/resource/view.php?id=617253
// 2 --> https://alud.deusto.es/mod/resource/view.php?id=617254

//si no va el link es slf4j-api-1.7.25.jar y slf4j-simple-1.7.25.jar

import java.sql.*; //Importamos todas las clases de java.sql

/*
    * CREAMOS UNA BASE DE DATOS SQLite.db y generamos una tabla PERSONA

    CREATE TABLE Persona (
        id INTEGER PRIMARY KEY,
        nombre VARCHAR(255) NOT NULL UNIQUE,
        apellido VARCHAR(255) NOT NULL,
        edad INTEGER NOT NULL,
        correo_electronico VARCHAR(255)
    );

    * Añadimos datos a la tabla PERSONA
    * INSERT INTO persona (nombre, apellido, edad, correo_electronico) VALUES ('Erik', 'Eguskiza', 19, 'e.eguskiza@opendeusto.es')
 */

public class BasesDeDatos {
    // PARA MODIFICAR LA BASE executeUpdate y PARA CONSULTAR executeQuery !!!!

    public static void consultaSQL() {
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:src/Recursos/SQLite.db"; //Ruta de la base de datos.

            try (Connection conn = DriverManager.getConnection(url)) { //Lo primero es conectarnos a la base de datos.
                System.out.println("Conexión a SQLite establecida con éxito.");
                Statement stmt = conn.createStatement(); //Creamos un objeto Statement para poder ejecutar sentencias SQL.
                ResultSet rs = stmt.executeQuery("SELECT * FROM Persona"); //Ejecutamos una sentencia SQL y guardamos el resultado.

                while (rs.next()) { //Recorremos el resultado.
                    System.out.println(rs.getInt("id") + "\t" +
                            rs.getString("nombre") + "\t" +
                            rs.getString("apellido") + "\t" +
                            rs.getInt("edad") + "\t" +
                            rs.getString("correo_electronico"));
                }
                rs.close();
                stmt.close();
                conn.close();

            } catch (SQLException e) {
                System.out.println("Error de conexión: " + e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No se encontró el driver de SQLite: " + e.getMessage());
        }
    }

    public static void insercionSQL(){
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:src/Recursos/SQLite.db"; //Ruta de la base de datos.

            try (Connection conn = DriverManager.getConnection(url)) { //Lo primero es conectarnos a la base de datos.
                System.out.println("Conexión a SQLite establecida con éxito.");
                Statement stmt = conn.createStatement(); //Creamos un objeto Statement para poder ejecutar sentencias SQL.
                int filasAfectadas = stmt.executeUpdate("INSERT INTO persona (id, nombre, apellido, edad, correo_electronico) VALUES (2, 'Alex', 'Jauregui', 33, 'alex.jauregui@opendeusto.es')"); // Ejecutamos una sentencia SQL y guardamos el número de filas afectadas.
                System.out.println(filasAfectadas + " filas afectadas.");
                stmt.close();
                conn.close();

            } catch (SQLException e) {
                System.out.println("Error de conexión: " + e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No se encontró el driver de SQLite: " + e.getMessage());
        }

    }

    public static void modificacionSQL(){
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:src/Recursos/SQLite.db"; //Ruta de la base de datos.

            try (Connection conn = DriverManager.getConnection(url)) { //Lo primero es conectarnos a la base de datos.
                System.out.println("Conexión a SQLite establecida con éxito.");
                Statement stmt = conn.createStatement(); //Creamos un objeto Statement para poder ejecutar sentencias SQL.
                int filasAfectadas = stmt.executeUpdate("UPDATE Persona SET edad = 19 WHERE nombre = 'Alex'"); // Ejecutamos una sentencia SQL y guardamos el número de filas afectadas.
                System.out.println(filasAfectadas + " filas afectadas.");
                stmt.close();
                conn.close();

            } catch (SQLException e) {
                System.out.println("Error de conexión: " + e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No se encontró el driver de SQLite: " + e.getMessage());
        }
    }

    public static void modificacionSQL2(){ //Aqui hacemos uso de prepared statement que ayuda a evitar inyecciones SQL erroneas.
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:src/Recursos/SQLite.db"; // Ruta de la base de datos.

            try (Connection conn = DriverManager.getConnection(url)) { // Conexión a la base de datos.
                System.out.println("Conexión a SQLite establecida con éxito.");

                String sql = "UPDATE Persona SET edad = ? WHERE nombre = ?"; // Sentencia SQL con parámetros.
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) { // Creación de un PreparedStatement.
                    pstmt.setInt(1, 19); // Asignar valor al primer parámetro (edad).
                    pstmt.setString(2, "Alex"); // Asignar valor al segundo parámetro (nombre).

                    int filasAfectadas = pstmt.executeUpdate(); // Ejecutar la sentencia SQL.
                    System.out.println(filasAfectadas + " filas afectadas.");
                }

            } catch (SQLException e) {
                System.out.println("Error de conexión: " + e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No se encontró el driver de SQLite: " + e.getMessage());
        }
    }


    public static void borradoSQL(){
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:src/Recursos/SQLite.db"; //Ruta de la base de datos.

            try (Connection conn = DriverManager.getConnection(url)) { //Lo primero es conectarnos a la base de datos.
                System.out.println("Conexión a SQLite establecida con éxito.");
                Statement stmt = conn.createStatement(); //Creamos un objeto Statement para poder ejecutar sentencias SQL.
                int filasAfectadas = stmt.executeUpdate("DELETE FROM Persona WHERE nombre = 'Alex'"); // Ejecutamos una sentencia SQL y guardamos el número de filas afectadas.
                System.out.println(filasAfectadas + " filas afectadas.");
                stmt.close();
                conn.close();

            } catch (SQLException e) {
                System.out.println("Error de conexión: " + e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No se encontró el driver de SQLite: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        //consultaSQL();
        //insercionSQL();
        //modificacionSQL();
        //modificacionSQL2();
        //borradoSQL();
    }
}
