package views;

import clases.Sesion;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static controller.sesionesController.updateSesionCtrl;

public class AsientosFrame extends JFrame {

    private JButton[][] asientos; //matriz para cuadrícula de botones

    private Map<String, ArrayList<Boolean>> butacas;

    private ArrayList<String> asientosSeleccionados;
    private Sesion sesion;
    //constructor
    public AsientosFrame(Sesion sesion){
        this.sesion=sesion;
        setTitle("Selección de Asientos"); //título de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //acción para cerrar la ventana
        getContentPane().setBackground(Color.DARK_GRAY); //color de fondo

        //Carga de la fuente Montserrat-Medium
        Font montserratMedium = loadFont(".\\resources\\Montserrat-Medium.ttf");

        //Se establece la fuente para el proyecto
        setUIFont(new FontUIResource(montserratMedium));

        //Cargamos la imagen que se va a emplear en los laterales
        ImageIcon lateralIcon = new ImageIcon(".\\resources\\lateral2.png");

        //Encabezado

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); //Creamos el JPanel para el encabezado

        JLabel headerLabel = new JLabel("Selección de Asientos"); //texto encabezado
        Color headerColor = Color.decode("#4D9694");//color encabezado
        headerPanel.setBackground(headerColor); //establecemos color de fondo
        headerLabel.setFont(montserratMedium.deriveFont(Font.PLAIN, 18)); //tamaño de la fuente
        headerLabel.setForeground(Color.WHITE); //color de texto

        headerPanel.add(headerLabel); //Añadimos la etiqueta del encabezado a su panel

        JPanel contentPanel = new JPanel(new BorderLayout()); //Creamos un panel contenedor
        contentPanel.setBackground(Color.DARK_GRAY); //color de fondo
        contentPanel.add(headerPanel, BorderLayout.NORTH); //añdimos el headerPanel al contentPanel al norte
        contentPanel.add(new JLabel(lateralIcon), BorderLayout.WEST); //añadimos imagen en la posición oeste
        contentPanel.add(new JLabel(lateralIcon), BorderLayout.EAST); //añadimos imagen en la posición este

        //Panel para los asientos
        JPanel asientosPanel = new JPanel(new GridBagLayout());
        asientosPanel.setBackground(Color.DARK_GRAY); //color de fondo

        //tamaño asientos, ocupados y seleccionados
        asientos = new JButton[10][10];
        butacas = sesion.getButacas();
        asientosSeleccionados = new ArrayList<>();

        GridBagConstraints gbc = new GridBagConstraints(); //configuramos la disposición
        gbc.insets = new Insets(5, 5, 5, 5); //márgenes internos

        /**
         * Creamos y configuramos los botones de los asientos en el panel de asientos.
         * Los botones representan los asientos y su estado de ocupación y selección.
         */

        for (int fila = 0; fila < 10; fila++) {
            for (int columna = 0; columna < 10; columna++) {
                String filaLetra = String.valueOf((char) ('A' + fila));
                String columnaNumero = String.valueOf(columna + 1);
                JButton botonAsiento = new JButton( filaLetra  + columnaNumero);
                botonAsiento.setFont(montserratMedium);
                botonAsiento.setBackground(Color.WHITE);
                botonAsiento.setPreferredSize(new Dimension(120, 120));

                if (butacas.containsKey(filaLetra) && butacas.get(filaLetra).get(columna)) {
                    botonAsiento.setEnabled(false);
                    botonAsiento.setBackground(Color.RED);
                } else {
                    botonAsiento.addActionListener(e -> {
                        JButton asientoSeleccionado = (JButton) e.getSource();
                        int filaSeleccionada = -1;
                        int columnaSeleccionada = -1;

                        for (int i = 0; i < asientos.length; i++) {
                            for (int j = 0; j < asientos[i].length; j++) {
                                if (asientos[i][j] == asientoSeleccionado) {
                                    filaSeleccionada = i;
                                    columnaSeleccionada = j;
                                    break;
                                }
                            }
                            if (filaSeleccionada != -1 && columnaSeleccionada != -1) {
                                break;
                            }
                        }

                        String asientoSeleccionadoTexto =  filaLetra  + columnaNumero;
                        if (asientosSeleccionados.contains(asientoSeleccionadoTexto)) {
                            asientosSeleccionados.remove(asientoSeleccionadoTexto);
                            asientoSeleccionado.setBackground(Color.WHITE);
                        } else {
                            asientosSeleccionados.add(asientoSeleccionadoTexto);
                            asientoSeleccionado.setBackground(Color.YELLOW);
                        }
                    });
                }

                asientos[fila][columna] = botonAsiento; //se posiciona el boton de asiento creado en la posición de la matriz
                gbc.gridx = columna; //columna en la que se coloca el botón
                gbc.gridy = fila; //fila en la que se coloca el botón
                asientosPanel.add(botonAsiento, gbc); //añadimos los botones al panel de asientos
            }
        }

        contentPanel.add(asientosPanel, BorderLayout.CENTER); //añadimos los asientos al contenedor principal en el centro

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));//nuevo panel para recoger botones de comprar y cancelar
        buttonsPanel.setBackground(Color.decode("#4D9694")); //color de fondo

        JButton comprarButton = new JButton("Comprar"); //botón de comprar
        comprarButton.setFont(montserratMedium); //fuente
        comprarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //cursor mano
        buttonsPanel.add(comprarButton); //añadir botón al panel de buttons

        JButton cancelarButton = new JButton("Cancelar");
        cancelarButton.setFont(montserratMedium); //fuente
        cancelarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //cursor mano
        buttonsPanel.add(cancelarButton); //añadir botón al panel de buttons

        //ActionListener para el botón cancelar
        //Crea una instancia de la clase inicio y muestra su ventana
        cancelarButton.addActionListener(e -> {
            Inicio inicioFrame = new Inicio();
            inicioFrame.setVisible(true);
            dispose(); //cierra la ventana actual
        });

        //footer
        //Creamos el JPanel para el footer
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        footerPanel.setBackground(Color.GRAY); //color de fondo

        //Creamos el JLabel con el texto del footer
        JLabel footerLabel = new JLabel("Aitor Couñago - Ángela Serantes © 2023 ");
        footerLabel.setForeground(Color.WHITE);
        //Añadimos el JLabel al JPanel del footer
        footerPanel.add(footerLabel);

        contentPanel.add(buttonsPanel, BorderLayout.SOUTH); //Añadimos el panel de botones al contentPanel

        setLayout(new BorderLayout()); //diseño de la ventana

        add(contentPanel, BorderLayout.CENTER); //panel contenedor en el centro
        add(footerPanel, BorderLayout.SOUTH); //panel footer al sur

        setSize(1000, 800); //tamaño ventana
        setVisible(true); //visibilidad ventana

        /**
         * ActionListener para el botón "Comprar".
         * Es el encargado de controlar la acción cuando se hace click en el botón "Comprar".
         * Permite al usuario/a seleccionar la ubicación deseada y el nombre del archivo y guarda la entrada en un archivo de texto.
         * Muestra mensajes de confirmación o error según el resultado del proceso de guardado.
         */
        comprarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int seleccion = fileChooser.showSaveDialog(AsientosFrame.this);

                if (seleccion == JFileChooser.APPROVE_OPTION) {
                    File archivoDestino = fileChooser.getSelectedFile();
                    String filePath = archivoDestino.getAbsolutePath();

                    if (!filePath.toLowerCase().endsWith(".txt")) {
                        archivoDestino = new File(filePath + ".txt");
                    }

                    try {
                        archivoDestino.createNewFile();

                        BufferedWriter writer = new BufferedWriter(new FileWriter(archivoDestino));
                        writer.write("Película: " + sesion.getPelicula().getTitulo());
                        writer.newLine();
                        writer.write("Sala: " + sesion.getIdSala());
                        writer.newLine();
                        writer.write("Fecha: " + sesion.getFecha());
                        writer.newLine();
                        writer.write("Hora: " + sesion.getHora());
                        writer.newLine();
                        writer.newLine();
                        writer.write("Asientos seleccionados:");
                        writer.newLine();
                        for (String asientoSeleccionado : asientosSeleccionados) {
                            writer.write("Asiento " + asientoSeleccionado );
                            writer.newLine();
                        }

                        writer.close();
                        JOptionPane.showMessageDialog(AsientosFrame.this, "Entrada guardada correctamente en el archivo.");

                        updateSesionCtrl(sesion,asientosSeleccionados);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(AsientosFrame.this, "Error al guardar su entrada en el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

        });
    }

    //Método para cargar la fuente desde un archivo .ttf
    private static Font loadFont(String fontFileName) {
        try {
            return Font.createFont(Font.TRUETYPE_FONT, new File(fontFileName)).deriveFont(Font.PLAIN, 14);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Método para establecer la fuente predeterminada para el proyecto en su conjunto
    private static void setUIFont(FontUIResource font) {
        UIManager.put("Button.font", font);
        UIManager.put("ToggleButton.font", font);
        UIManager.put("RadioButton.font", font);
        UIManager.put("CheckBox.font", font);
        UIManager.put("ColorChooser.font", font);
        UIManager.put("ComboBox.font", font);
        UIManager.put("Label.font", font);
        UIManager.put("List.font", font);
        UIManager.put("MenuBar.font", font);
        UIManager.put("MenuItem.font", font);
        UIManager.put("RadioButtonMenuItem.font", font);
        UIManager.put("CheckBoxMenuItem.font", font);
        UIManager.put("Menu.font", font);
        UIManager.put("PopupMenu.font", font);
        UIManager.put("OptionPane.font", font);
        UIManager.put("Panel.font", font);
        UIManager.put("ProgressBar.font", font);
        UIManager.put("ScrollPane.font", font);
        UIManager.put("Viewport.font", font);
        UIManager.put("TabbedPane.font", font);
        UIManager.put("Table.font", font);
        UIManager.put("TableHeader.font", font);
        UIManager.put("TextField.font", font);
        UIManager.put("PasswordField.font", font);
        UIManager.put("TextArea.font", font);
        UIManager.put("TextPane.font", font);
        UIManager.put("EditorPane.font", font);
        UIManager.put("TitledBorder.font", font);
        UIManager.put("ToolBar.font", font);
        UIManager.put("ToolTip.font", font);
        UIManager.put("Tree.font", font);
    }

    //Punto de entrada
   /**public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            //Crear y mostrar la ventana de AsientosFrame
            Sesion sesion = new Sesion();
            AsientosFrame asientosFrame = new AsientosFrame(sesion);
            asientosFrame.setVisible(true);
        });
    }**/
}
