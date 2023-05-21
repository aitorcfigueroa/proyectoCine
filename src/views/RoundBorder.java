package views;
import javax.swing.border.Border;
import java.awt.*;
public class RoundBorder implements Border {
    private int radius;
    private int borderThickness;
    private Color color;

    //Constructor parametrizado
    public RoundBorder(int radius, int borderThickness, Color color) {
        this.radius = radius;
        this.borderThickness = borderThickness;
        this.color = color;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        //Crear un objeto Graphics2D a partir del objeto Graphics pasado
        Graphics2D g2 = (Graphics2D) g.create();

        //Establecer el color y el grosor
        g2.setColor(color);
        g2.setStroke(new BasicStroke(borderThickness));

        //Dibujamos el rectángulo redondeado con los bordes
        g2.drawRoundRect(x + borderThickness / 2, y + borderThickness / 2, width - 1 - borderThickness, height - 1 - borderThickness, radius, radius);

        //Liberamos los recursos del objeto Graphics2D
        g2.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        //Calculamos los márgenes internos para el componente
        int margin = radius / 2 + borderThickness / 2;
        return new Insets(margin, margin, margin, margin);
    }

    @Override
    public boolean isBorderOpaque() {
        //Indicamos si el borde es opaco y debe ser dibujado
        return true;
    }
}