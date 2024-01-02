package Tema6;

// Definición de una clase abstracta
abstract class Figura {
    // Método abstracto para calcular el área de la figura
    public abstract double calcularArea();
}

// Interfaz para figuras que pueden ser dibujadas
interface Dibujable {
    void dibujar();
}

// Clase concreta que hereda de Figura y también implementa la interfaz Dibujable
class Circulo extends Figura implements Dibujable {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    // Implementación del método abstracto de Figura
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    // Implementación del método de la interfaz Dibujable
    public void dibujar() {
        System.out.println("Dibujando un círculo");
    }
}

public class EjemploHerenciaInterfaces {
    public static void main(String[] args) {
        // Crear un objeto de la clase Circulo
        Circulo circulo = new Circulo(5.0);

        // Calcular y mostrar el área del círculo
        double area = circulo.calcularArea();
        System.out.println("Área del círculo: " + area);

        // Dibujar el círculo
        circulo.dibujar();
    }
}

