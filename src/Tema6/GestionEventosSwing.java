import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;

public class GestionEventosSwing extends JFrame {

    public GestionEventosSwing() {
        super("Gestión de Eventos en Swing");

        // Configurando el layout
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Botón para demostrar ActionListener
        JButton boton = new JButton("Presiona");
        boton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Botón presionado"));
        add(boton);

        // TextField para eventos de teclado
        JTextField textField = new JTextField(20);
        textField.setText("Presiona Enter" + System.lineSeparator() + "o Ctrl+F");
        textField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    JOptionPane.showMessageDialog(GestionEventosSwing.this, "Enter presionado");
                }
            }
        });
        add(textField);

        // Asignación de Key Binding
        // Key Binding se utiliza para asociar una acción específica a una combinación de teclas.

        // Crear un KeyStroke que representa la combinación de teclas 'Ctrl+F'.
        // KeyEvent.VK_F es la tecla 'F', y InputEvent.CTRL_DOWN_MASK indica que la tecla 'Ctrl' debe estar presionada.
        //KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK); // Windows
        KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.META_DOWN_MASK); // Mac

        // Obtener el InputMap del textField. El InputMap se usa para definir qué combinación de teclas
        // activará una acción. WHEN_IN_FOCUSED_WINDOW indica que el key binding debe funcionar
        // siempre que la ventana que contiene el textField tenga el foco, independientemente de si
        // textField tiene el foco directo.
        //textField.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, "F_Pressed"); // Windows
        textField.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, "F_Pressed"); // Mac

        // Definir la acción que se realizará cuando se detecte la combinación de teclas.
        // El método put asocia el KeyStroke con un objeto Action. Aquí, "F_Pressed" es una etiqueta
        // que identifica la acción, y la instancia de AbstractAction define lo que sucederá
        // cuando se active la combinación de teclas.

        textField.getActionMap().put("F_Pressed", new AbstractAction() {
            // El método actionPerformed se llama automáticamente cuando se presiona 'Ctrl+F'.
            public void actionPerformed(ActionEvent e) {
                // Mostrar un mensaje utilizando JOptionPane.
                JOptionPane.showMessageDialog(GestionEventosSwing.this, "Ctrl+F presionado");
            }
        });

        textField.getActionMap().put("F_Pressed", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(GestionEventosSwing.this, "Cmd+F presionado");
            }
        });

        // JLabel para demostrar MouseListener
        JLabel label = new JLabel("Haz clic sobre mí");
        label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) { //se hace clic y se llama cuando sueltas
                JOptionPane.showMessageDialog(GestionEventosSwing.this, "Label clickeado");
            }

            public void mouseEntered(MouseEvent e) {
                label.setText("¡Estas encima!");
            }

            public void mouseExited(MouseEvent e) {
                label.setText("Haz clic sobre mí");
            }

            public void mousePressed(MouseEvent e) { //segun haces clic
                label.setText("¡Me has presionado!");
            }

            public void mouseReleased(MouseEvent e) {
                label.setText("¡Me has soltado!");
            }

            public void mouseWheelMoved(MouseWheelEvent e) {
                label.setText("¡Rueda del ratón movida!");
            }


        });
        add(label);

        // JLabel que se podrá arrastrar
        JLabel draggableLabel = new JLabel("Arrástrame");
        draggableLabel.setTransferHandler(new TransferHandler("text"));

        // Habilitar el arrastre de texto desde el JLabel
        new DragSource().createDefaultDragGestureRecognizer(draggableLabel, DnDConstants.ACTION_COPY, new DragGestureListener() {
            // Este método se llama cuando se detecta un gesto de arrastre (drag gesture).
            public void dragGestureRecognized(DragGestureEvent event) {
                // Iniciar el arrastre.
                // DragSource.DefaultCopyDrop crea un cursor predeterminado.
                // new StringSelection(draggableLabel.getText()) es el contenido que se arrastra: el texto del JLabel.
                event.startDrag(DragSource.DefaultCopyDrop, new StringSelection(draggableLabel.getText()));
            }
        });

        add(draggableLabel);

        // JPanel que actuará como destino de la soltura
        JPanel dropPanel = new JPanel();
        dropPanel.setPreferredSize(new Dimension(200, 200)); // Define el tamaño del panel
        dropPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Añade un borde para visualización

        // Establecer el manejador de transferencia para el JPanel
        dropPanel.setTransferHandler(new TransferHandler() {
            // Este método determina si los datos ofrecidos son aceptables.
            public boolean canImport(TransferHandler.TransferSupport support) {
                // Verificar si los datos ofrecidos soportan el tipo de sabor de datos (DataFlavor) especificado.
                // En este caso, se verifica si es un String.
                return support.isDataFlavorSupported(DataFlavor.stringFlavor);
            }

            // Este método maneja la importación de los datos.
            public boolean importData(TransferHandler.TransferSupport support) {
                try {
                    // Extraer los datos transferidos. Aquí se espera que sean una cadena de texto.
                    String data = (String) support.getTransferable().getTransferData(DataFlavor.stringFlavor);
                    // Añadir un nuevo JLabel con los datos transferidos al dropPanel.
                    dropPanel.add(new JLabel(data));
                    // Revalidar el panel para actualizar la interfaz de usuario.
                    dropPanel.revalidate();
                    return true;
                } catch (Exception e) {
                    // Manejo de errores
                    e.printStackTrace();
                }
                return false;
            }
        });

        add(dropPanel);


        // Configuraciones finales del JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GestionEventosSwing();
    }
}
