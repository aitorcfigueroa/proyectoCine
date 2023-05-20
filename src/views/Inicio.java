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

        //Carga de la fuente Montserrat-Medium
        Font montserratMedium = loadFont("C:\\Users\\Angela\\IdeaProjects\\proyectoCine\\resources\\Montserrat-Medium.ttf");

        //Se establece la fuente para el proyecto
        setUIFont(new FontUIResource(montserratMedium));

        //Se crea la barra de menú
        JMenuBar menuBar = new JMenuBar();

        //Creamos el panel izquierdo para mantener los elementos que queremos alineados a la izquierda en la barra de menú
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel labelInicio = new JLabel("Inicio");
        labelInicio.setFont(montserratMedium);
        panelIzquierdo.add(labelInicio);
        JLabel labelCartelera = new JLabel("Cartelera");
        labelCartelera.setFont(montserratMedium);
        panelIzquierdo.add(labelCartelera);

        //Creamos el panel derecho para mantener los elementos que queremos alineados a la derecha en la barra de menú
        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JLabel labelComprarEntradas = new JLabel("Comprar entradas");
        labelComprarEntradas.setFont(montserratMedium);
        panelDerecho.add(labelComprarEntradas);
        JLabel labelIniciarSesion = new JLabel("Iniciar sesión");
        labelIniciarSesion.setFont(montserratMedium);
        panelDerecho.add(labelIniciarSesion);

        //Agregamos los paneles con las posiciones a la barra de menú
        menuBar.add(panelIzquierdo);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(panelDerecho);

        //Asignamos la barra de menú a la ventana
        ventana.setJMenuBar(menuBar);


    }
}
