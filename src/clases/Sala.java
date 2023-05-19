package clases;

public class Sala {
    String nombre_sala;
    int filas;
    int columnas;

    public Sala(String nombre_sala, int filas, int columnas) {
        this.nombre_sala = nombre_sala;
        this.filas = filas;
        this.columnas = columnas;
    }

    public String getNombre_sala() {
        return nombre_sala;
    }

    public void setNombre_sala(String nombre_sala) {
        this.nombre_sala = nombre_sala;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }
}
