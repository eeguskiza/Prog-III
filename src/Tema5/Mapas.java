package Tema5;

import java.util.*;

public class Mapas {

    /**
     * HashSet:
     * - No mantiene el orden de los elementos.
     * - Ofrece un rendimiento constante para las operaciones básicas como añadir, eliminar y comprobar si un elemento existe.
     * - Es la opción más eficiente si no necesitas un ordenamiento específico.
     */

    public static void demoHashSet() {
        HashSet<String> hashSet = new HashSet<>();

        // Añade elementos al conjunto
        hashSet.add("Elemento1");
        hashSet.add("Elemento2");
        hashSet.add("Elemento3");

        // Muestra el HashSet
        System.out.println("HashSet: " + hashSet);

        // Elimina un elemento
        hashSet.remove("Elemento2");

        // Comprueba si un elemento existe
        boolean contiene = hashSet.contains("Elemento1");
        System.out.println("Contiene Elemento1: " + contiene);

        // Tamaño del HashSet
        int tamaño = hashSet.size();
        System.out.println("Tamaño del HashSet: " + tamaño);

        // Iterar sobre elementos
        for (String elemento : hashSet) {
            System.out.println(elemento);
        }

        // Limpiar el HashSet
        hashSet.clear();
    }

    /**
     * TreeSet:
     * - Almacena los elementos en un orden ascendente según su orden natural o un comparador proporcionado.
     * - Ofrece un rendimiento logarítmico para las operaciones básicas.
     * - Es útil cuando se necesita un conjunto ordenado.
     */

    public static void demoTreeSet() {
        TreeSet<String> treeSet = new TreeSet<>();

        // Añade elementos al conjunto
        treeSet.add("Manzana");
        treeSet.add("Naranja");
        treeSet.add("Plátano");

        // Muestra el TreeSet
        System.out.println("TreeSet: " + treeSet);

        // Elimina un elemento
        treeSet.remove("Naranja");

        // Comprueba si un elemento existe
        boolean contiene = treeSet.contains("Manzana");
        System.out.println("Contiene Manzana: " + contiene);

        // Tamaño del TreeSet
        int tamaño = treeSet.size();
        System.out.println("Tamaño del TreeSet: " + tamaño);

        // Iterar sobre elementos en orden ascendente
        for (String elemento : treeSet) {
            System.out.println(elemento);
        }

        // El primer y último elemento
        String primerElemento = treeSet.first();
        String ultimoElemento = treeSet.last();
        System.out.println("Primer elemento: " + primerElemento);
        System.out.println("Último elemento: " + ultimoElemento);

        // Limpiar el TreeSet
        treeSet.clear();
    }

    /**
     * HashMap:
     * - Almacena pares de clave-valor.
     * - No garantiza el orden de los elementos.
     * - Ofrece un rendimiento constante para las operaciones de búsqueda, inserción y eliminación.
     * - Ideal para búsquedas rápidas donde las claves son únicas.
     */
    public static void demoHashMap() {
        HashMap<String, Integer> hashMap = new HashMap<>();

        // Añadir elementos
        hashMap.put("Manzana", 50);
        hashMap.put("Naranja", 30);

        // Acceder a un elemento
        int precioManzana = hashMap.get("Manzana");

        // Comprobar si existe una clave
        boolean existeNaranja = hashMap.containsKey("Naranja");

        // Eliminar un elemento
        hashMap.remove("Naranja");

        // Iterar sobre claves
        for (String clave : hashMap.keySet()) {
            // Acciones con la clave
        }

        // Iterar sobre valores
        for (Integer valor : hashMap.values()) {
            // Acciones con el valor
        }
    }

    /**
     * TreeMap:
     * - Almacena pares de clave-valor en un orden ascendente según su orden natural o un comparador proporcionado.
     * - Ofrece un rendimiento logarítmico para las operaciones básicas.
     * - Ideal cuando se necesita un conjunto ordenado.
     */
    public static void demoTreeMap() {
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        // Añadir elementos
        treeMap.put("Manzana", 50);
        treeMap.put("Naranja", 30);

        // Acceder a un elemento
        int precioManzana = treeMap.get("Manzana");

        // Comprobar si existe una clave
        boolean existeNaranja = treeMap.containsKey("Naranja");

        // Eliminar un elemento
        treeMap.remove("Naranja");

        // Iterar sobre el TreeMap
        for (Map.Entry<String, Integer> entrada : treeMap.entrySet()) {
            String clave = entrada.getKey();
            Integer valor = entrada.getValue();
            // ... [Acciones con la clave y el valor] ...
        }
    }

    public static void main(String[] args) {
        //demoHashSet();
        //demoTreeSet();
        //demoHashMap();
        //demoTreeMap();
    }

}
