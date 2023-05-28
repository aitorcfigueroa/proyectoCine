package model;

import clases.Pelicula;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import static model.dbconnection.closeConection;

public class peliculas {
    /**
     * Método para recuperar una película.
     * @param id el id de la película
     * @return devuelve una película si la encuentra o null.
     */
    public static Pelicula getPelicula(int id) {
        Connection conexion = dbconnection.conexion();
        Statement seleccion = null;
        String texto_seleccion = "select * from peliculas where idPelicula = '" + id + "'";
        ResultSet resultado = null;
        Pelicula nuevaPelicula = null;

        try {
            assert conexion != null;
            seleccion = conexion.createStatement();
            resultado = seleccion.executeQuery(texto_seleccion);
            while(resultado.next()){
                int idPelicula = resultado.getInt("idPelicula");
                String titulo = resultado.getString("titulo");
                String director = resultado.getString("director");
                int año = resultado.getInt("año");
                int duracion = resultado.getInt("duracion");
                int edad = resultado.getInt("Edad");
                String generos = resultado.getString("genero");
                String sinopsis = resultado.getString("sinopsis");
                String cartel = resultado.getString("cartel");

                ArrayList<String> genero = new ArrayList<>(Arrays.asList(generos.split(",")));

                nuevaPelicula = new Pelicula(idPelicula, titulo, director, año, duracion, edad, genero, sinopsis, cartel);
            }
            resultado.close();
        } catch (SQLException e) {
            System.out.println("Error a la hora de consultar la tabla, puede que la película no exista.");
            System.out.println(e.getLocalizedMessage());
            return null;
        }
        closeConection(conexion);
        return nuevaPelicula;
    }
}
