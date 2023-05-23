package views;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.IOException;

public class SesionesFrame extends JFrame {

    //Constructor
    public SesionesFrame() {
        setTitle("CineScript"); //título de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //acción para cerrar la ventana
        getContentPane().setBackground(Color.DARK_GRAY); //color de fondo del contenido de la ventana

        //Carga de la fuente Montserrat-Medium
        Font montserratMedium = loadFont("C:\\Users\\Angela\\IdeaProjects\\proyectoCine\\resources\\Montserrat-Medium.ttf");

        //Se establece la fuente para el proyecto
        setUIFont(new FontUIResource(montserratMedium));

        //Se crea la barra de menú
        JMenuBar menuBar = new JMenuBar();

        //Creamos el panel izquierdo para mantener los elementos que queremos alineados a la izquierda en la barra de menú
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel labelInicio = new JLabel("Inicio");
        labelInicio.setFont(montserratMedium);
        panelIzquierdo.add(labelInicio);
        labelInicio.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Cambiar el diseño del cursor

        //Agregamos ActionListener a Inicio
        labelInicio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Abrir la ventana Inicio al hacer click en "Inicio"
                abrirVentanaInicio();
                dispose(); // Cerrar la ventana actual
            }
        });

        //Cartelera que está también en el panel izquierdo
        JLabel labelCartelera = new JLabel("Cartelera");
        labelCartelera.setFont(montserratMedium);
        panelIzquierdo.add(labelCartelera);
        labelCartelera.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Cambiar el diseño del cursor

        //Creamos el panel derecho para mantener los elementos que queremos alineados a la derecha en la barra de menú
        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JLabel labelComprarEntradas = new JLabel("Comprar entradas");
        labelComprarEntradas.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Cambiar el diseño del cursor
        labelComprarEntradas.setFont(montserratMedium);
        panelDerecho.add(labelComprarEntradas);

        JLabel labelIniciarSesion = new JLabel("Iniciar sesión");
        labelIniciarSesion.setFont(montserratMedium);
        panelDerecho.add(labelIniciarSesion);
        labelIniciarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Cambiar el diseño del cursor

        //Añadimos el componente "panelIzquierdo" a la barra de menú
        menuBar.add(panelIzquierdo);

        //Añadimos un espacio flexible horizontal en la barra de menú
        menuBar.add(Box.createHorizontalGlue());

        //Añadimos el componente "panelDerecho" a la barra de menú
        menuBar.add(panelDerecho);

        //Establecemos la barra de menú completa en la ventana
        setJMenuBar(menuBar);

        //Cargamos la imagen que se va a utilizar en ambos laterales de la ventana
        ImageIcon lateralIcon = new ImageIcon("C:\\Users\\Angela\\IdeaProjects\\proyectoCine\\resources\\lateral2.png");

        //Creamos un panel BorderLayout para poder organizar los componentes
        JPanel contentPanel = new JPanel(new BorderLayout());

        //Color de fondo del panel como gris oscuro
        contentPanel.setBackground(Color.DARK_GRAY);



        //Encabezado
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); //Creamos un panel para el header
        Color headerColor = Color.decode("#4D9694"); //Establecemos el color para el header
        headerPanel.setBackground(headerColor);//Color de fondo
        JLabel headerLabel = new JLabel("Elige tu sesión"); //Etiqueta con el texto del header
        headerLabel.setForeground(Color.WHITE); //Color del texto del header
        headerLabel.setFont(montserratMedium.deriveFont(Font.PLAIN, 18)); //Fuente y tamaño del header
        headerPanel.add(headerLabel);//Se añade la etiqueta del header al panel del header
        contentPanel.add(headerPanel, BorderLayout.NORTH); //Se posiciona el panel del header al panel principal en el norte

        contentPanel.add(new JLabel(lateralIcon), BorderLayout.WEST); //Se añade una etiqueta con la imagen lateral al panel principal al oeste
        contentPanel.add(new JLabel(lateralIcon), BorderLayout.EAST); //Se añade una etiqueta con la imagen lateral al panel principal al este


        JPanel peliculasPanel = new JPanel(new GridLayout(3, 2, 20, 20)); //Creamos un panel para organizar las peliculas en 3 filas y dos columnas con espacio horizontal y vertical
        peliculasPanel.setBackground(Color.DARK_GRAY); //Color de fondo del panel

        // Película 1
        JPanel panelPelicula1 = new JPanel(new BorderLayout()); //Creamos un panel para recoger la "Pelicula1" con BorderLayout
        panelPelicula1.setBackground(Color.DARK_GRAY); //Definimos el color de fondo como gris oscuro
        panelPelicula1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); //Borde vacío con un margen de 10 píxeles en cada lado del panel

    }
}
