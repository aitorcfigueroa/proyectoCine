package views;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;

// toDo en construcción hay que cambiar el gif y poner otra opción para el inicio
// toDo desplegar botones de menú
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

        //Se añade un header
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Color headerColor = Color.decode("#4D9694");
        headerPanel.setBackground(headerColor);

        JLabel headerLabel = new JLabel("Bienvenidas y bienvenidos a CineScript");
        headerLabel.setFont(montserratMedium.deriveFont(Font.PLAIN, 18));

        headerPanel.add(headerLabel);

        ventana.setLayout(new BorderLayout());
        ventana.add(headerPanel, BorderLayout.NORTH);

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

        //Agregamos un listener al evento de redimensionamiento de la ventana
        ventana.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Ajustar la posición del GIF al cambiar el tamaño de la ventana
                int gifX = (ventana.getWidth() - gifIcon.getIconWidth()) / 2;
                int gifY = (ventana.getHeight() - gifIcon.getIconHeight()) / 2;
                gifLabel.setBounds(gifX, gifY, gifIcon.getIconWidth(), gifIcon.getIconHeight());
            }
        });

        //Establecemos el tamaño de la ventana
        ventana.setSize(1600, 900);

        //Hacemos visible la ventana
        ventana.setVisible(true);
    }

    //Método para cargar la fuente desde un archivo .ttf
    private static Font loadFont(String fontFileName) {
        try {
            return Font.createFont(Font.TRUETYPE_FONT, new File(fontFileName)).deriveFont(Font.PLAIN, 14);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Método para establecer la fuente predeterminada para el proyecto en su conjunto
    private static void setUIFont(FontUIResource font) {
        UIManager.put("Button.font", font);
        UIManager.put("ToggleButton.font", font);
        UIManager.put("RadioButton.font", font);
        UIManager.put("CheckBox.font", font);
        UIManager.put("ColorChooser.font", font);
        UIManager.put("ComboBox.font", font);
        UIManager.put("Label.font", font);
        UIManager.put("List.font", font);
        UIManager.put("MenuBar.font", font);
        UIManager.put("MenuItem.font", font);
        UIManager.put("RadioButtonMenuItem.font", font);
        UIManager.put("CheckBoxMenuItem.font", font);
        UIManager.put("Menu.font", font);
        UIManager.put("PopupMenu.font", font);
        UIManager.put("OptionPane.font", font);
        UIManager.put("Panel.font", font);
        UIManager.put("ProgressBar.font", font);
        UIManager.put("ScrollPane.font", font);
        UIManager.put("Viewport.font", font);
        UIManager.put("TabbedPane.font", font);
        UIManager.put("Table.font", font);
        UIManager.put("TableHeader.font", font);
        UIManager.put("TextField.font", font);
        UIManager.put("PasswordField.font", font);
        UIManager.put("TextArea.font", font);
        UIManager.put("TextPane.font", font);
        UIManager.put("EditorPane.font", font);
        UIManager.put("TitledBorder.font", font);
        UIManager.put("ToolBar.font", font);
        UIManager.put("ToolTip.font", font);
        UIManager.put("Tree.font", font);
    }
}
