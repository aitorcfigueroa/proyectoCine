package clases;

import java.util.ArrayList;

public class Pelicula {
    int idPelicula;
    String titulo;
    String director;
    int año;
    int duracion;
    int edad;
    ArrayList<String> genero;
    String sinopsis;
    String cartel;

    public Pelicula(String titulo, String director, int año, int duracion, int edad) {
        this.titulo = titulo;
        this.director = director;
        this.año = año;
        this.duracion = duracion;
        this.edad = edad;
    }


    public Pelicula(int idPelicula, String titulo, String director, int año, int duracion, int edad, ArrayList<String> genero, String sinopsis, String cartel) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.director = director;
        this.año = año;
        this.duracion = duracion;
        this.edad = edad;
        this.genero = genero;
        this.sinopsis = sinopsis;
        this.cartel = cartel;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<String> getGenero() {
        return genero;
    }

    public void setGenero(ArrayList<String> genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getCartel() {
        return cartel;
    }

    public void setCartel(String cartel) {
        this.cartel = cartel;
    }
}
