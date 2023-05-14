import java.util.ArrayList;
import java.util.List;

public class Cine {
    String nombre_cine;
    double precio;
    List<Sala> salas = new ArrayList<Sala>();

    public Cine(String nombre_cine, double precio) {
        this.nombre_cine = nombre_cine;
        this.precio = precio;
    }

    public String getNombre_cine() {
        return nombre_cine;
    }

    public void setNombre_cine(String nombre_cine) {
        this.nombre_cine = nombre_cine;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    public void addSala(Sala sala) {
        this.salas.add(sala);
    }
}
