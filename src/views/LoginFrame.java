package views;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginFrame extends JFrame {
    private JPanel headerPanel;
    private JPanel panelIzquierdo;
    private JPanel panelDerecho;
    private JPanel footerPanel;
    private JTextField correoTextField;
    private JPasswordField contrasenaPasswordField;
    private JButton iniciarSesionButton;

    public LoginFrame(){
        //configuramos ventana
        setTitle("Inicio de Sesión"); //título de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //acción para cerrar la ventana
        getContentPane().setBackground(Color.DARK_GRAY);//color de fondo
        setLayout(new BorderLayout());

        //Carga de la fuente Montserrat-Medium
        Font montserratMedium = loadFont("../resources/Montserrat-Medium.ttf");

        //Se establece la fuente para el proyecto
        setUIFont(new FontUIResource(montserratMedium));

        //Cargamos las imágenes laterales
        ImageIcon lateralIcon = new ImageIcon("../resources/lateral2.png");
        JLabel lateralLabelLeft = new JLabel(lateralIcon);
        JLabel lateralLabelRight = new JLabel(lateralIcon);


        //Encabezado
        //Creamos el JPanel para el encabezado
        headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(Color.decode("#4D9694"));

        //Creamos el JLabel con el texto del encabezado
        JLabel headerLabel = new JLabel("Inicia sesión");
        headerLabel.setFont(new Font(montserratMedium.getName(), Font.PLAIN, 18));
        headerLabel.setForeground(Color.WHITE);

        //Añadimos el JLabel al JPanel del encabezado
        headerPanel.add(headerLabel);

        //Crear la barra de menú
        JMenuBar menuBar = createMenuBar();
        setJMenuBar(menuBar);

        //footer
        //Creamos el JPanel para el footer
        footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        footerPanel.setBackground(Color.GRAY);

        //Creamos el JLabel con el texto del footer
        JLabel footerLabel = new JLabel("Aitor Couñago - Ángela Serantes © 2023 ");
        footerLabel.setForeground(Color.WHITE);

        //Añadimos el JLabel al JPanel del footer
        footerPanel.add(footerLabel);

        //Creamos el JPanel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.DARK_GRAY);

        //Creamos el JPanel para el espacio adicional en la parte superior
        JPanel topSpacePanel = new JPanel();
        topSpacePanel.setOpaque(false);
        topSpacePanel.setPreferredSize(new Dimension(1, 100)); //Ajustamos el tamaño del espacio superior
        topSpacePanel.setBackground(Color.DARK_GRAY);

        //Creamos el JPanel para el espacio adicional en la parte inferior
        JPanel bottomSpacePanel = new JPanel();
        bottomSpacePanel.setOpaque(false);
        bottomSpacePanel.setPreferredSize(new Dimension(1, 100)); // Ajustamos el tamaño del espacio inferior
        bottomSpacePanel.setBackground(Color.DARK_GRAY);

        //Creamos el JPanel para contener los componentes laterales, el formulario y el espacio adicional
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setOpaque(false); //Establecemos el fondo como transparente

        //Creamos el JPanel para el espacio a la izquierda del formulario
        JPanel leftSpacePanel = new JPanel();
        leftSpacePanel.setOpaque(false);
        leftSpacePanel.setPreferredSize(new Dimension(350, 1)); //Ajustamos el tamaño del espacio izquierdo
        leftSpacePanel.setBackground(Color.DARK_GRAY); //Establecemos el color de fondo de los laterales

        //Creamos el JPanel para el espacio a la derecha del formulario
        JPanel rightSpacePanel = new JPanel();
        rightSpacePanel.setOpaque(false);
        rightSpacePanel.setPreferredSize(new Dimension(350, 1)); //Ajustamos el tamaño del espacio derecho
        rightSpacePanel.setBackground(Color.DARK_GRAY); //Color de fondo de los laterales

        //Creamos el formulario de inicio de sesión
        JPanel formularioPanel = createFormularioPanel();

        //Márgenes internos del formularioPanel
        Border formularioMargin = new EmptyBorder(10, 10, 10, 10);
        formularioPanel.setBorder(formularioMargin);

        //Borde con esquinas redondeadas y grosor al formulario
        int radius = 40; // Radio de las esquinas redondeadas
        Border roundedBorder = new RoundBorder(radius, 6, Color.BLACK);
        formularioPanel.setBorder(roundedBorder);

        //Añadimos los componentes al BorderLayout
        contentPanel.add(topSpacePanel, BorderLayout.NORTH);
        contentPanel.add(leftSpacePanel, BorderLayout.WEST);
        contentPanel.add(rightSpacePanel, BorderLayout.EAST);
        contentPanel.add(formularioPanel, BorderLayout.CENTER);
        contentPanel.add(bottomSpacePanel, BorderLayout.SOUTH);

        //Añadimos los componentes al BorderLayout
        mainPanel.add(lateralLabelLeft, BorderLayout.WEST);
        mainPanel.add(lateralLabelRight, BorderLayout.EAST);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        //Añadimos los componentes al BorderLayout
        add(headerPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);

        //tamaño de la ventana
        setSize(1600, 900);
        setLocationRelativeTo(null); //Centrar la ventana en la pantalla

    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        //Creamos el panel izquierdo para mantener los elementos que queremos alineados a la izquierda en la barra de menú
        panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel labelInicio = new JLabel("Inicio");
        labelInicio.setFont(panelIzquierdo.getFont());
        labelInicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panelIzquierdo.add(labelInicio);
        JLabel labelCartelera = new JLabel("Cartelera");
        labelCartelera.setFont(panelIzquierdo.getFont());
        labelCartelera.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panelIzquierdo.add(labelCartelera);


        labelInicio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarVentanaInicio();
            }
        });
        // Crear el panel derecho para los elementos alineados a la derecha
        panelDerecho = new JPanel();
        panelDerecho.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JLabel labelComprarEntradas = new JLabel("Comprar entradas");
        labelComprarEntradas.setFont(panelDerecho.getFont());
        labelComprarEntradas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panelDerecho.add(labelComprarEntradas);
        // Botón de Cartelera
        labelCartelera.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                abrirCarteleraFrame();
            }
        });
        JLabel labelIniciarSesion = new JLabel("Iniciar sesión");
        labelIniciarSesion.setFont(panelDerecho.getFont());
        labelIniciarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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

        //ActionListener al labelComprarEntradas
        labelComprarEntradas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                abrirVentanaSesiones();
            }
        });


        //Añadimos los paneles a la barra de menú
        menuBar.add(panelIzquierdo);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(panelDerecho);

        return menuBar;
    }

}
