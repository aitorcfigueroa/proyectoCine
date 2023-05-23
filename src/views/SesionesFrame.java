package views;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.IOException;

public class SesionesFrame extends JFrame {

    //Constructor
    public SesionesFrame() {
        setTitle("CineScript"); //título de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //acción para cerrar la ventana
        getContentPane().setBackground(Color.DARK_GRAY); //color de fondo del contenido de la ventana

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
        labelInicio.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Cambiar el diseño del cursor

        //Agregamos ActionListener a Inicio
        labelInicio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Abrir la ventana Inicio al hacer click en "Inicio"
                abrirVentanaInicio();
                dispose(); // Cerrar la ventana actual
            }
        });

        //Cartelera que está también en el panel izquierdo
        JLabel labelCartelera = new JLabel("Cartelera");
        labelCartelera.setFont(montserratMedium);
        panelIzquierdo.add(labelCartelera);
        labelCartelera.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Cambiar el diseño del cursor

        //Creamos el panel derecho para mantener los elementos que queremos alineados a la derecha en la barra de menú
        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JLabel labelComprarEntradas = new JLabel("Comprar entradas");
        labelComprarEntradas.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Cambiar el diseño del cursor
        labelComprarEntradas.setFont(montserratMedium);
        panelDerecho.add(labelComprarEntradas);

        JLabel labelIniciarSesion = new JLabel("Iniciar sesión");
        labelIniciarSesion.setFont(montserratMedium);
        panelDerecho.add(labelIniciarSesion);
        labelIniciarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Cambiar el diseño del cursor

        //Añadimos el componente "panelIzquierdo" a la barra de menú
        menuBar.add(panelIzquierdo);

        //Añadimos un espacio flexible horizontal en la barra de menú
        menuBar.add(Box.createHorizontalGlue());

        //Añadimos el componente "panelDerecho" a la barra de menú
        menuBar.add(panelDerecho);

        //Establecemos la barra de menú completa en la ventana
        setJMenuBar(menuBar);
    }
}
