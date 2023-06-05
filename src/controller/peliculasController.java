package controller;

import clases.Pelicula;

import java.util.ArrayList;

import static model.peliculasModel.getListaPeliculas;

public class peliculasController {
    /**
     * Controlador para recuperar los carteles de las películas disponibles
     * @return un ArrayList con todos los carteles de las peliculas disponibles
     */
    public static ArrayList<String> cartelesCtrl() {
        ArrayList<String> carteles = new ArrayList<>();

        ArrayList<Pelicula> peliculas = getListaPeliculas();

        for (Pelicula pelicula: peliculas) {
            carteles.add(pelicula.getCartel());
        }
        return carteles;
    }

    /**
     * Controlador para recuperar los títulos de las películas disponibles
     * @return un ArrayList con todos los títulos de las peliculas disponibles
     */
    public static ArrayList<String> titulosCtrl() {
        ArrayList<String> titulos = new ArrayList<>();

        ArrayList<Pelicula> peliculas = getListaPeliculas();

        for (Pelicula pelicula: peliculas) {
            titulos.add(pelicula.getTitulo());
        }

        return titulos;
    }
}
