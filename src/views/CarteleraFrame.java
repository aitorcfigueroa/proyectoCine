package views;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

        //barra de menú
        JMenuBar menuBar = new JMenuBar();

        //Creamos el panel izquierdo para mantener los elementos que queremos alineados a la izquierda en la barra de menú
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel labelInicio = new JLabel("Inicio");
        labelInicio.setFont(montserratMedium);
        labelInicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panelIzquierdo.add(labelInicio);
        JLabel labelCartelera = new JLabel("Cartelera");
        labelCartelera.setFont(montserratMedium);
        panelIzquierdo.add(labelCartelera);
        labelInicio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarVentanaInicio();
            }
        });

        //Creamos el panel derecho para mantener los elementos que queremos alineados a la derecha en la barra de menú
        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JLabel labelComprarEntradas = new JLabel("Comprar entradas");
        labelComprarEntradas.setFont(montserratMedium);
        panelDerecho.add(labelComprarEntradas);
        JLabel labelIniciarSesion = new JLabel("Iniciar sesión");
        labelIniciarSesion.setFont(montserratMedium);
        panelDerecho.add(labelIniciarSesion);

        //Creamos el menú desplegable de "Iniciar sesión"
        JPopupMenu menuDesplegable = new JPopupMenu();
        JMenuItem opcionLogin = new JMenuItem("Login");
        JMenuItem opcionRegistro = new JMenuItem("Regístrate");
        menuDesplegable.add(opcionLogin);
        menuDesplegable.add(opcionRegistro);

        opcionLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginFrame loginFrame = new LoginFrame();
                loginFrame.setVisible(true);
            }
        });

        opcionRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistroUsuarioFrame registroUsuarioFrame = new RegistroUsuarioFrame();
                registroUsuarioFrame.mostrarVentana();
            }
        });

        labelIniciarSesion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuDesplegable.show(labelIniciarSesion, 0, labelIniciarSesion.getHeight());
            }
        });

        //Cursor de la mano para los botones de menú
        labelInicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        labelCartelera.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        labelComprarEntradas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        labelIniciarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        //Agregamos los paneles con las posiciones a la barra de menú
        menuBar.add(panelIzquierdo);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(panelDerecho);

        //Asignamos la barra de menú a la ventana
        ventana.setJMenuBar(menuBar);

        //Carga imagen para laterales
        ImageIcon lateralIcon = new ImageIcon("../resources/lateral2.png");

        //Añadimos enncabezado

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(Color.GRAY);

        JLabel headerLabel = new JLabel("Cartelera CineScript");
        Color headerColor = Color.decode("#4D9694");
        headerPanel.setBackground(headerColor);
        headerLabel.setFont(montserratMedium.deriveFont(Font.PLAIN, 18));
        headerLabel.setForeground(Color.WHITE);

        headerPanel.add(headerLabel);

        //Creamos un panel que actúa de contenedor principal para organizar los componentes
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(Color.DARK_GRAY);
        contentPanel.add(headerPanel, BorderLayout.NORTH);
        contentPanel.add(new JLabel(lateralIcon), BorderLayout.WEST);
        contentPanel.add(new JLabel(lateralIcon), BorderLayout.EAST);

    }
}
