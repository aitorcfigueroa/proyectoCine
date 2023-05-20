package views;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.io.File;
import java.io.IOException;
public class RegistroUsuarioFrame {
    private JFrame frame;
    private JPanel panelIzquierdo;
    private JPanel panelDerecho;
    private JPanel footerPanel;
    private JTextField nombreTextField;
    private JTextField correoTextField;
    private JPasswordField contrasenaPasswordField;
    private JButton registrarButton;

    public RegistroUsuarioFrame() {
        //Configuramos la ventana principal
        frame = new JFrame("Registro de Usuario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setLayout(new BorderLayout());

        //Cargamos la fuente Montserrat-Medium desde un archivo .ttf
        Font montserratMedium = loadFont("C:\\Users\\Angela\\IdeaProjects\\proyectoCine\\resources\\Montserrat-Medium.ttf");

        //Establecemos la fuente Montserrat-Medium como la fuente predeterminada para el proyecto
        setUIFont(new FontUIResource(montserratMedium));

        //Añadimos la imagen lateral que vamos a usar en ambos laterales de la ventana
        ImageIcon lateralIcon = new ImageIcon("C:\\Users\\Angela\\IdeaProjects\\proyectoCine\\resources\\lateral2.png");
        JLabel lateralLabelLeft = new JLabel(lateralIcon);
        JLabel lateralLabelRight = new JLabel(lateralIcon);

        //Creamos la barra de menú
        JMenuBar menuBar = createMenuBar();
        frame.setJMenuBar(menuBar);

        //Creamos un JPanel para el footer
        footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        footerPanel.setBackground(Color.GRAY);

        //Creamos el JLabel con el texto del footer
        JLabel footerLabel = new JLabel("Aitor Couñago - Ángela Serantes © 2023 ");
        footerLabel.setForeground(Color.WHITE);

        //Agregamos el JLabel al JPanel del footer
        footerPanel.add(footerLabel);


        //Creamos el JPanel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.DARK_GRAY);

        //Creamos el JPanel para el espacio adicional en la parte superior
        JPanel topSpacePanel = new JPanel();
        topSpacePanel.setOpaque(false);
        topSpacePanel.setPreferredSize(new Dimension(1, 100)); //Ajustar el tamaño del espacio superior
        topSpacePanel.setBackground(Color.DARK_GRAY);

        //Creamos el JPanel para el espacio adicional en la parte inferior
        JPanel bottomSpacePanel = new JPanel();
        bottomSpacePanel.setOpaque(false);
        bottomSpacePanel.setPreferredSize(new Dimension(1, 100)); //Ajustar el tamaño del espacio inferior
        bottomSpacePanel.setBackground(Color.DARK_GRAY);

        //Crear el JPanel para contener los componentes laterales, el formulario y el espacio adicional
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setOpaque(false); // Establecer el fondo como transparente

        //Crear el JPanel para el espacio a la izquierda del formulario
        JPanel leftSpacePanel = new JPanel();
        leftSpacePanel.setOpaque(false);
        leftSpacePanel.setPreferredSize(new Dimension(350, 1)); // Ajustar el tamaño del espacio izquierdo
        leftSpacePanel.setBackground(Color.DARK_GRAY); // Establecer el color de fondo de los laterales

        //Crear el JPanel para el espacio a la derecha del formulario
        JPanel rightSpacePanel = new JPanel();
        rightSpacePanel.setOpaque(false);
        rightSpacePanel.setPreferredSize(new Dimension(350, 1)); //Ajustar el tamaño del espacio derecho
        rightSpacePanel.setBackground(Color.DARK_GRAY); //Establecer el color de fondo de los laterales

        //Crear el formulario de registro de usuario
        JPanel formularioPanel = createFormularioPanel();

        //Ajustar los márgenes internos del formularioPanel
        Border formularioMargin = new EmptyBorder(10, 10, 10, 10);
        formularioPanel.setBorder(formularioMargin);

        //Aplicamos borde con esquinas redondeadas y grosor al formulario
        int radius = 40; // Radio de las esquinas redondeadas
        Border roundedBorder = new RoundBorder(radius, 6, Color.BLACK);
        formularioPanel.setBorder(roundedBorder);

        //Agregamos los componentes al BorderLayout
        contentPanel.add(topSpacePanel, BorderLayout.NORTH);
        contentPanel.add(leftSpacePanel, BorderLayout.WEST);
        contentPanel.add(rightSpacePanel, BorderLayout.EAST);
        contentPanel.add(formularioPanel, BorderLayout.CENTER);
        contentPanel.add(bottomSpacePanel, BorderLayout.SOUTH);

        //Agregamos los componentes al BorderLayout
        mainPanel.add(lateralLabelLeft, BorderLayout.WEST);
        mainPanel.add(lateralLabelRight, BorderLayout.EAST);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        //Agregamos los componentes al BorderLayout
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(footerPanel, BorderLayout.SOUTH);

        //Establecemos el tamaño de la ventana
        frame.setSize(1600, 900);
        frame.setLocationRelativeTo(null); //Centrar la ventana en la pantalla
        frame.setVisible(true);
    }
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        //Crear el panel izquierdo para los elementos alineados a la izquierda
        panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel labelInicio = new JLabel("Inicio");
        labelInicio.setFont(panelIzquierdo.getFont());
        panelIzquierdo.add(labelInicio);
        JLabel labelCartelera = new JLabel("Cartelera");
        labelCartelera.setFont(panelIzquierdo.getFont());
        panelIzquierdo.add(labelCartelera);

        //Crear el panel derecho para los elementos alineados a la derecha
        panelDerecho = new JPanel();
        panelDerecho.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JLabel labelComprarEntradas = new JLabel("Comprar entradas");
        labelComprarEntradas.setFont(panelDerecho.getFont());
        panelDerecho.add(labelComprarEntradas);
        JLabel labelIniciarSesion = new JLabel("Iniciar sesión");
        labelIniciarSesion.setFont(panelDerecho.getFont());
        panelDerecho.add(labelIniciarSesion);

        //Agregar los paneles a la barra de menú
        menuBar.add(panelIzquierdo);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(panelDerecho);

        return menuBar;
    }

}
