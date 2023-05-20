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

        //Cargamos el archivo GIF mientras está en construcción la página
        ImageIcon gifIcon = new ImageIcon("C:\\Users\\Angela\\IdeaProjects\\proyectoCine\\resources\\logo1.gif");
        JLabel gifLabel = new JLabel(gifIcon);

        //Cargamos la imagen lateral, que vamos a usar en ambos laterales
        ImageIcon lateralIcon = new ImageIcon("C:\\Users\\Angela\\IdeaProjects\\proyectoCine\\resources\\lateral2.png");
        JLabel lateralLabelLeft = new JLabel(lateralIcon);
        JLabel lateralLabelRight = new JLabel(lateralIcon);

        //Crear el JPanel para poder usar el footer con texto y color personalizado como otro componente
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        footerPanel.setBackground(Color.GRAY);

        //Creamos el JLabel con el texto del footer
        JLabel footerLabel = new JLabel("Aitor Couñago - Ángela Serantes © 2023 ");
        footerLabel.setForeground(Color.WHITE);

        //Agregamos el JLabel al JPanel del footer
        footerPanel.add(footerLabel);

        //Establecemos un BorderLayout para organizar el contenido principal de la ventana
        ventana.setLayout(new BorderLayout());

        //Agregamos los componentes anteriores al BorderLayout de la ventana
        ventana.add(lateralLabelLeft, BorderLayout.WEST);
        ventana.add(lateralLabelRight, BorderLayout.EAST);
        ventana.add(gifLabel, BorderLayout.CENTER);
        ventana.add(footerPanel, BorderLayout.SOUTH);

    }
}
