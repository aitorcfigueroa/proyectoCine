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
    }
}
