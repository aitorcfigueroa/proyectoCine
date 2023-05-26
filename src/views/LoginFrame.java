package views;

import javax.swing.*;
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

    }

}
