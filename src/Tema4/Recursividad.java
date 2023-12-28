package Tema4;

public class Recursividad {
    /*
    1. Recursividad Lineal: Suma los números hasta n.
    2. Recursividad Binaria (Logarítmica): Realiza llamadas recursivas dividiendo n por 2.
    3. Recursividad Múltiple (Divide y Vencerás): Combina la división y la resta en sus llamadas recursivas.
    4. Recursividad Exponencial: Similar a la secuencia de Fibonacci, sumando los dos números anteriores.
     */

    // 1.1 Recursividad Lineal
    public static int recursividadLineal(int n) {
        if (n <= 1) {
            return n;
        } else {
            return n + recursividadLineal(n - 1);
        }
    }

    // 1.2 Recursividad Binaria (Logarítmica)
    public static int recursividadBinaria(int n) {
        if (n <= 1) {
            return n;
        } else {
            return recursividadBinaria(n / 2) + recursividadBinaria(n / 2);
        }
    }

    // 2.1 Recursividad Múltiple - Divide y Vencerás
    public static int divideYVenceras(int n) {
        if (n <= 1) {
            return n;
        } else {
            return divideYVenceras(n / 2) + divideYVenceras(n - 1);
        }
    }

    // 2.2 Recursividad Exponencial
    public static int recursividadExponencial(int n) {
        if (n <= 1) {
            return n;
        } else {
            return recursividadExponencial(n - 1) + recursividadExponencial(n - 2);
        }
    }

    // Método para ordenar un array usando Merge Sort (Divide y Vencerás)
    public static void mergeSort(int[] array) {
        if (array.length <= 1) {
            return;
        }

        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        System.arraycopy(array, 0, left, 0, left.length);
        System.arraycopy(array, mid, right, 0, right.length);

        mergeSort(left);
        mergeSort(right);

        merge(array, left, right);
    }

    // Método para fusionar dos subarrays en un array ordenado
    private static void merge(int[] array, int[] left, int[] right) {
        int totalLength = left.length + right.length;
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < left.length) {
            array[k++] = left[i++];
        }

        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    // Método recursivo que intencionadamente causa StackOverflowError
    public static void intentaCausarStackOverflow(int n) {
        try {
            intentaCausarStackOverflow(n + 1);
        } catch (StackOverflowError e) {
            System.out.println("Stack Overflow ha ocurrido con n = " + n);
            throw e; // Relanzar la excepción para observar su comportamiento
        }
    }

    public static void main(String[] args) {

        // System.out.println(recursividadLineal(5));
        // System.out.println(recursividadBinaria(5));
        // System.out.println(divideYVenceras(5));
        // System.out.println(recursividadExponencial(5));

        // Ejemplo de cómo llamar al método Merge Sort
        // int[] miArray = {5, 1, 6, 2, 3, 4};
        // mergeSort(miArray);
        // System.out.println(Arrays.toString(miArray));

        // Ejemplo de cómo llamar al método que causa StackOverflowError --> No se captura bien el error pero logramos ver su comportamiento
        /*
        try {
            intentaCausarStackOverflow(1);
        } catch (StackOverflowError e) {
            System.out.println("Capturado en main: " + e.getMessage());
        }
         */
    }
}
