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

        //Película 1
        JPanel panelPelicula1 = new JPanel(new BorderLayout()); //Creamos un panel para recoger la "Pelicula1" con BorderLayout
        panelPelicula1.setBackground(Color.DARK_GRAY); //Definimos el color de fondo como gris oscuro
        panelPelicula1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); //Borde vacío con un margen de 10 píxeles en cada lado del panel

        //Cargamos la imagen de la película 1 desde la ruta relativa
        ImageIcon pelicula1 = new ImageIcon("../resources/peli1.png");

        //Se obtiene la imagen y se escala al tamaño deseado
        Image imagen1 = pelicula1.getImage().getScaledInstance(200, -1, Image.SCALE_SMOOTH);

        //Se crea un nuevo ImageIcon con la imagen escalada de la película 1
        ImageIcon pelicula1Scaled = new ImageIcon(imagen1);

        //Creamos un nuevo JLabel con la imagen escalada de la película 1
        JLabel labelPelicula1 = new JLabel(pelicula1Scaled);
        panelPelicula1.add(labelPelicula1, BorderLayout.CENTER); //Posicionamos el Jlabel en el centro

        //Se crea un nuevo JPanel llamado panelInfo1 para recoger la información de la primera película
        JPanel panelInfo1 = new JPanel();
        panelInfo1.setBackground(Color.DARK_GRAY); //Color del panel
        //Se establece un BoxLayout con orientación vertical en el panelInfo1
        panelInfo1.setLayout(new BoxLayout(panelInfo1, BoxLayout.Y_AXIS));
        //Añadimos espacio entre la imagen y el título
        panelInfo1.add(Box.createVerticalStrut(20));
        JLabel tituloPelicula1 = new JLabel("FATUM"); // etiqueta título de la película1
        tituloPelicula1.setForeground(Color.WHITE); //Color del texto
        tituloPelicula1.setHorizontalAlignment(SwingConstants.CENTER); //Se alinea el texto del JLabel al centro-horizontal
        tituloPelicula1.setAlignmentX(Component.CENTER_ALIGNMENT); //Se alinea el JLabel en el eje X al centro
        panelInfo1.add(tituloPelicula1); //Se añade la etiqueta al panel de info1 de la primera película

        //Creamos un nuevo JPanel llamado panelBotones1
        JPanel panelBotones1 = new JPanel();
        panelBotones1.setBackground(Color.DARK_GRAY); //Color de fondo del panel

        //Se establece un nuevo FlowLayout con alineación central en el panelBotones1
        panelBotones1.setLayout(new FlowLayout(FlowLayout.CENTER));

        panelBotones1.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0)); //Borde vacío para aumentar la distancia

        //Creamos un nuevo JButton llamado boton1_1 para sesión "16:00"
        JButton boton1_1 = new JButton("16:00");
        boton1_1.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Cursor mano
        //Creamos un nuevo JButton llamado boton1_2 para sesión "18:00"
        JButton boton1_2 = new JButton("18:00");
        boton1_2.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Cursor mano
        //Creamos un nuevo JButton llamado boton1_3 para sesión "20:00"
        JButton boton1_3 = new JButton("20:00");
        boton1_3.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Cursor mano
        //Creamos un nuevo JButton llamado boton1_4 para sesión "22:30"
        JButton boton1_4 = new JButton("22:30");
        boton1_4.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Cursor mano
        JButton boton1_5 = new JButton("00:30");
        //Creamos un nuevo JButton llamado boton1_5 para sesión "00:30"
        boton1_5.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Cursor mano
        //Creamos un nuevo JButton llamado botonEdad1 para recoger "Edad"
        JButton botonEdad1 = new JButton("Edad");
        botonEdad1.setBackground(Color.decode("#FF5757")); //Color de botónEdad1

        //Se añaden los botones al panel
        panelBotones1.add(boton1_1);
        panelBotones1.add(boton1_2);
        panelBotones1.add(boton1_3);
        panelBotones1.add(boton1_4);
        panelBotones1.add(boton1_5);
        panelBotones1.add(botonEdad1);

        //Se añade el panel Botones1 al panelInfo1
        panelInfo1.add(panelBotones1);

        //Se añade el panelInfo1 al panelPelicula1 al sur
        panelPelicula1.add(panelInfo1, BorderLayout.SOUTH);

        //Añadimos el panelPelicula1 al peliculasPanel
        peliculasPanel.add(panelPelicula1);

        //Evento al pasar el ratón por encima de la película 1
        labelPelicula1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ToolTipManager.sharedInstance().setInitialDelay(0);
                panelPelicula1.setToolTipText("Título: Película 1\nDirector: Director 1\nAño: 2023\nDuración: 95 minutos\nSinopsis: Sinopsis de la película 1");
            }
        });


        // Película 2
        JPanel panelPelicula2 = new JPanel(new BorderLayout()); //Creamos un panel para recoger la "Pelicula2" con BorderLayout
        panelPelicula2.setBackground(Color.DARK_GRAY); //Definimos el color de fondo como gris oscuro
        panelPelicula2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); //Borde vacío con un margen de 10 píxeles en cada lado del panel

        //Cargamos la imagen de la película2 desde la ruta relativa
        ImageIcon pelicula2 = new ImageIcon("../resources/peli2.png");
        //Se obtiene la imagen y se escala al tamaño deseado
        Image imagen2 = pelicula2.getImage().getScaledInstance(200, -1, Image.SCALE_SMOOTH);
        //Se crea un nuevo ImageIcon con la imagen escalada de la película 2
        ImageIcon pelicula2Scaled = new ImageIcon(imagen2);

        JLabel labelPelicula2 = new JLabel(pelicula2Scaled); //Creamos un nuevo JLabel con la imagen escalada de la película 2
        panelPelicula2.add(labelPelicula2, BorderLayout.CENTER); //Posicionamos el Jlabel en el centro

        //Se crea un nuevo JPanel llamado panelInfo2 para recoger la información de la segunda película
        JPanel panelInfo2 = new JPanel();
        panelInfo2.setBackground(Color.DARK_GRAY);//Color de fondo del panel
        //Se establece un BoxLayout con orientación vertical en el panelInfo2
        panelInfo2.setLayout(new BoxLayout(panelInfo2, BoxLayout.Y_AXIS));
        //Agregamos espacio entre la imagen y el título
        panelInfo2.add(Box.createVerticalStrut(20));

        JLabel tituloPelicula2 = new JLabel("SICA"); //Etiqueta título de la película2
        tituloPelicula2.setForeground(Color.WHITE);  //Color del texto
        tituloPelicula2.setHorizontalAlignment(SwingConstants.CENTER); //Se alinea el texto del JLabel al centro-horizontal
        tituloPelicula2.setAlignmentX(Component.CENTER_ALIGNMENT); //Se alinea el JLabel en el eje X al centro
        panelInfo2.add(tituloPelicula2); //Se añade la etiqueta del titulo al panel de info2 de la segunda película

        //Creamos un nuevo JPanel llamado panelBotones2
        JPanel panelBotones2 = new JPanel();
        panelBotones2.setBackground(Color.DARK_GRAY); //Color de fondo del panel
        //Se establece un nuevo FlowLayout con alineación al centro en el panelBotones2
        panelBotones2.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelBotones2.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0)); // Agregar un borde vacío para aumentar la distancia
        //Creamos un nuevo JButton llamado boton2_1 para sesión "16:30"
        JButton boton2_1 = new JButton("16:30");
        boton2_1.setCursor(new Cursor(Cursor.HAND_CURSOR)); //cursor mano
        //Creamos un nuevo JButton llamado boton2_2 para sesión "18:30"
        JButton boton2_2 = new JButton("18:30");
        boton2_2.setCursor(new Cursor(Cursor.HAND_CURSOR)); //cursor mano
        //Creamos un nuevo JButton llamado boton2_3 para sesión "20:30"
        JButton boton2_3 = new JButton("20:30");
        boton2_3.setCursor(new Cursor(Cursor.HAND_CURSOR)); //cursor mano
        //Creamos un nuevo JButton llamado boton2_4 para sesión "22:10"
        JButton boton2_4 = new JButton("22:10");
        boton2_4.setCursor(new Cursor(Cursor.HAND_CURSOR)); //cursor mano
        //Creamos un nuevo JButton llamado boton2_5 para sesión "00:30"
        JButton boton2_5 = new JButton("00:30");
        boton2_5.setCursor(new Cursor(Cursor.HAND_CURSOR)); //cursor mano
        //Creamos un nuevo JButton llamado botonEdad2 para recoger "Edad"
        JButton botonEdad2 = new JButton("Edad");
        botonEdad2.setBackground(Color.decode("#FFBD59")); //color del botón Edad2

        //Se añaden los botones al panel
        panelBotones2.add(boton2_1);
        panelBotones2.add(boton2_2);
        panelBotones2.add(boton2_3);
        panelBotones2.add(boton2_4);
        panelBotones2.add(boton2_5);
        panelBotones2.add(botonEdad2);
        //Se añade el panel Botones2 al panelInfo2
        panelInfo2.add(panelBotones2);

        //Añadimos el panelInfo2 al panelPelicula2 al sur
        panelPelicula2.add(panelInfo2, BorderLayout.SOUTH);

        //Añadimos el panelPelicula2 al peliculasPanel
        peliculasPanel.add(panelPelicula2);


        //Evento al pasar el ratón por encima de la película 2
        labelPelicula2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ToolTipManager.sharedInstance().setInitialDelay(0);
                panelPelicula2.setToolTipText("Título: Película 2\nDirector: Director 2\nAño: 2023\nDuración: 95 minutos\nSinopsis: Sinopsis de la película 2");
            }
        });


        // Película 3
        JPanel panelPelicula3 = new JPanel(new BorderLayout()); //Creamos un panel para recoger la "Pelicula3" con BorderLayout
        panelPelicula3.setBackground(Color.DARK_GRAY); //Color de fondo del panel
        panelPelicula3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); //Borde vacío con un margen de 10 píxeles en cada lado del panel

        //Cargamos la imagen de la película3 desde la ruta relativa
        ImageIcon pelicula3 = new ImageIcon("../resources/peli3.png");
        Image imagen3 = pelicula3.getImage().getScaledInstance(200, -1, Image.SCALE_SMOOTH); //Se obtiene la imagen y se escala al tamaño deseado
        ImageIcon pelicula3Scaled = new ImageIcon(imagen3); //Se crea un nuevo ImageIcon con la imagen escalada de la película 3

        JLabel labelPelicula3 = new JLabel(pelicula3Scaled); //Creamos un nuevo JLabel con la imagen escalada de la película 3
        panelPelicula3.add(labelPelicula3, BorderLayout.CENTER); //Posicionamos el Jlabel en el centro

        //Se crea un nuevo JPanel llamado panelInfo3 para recoger la información de la tercera película
        JPanel panelInfo3 = new JPanel();
        panelInfo3.setBackground(Color.DARK_GRAY); //Color de fondo del panel
        panelInfo3.setLayout(new BoxLayout(panelInfo3, BoxLayout.Y_AXIS)); //Se establece un BoxLayout con orientación vertical en el panelInfo3
        // Agregar espacio entre la imagen y el título
        panelInfo3.add(Box.createVerticalStrut(20));

        JLabel tituloPelicula3 = new JLabel("SUPER MARIO BROS LA PELÍCULA");   //Etiqueta título de la película3
        tituloPelicula3.setForeground(Color.WHITE); //Color del texto
        tituloPelicula3.setHorizontalAlignment(SwingConstants.CENTER); //Se alinea el texto del JLabel al centro-horizontal
        tituloPelicula3.setAlignmentX(Component.CENTER_ALIGNMENT); //Se alinea el JLabel en el eje X al centro
        panelInfo3.add(tituloPelicula3); //Se añade la etiqueta del titulo al panel de info3 de la tercera película

        //Creamos un nuevo JPanel llamado panelBotones3
        JPanel panelBotones3 = new JPanel();
        panelBotones3.setBackground(Color.DARK_GRAY); //Color de fondo del panel
        //Se establece un nuevo FlowLayout con alineación al centro en el panelBotones3
        panelBotones3.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelBotones3.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0)); //borde vacío para aumentar la distancia
        //Creamos un nuevo JButton llamado boton3_1 para sesión "16:15"
        JButton boton3_1 = new JButton("16:15");
        boton3_1.setCursor(new Cursor(Cursor.HAND_CURSOR)); //cursor mano
        //Creamos un nuevo JButton llamado boton3_2 para sesión "17:45"
        JButton boton3_2 = new JButton("17:45");
        boton3_2.setCursor(new Cursor(Cursor.HAND_CURSOR)); //cursor mano
        //Creamos un nuevo JButton llamado boton3_3 para sesión "19:10"
        JButton boton3_3 = new JButton("19:10");
        boton3_3.setCursor(new Cursor(Cursor.HAND_CURSOR)); //cursor mano
        //Creamos un nuevo JButton llamado boton3_4 para sesión "20:35"
        JButton boton3_4 = new JButton("20:35");
        boton3_4.setCursor(new Cursor(Cursor.HAND_CURSOR)); //cursor mano
        //Creamos un nuevo JButton llamado boton3_5 para sesión "21:55"
        JButton boton3_5 = new JButton("21:55");
        boton3_5.setCursor(new Cursor(Cursor.HAND_CURSOR)); //cursor mano
        //Creamos un nuevo JButton llamado botonEdad3 para recoger "Edad"
        JButton botonEdad3 = new JButton("Edad");
        botonEdad3.setBackground(Color.decode("#FFBD59"));

        //Se añaden los botones al panel
        panelBotones3.add(boton3_1);
        panelBotones3.add(boton3_2);
        panelBotones3.add(boton3_3);
        panelBotones3.add(boton3_4);
        panelBotones3.add(boton3_5);
        panelBotones3.add(botonEdad3);
        panelInfo3.add(panelBotones3);

        panelPelicula3.add(panelInfo3, BorderLayout.SOUTH);  //Añadimos el panelInfo3 al panelPelicula3 al sur
        peliculasPanel.add(panelPelicula3); //Añadimos el panelPelicula3 al peliculasPanel

        //Evento al pasar el ratón por encima de la película 3
        labelPelicula3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ToolTipManager.sharedInstance().setInitialDelay(0);
                panelPelicula3.setToolTipText("Título: Película 3\nDirector: Director 3\nAño: 2023\nDuración: 95 minutos\nSinopsis: Sinopsis de la película 3");
            }
        });

        //Película 4
        JPanel panelPelicula4 = new JPanel(new BorderLayout()); //Creamos un panel para recoger la "Pelicula4" con BorderLayout
        panelPelicula4.setBackground(Color.DARK_GRAY); //Color de fondo del panel
        panelPelicula4.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); //Borde vacío con un margen de 10 píxeles en cada lado del panel

    }
}
