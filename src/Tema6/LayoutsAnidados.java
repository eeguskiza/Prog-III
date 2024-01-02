package Tema6;

import javax.swing.*;
import java.awt.*;

public class LayoutsAnidados extends JFrame {

    public LayoutsAnidados() {
        super("Layouts anidados demo");

        // Panel principal con BorderLayout
        setLayout(new BorderLayout());
        setBackground(Color.BLUE); //Si te fijas al cambiar el tamaño de la pantalla con el raton mientras se repinta se ve el azul

        // Panel superior con FlowLayout
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(new JButton("Botón 1"));
        topPanel.add(new JButton("Botón 2"));
        topPanel.setBackground(Color.RED);
        add(topPanel, BorderLayout.NORTH);

        // Panel central con GridLayout
        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        centerPanel.add(new JLabel("Etiqueta 1"));
        centerPanel.add(new JLabel("Etiqueta 2"));
        centerPanel.add(new JTextField("Campo de texto 1"));
        centerPanel.add(new JTextField("Campo de texto 2"));
        centerPanel.setBackground(Color.GREEN);
        add(centerPanel, BorderLayout.CENTER);

        // Panel inferior con BoxLayout
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));
        bottomPanel.add(new JButton("Botón 3"));
        bottomPanel.add(Box.createHorizontalGlue()); // Espaciador
        bottomPanel.add(new JButton("Botón 4"));
        bottomPanel.setBackground(Color.YELLOW);
        add(bottomPanel, BorderLayout.SOUTH);

        // Configuración del JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LayoutsAnidados();
    }
}

