import javax.swing.*;
import java.awt.*;

public class ComponentesBasicos extends JFrame {

    public ComponentesBasicos() {
        super("Componentes Básicos de Swing");

        // Configuración del GridLayout
        // Se define un número suficiente de filas para acomodar todos los componentes y 1 columna
        setLayout(new GridLayout(0, 1));

        // Añadiendo JLabel
        add(new JLabel("Etiqueta de Texto"));

        // Añadiendo JButton
        add(new JButton("Botón"));

        // Añadiendo JTextField
        add(new JTextField(20));

        // Añadiendo JTextArea dentro de un JScrollPane
        JTextArea textArea = new JTextArea(3, 20);
        add(new JScrollPane(textArea));

        // Añadiendo JCheckBox
        add(new JCheckBox("Casilla de Verificación"));

        // Añadiendo JRadioButton dentro de un ButtonGroup
        JRadioButton radioButton1 = new JRadioButton("Opción 1", true);
        JRadioButton radioButton2 = new JRadioButton("Opción 2");
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(radioButton1);
        radioGroup.add(radioButton2);
        JPanel radioPanel = new JPanel(new FlowLayout());
        radioPanel.add(radioButton1);
        radioPanel.add(radioButton2);
        add(radioPanel);

        // Añadiendo JComboBox
        JComboBox<String> comboBox = new JComboBox<>(new String[]{"Item 1", "Item 2", "Item 3"});
        add(comboBox);

        // Añadiendo JList dentro de un JScrollPane
        JList<String> list = new JList<>(new String[]{"Elemento 1", "Elemento 2", "Elemento 3"});
        add(new JScrollPane(list));

        // Configuraciones finales del JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ComponentesBasicos();
    }
}
