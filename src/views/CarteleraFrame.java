package views;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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

        //Añadimos el carrusel de imágenes al panel de contenido de la ventana principal
        addImageCarousel(contentPanel, ventana);

        //Creamos un panel para lograr espacio
        JPanel spacingPanel1 = new JPanel();
        spacingPanel1.setBackground(Color.DARK_GRAY);
        spacingPanel1.setPreferredSize(new Dimension(contentPanel.getWidth(), 50));

        //Creamos un panel de espaciado de botones
        JPanel buttonSpacingPanel = new JPanel();
        buttonSpacingPanel.setBackground(Color.DARK_GRAY);
        buttonSpacingPanel.setPreferredSize(new Dimension(contentPanel.getWidth(), 200));

        //footer
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        footerPanel.setBackground(Color.GRAY);

        JLabel footerLabel = new JLabel("Aitor Couñago - Ángela Serantes © 2023 ");
        footerLabel.setForeground(Color.WHITE);

        footerPanel.add(footerLabel);

        //Agregamos los componentes anteriores al BorderLayout de la ventana
        ventana.add(contentPanel, BorderLayout.CENTER);
        ventana.add(spacingPanel1, BorderLayout.SOUTH);
        ventana.add(buttonSpacingPanel, BorderLayout.SOUTH);
        ventana.add(footerPanel, BorderLayout.PAGE_END);

        //tamaño de la ventana
        ventana.setSize(1600, 900);
        ventana.setVisible(true); //visibilidad de la ventana

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
    /**
     * Muestra la ventana de inicio y cierra la ventana actual.
     */
    private void mostrarVentanaInicio() {
        Inicio inicio = new Inicio();
        inicio.setVisible(true);
        dispose(); // Cerrar la ventana
    }

    /**
     * Abre la ventana de sesiones en un hilo de eventos de Swing.
     */
    private static void abrirVentanaSesiones() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SesionesFrame sesionesFrame = new SesionesFrame();
                sesionesFrame.setVisible(true);
            }
        });
    }

    /**
     * Añadimos el carrusel de imágenes al panel principal.
     * @param parentPanel El panel al que se agregará el carrusel de imágenes.
     * @param ventana La ventana principal del programa.
     */
    private static void addImageCarousel(JPanel parentPanel, JFrame ventana) {
        //Creamos el panel del carrusel con un BorderLayout
        JPanel carouselPanel = new JPanel(new BorderLayout());
        carouselPanel.setBackground(Color.DARK_GRAY);

        //Etiqueta que sirve para visualizar las imágenes centradas en el carrusel
        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);

        //Color para los botones del carrusel
        Color buttonColor = Color.decode("#4D9694");

        //Botón para ir a la imagen anterior
        JButton previousButton = new JButton("<");
        previousButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        previousButton.setForeground(buttonColor);
        previousButton.setOpaque(false);
        previousButton.setContentAreaFilled(false);
        previousButton.setBorderPainted(false);
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentIndex = (currentIndex - 1 + IMAGE_PATHS.length) % IMAGE_PATHS.length;
                updateImage(imageLabel, ventana);
            }
        });

        //Botón para ir a la siguiente imagen
        JButton nextButton = new JButton(">");
        nextButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        nextButton.setForeground(buttonColor); // Asignar el color a los botones
        nextButton.setOpaque(false);
        nextButton.setContentAreaFilled(false);
        nextButton.setBorderPainted(false);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentIndex = (currentIndex + 1) % IMAGE_PATHS.length;
                updateImage(imageLabel, ventana);
            }
        });

        //Panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.DARK_GRAY);
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(previousButton, BorderLayout.WEST);
        buttonPanel.add(nextButton, BorderLayout.EAST);

        //Añadimos la etiqueta de la imagen y el panel de botones al panel del carrusel
        carouselPanel.add(imageLabel, BorderLayout.CENTER);
        carouselPanel.add(buttonPanel, BorderLayout.SOUTH);

        //Añadimos el panel del carrusel al panel principal
        parentPanel.add(carouselPanel, BorderLayout.CENTER);

        //Se configura y empieza el temporizador para cambiar automáticamente las imágenes
        timer = new Timer(SLIDE_DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentIndex = (currentIndex + 1) % IMAGE_PATHS.length;
                updateImage(imageLabel, ventana);
            }
        });
        timer.start();
    }
}
