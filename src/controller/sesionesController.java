package controller;

import clases.Sesion;
import clases.SesionesPorSala;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Map;

import static java.lang.Integer.parseInt;
import static model.sesionesModel.*;

public class sesionesController {
    /**
     * Controlador para recuperar una sesión
     * @param id identificador de la sesión que se quiere recuperar
     * @return una sesión
     */
    public static Sesion sesionCtrl(int id) {
        Sesion nuevaSesion = getSesion(id);

        return nuevaSesion;
    }

    /**
     * Controlador para recuperar las sesiones de un día
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

    /**
     * Controlador para guardar las butacas seleccionadas en la base de datos
     * @param sesion Sesion en la que se van a realizar los cambios
     * @param butacasSeleccionadas Butacas que ha seleccionado el usuario
     * @return true si la operación se realiza con éxito o false en el caso de que exista algún error durante el proceso
     */
    public static Boolean updateSesionCtrl(Sesion sesion, ArrayList<String> butacasSeleccionadas) {
        int idSesion = sesion.getIdSesion();
        Map<String, ArrayList<Boolean>> butacas = sesion.getButacas();

        for (String butaca: butacasSeleccionadas) {
            String[] filaNum = butaca.split("");
            String fila = filaNum[0];
            int columna = parseInt(filaNum[1]) -1;
            ArrayList<Boolean> columnas = butacas.get(fila);
            columnas.set(columna, true);
            butacas.put(fila, columnas);
        }

        Boolean resultado = putSesion(idSesion, butacas);

        return resultado;
    }
}
