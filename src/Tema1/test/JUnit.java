package Tema1.test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*
Tema1.test.JUnit es una herramienta de prueba que se utiliza para escribir y ejecutar pruebas automatizadas en el código Java.
Te permite comprobar si tu código funciona como esperas al realizar pruebas sobre pequeñas partes del mismo,
denominadas pruebas unitarias. Con Tema1.test.JUnit, puedes asegurarte de que los cambios que haces no rompan el comportamiento existente
del código, facilitando la detección de errores y mejorando la calidad del software.
 */

/*
- @Before – inicialización anterior al test
– @After – cierre posterior al test
– @Test – método de test
 */


// Tema1.test.JUnit 3: Las pruebas heredan de TestCase y deben comenzar con la palabra "test".
// Tema1.test.JUnit 4: Introduce anotaciones como @Test para métodos de prueba, no requiere heredar de TestCase.
// Tema1.test.JUnit 5: Añade más anotaciones y funcionalidades, más modular con Jupiter.

public class JUnit {

    // Variable que mantendrá el objeto a probar.
    private Operacion operacion;

    // El método anotado con @Before se ejecuta antes de cada método de prueba.
    @Before
    public void setUp() {
        // Inicialización del objeto Operacion antes de cada prueba
        operacion = new Operacion();
    }

    // El método anotado con @Test es un método de prueba.
    @Test
    public void testSuma() {
        // Realizar una operación de suma y verificar el resultado
        assertEquals("La suma de 2 y 3 debe ser 5", 5, operacion.suma(2, 3));
    }

    // Este es otro método de prueba para verificar la resta.
    @Test
    public void testResta() {
        // Comprobamos que la resta funcione correctamente
        assertEquals("La resta de 5 y 2 debe ser 3", 3, operacion.resta(5, 2));
    }

    //ejemplo assert true
    @Test
    public void testAssertTrue() {
        // Comprobamos que la resta funcione correctamente
        assertTrue("La resta de 5 y 2 debe ser 3", 3==operacion.resta(5, 2));
    }

    // Clase de ejemplo que vamos a probar
    // Debes reemplazar esto con tu propia clase y métodos.
    private class Operacion {

        // Método de ejemplo para sumar dos números.
        public int suma(int a, int b) {
            return a + b;
        }

        // Método de ejemplo para restar dos números.
        public int resta(int a, int b) {
            return a - b;
        }
    }
}

