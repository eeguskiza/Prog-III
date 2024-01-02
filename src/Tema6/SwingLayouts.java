package Tema6;

import javax.swing.*;
import java.awt.*;
/**
 * Esta clase SwingLayouts demuestra el uso de diferentes layouts en Swing.
 * Cada layout tiene un propósito específico y es útil para distintas disposiciones de interfaces de usuario:
 *
 * - BorderLayout: Ideal para una disposición básica que necesita áreas bien definidas (norte, sur, este, oeste, centro).
 *   Utilizado comúnmente para agregar barras de herramientas, menús y paneles de estado.
 *
 * - FlowLayout: Adecuado para disponer componentes secuencialmente, uno tras otro (como en una línea).
 *   Útil para interfaces simples con una disposición lineal, como un conjunto de botones o un formulario sencillo.
 *
 * - GridLayout: Excelente para crear formularios con una disposición regular, como una matriz de etiquetas y campos de texto.
 *   Cada componente ocupa una celda de igual tamaño, lo que lo hace ideal para calculadoras, teclados o formularios estructurados.
 *
 * - BoxLayout: Permite disponer los componentes ya sea en una línea vertical o horizontal.
 *   Es útil para listas de elementos o para alinear componentes a lo largo de un solo eje, manteniendo su orden y alineación.
 *
 * - CardLayout: Permite la disposición de componentes de manera que solo uno se muestra a la vez, como un mazo de cartas.
 *   Ideal para interfaces con múltiples pantallas o pasos, como asistentes de configuración o menús con varias opciones.
 */


public class SwingLayouts extends JFrame {

    // Constructor para BorderLayout
    // En BorderLayout, los componentes se organizan en cinco áreas: NORTH, SOUTH, EAST, WEST, CENTER.
    public SwingLayouts(BorderLayout layout) {
        super("BorderLayout Demo");
        setLayout(layout);
        add(new JPanel() {{ setBackground(Color.RED); }}, BorderLayout.NORTH);
        add(new JPanel() {{ setBackground(Color.GREEN); }}, BorderLayout.SOUTH);
        add(new JPanel() {{ setBackground(Color.BLUE); }}, BorderLayout.EAST);
        add(new JPanel() {{ setBackground(Color.YELLOW); }}, BorderLayout.WEST);
        add(new JPanel() {{ setBackground(Color.ORANGE); }}, BorderLayout.CENTER);
        setupFrame();
    }

    // Constructor para FlowLayout
    // En FlowLayout, los componentes se colocan uno tras otro, en una dirección que fluye como un texto.
    public SwingLayouts(FlowLayout layout) {
        super("FlowLayout Demo");
        setLayout(layout);
        for (int i = 0; i < 5; i++) {
            add(new JPanel() {{ setBackground(new Color((int)(Math.random() * 0x1000000))); setPreferredSize(new Dimension(50, 50)); }});
        }
        setupFrame();
    }

    // Constructor para GridLayout
    // En GridLayout, los componentes se organizan en una cuadrícula de filas y columnas.
    public SwingLayouts(GridLayout layout) {
        super("GridLayout Demo");
        setLayout(layout);
        for (int i = 0; i < 6; i++) {
            add(new JPanel() {{ setBackground(new Color((int)(Math.random() * 0x1000000))); }});
        }
        setupFrame();
    }

    // Constructor para BoxLayout
// En BoxLayout, los componentes se pueden alinear vertical u horizontalmente.
    public SwingLayouts(BoxLayout layout) {
        super("BoxLayout Demo");
        // Se establece BoxLayout en el contenedor de contenido del JFrame
        Container container = getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.add(new JPanel() {{ setBackground(Color.RED); setAlignmentX(Component.CENTER_ALIGNMENT); }});
        container.add(new JPanel() {{ setBackground(Color.GREEN); setAlignmentX(Component.CENTER_ALIGNMENT); }});
        container.add(new JPanel() {{ setBackground(Color.BLUE); setAlignmentX(Component.CENTER_ALIGNMENT); }});
        setupFrame();
    }


    // Constructor para CardLayout
    // En CardLayout, los componentes se apilan como un mazo de cartas, con solo uno visible a la vez.
    public SwingLayouts(CardLayout layout) {
        super("CardLayout Demo");
        CardLayout cardLayout = new CardLayout();
        setLayout(cardLayout);

        // Crear y añadir paneles
        JPanel card1 = new JPanel();
        card1.setBackground(Color.RED);
        JPanel card2 = new JPanel();
        card2.setBackground(Color.GREEN);
        JPanel card3 = new JPanel();
        card3.setBackground(Color.BLUE);

        add(card1, "Card 1");
        add(card2, "Card 2");
        add(card3, "Card 3");

        // Crear botones para cambiar entre tarjetas
        JButton btn1 = new JButton("Mostrar Card 1");
        btn1.addActionListener(e -> cardLayout.show(getContentPane(), "Card 1"));
        JButton btn2 = new JButton("Mostrar Card 2");
        btn2.addActionListener(e -> cardLayout.show(getContentPane(), "Card 2"));
        JButton btn3 = new JButton("Mostrar Card 3");
        btn3.addActionListener(e -> cardLayout.show(getContentPane(), "Card 3"));

        card1.add(btn2);
        card2.add(btn3);
        card3.add(btn1);

        setupFrame();
    }

    private void setupFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        // new SwingLayouts(new BorderLayout());
        // new SwingLayouts(new FlowLayout());
        // new SwingLayouts(new GridLayout(2, 3));
        // new SwingLayouts();
        // new SwingLayouts(new CardLayout());
    }
}

