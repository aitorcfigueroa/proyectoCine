package clases;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Map;

public class Sesion {
    int idSesion;
    int idSala;
    int idPelicula;
    LocalDate fecha;
    LocalTime hora;
    Map<String, ArrayList<Boolean>> butacas;

    public int getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(int idSesion) {
        this.idSesion = idSesion;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Map<String, ArrayList<Boolean>> getButacas() {
        return butacas;
    }

    public void setButacas(Map<String, ArrayList<Boolean>> butacas) {
        this.butacas = butacas;
    }
}
