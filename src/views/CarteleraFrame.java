package views;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;

public class CarteleraFrame extends JFrame {

    //Array que almacena las rutas de las imágenes
    private static final String[] IMAGE_PATHS = {
            "../resources/peli1.png",
            "../resources/peli2.png",
            "../resources/peli3.png",
            "../resources/peli4.png",
            "../resources/peli5.png",
            "../resources/peli6.png"
    };

    private static final int SLIDE_DELAY = 2400; //Tiempo para el cambio de dispositivas

    private static int currentIndex = 0; //Índice de la imagen actual en el carrusel
    private static Timer timer;  //Temporizador utilizado para cambiar automáticamente las imágenes en el carrusel

    /**
     * Muestra la ventana principal de la cartelera.
     */
    public void mostrarVentana() {
        JFrame ventana = new JFrame("CineScript - Cartelera");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().setBackground(Color.DARK_GRAY);
        ventana.setLayout(new BorderLayout());

        //Carga de la fuente Montserrat-Medium
        Font montserratMedium = loadFont("../resources/Montserrat-Medium.ttf");

        //Se establece la fuente para el proyecto
        setUIFont(new FontUIResource(montserratMedium));

    }
}
