package Tema3;

public class Preferences {

    public static void main(String[] args) {
        // Las 'Preferences' en Java permiten almacenar y recuperar
        // datos de preferencia y configuración de usuario y sistema de forma persistente.

        // Obtener las preferencias asociadas con la clase 'PreferencesExample'.
        // Estas preferencias se almacenan en un nodo específico del sistema operativo,
        // como el registro de Windows o archivos ocultos en sistemas Unix.
        java.util.prefs.Preferences prefs = java.util.prefs.Preferences.userNodeForPackage(Preferences.class);

        // Guardar una preferencia en el nodo de preferencias.
        // 'put' toma dos argumentos: una clave y un valor asociado.
        // Aquí, la clave es 'ejemploKey' y el valor es 'Valor de Ejemplo'.
        prefs.put("ejemploKey", "Valor de Ejemplo");

        // Recuperar y imprimir el valor de una preferencia.
        // 'get' toma dos argumentos: una clave y un valor por defecto.
        // Si 'ejemploKey' no existe, se devuelve "Default Value".
        String valor = prefs.get("ejemploKey", "Default Value");
        System.out.println("ejemploKey: " + valor);

        // Ejemplo de cómo guardar y recuperar un valor booleano.
        // 'putBoolean' y 'getBoolean' son específicos para manejar booleanos.
        // 'mostrarInicioRapido' es la clave, y se establece en 'true'.
        prefs.putBoolean("mostrarInicioRapido", true);

        // Recuperar el valor booleano de 'mostrarInicioRapido'.
        // Si no existe, se devuelve 'false' como valor por defecto.
        boolean mostrarInicioRapido = prefs.getBoolean("mostrarInicioRapido", false);
        System.out.println("mostrarInicioRapido: " + mostrarInicioRapido);

        // Eliminar una preferencia específica por su clave.
        // 'remove' elimina la preferencia asociada con 'ejemploKey'.
        prefs.remove("ejemploKey");

        // Eliminar todas las preferencias en el nodo.
        // CUIDADO: 'clear' eliminará TODAS las preferencias en este nodo.
        // Descomenta la siguiente línea si estás seguro de querer eliminar todo.
        // prefs.clear();
    }
}
