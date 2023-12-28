package Tema5;

import java.util.*;

public class EstructurasLineales {

    public static void listas() {
        // Creación de un lista primitiva con un tamaño  determinado --> No las vamos a usar
        int[] array = new int[10];

        // Creación de un ArrayList con un tamaño inicial determinado
        ArrayList<Integer> lista = new ArrayList<>(10);

        // add(e): Añade un elemento al final de la lista
        lista.add(5); // Lista: [5]

        // add(ind, e): Añade un elemento en la posición especificada
        lista.add(0, 3); // Lista: [3, 5]

        // set(ind, e): Establece un elemento en la posición especificada
        lista.set(1, 4); // Lista: [3, 4]

        // get(ind): Obtiene el elemento en la posición especificada
        int elemento = lista.get(0); // elemento = 3

        // contains(e): Verifica si la lista contiene un elemento específico
        boolean contiene = lista.contains(4); // contiene = true

        // indexOf(e): Devuelve el índice de la primera aparición del elemento
        int indice = lista.indexOf(4); // indice = 1

        // remove(ind): Elimina el elemento en la posición especificada
        lista.remove(1); // Lista: [3]

        // remove(e): Elimina la primera aparición del elemento especificado
        lista.remove(Integer.valueOf(3)); // Lista ahora está vacía

        // size(): Devuelve el número de elementos en la lista
        int tamaño = lista.size(); // tamaño = 0

        // clear(): Elimina todos los elementos de la lista
        lista.clear();

        // isEmpty(): Verifica si la lista está vacía
        boolean estaVacia = lista.isEmpty(); // estaVacia = true

        // iterator() y listIterator(): Permiten iterar sobre los elementos de la lista
        // No mostrado aquí por brevedad

        // toArray(): Convierte la lista en un array
        Object[] cosa = lista.toArray();

        // addAll(Collection c): Añade todos los elementos de la colección especificada al final de la lista
        lista.addAll(List.of(1, 2, 3)); // Lista: [1, 2, 3]

        // subList(indFrom, indTo): Devuelve una vista de la porción de la lista entre los índices especificados
        List<Integer> sublista = lista.subList(1, 3); // sublista: [2, 3]

        // ensureCapacity(n): Asegura que la lista puede contener al menos el número de elementos especificados
        lista.ensureCapacity(20);

        // trimToSize(): Reduce la capacidad de la lista al tamaño actual
        lista.trimToSize();

        // sort(Comparator<E> c): Ordena la lista según el comparador especificado
        lista.sort(Comparator.naturalOrder()); // Lista ordenada

        // clone(): Crea una copia superficial de la lista
        ArrayList<Integer> copiaLista = (ArrayList<Integer>) lista.clone();
    }

    public static void ejemploLinkedList() {
        // Crear una LinkedList
        LinkedList<String> listaEnlazada = new LinkedList<>();

        // Añadir elementos
        listaEnlazada.add("Elemento 1");
        listaEnlazada.add("Elemento 2");
        listaEnlazada.add("Elemento 3");

        // Insertar un elemento en una posición específica
        listaEnlazada.add(1, "Elemento insertado");

        // Eliminar el primer elemento
        listaEnlazada.removeFirst();

        // Eliminar un elemento específico
        listaEnlazada.remove("Elemento 3");

        // Acceder a un elemento
        String elemento = listaEnlazada.get(0); // Obtiene el primer elemento
        System.out.println("Elemento obtenido: " + elemento);

        // Recorrer la LinkedList
        for (String item : listaEnlazada) {
            System.out.println(item);
        }
    }

    /**
     * Diferencias y Casos de Uso de ArrayList y LinkedList
     *
     * Estructura Interna:
     * - ArrayList: Utiliza un array dinámico, con acceso rápido a elementos indexados.
     * - LinkedList: Usa una lista doblemente enlazada, facilitando inserciones y eliminaciones.
     *
     * Rendimiento en Operaciones:
     * - ArrayList:
     *   - Acceso: Alta eficiencia en lectura (acceso aleatorio).
     *   - Inserción/Eliminación: Menos eficiente, especialmente en el medio.
     * - LinkedList:
     *   - Acceso: Menor eficiencia (requiere atravesar la lista).
     *   - Inserción/Eliminación: Alta eficiencia, especialmente en extremos.
     *
     * Casos de Uso:
     * - ArrayList:
     *   - Ideal para acceso aleatorio frecuente.
     *   - Bueno para adiciones/eliminaciones al final de la lista.
     *   - Ejemplo: Lista de libros en biblioteca virtual.
     * - LinkedList:
     *   - Preferible para inserciones/eliminaciones frecuentes en cualquier punto.
     *   - Útil para listas con cambios constantes y orden de acceso no crítico.
     *   - Ejemplo: Implementación de colas, pilas, listas de tareas dinámicas.
     *
     * Conclusión:
     * - ArrayList es la opción predeterminada por su eficiencia en acceso aleatorio.
     * - LinkedList es mejor para inserciones/eliminaciones frecuentes.
     */

    /**
     * Método para demostrar el uso de Stack en Java.
     * Los Stacks son colecciones basadas en el principio LIFO (Last In, First Out).
     */
    public static void demoStack() {
        Stack<Integer> stack = new Stack<>();

        // Añadiendo elementos a la pila
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Muestra el elemento en la cima sin eliminarlo
        System.out.println("Elemento en la cima: " + stack.peek());

        // Eliminando elementos (el último elemento que se añadió es el primero en salir)
        while (!stack.isEmpty()) {
            System.out.println("Eliminado: " + stack.pop());
        }
    }

    /**
     * Método para demostrar el uso de Queue en Java.
     * Las Queues son colecciones basadas en el principio FIFO (First In, First Out).
     */
    public static void demoQueue() {
        //Cola normal
        Queue<Integer> cola = new LinkedList<>();
        // Crear una cola con doble enlace
        Deque<Integer> queue = new LinkedList<>();

        // Añadiendo elementos a la cola
        queue.add(1);
        queue.add(2);
        queue.add(3);

        cola.add(1);
        cola.add(2);
        cola.add(3);
        cola.offer(4);//un add cuando añade devuelve true, offer si la cola esta llena devuelve false

        //Añaadir un elemento en la primera posición
        queue.addFirst(4);

        //Añadir un elemento en la última posición
        queue.addLast(5);


        // Muestra el primer elemento sin eliminarlo
        System.out.println("Primer elemento: " + queue.peek());

        // Eliminando elementos (el primer elemento que se añadió es el primero en salir)
        while (!queue.isEmpty()) {
            System.out.println("Eliminado: " + queue.remove());
        }
    }


    public static void main(String[] args) {
        //listas();
        //ejemploLinkedList();
        //demoStack();
        //demoQueue();
        //demoHashSet();
        //demoTreeSet();
        //demoHashMap();
        //demoTreeMap();
    }
}
