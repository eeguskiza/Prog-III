package Tema6;

import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;
import java.awt.*;

/**
 * Este ejemplo muestra dos constructores para un JTree. El primero utiliza un modelo personalizado
 * (CustomTreeModel) para construir una estructura de árbol personalizada. El segundo constructor
 * utiliza el modelo por defecto (DefaultTreeModel), que gestiona automáticamente la estructura del árbol.
 *
 * Diferencias clave entre el modelo personalizado y el modelo por defecto:
 *
 * Modelo Personalizado (CustomTreeModel):
 * - Se extiende DefaultTreeModel y permite una mayor personalización de la estructura del árbol.
 * - El programador tiene control total sobre la creación y organización de los nodos del árbol.
 * - Útil cuando se necesita una estructura de árbol específica o datos personalizados.
 *
 * Modelo por Defecto (DefaultTreeModel):
 * - Gestiona automáticamente la estructura del árbol utilizando DefaultMutableTreeNode.
 * - Adecuado para casos en los que la estructura del árbol es estándar y no requiere personalización.
 * - Facilita la construcción rápida de árboles sin necesidad de crear un modelo personalizado.
 */


public class JTreeExample extends JFrame {

    public JTreeExample(int i) {
        super("Ejemplo Avanzado de JTree");

        // Crear un JTree con el modelo por defecto (DefaultTreeModel)
        JTree tree = new JTree();

        // Permitir la selección de filas. Esto hace que la selección de nodos en el árbol sea más clara
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        // Añadir un listener para manejar la selección de nodos
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                if (selectedNode != null) {
                    // Acciones a realizar cuando se selecciona un nodo. Por ejemplo, imprimir el nombre del nodo
                    System.out.println("Nodo seleccionado: " + selectedNode.getUserObject());
                }
            }
        });

        // Añadir el árbol a un JScrollPane. Esto es útil si el árbol es muy grande y requiere desplazamiento
        JScrollPane treeView = new JScrollPane(tree);
        getContentPane().add(treeView);

        // Configuración básica del JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
    }

    public JTreeExample( ) {
        super("Ejemplo de JTree");

        // Crear un modelo personalizado para el árbol implementando la interfaz TreeModel
        CustomTreeModel customModel = new CustomTreeModel();

        // Crear un JTree utilizando el modelo personalizado
        JTree tree = new JTree(customModel);

        // Permitir la selección de filas. Esto hace que la selección de nodos en el árbol sea más clara
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        // Añadir un listener para manejar la selección de nodos
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                if (selectedNode != null) {
                    // Acciones a realizar cuando se selecciona un nodo. Por ejemplo, imprimir el nombre del nodo
                    System.out.println("Nodo seleccionado: " + selectedNode.getUserObject());
                }
            }
        });

        // Añadir el árbol a un JScrollPane. Esto es útil si el árbol es muy grande y requiere desplazamiento
        JScrollPane treeView = new JScrollPane(tree);
        getContentPane().add(treeView);

        // Configuración básica del JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
    }

    // Implementar un modelo personalizado que extiende DefaultTreeModel
    class CustomTreeModel extends DefaultTreeModel {
        public CustomTreeModel() {
            super(new DefaultMutableTreeNode("Raíz"));
            DefaultMutableTreeNode root = (DefaultMutableTreeNode) getRoot();

            // Añadir nodos al modelo personalizado
            DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("Nodo 1");
            DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("Nodo 2");
            root.add(node1);
            root.add(node2);

            node1.add(new DefaultMutableTreeNode("Hoja 1.1"));
            node2.add(new DefaultMutableTreeNode("Hoja 2.1"));
            node2.add(new DefaultMutableTreeNode("Hoja 2.2"));
        }
    }



    public static void main(String[] args) {
        // Iniciar la interfaz gráfica en el Event Dispatch Thread (EDT) para mantener la aplicación segura y receptiva
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //new JTreeExample().setVisible(true);
                //new JTreeExample(1).setVisible(true);
            }
        });
    }
}

