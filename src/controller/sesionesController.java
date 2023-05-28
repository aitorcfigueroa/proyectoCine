package controller;

import clases.Sesion;
import clases.SesionesPorSala;

import java.time.LocalDate;
import java.util.ArrayList;
import static model.sesionesModel.getListaSesiones;

public class sesionesController {
    /**
     * Método para recuperar las sesiones de un día
     * @param cine nombre del cine
     * @param fecha día en el que se quiere buscar sesiones
     * @return ArrayList con la lista de sesiones para el día elegido
     */
    public static ArrayList<SesionesPorSala> sesiones(String cine, LocalDate fecha) {
        if (fecha == null) {
            fecha = LocalDate.now();
        } else {
            fecha = LocalDate.parse("2023-05-14");
        }

        ArrayList<Sesion> listaSesiones = getListaSesiones(cine, fecha);
        ArrayList<SesionesPorSala> sesionesPorSala = null;
        for (Sesion sesion: listaSesiones) {
            for (SesionesPorSala sesionPorSala: sesionesPorSala) {
                if (sesionPorSala.getSala() == sesion.getIdSala()) {
                    sesionPorSala.setSesiones(sesion);
                } else {
                    sesionesPorSala.add(new SesionesPorSala(sesion.getIdSala(), sesion.getPelicula(), sesion));
                }
            }
        }

        return sesionesPorSala;
    }
}
