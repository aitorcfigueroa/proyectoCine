package clases;

public class Cine {
    int idCine;
    String nombre_cine;
    double precio;

    public Cine(int idCine, String nombre_cine, double precio) {
        this.idCine = idCine;
        this.nombre_cine = nombre_cine;
        this.precio = precio;
    }

    public Cine(String nombre_cine, double precio) {
        this.nombre_cine = nombre_cine;
        this.precio = precio;
    }

    public String getNombre_cine() {
        return nombre_cine;
    }

    public int getIdCine() {
        return idCine;
    }

    public void setIdCine(int idCine) {
        this.idCine = idCine;
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
}
