package Tema6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComponentesAvanzados extends JFrame {

    public ComponentesAvanzados() {
        super("Componentes Avanzados de Swing");

        // Configuración del GridLayout
        setLayout(new GridLayout(0, 1));

        // Añadiendo JSlider
        JSlider slider = new JSlider(0, 100);
        add(slider);

        // Añadiendo JSpinner
        JSpinner spinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        add(spinner);

        // Añadiendo JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Pestaña 1", new JLabel("Contenido de la Pestaña 1"));
        tabbedPane.addTab("Pestaña 2", new JLabel("Contenido de la Pestaña 2"));
        add(tabbedPane);

        // Añadiendo JToolBar
        JToolBar toolBar = new JToolBar();
        toolBar.add(new JButton("Botón 1"));
        toolBar.add(new JButton("Botón 2"));
        add(toolBar);

        // Añadiendo JProgressBar
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(75);
        add(progressBar);

        // Botón para mostrar JDialog
        JButton showDialogButton = new JButton("Mostrar Diálogo");
        showDialogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog(ComponentesAvanzados.this, "Diálogo de Ejemplo", true);
                dialog.setLayout(new FlowLayout());
                dialog.add(new JLabel("Este es un diálogo"));
                dialog.setSize(300, 200);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        });
        add(showDialogButton);

        // Configuraciones finales del JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ComponentesAvanzados();
    }
}

