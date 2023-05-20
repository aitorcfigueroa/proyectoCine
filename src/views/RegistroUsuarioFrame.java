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


        // Creamos el JPanel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.DARK_GRAY);

        // Creamos el JPanel para el espacio adicional en la parte superior
        JPanel topSpacePanel = new JPanel();
        topSpacePanel.setOpaque(false);
        topSpacePanel.setPreferredSize(new Dimension(1, 100)); //Ajustar el tamaño del espacio superior
        topSpacePanel.setBackground(Color.DARK_GRAY);

        // Creamos el JPanel para el espacio adicional en la parte inferior
        JPanel bottomSpacePanel = new JPanel();
        bottomSpacePanel.setOpaque(false);
        bottomSpacePanel.setPreferredSize(new Dimension(1, 100)); //Ajustar el tamaño del espacio inferior
        bottomSpacePanel.setBackground(Color.DARK_GRAY);

    }
}
