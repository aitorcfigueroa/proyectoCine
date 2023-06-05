package views;

import clases.Pelicula;
import clases.Sesion;
import clases.SesionesPorSala;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import static controller.sesionesController.sesionesCtrl;

public class SesionesPorPeliculaFrame extends JFrame {
    public static JPanel peliculasPanel() throws IOException {
        ArrayList<SesionesPorSala> sesionesPorSalas = sesionesCtrl("Castelao", LocalDate.parse("2023-05-14"));
        JPanel peliculasPanel = new JPanel(new GridLayout(3, 2, 20, 20)); //Creamos un panel para organizar las peliculas en 3 filas y dos columnas con espacio horizontal y vertical
        peliculasPanel.setBackground(Color.DARK_GRAY); //Color de fondo del panel

        for (SesionesPorSala sesionPorSala: sesionesPorSalas) {
            Pelicula pelicula = sesionPorSala.getPelicula();
            JPanel panelPelicula = new JPanel(new BorderLayout());
            panelPelicula.setBackground(Color.DARK_GRAY);
            panelPelicula.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            Image poster = ImageIO.read(new URL(pelicula.getCartel())).getScaledInstance(200, -1, Image.SCALE_SMOOTH);
            ImageIcon posterEscalado = new ImageIcon(poster);
            JLabel labelPelicula = new JLabel(posterEscalado);
            panelPelicula.add(labelPelicula, BorderLayout.CENTER);

            JPanel panelInfo = new JPanel();
            panelInfo.setBackground(Color.DARK_GRAY);
            panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.Y_AXIS));
            panelInfo.add(Box.createVerticalStrut(20));

            JLabel tituloPelicula = new JLabel(pelicula.getTitulo());
            tituloPelicula.setForeground(Color.WHITE);
            tituloPelicula.setHorizontalAlignment(SwingConstants.CENTER);
            tituloPelicula.setAlignmentX(Component.CENTER_ALIGNMENT);
            panelInfo.add(tituloPelicula);

            JPanel panelHorarios = new JPanel();
            panelHorarios.setBackground(Color.DARK_GRAY);
            panelHorarios.setLayout(new FlowLayout(FlowLayout.CENTER));
            panelHorarios.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));

            for (Sesion sesion: sesionPorSala.getSesiones()) {
                String hora = sesion.getHora().toString();
                JButton botonHora = new JButton(hora);
                botonHora.setCursor(new Cursor(Cursor.HAND_CURSOR));
                panelHorarios.add(botonHora);
                botonHora.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        AsientosFrame asientosFrame = new AsientosFrame(sesion);
                        asientosFrame.setVisible(true);
                    }
                });

            }

            int edad = pelicula.getEdad();

            JButton botonEdad = new JButton(Integer.toString(edad));
            Color color = Color.ORANGE;
            if (edad >= 18) {
                color = Color.RED;
            } else if (edad < 12){
                color = Color.GREEN;
            }
            botonEdad.setBackground(color);
            panelHorarios.add(botonEdad);

            panelInfo.add(panelHorarios);
            panelPelicula.add(panelInfo, BorderLayout.SOUTH);
            peliculasPanel.add(panelPelicula);

            labelPelicula.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    String director = pelicula.getDirector();
                    int año = pelicula.getAño();
                    int duracion = pelicula.getDuracion();
                    String sinopsis = pelicula.getSinopsis();
                    String datosPelicula = "Director: " + director + " \nAño: " + año + " \nDuración: " + duracion + " minutos \nSinopsis: " + sinopsis;
                    ToolTipManager.sharedInstance().setInitialDelay(0);
                    panelPelicula.setToolTipText(datosPelicula);
                }
            });
        }

        return peliculasPanel;
    }
}
