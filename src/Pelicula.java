import java.awt.*;

public class Pelicula {
    String titulo;
    Image portada;
    String director;
    int duracion;
    String clasificacionPG;
    String genero;
    String sinopsis;

    public Pelicula(String titulo, String director, int duracion, String clasificacionPG) {
        this.titulo = titulo;
        this.director = director;
        this.duracion = duracion;
        this.clasificacionPG = clasificacionPG;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Image getPortada() {
        return portada;
    }

    public void setPortada(Image portada) {
        this.portada = portada;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getClasificacionPG() {
        return clasificacionPG;
    }

    public void setClasificacionPG(String clasificacionPG) {
        this.clasificacionPG = clasificacionPG;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
}
