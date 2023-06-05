package controller;

import clases.Sala;

import static model.salasModel.getSala;

public class salasController {
    /**
     * Controlador para recuperar una sala
     * @param idSala Identificador de la sala
     * @return un objeto de tipo sala
     */
    public static Sala salaCtrl(int idSala) {
        Sala nuevaSala = getSala(idSala);

        return nuevaSala;
    }
}
