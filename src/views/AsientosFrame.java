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

    }
}
