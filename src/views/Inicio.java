package views;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;
public class Inicio {
    public static void main(String[] args) {
        //Se crea la ventana principal
        JFrame ventana = new JFrame("CineScript");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().setBackground(Color.DARK_GRAY);

    }
}
