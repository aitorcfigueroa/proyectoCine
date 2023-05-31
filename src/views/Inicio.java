package views;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Inicio extends JFrame{
    public Inicio () {
        setTitle("CineScript");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.DARK_GRAY);


        //Carga de la fuente Montserrat-Medium
        Font montserratMedium = loadFont("../resources/Montserrat-Medium.ttf");

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
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);

        setLayout(new BorderLayout());
        add(headerPanel, BorderLayout.NORTH);

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

        //Establecemos el hand cursor para los botones de menú
        labelInicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        labelCartelera.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        labelComprarEntradas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        labelIniciarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       
        //Agregamos los paneles con las posiciones a la barra de menú
        menuBar.add(panelIzquierdo);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(panelDerecho);

        //Asignamos la barra de menú a la ventana
        setJMenuBar(menuBar);

        //Añadimos menú desplegable de "Iniciar sesión"
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

        //Cargamos el archivo GIF mientras está en construcción la página
        ImageIcon gifIcon = new ImageIcon("../resources/logo1.gif");
        JLabel gifLabel = new JLabel(gifIcon);

        //Cargamos la imagen lateral, que vamos a usar en ambos laterales
        ImageIcon lateralIcon = new ImageIcon("../resources/lateral2.png");
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

        //Agregamos los componentes anteriores al BorderLayout de la ventana
        add(lateralLabelLeft, BorderLayout.WEST);
        add(lateralLabelRight, BorderLayout.EAST);
        add(gifLabel, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);

        //Agregamos un listener al evento de redimensionamiento de la ventana

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Ajustar la posición del GIF al cambiar el tamaño de la ventana
                int gifX = (getWidth() - gifIcon.getIconWidth()) / 2;
                int gifY = (getHeight() - gifIcon.getIconHeight()) / 2;

                gifLabel.setBounds(gifX, gifY, gifIcon.getIconWidth(), gifIcon.getIconHeight());
            }
        });

        //Establecemos el tamaño de la ventana
        setSize(1600, 900);

        //Hacemos visible la ventana
        setVisible(true);


        // Agregar ActionListener al labelComprarEntradas
        labelComprarEntradas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Abrir la ventana SesionesFrame al hacer clic en "Comprar entradas"
                abrirVentanaSesiones();
            }
        });

        // Botón de Cartelera
        labelCartelera.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                abrirCarteleraFrame();
            }
        });
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

    /**
     * Abre la ventana de SesionesFrame para mostrar las sesiones disponibles.
     * Se ejecuta en el hilo de despacho de eventos de Swing para garantizar la
     * sincronización correcta con la interfaz de usuario.
     */
    private static void abrirVentanaSesiones() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SesionesFrame sesionesFrame = null;
                try {
                    sesionesFrame = new SesionesFrame();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                sesionesFrame.setVisible(true);
            }
        });
    }

    private static void abrirCarteleraFrame() {
        CarteleraFrame carteleraFrame = new CarteleraFrame();
        carteleraFrame.mostrarVentana();
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Inicio inicio = new Inicio();
                inicio.setVisible(true);
            }
        });
    }
}
