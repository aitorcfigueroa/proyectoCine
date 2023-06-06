package views;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

/**
 * La clase RegistroUsuarioFrame representa la ventana de registro de usuario de la aplicación, para poder proporcionar nombre, correo electrónico y contraseña
 */
public class RegistroUsuarioFrame  extends JFrame{
    private JPanel headerPanel;
    private JPanel panelIzquierdo;
    private JPanel panelDerecho;
    private JPanel footerPanel;
    private JTextField nombreTextField;
    private JTextField correoTextField;
    private JPasswordField contrasenaPasswordField;
    private JButton registrarButton;

    public RegistroUsuarioFrame() {
        //Configuramos la ventana principal
        setTitle("Registro de Usuario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.DARK_GRAY);
        setLayout(new BorderLayout());

        //Cargamos la fuente Montserrat-Medium desde un archivo .ttf
        Font montserratMedium = loadFont(".\\resources\\Montserrat-Medium.ttf");

        //Establecemos la fuente Montserrat-Medium como la fuente predeterminada para el proyecto
        setUIFont(new FontUIResource(montserratMedium));

        //Añadimos la imagen lateral que vamos a usar en ambos laterales de la ventana
        ImageIcon lateralIcon = new ImageIcon(".\\resources\\lateral2.png");

        JLabel lateralLabelLeft = new JLabel(lateralIcon);
        JLabel lateralLabelRight = new JLabel(lateralIcon);

        //Creamos el JPanel para el encabezado
        headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(Color.decode("#4D9694"));

        //Creamos el JLabel con el texto del encabezado
        JLabel headerLabel = new JLabel("Registro de Usuario");
        headerLabel.setFont(new Font(montserratMedium.getName(), Font.PLAIN, 18));
        headerLabel.setForeground(Color.WHITE);

        //Añadimos el JLabel al JPanel del encabezado
        headerPanel.add(headerLabel);

        //Creamos la barra de menú
        JMenuBar menuBar = createMenuBar();
        setJMenuBar(menuBar);


        //Creamos un JPanel para el footer
        footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        footerPanel.setBackground(Color.GRAY);

        //Creamos el JLabel con el texto del footer
        JLabel footerLabel = new JLabel("Aitor Couñago - Ángela Serantes © 2023 ");
        footerLabel.setForeground(Color.WHITE);

        //Agregamos el JLabel al JPanel del footer
        footerPanel.add(footerLabel);


        //Creamos el JPanel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.DARK_GRAY);

        //Creamos el JPanel para el espacio adicional en la parte superior
        JPanel topSpacePanel = new JPanel();
        topSpacePanel.setOpaque(false);
        topSpacePanel.setPreferredSize(new Dimension(1, 100)); //Ajustar el tamaño del espacio superior
        topSpacePanel.setBackground(Color.DARK_GRAY);

        //Creamos el JPanel para el espacio adicional en la parte inferior
        JPanel bottomSpacePanel = new JPanel();
        bottomSpacePanel.setOpaque(false);
        bottomSpacePanel.setPreferredSize(new Dimension(1, 100)); //Ajustar el tamaño del espacio inferior
        bottomSpacePanel.setBackground(Color.DARK_GRAY);

        //Crear el JPanel para contener los componentes laterales, el formulario y el espacio adicional
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setOpaque(false); // Establecer el fondo como transparente

        //Crear el JPanel para el espacio a la izquierda del formulario
        JPanel leftSpacePanel = new JPanel();
        leftSpacePanel.setOpaque(false);
        leftSpacePanel.setPreferredSize(new Dimension(350, 1)); //Ajustar el tamaño del espacio izquierdo
        leftSpacePanel.setBackground(Color.DARK_GRAY); // Establecer el color de fondo de los laterales

        //Crear el JPanel para el espacio a la derecha del formulario
        JPanel rightSpacePanel = new JPanel();
        rightSpacePanel.setOpaque(false);
        rightSpacePanel.setPreferredSize(new Dimension(350, 1)); //Ajustar el tamaño del espacio derecho
        rightSpacePanel.setBackground(Color.DARK_GRAY); //Establecer el color de fondo de los laterales

        //Crear el formulario de registro de usuario
        JPanel formularioPanel = createFormularioPanel();

        //Ajustar los márgenes internos del formularioPanel
        Border formularioMargin = new EmptyBorder(10, 10, 10, 10);
        formularioPanel.setBorder(formularioMargin);

        //Aplicamos borde con esquinas redondeadas y grosor al formulario
        int radius = 40; // Radio de las esquinas redondeadas
        Border roundedBorder = new RoundBorder(radius, 6, Color.BLACK);
        formularioPanel.setBorder(roundedBorder);

        //Agregamos los componentes al BorderLayout
        contentPanel.add(topSpacePanel, BorderLayout.NORTH);
        contentPanel.add(leftSpacePanel, BorderLayout.WEST);
        contentPanel.add(rightSpacePanel, BorderLayout.EAST);
        contentPanel.add(formularioPanel, BorderLayout.CENTER);
        contentPanel.add(bottomSpacePanel, BorderLayout.SOUTH);

        //Agregamos los componentes al BorderLayout
        mainPanel.add(lateralLabelLeft, BorderLayout.WEST);
        mainPanel.add(lateralLabelRight, BorderLayout.EAST);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        //Agregamos los componentes al BorderLayout
        add(headerPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);

        //Establecemos el tamaño de la ventana
        setSize(1600, 900);
        setLocationRelativeTo(null); //Centrar la ventana en la pantalla
    }

    /**
     * Creación de la barra de menú
     * @return menuBar
     */
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        //Crear el panel izquierdo para los elementos alineados a la izquierda
        panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel labelInicio = new JLabel("Inicio");
        labelInicio.setFont(panelIzquierdo.getFont());

        labelInicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panelIzquierdo.add(labelInicio);
        JLabel labelCartelera = new JLabel("Cartelera");
        labelCartelera.setFont(panelIzquierdo.getFont());
        labelCartelera.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panelIzquierdo.add(labelCartelera);

        labelInicio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarVentanaInicio();
            }
        });
        //Botón de Cartelera
        labelCartelera.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                abrirCarteleraFrame();
            }
        });

        //Crear el panel derecho para los elementos alineados a la derecha
        panelDerecho = new JPanel();
        panelDerecho.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JLabel labelComprarEntradas = new JLabel("Comprar entradas");
        labelComprarEntradas.setFont(panelDerecho.getFont());
        labelComprarEntradas.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelDerecho.add(labelComprarEntradas);
        JLabel labelIniciarSesion = new JLabel("Iniciar sesión");
        labelIniciarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        labelIniciarSesion.setFont(panelDerecho.getFont());
        panelDerecho.add(labelIniciarSesion);
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

        // Agregar ActionListener al labelComprarEntradas
        labelComprarEntradas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                abrirVentanaSesiones();
            }
        });

        //Agregar los paneles a la barra de menú
        menuBar.add(panelIzquierdo);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(panelDerecho);

        return menuBar;
    }

    /**
     * Creación del panel del formulario
     * @return formularioPanel
     */
    private JPanel createFormularioPanel() {
        JPanel formularioPanel = new JPanel(new GridBagLayout());
        formularioPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 40, 5); // Márgenes internos


        // Crear componentes del formulario
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        formularioPanel.add(nombreLabel, gbc);

        nombreTextField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;

        formularioPanel.add(nombreTextField, gbc);

        JLabel correoLabel = new JLabel("Correo electrónico:");
        correoLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;

        formularioPanel.add(correoLabel, gbc);

        correoTextField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;

        formularioPanel.add(correoTextField, gbc);

        JLabel contrasenaLabel = new JLabel("Contraseña:");
        contrasenaLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        formularioPanel.add(contrasenaLabel, gbc);

        contrasenaPasswordField = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        formularioPanel.add(contrasenaPasswordField, gbc);

        registrarButton = new JButton("Registrar");
        gbc.gridx = 1;
        gbc.gridy = 3;
        formularioPanel.add(registrarButton, gbc);

        return formularioPanel;
    }
    /**
     * Método para cargar la fuente desde un archivo .ttf
     * @param fontFileName
     * @return
     */
    private Font loadFont(String fontFileName) {
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
        // Configurar la fuente para todos los componentes de la interfaz de usuario
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
     * Muestra la ventana de inicio
     */
    private void mostrarVentanaInicio() {
        Inicio inicio = new Inicio();
        inicio.setVisible(true);
        dispose(); // Cerrar la ventana
    }

    /**
     * Muestra la ventana principal de la aplicación.
     */
    public void mostrarVentana() {
        setVisible(true); //hace visible la ventana principal

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
     * Abre la ventana de sesiones en un hilo de eventos de Swing.
     * Este método crea una instancia de la ventana de sesiones y la muestra en la interfaz de usuario.
     * La ventana de sesiones permite al usuario ver y seleccionar la sesion deseada para las películas.
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

    /**
     * Punto de entrada principal del registro de usuario
     * Este método inicia la aplicación Swing en el hilo de eventos de Swing y muestra la ventana de registro de usuario en la interfaz de usuario.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RegistroUsuarioFrame registroUsuarioFrame = new RegistroUsuarioFrame();
            registroUsuarioFrame.mostrarVentana();
        });
    }
}
