package model;

import clases.Cine;
import clases.Pelicula;
import clases.Sesion;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import static model.dbconnection.closeConection;

public class query {
    public static void main(String[] args) {
        Pelicula test = pelicula(2);
        System.out.println(test.getTitulo());
        System.out.println(test.getGenero().get(2));
    }

    /**
     * Método para recuperar la lista con los nombres de los cines
     * @return ArrayList con los nombres de los cines disponibles.
     */
    public static ArrayList<String> listaCines() {
        Connection conexion = dbconnection.conexion();
        Statement seleccion = null;
        String texto_seleccion = "select * from cines";
        ResultSet resultado = null;
        ArrayList<String> cines = new ArrayList<String>();

        try {
            assert conexion != null;
            seleccion = conexion.createStatement();
            resultado = seleccion.executeQuery(texto_seleccion);
            while(resultado.next()){
                cines.add(resultado.getString("nombre"));
            }
            resultado.close();
        } catch (SQLException e) {
            System.out.println("Error a la hora de consultar la tabla");
            System.out.println(e.getLocalizedMessage());
            return null;
        }
        closeConection(conexion);
        return cines;
    }

    /**
     * Método para recuperar los datos de un cine.
     * @param cine nombre del cine
     * @return un objeto de la clase Cine.
     */
    public static Cine cine(String cine) {
        Connection conexion = dbconnection.conexion();
        Statement seleccion = null;
        String texto_seleccion = "select * from cines where nombre = '" + cine + "'";
        ResultSet resultado = null;

        try {
            assert conexion != null;
            seleccion = conexion.createStatement();
            resultado = seleccion.executeQuery(texto_seleccion);
            while(resultado.next()){
                // TODO: Crear el cine con el objeto cine.
                System.out.println("nombre= " + resultado.getString("nombre") + ", precio= " + resultado.getDouble("precio"));
            }
            resultado.close();
        } catch (SQLException e) {
            System.out.println("Error a la hora de consultar la tabla");
            System.out.println(e.getLocalizedMessage());
        }
        closeConection(conexion);
        return null;
    }

    /**
     * Método para recuperar la lista de sesiones disponibles
     * @param nombre Nombre del cine en el que se busca.
     * @param fecha Fecha que se busca.
     * @return lista de sesiones disponibles.
     */
    public static ArrayList<Sesion> sesiones(String nombre, LocalDate fecha) {
        Cine cine = cine(nombre);

        Connection conexion = dbconnection.conexion();
        Statement seleccion = null;
        String texto_seleccion = "select * from sesiones where idCine = '" + cine.getIdCine() + "' and fecha = '" + fecha + "'";
        ResultSet resultado = null;
        int idSesion;
        int idSala;
        int idPelicula;
        LocalDate fechaBD;
        LocalTime hora;
        Map butacas;
        ArrayList<Sesion> sesionArrayList = new ArrayList<Sesion>();

        try {
            assert conexion != null;
            seleccion = conexion.createStatement();
            resultado = seleccion.executeQuery(texto_seleccion);
            while(resultado.next()){
                idSesion = resultado.getInt("idSesion");
                idSala = resultado.getInt("idSala");
                idPelicula = resultado.getInt("idPelicula");
                fechaBD = resultado.getDate("fecha").toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                hora = resultado.getTime("hora").toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
                String sitios = resultado.getString("butacas");
                ObjectMapper objectMapper = new ObjectMapper();

                butacas = objectMapper.readValue(sitios, Map.class);

                Sesion sesion = new Sesion(idSesion, idSala, idPelicula, fechaBD, hora, butacas);
                sesionArrayList.add(sesion);
            }
            resultado.close();
        } catch (SQLException e) {
            System.out.println("Error a la hora de consultar la tabla");
            System.out.println(e.getLocalizedMessage());
            return null;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        closeConection(conexion);
        return sesionArrayList;
    }

    public static Pelicula pelicula(int id) {
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

                ArrayList<String> genero = new ArrayList<>(Arrays.asList(generos.split(",")));

                nuevaPelicula = new Pelicula(idPelicula, titulo, director, año, duracion, edad, genero, sinopsis);
            }
            resultado.close();
        } catch (SQLException e) {
            System.out.println("Error a la hora de consultar la tabla");
            System.out.println(e.getLocalizedMessage());
            return null;
        }
        closeConection(conexion);
        return nuevaPelicula;
    }
}
