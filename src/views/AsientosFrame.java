package views;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;

public class AsientosFrame extends JFrame {

    private JButton[][] asientos; //matriz para cuadrícula de botones

    private boolean[][] ocupados; //matriz para indicar si el asiento está ocupado o no

    private boolean[][] seleccionados; //matriz para indicar si el asiento está siendo seleccionado o no

    //constructor
    public AsientosFrame(){
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
        ocupados = new boolean[10][10];
        seleccionados = new boolean[10][10];

        GridBagConstraints gbc = new GridBagConstraints(); //configuramos la disposición
        gbc.insets = new Insets(5, 5, 5, 5); //márgenes internos

        /**
         * Creamos y configuramos los botones de los asientos en el panel de asientos.
         * Los botones representan los asientos y su estado de ocupación y selección.
         */

        for (int fila = 0; fila < 10; fila++) {
            for (int columna = 0; columna < 10; columna++) {
                JButton botonAsiento = new JButton("F:" + (fila + 1) + ", A:" + (columna + 1));
                botonAsiento.setFont(montserratMedium);
                botonAsiento.setBackground(Color.WHITE);
                botonAsiento.setPreferredSize(new Dimension(120, 120)); //tamaño del botón

                //Comprobamos si el asiento está ocupado
                if (ocupados[fila][columna]) {
                    botonAsiento.setEnabled(false);
                    botonAsiento.setBackground(Color.RED);
                } else {
                    botonAsiento.addActionListener(e -> {
                        JButton asientoSeleccionado = (JButton) e.getSource();
                        int filaSeleccionada = -1;
                        int columnaSeleccionada = -1;

                        //Buscamos el botón seleccionado en la matriz de asientos
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

                        // Verificar si el asiento está ocupado
                        if (ocupados[filaSeleccionada][columnaSeleccionada]) {
                            return;
                        }

                        //Cambiamos el estado del asiento seleccionado
                        seleccionados[filaSeleccionada][columnaSeleccionada] = !seleccionados[filaSeleccionada][columnaSeleccionada];

                        //Cambiamos el color del botón según su estado actual
                        if (seleccionados[filaSeleccionada][columnaSeleccionada]) {
                            //Asiento seleccionado = color amarillo
                            asientoSeleccionado.setBackground(Color.YELLOW);
                        } else {
                            //Asiento deseleccionado = color blanco
                            asientoSeleccionado.setBackground(Color.WHITE);
                        }
                    });
                }

                asientos[fila][columna] = botonAsiento; //se posiciona el boton de asiento creado en la posición de la matriz
                gbc.gridx = columna; //columna en la que se coloca el botón
                gbc.gridy = fila; //fila en la que se coloca el botón
                asientosPanel.add(botonAsiento, gbc); //añadimos los botones al panel de asientos
            }
        }


    }
}
