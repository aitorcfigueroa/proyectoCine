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
import static model.cines.getCine;
import static model.peliculasModel.getPelicula;
import static model.salas.getListaSalas;

public class sesionesModel {
    public static void main(String[] args) {
        ArrayList<Sesion> sesionesCine = getListaSesiones("Castelao", LocalDate.parse("2023-05-14"));
        System.out.println(sesionesCine);
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
}
