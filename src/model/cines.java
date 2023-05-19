package model;

import clases.Cine;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static model.dbconnection.closeConection;

public class cines {
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
        Cine nuevoCine = null;

        try {
            assert conexion != null;
            seleccion = conexion.createStatement();
            resultado = seleccion.executeQuery(texto_seleccion);
            while(resultado.next()){
                int idCine = resultado.getInt("idCine");
                String nombreCine = resultado.getString("nombre");
                double precio = resultado.getDouble("precio");

                nuevoCine = new Cine(idCine, nombreCine, precio);
            }
            resultado.close();
        } catch (SQLException e) {
            System.out.println("Error a la hora de consultar la tabla");
            System.out.println(e.getLocalizedMessage());
        }
        closeConection(conexion);
        return nuevoCine;
    }
}
