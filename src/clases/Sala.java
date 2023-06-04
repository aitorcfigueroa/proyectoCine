package clases;

public class Sala {
    int idSala;
    String nombreSala;
    int filas;
    int columnas;

    public Sala(int idSala, String nombreSala, int filas, int columnas) {
        this.idSala = idSala;
        this.nombreSala = nombreSala;
        this.filas = filas;
        this.columnas = columnas;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
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
