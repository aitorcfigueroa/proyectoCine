package model;

import clases.Cine;
import clases.Pelicula;
import clases.Sala;
import clases.Sesion;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Map;

import static model.dbconnection.closeConection;
import static model.cinesModel.getCine;
import static model.peliculasModel.getPelicula;
import static model.salasModel.getListaSalas;

public class sesionesModel {
    public static void main(String[] args) {
        Sesion sesionesCine = getSesion(1);
        putSesion(1, sesionesCine.getButacas());
        /*System.out.println(sesionesCine.get(0).getButacas().get("A"));
        System.out.println(sesionesCine.get(0).getButacas().get("A").set(2, true));
        System.out.println(sesionesCine.get(0).getButacas().get("A"));*/
    }

    /**
     * Método para recuperar la lista de sesiones disponibles
     * @param nombre Nombre del cine en el que se busca.
     * @param fecha Fecha que se busca.
     * @return lista de sesiones disponibles.
     */
    public static ArrayList<Sesion> getListaSesiones(String nombre, LocalDate fecha) {
        Cine cine = getCine(nombre);
        ArrayList<Sala> salas = getListaSalas(cine.getIdCine());
        String idSalas = "";
        for (int i = 0; i < salas.size(); i++) {
            idSalas += salas.get(i).getIdSala();
            if (i < salas.size()-1) {
                idSalas += ", ";
            }
        }

        Connection conexion = dbconnection.conexion();
        Statement seleccion = null;
        String texto_seleccion = "select * from sesiones where idSala in (" + idSalas + ") and fecha = '" + fecha + "'";
        ResultSet resultado = null;
        int idSesion;
        int idSala;
        int idPelicula;
        Pelicula pelicula;
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

                pelicula = getPelicula(idPelicula);

                fechaBD = LocalDate.parse(resultado.getString("fecha"));
                hora = LocalTime.parse(resultado.getString("hora"));

                String sitios = resultado.getString("butacas");
                ObjectMapper objectMapper = new ObjectMapper();

                butacas = objectMapper.readValue(sitios, Map.class);

                Sesion sesion = new Sesion(idSesion, idSala, pelicula, fechaBD, hora, butacas);
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

    /**
     * Método para recuparar una sesión
     * @param id id de la sesión
     * @return una sesión
     */
    public static Sesion getSesion(int id) {
        Sesion newSesion = null;
        Connection conexion = dbconnection.conexion();
        Statement seleccion = null;
        String texto_seleccion = "select * from sesiones where idSesion=" + id;
        ResultSet resultado = null;
        int idSesion;
        int idSala;
        int idPelicula;
        Pelicula pelicula;
        LocalDate fechaBD;
        LocalTime hora;
        Map butacas;

        try {
            assert conexion != null;
            seleccion = conexion.createStatement();
            resultado = seleccion.executeQuery(texto_seleccion);
            while(resultado.next()){
                idSesion = resultado.getInt("idSesion");
                idSala = resultado.getInt("idSala");
                idPelicula = resultado.getInt("idPelicula");

                pelicula = getPelicula(idPelicula);

                fechaBD = LocalDate.parse(resultado.getString("fecha"));
                hora = LocalTime.parse(resultado.getString("hora"));

                String sitios = resultado.getString("butacas");
                System.out.println(sitios);
                ObjectMapper objectMapper = new ObjectMapper();

                butacas = objectMapper.readValue(sitios, Map.class);

                newSesion = new Sesion(idSesion, idSala, pelicula, fechaBD, hora, butacas);
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
        return newSesion;
    }

    /**
     * Modelo para actualizar las butacas de una sesión
     * @param id identificador de la sesión
     * @param butacas mapa con todas las butacas de la sesión actualizadas
     * @return true si se actualizan correctamente o false si existe algún error al actualizarlas
     */
    public static Boolean putSesion(int id, Map<String, ArrayList<Boolean>> butacas) {
        ObjectMapper objectMapper = new ObjectMapper();
        String cadenaButacas = null;

        try {
            cadenaButacas = objectMapper.writeValueAsString(butacas);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        Connection conexion = dbconnection.conexion();
        Statement consulta = null;
        String texto_update = "update sesiones set butacas='" + cadenaButacas + "' where idSesion=" + id;
        Integer resultado = null;

        try {
            assert conexion != null;
            consulta = conexion.createStatement();
            resultado = consulta.executeUpdate(texto_update);

        } catch (SQLException e) {
            System.out.println("Error a la hora de consultar la tabla");
            System.out.println(e.getLocalizedMessage());
        }

        closeConection(conexion);

        if (resultado == 1) {
            System.out.println("Base de datos actualizada con éxito");
            return true;
        } else {
            System.out.println("Error al actualizar la base de datos");
            return false;
        }
    }
}
