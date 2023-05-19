package model;

import clases.Cine;
import clases.Sala;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static model.dbconnection.closeConection;

public class salas {
    /**
     * Método para consultar la lista de salas de un cine
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
}
