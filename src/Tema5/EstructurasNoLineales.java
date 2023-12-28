package Tema5;

import java.util.ArrayList;
import java.util.List;

public class EstructurasNoLineales {

    /**
     * Esta clase representa un nodo básico en un árbol.
     * Cada nodo contiene un valor y una referencia a sus hijos izquierdo y derecho.
     */
    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    /**
     * Esta clase representa un árbol binario simple.
     * Se pueden agregar elementos al árbol y recorrer el árbol en orden.
     */
    class BinaryTree {
        TreeNode root;

        BinaryTree() {
            root = null;
        }

        // Método para insertar un valor en el árbol. Este método inicialmente llama a insertRecursive.
        void insert(int value) {
            root = insertRecursive(root, value);
        }

        // Método recursivo para insertar un nuevo valor en el árbol
        TreeNode insertRecursive(TreeNode current, int value) {
            if (current == null) {
                return new TreeNode(value);
            }

            if (value < current.value) {
                current.left = insertRecursive(current.left, value);
            } else if (value > current.value) {
                current.right = insertRecursive(current.right, value);
            } else {
                // El valor ya existe
                return current;
            }

            return current;
        }

        // Método para realizar el recorrido inorden del árbol
        void inorderTraversal() {
            inorderRecursive(root);
        }

        // Método recursivo para el recorrido inorden
        void inorderRecursive(TreeNode current) {
            if (current != null) {
                inorderRecursive(current.left);
                System.out.print(current.value + " ");
                inorderRecursive(current.right);
            }
        }
    }

    /**
     * La clase Graph representa un grafo con una lista de adyacencia.
     * Soporta grafos dirigidos y no dirigidos, permitiendo agregar y visualizar bordes.
     * Utiliza una lista de listas para almacenar las conexiones entre vértices.
     * Ejemplo de uso: Graph g = new Graph(5); g.addEdge(0, 1); g.printGraph();
     */

    // Clase para representar un grafo utilizando una lista de adyacencia
    static class Graph {
        private int numVertices; // Número de vértices
        private List<List<Integer>> adjList; // Lista de adyacencia

        // Constructor del grafo
        public Graph(int numVertices) {
            this.numVertices = numVertices;
            adjList = new ArrayList<>(numVertices);
            for (int i = 0; i < numVertices; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        // Método para agregar un borde al grafo
        public void addEdge(int src, int dest) {
            adjList.get(src).add(dest);
            // Para un grafo no dirigido, añadir una arista en ambas direcciones
            adjList.get(dest).add(src);
        }

        // Método para imprimir la representación del grafo
        public void printGraph() {
            for (int i = 0; i < numVertices; i++) {
                System.out.print("Lista de adyacencia del vértice " + i + ": ");
                for (Integer vertex : adjList.get(i)) {
                    System.out.print(vertex + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        /*
        EstructurasNoLineales estructuras = new EstructurasNoLineales();

        BinaryTree tree = estructuras.new BinaryTree();

        // Insertar valores en el árbol
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        // Realizar un recorrido inorden del árbol
        System.out.println("Recorrido inorden del árbol:");
        tree.inorderTraversal();
        */

        /*
        // Crear un grafo con 5 vértices
        Graph graph = new Graph(5);

        // Agregar bordes al grafo
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        // Imprimir la representación del grafo
        graph.printGraph();
        */
    }
}

