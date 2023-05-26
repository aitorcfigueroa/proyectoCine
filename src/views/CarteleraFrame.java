package views;

import javax.swing.*;

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
}
