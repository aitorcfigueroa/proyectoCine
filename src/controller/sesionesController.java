package controller;

import clases.Sesion;

import java.time.LocalDate;
import java.util.ArrayList;
import static model.sesionesModel.getListaSesiones;

public class sesionesController {
    public static ArrayList<Sesion> sesionesHoy(String cine) {
        LocalDate hoy = LocalDate.now();
        ArrayList<Sesion> sesiones = getListaSesiones(cine, hoy);
        return sesiones;
    }

    public static ArrayList<Sesion> sesionesOtraFecha(String cine, LocalDate fecha) {
        fecha = LocalDate.parse("2023-05-14");
        ArrayList<Sesion> sesiones = getListaSesiones(cine, fecha);
        return sesiones;
    }
}
