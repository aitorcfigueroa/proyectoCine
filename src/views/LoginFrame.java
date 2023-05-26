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
    }

}
