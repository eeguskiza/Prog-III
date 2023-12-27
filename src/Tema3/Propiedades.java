package Tema3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Propiedades extends JFrame {

    private static final String PROPERTIES_PATH = "Recursos/config.properties";
    private Properties propiedades;
    private JTextField texto;

    public Propiedades() {
        cargarPropiedades();
        setTitle("Ventana con Propiedades");
        setBounds(
                Integer.parseInt(propiedades.getProperty("posicionX", "100")),
                Integer.parseInt(propiedades.getProperty("posicionY", "100")),
                Integer.parseInt(propiedades.getProperty("ancho", "300")),
                Integer.parseInt(propiedades.getProperty("alto", "200"))
        );

        // Configurar el panel central
        JPanel panelCentral = new JPanel(new GridBagLayout());
        panelCentral.setBackground(new Color(173, 216, 230));

        // Configurar el campo de texto
        texto = new JTextField(propiedades.getProperty("ultimoMensaje", "Hola Mundo"));
        texto.setPreferredSize(new Dimension(200, 24)); // Dimensiones del campo de texto
        texto.setHorizontalAlignment(JTextField.CENTER); // Alineación del texto

        // Agregar el campo de texto al panel central
        panelCentral.add(texto);

        // Agregar el panel central a la ventana
        add(panelCentral, BorderLayout.CENTER);

        // Configurar la acción de cierre de la ventana --> Guardar propiedades
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                guardarPropiedades();
            }
        });
    }

    private void cargarPropiedades() {
        propiedades = new Properties();
        // Carga las propiedades o establece valores por defecto si no existen
        try {
            if (Files.exists(Paths.get(PROPERTIES_PATH))) {
                propiedades.load(new FileInputStream(PROPERTIES_PATH));
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    private void guardarPropiedades() {
        // Actualiza las propiedades con el estado actual de la ventana
        propiedades.setProperty("ultimoMensaje", texto.getText());
        propiedades.setProperty("posicionX", String.valueOf(getX()));
        propiedades.setProperty("posicionY", String.valueOf(getY()));
        propiedades.setProperty("ancho", String.valueOf(getWidth()));
        propiedades.setProperty("alto", String.valueOf(getHeight()));

        try (FileOutputStream output = new FileOutputStream(PROPERTIES_PATH)) {
            propiedades.store(output, "Configuración de la ventana");
            System.out.println("Propiedades guardadas.");
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Propiedades ventana = new Propiedades();
            ventana.setVisible(true);
        });
    }
}
