package controller;

import clases.Sesion;
import clases.SesionesPorSala;

import java.time.LocalDate;
import java.util.ArrayList;
import static model.sesionesModel.getListaSesiones;
import static model.sesionesModel.getSesion;

public class sesionesController {
    public static Sesion sesionCtrl(int id) {
        Sesion nuevaSesion = getSesion(id);

        return nuevaSesion;
    }

    /**
     * Método para recuperar las sesiones de un día
     * @param cine nombre del cine
     * @param fecha día en el que se quiere buscar sesiones
     * @return ArrayList con la lista de sesiones para el día elegido
     */
    public static ArrayList<SesionesPorSala> sesionesCtrl(String cine, LocalDate fecha) {
        if (fecha == null) {
            fecha = LocalDate.now();
        }

        ArrayList<Sesion> listaSesiones = getListaSesiones(cine, fecha);
        ArrayList<SesionesPorSala> sesionesPorSala = new ArrayList<>();
        assert listaSesiones != null;
        for (Sesion sesion: listaSesiones) {
            if (sesionesPorSala.size() == 0) {
                sesionesPorSala.add(new SesionesPorSala(sesion.getIdSala(), sesion.getPelicula(), sesion));
            } else {
                boolean estaPresente = true;

                for (SesionesPorSala sesionPorSala : sesionesPorSala) {
                    if (sesionPorSala.getSala() == sesion.getIdSala()) {
                        sesionPorSala.setSesiones(sesion);
                        estaPresente = true;
                        break;
                    } else {
                        estaPresente = false;
                    }
                }

                if (!estaPresente) {
                    sesionesPorSala.add(new SesionesPorSala(sesion.getIdSala(), sesion.getPelicula(), sesion));
                }
            }
        }

        return sesionesPorSala;
    }
}
