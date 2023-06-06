package views;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.IOException;

/**
 * La clase SesionesFrame representa la ventana de sesiones de la aplicación
 */
public class SesionesFrame extends JFrame {

    //Constructor
    public SesionesFrame() throws IOException {
        setTitle("CineScript"); //título de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //acción para cerrar la ventana
        getContentPane().setBackground(Color.DARK_GRAY); //color de fondo del contenido de la ventana

        //Carga de la fuente Montserrat-Medium
        Font montserratMedium = loadFont(".\\resources\\Montserrat-Medium.ttf");

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

        // Agregar ActionListener al labelInicio
        labelInicio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Abrir la ventana Inicio al hacer clic en "Inicio"
                abrirVentanaInicio();
                dispose(); // Cerrar la ventana actual
            }
        });

        //Cartelera que está también en el panel izquierdo
        JLabel labelCartelera = new JLabel("Cartelera");
        labelCartelera.setFont(montserratMedium);
        panelIzquierdo.add(labelCartelera);
        labelCartelera.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Cambiar el diseño del cursor

        //Botón de Cartelera-MouseListener
        labelCartelera.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                abrirCarteleraFrame();
            }
        });

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

        // Crear el menú desplegable de "Iniciar sesión"
        JPopupMenu menuDesplegable = new JPopupMenu();
        JMenuItem opcionLogin = new JMenuItem("Login");
        JMenuItem opcionRegistro = new JMenuItem("Regístrate");
        menuDesplegable.add(opcionLogin);
        menuDesplegable.add(opcionRegistro);

        opcionLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginFrame loginFrame = new LoginFrame();
                loginFrame.setVisible(true);
            }
        });

        opcionRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistroUsuarioFrame registroUsuarioFrame = new RegistroUsuarioFrame();
                registroUsuarioFrame.mostrarVentana();
            }
        });

        labelIniciarSesion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuDesplegable.show(labelIniciarSesion, 0, labelIniciarSesion.getHeight());
            }
        });

        //Añadimos el componente "panelIzquierdo" a la barra de menú
        menuBar.add(panelIzquierdo);

        //Añadimos un espacio flexible horizontal en la barra de menú
        menuBar.add(Box.createHorizontalGlue());

        //Añadimos el componente "panelDerecho" a la barra de menú
        menuBar.add(panelDerecho);

        //Establecemos la barra de menú completa en la ventana
        setJMenuBar(menuBar);

        //Cargamos la imagen que se va a utilizar en ambos laterales de la ventana
        ImageIcon lateralIcon = new ImageIcon(".\\resources\\lateral2.png");

        //Creamos un panel BorderLayout para poder organizar los componentes
        JPanel contentPanel = new JPanel(new BorderLayout());

        //Color de fondo del panel como gris oscuro
        contentPanel.setBackground(Color.DARK_GRAY);


        //Encabezado
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); //Creamos un panel para el header
        Color headerColor = Color.decode("#4D9694"); //Establecemos el color para el header
        headerPanel.setBackground(headerColor);//Color de fondo
        JLabel headerLabel = new JLabel("Elige tu sesión"); //Etiqueta con el texto del header
        headerLabel.setForeground(Color.WHITE); //Color del texto del header
        headerLabel.setFont(montserratMedium.deriveFont(Font.PLAIN, 18)); //Fuente y tamaño del header
        headerPanel.add(headerLabel);//Se añade la etiqueta del header al panel del header
        contentPanel.add(headerPanel, BorderLayout.NORTH); //Se posiciona el panel del header al panel principal en el norte

        contentPanel.add(new JLabel(lateralIcon), BorderLayout.WEST); //Se añade una etiqueta con la imagen lateral al panel principal al oeste
        contentPanel.add(new JLabel(lateralIcon), BorderLayout.EAST); //Se añade una etiqueta con la imagen lateral al panel principal al este

        JPanel peliculasPanel = SesionesPorPeliculaFrame.peliculasPanel();

        //Creamos un JscrollPane asociado al panel de películas
        JScrollPane scrollPane = new JScrollPane(peliculasPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); //Barra scroll vertical
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); //Se tablece la política en NEVER para la barra horizontal
        contentPanel.add(scrollPane, BorderLayout.CENTER); //Se añade al panel

        //Footer
        JPanel footerPanel = new JPanel(new BorderLayout()); //Creamos un nuevo JPanel llamado footerPanel con BorderLayout para organizar los componentes
        footerPanel.setBackground(Color.GRAY); //Color de fondo del panel
        JPanel footerTextPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));// Creamos un JPanel llamado footerTextPanel
        footerTextPanel.setBackground(Color.GRAY); //Color de fondo del panel

        JLabel footerLabel = new JLabel("Aitor Couñago - Ángela Serantes © 2023 "); //Creamos un nuevo Jlabel con el texto del footer
        footerLabel.setForeground(Color.WHITE); //Color del texto
        footerLabel.setHorizontalAlignment(SwingConstants.CENTER); //Alineamos el texto al centro
        footerTextPanel.add(footerLabel); //Se añade la etiqueta al panel

        footerPanel.add(footerTextPanel, BorderLayout.CENTER); //Posicionamos al centro el footertext

        contentPanel.add(footerPanel, BorderLayout.SOUTH); //Posicionamos el panel al sur

        setContentPane(contentPanel); //Establecemos el contentPane como el contentPanel
        pack(); //Ajustamos la ventana según el contenido
        setLocationRelativeTo(null); //Centramos la ventana en la pantalla
    }

    /**
     * Método para cargar la fuente desde un archivo .ttf
     * @param fontFileName
     * @return
     */
    private static Font loadFont(String fontFileName) {
        try {
            return Font.createFont(Font.TRUETYPE_FONT, new File(fontFileName)).deriveFont(Font.PLAIN, 14);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * Método para establecer la fuente predeterminada para el proyecto en su conjunto
     * @param font
     */
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

    /**
     * Método para mostrar la ventana de Inicio
     */

    private static void abrirVentanaInicio() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Inicio.main(null);
            }
        });
    }

    /**
     * Abre la ventana de la cartelera de películas.
     * Este método crea una instancia de la cartelera de películas y lo muestra en la interfaz de usuario.
     * La cartelera proporciona una visualización de las películas disponibles.
     */

    private static void abrirCarteleraFrame() {
        CarteleraFrame carteleraFrame = new CarteleraFrame();
        carteleraFrame.mostrarVentana();
    }


    /**
     * Punto de entrada para la aplicación.
     * Crea y muestra la ventana "SesionesFrame" en el hilo de eventos de Swing.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SesionesFrame(); //Iniciamos la aplicación Swing al invocar el método run()
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}

