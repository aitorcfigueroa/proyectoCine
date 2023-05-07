import java.util.Arrays;

public class Sala {
    String nombre_sala;
    boolean [][] butacas;

    public Sala(String nombre_sala, int filas, int columnas) {
        this.nombre_sala = nombre_sala;
        this.butacas = new boolean[filas][columnas];
    }

    public String getNombre_sala() {
        return nombre_sala;
    }

    public void setNombre_sala(String nombre_sala) {
        this.nombre_sala = nombre_sala;
    }

    public boolean[][] getButacas() {
        return butacas;
    }

    public void setButacas(int filas, int columnas) {
        this.butacas = new boolean[filas][columnas];
    }
}
