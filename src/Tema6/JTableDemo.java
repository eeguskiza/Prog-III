import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTableDemo extends JFrame {

    public JTableDemo() {
        super("Ejemplo de JTable");

        // Crear un modelo de datos para la tabla
        DefaultTableModel model = new DefaultTableModel();

        // Definir las columnas de la tabla
        model.addColumn("Nombre");
        model.addColumn("Edad");
        model.addColumn("Ciudad");

        // Agregar datos ficticios a la tabla
        model.addRow(new Object[]{"Juan", 25, "Madrid"});
        model.addRow(new Object[]{"María", 30, "Barcelona"});
        model.addRow(new Object[]{"Carlos", 22, "Valencia"});
        model.addRow(new Object[]{"Laura", 28, "Sevilla"});

        // Crear la tabla con el modelo de datos
        JTable table = new JTable(model);

        // Configurar la selección de filas y columnas
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(true);

        // Establecer la selección de celdas individuales
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Configurar el renderizador de celdas personalizado para alternar el fondo
        table.setDefaultRenderer(Object.class, new AlternatingRowRenderer());

        // Añadir la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Configuración básica del JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);
        setLocationRelativeTo(null);
    }

    // Renderizador de celdas personalizado para alternar el fondo de las filas
    class AlternatingRowRenderer extends DefaultTableCellRenderer {

        private boolean isRed = false;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if (!isSelected) {
                // Alterna el fondo entre rojo y blanco
                if (isRed) {
                    rendererComponent.setBackground(Color.RED);
                } else {
                    rendererComponent.setBackground(Color.WHITE);
                }
                isRed = !isRed;
            }

            return rendererComponent;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new JTableDemo().setVisible(true);
        });
    }
}
