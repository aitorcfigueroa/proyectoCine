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
    }
}
