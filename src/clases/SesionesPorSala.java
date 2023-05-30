package clases;

import java.util.ArrayList;

public class SesionesPorSala {
    int sala;
    Pelicula pelicula;
    ArrayList<Sesion> sesiones = new ArrayList<>();

    public SesionesPorSala(int sala, Pelicula pelicula, Sesion sesiones) {
        this.sala = sala;
        this.pelicula = pelicula;
        this.sesiones.add(sesiones);
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public ArrayList<Sesion> getSesiones() {
        return sesiones;
    }

    public void setSesiones(Sesion sesion) {
        this.sesiones.add(sesion);
    }
}
