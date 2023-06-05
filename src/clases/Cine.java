package clases;

public class Cine {
    int idCine;
    String nombreCine;
    double precio;

    public Cine(int idCine, String nombreCine, double precio) {
        this.idCine = idCine;
        this.nombreCine = nombreCine;
        this.precio = precio;
    }

    public Cine(String nombreCine, double precio) {
        this.nombreCine = nombreCine;
        this.precio = precio;
    }

    public String getNombreCine() {
        return nombreCine;
    }

    public int getIdCine() {
        return idCine;
    }

    public void setIdCine(int idCine) {
        this.idCine = idCine;
    }

    public void setNombreCine(String nombreCine) {
        this.nombreCine = nombreCine;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
