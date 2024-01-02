package Tema6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

public class SwingConcurrencyDemo extends JFrame {

    private JTextArea textArea;
    private JButton startSimpleTaskButton;
    private JButton startComplexTaskButton;

    public SwingConcurrencyDemo() {
        super("Hilos y Concurrency en Swing");

        // Crear un área de texto para mostrar mensajes y el progreso de las tareas
        textArea = new JTextArea(15, 30);
        textArea.setEditable(false);

        // Crear un botón para iniciar una tarea simple en un hilo separado
        startSimpleTaskButton = new JButton("Iniciar Tarea Simple");
        startSimpleTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                iniciarTareaSimple();
            }
        });

        // Crear un botón para iniciar una tarea compleja usando SwingWorker
        startComplexTaskButton = new JButton("Iniciar Tarea Compleja");
        startComplexTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                iniciarTareaCompleja();
            }
        });

        // Configurar el layout y agregar componentes al frame
        setLayout(new FlowLayout());
        add(new JScrollPane(textArea));
        add(startSimpleTaskButton);
        add(startComplexTaskButton);

        // Configuración básica del frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void iniciarTareaSimple() {
        // Iniciar un hilo simple
        new Thread(() -> {
            startSimpleTaskButton.setEnabled(false); // Deshabilitar el botón mientras la tarea está en ejecución
            try {
                textArea.append("Tarea simple en progreso...(100%)\n");
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(500); // Simular una tarea larga
                    // Construir y mostrar la "barra de progreso"
                    String progressBar = String.join("", Collections.nCopies(i, "=")) + (i + 1) * 10 + "%\n";
                    SwingUtilities.invokeLater(() -> textArea.append(progressBar));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            startSimpleTaskButton.setEnabled(true); // Re-habilitar el botón una vez completada la tarea
        }).start();
    }


    private void iniciarTareaCompleja() {
        // Utilizar SwingWorker para tareas largas y pesadas
        SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() throws Exception {
                // Esta es la tarea pesada que se ejecuta en un hilo separado.
                textArea.append("Tarea compleja en progreso...(500%)\n");
                for (int i = 0; i < 50; i++) {
                    Thread.sleep(500); // Simular una tarea larga
                    // Construir y mostrar la "barra de progreso"
                    String progressBar = String.join("", Collections.nCopies(i, "=")) + (i + 1) * 10 + "%\n";
                    SwingUtilities.invokeLater(() -> textArea.append(progressBar));
                }
                return null;
            }

            @Override
            protected void process(java.util.List<String> chunks) {
                // Este método se ejecuta en el Event Dispatch Thread (EDT)
                // y se usa para actualizar la interfaz de usuario con el progreso de la tarea.
                for (String text : chunks) {
                    textArea.append(text + "\n");
                }
            }

            @Override
            protected void done() {
                // Este método se ejecuta en el EDT una vez que la tarea de fondo ha terminado.
                textArea.append("Tarea compleja completada.\n");
                startComplexTaskButton.setEnabled(true); // Re-habilitar el botón
            }
        };

        startComplexTaskButton.setEnabled(false); // Deshabilitar el botón mientras la tarea está en ejecución
        worker.execute(); // Iniciar el SwingWorker
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SwingConcurrencyDemo::new);
    }
}
