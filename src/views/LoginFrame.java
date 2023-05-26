package views;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;
import java.awt.*;

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

    }

}
