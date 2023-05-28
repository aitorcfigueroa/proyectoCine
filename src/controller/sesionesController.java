package controller;

import clases.Sesion;

import java.time.LocalDate;
import java.util.ArrayList;
import static model.sesionesModel.getListaSesiones;

public class sesionesController {
    /**
     * Método para recuperar las sesiones del día actual.
     * @param cine nombre del cine
     * @return ArrayList con la lista de sesiones de ese día
     */
    public static ArrayList<Sesion> sesionesHoy(String cine) {
        LocalDate hoy = LocalDate.now();
        ArrayList<Sesion> sesiones = getListaSesiones(cine, hoy);
        return sesiones;
    }

    /**
     * Método para recuperar las sesiones de un día diferente al de hoy.
     * @param cine nombre del cine
     * @param fecha día en el que se quiere buscar sesiones
     * @return ArrayList con la lista de sesiones para el día elegido
     */
    public static ArrayList<Sesion> sesionesOtraFecha(String cine, LocalDate fecha) {
        fecha = LocalDate.parse("2023-05-14");
        ArrayList<Sesion> sesiones = getListaSesiones(cine, fecha);
        return sesiones;
    }
}
