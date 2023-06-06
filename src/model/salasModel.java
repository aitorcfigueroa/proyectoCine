package model;

import clases.Sala;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static model.dbconnection.closeConection;

public class salasModel {
    /**
     * Modelo para consultar la lista de salas de un cine
     * @param idCine el id del cine a consultar
     * @return lista de salas
     */
    public static ArrayList<Sala> getListaSalas(int idCine) {
        Connection conexion = dbconnection.conexion();
        Statement seleccion = null;
        String texto_seleccion = "select * from salas where idCine = '" + idCine + "'";
        ResultSet resultado = null;
        Sala nuevaSala = null;
        ArrayList<Sala> salas = new ArrayList<Sala>();

        try {
            assert conexion != null;
            seleccion = conexion.createStatement();
            resultado = seleccion.executeQuery(texto_seleccion);
            while(resultado.next()){
                int idSala = resultado.getInt("idSala");
                String nombre = resultado.getString("nombre");
                int filas = resultado.getInt("filas");
                int columnas = resultado.getInt("columnas");
                nuevaSala = new Sala(idSala, nombre, filas, columnas);
                salas.add(nuevaSala);
            }
            resultado.close();
        } catch (SQLException e) {
            System.out.println("Error a la hora de consultar la tabla");
            System.out.println(e.getLocalizedMessage());
            return null;
        }
        closeConection(conexion);
        return salas;
    }

    /**
     * Modelo para recuperar una sala
     * @param id identificador de la sala
     * @return un objeto de tipo sala
     */
    public static Sala getSala(int id) {
        Sala newSala = null;
        Connection conexion = dbconnection.conexion();
        Statement seleccion = null;
        String texto_seleccion = "select * from salas where idSala=" + id;
        ResultSet resultado = null;
        int idSala;
        String nombreSala;
        int filas;
        int columnas;

        try {
            assert conexion != null;
            seleccion = conexion.createStatement();
            resultado = seleccion.executeQuery(texto_seleccion);
            while(resultado.next()){
                idSala = resultado.getInt("idSala");
                nombreSala = resultado.getString("nombre");
                filas = resultado.getInt("filas");
                columnas = resultado.getInt("columnas");

                newSala = new Sala(idSala, nombreSala, filas, columnas);
            }
            resultado.close();
        } catch (SQLException e) {
            System.out.println("Error a la hora de consultar la tabla");
            System.out.println(e.getLocalizedMessage());
            return null;
        }
        closeConection(conexion);
        return newSala;
    }
}
