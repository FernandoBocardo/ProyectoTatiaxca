/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dominio.Merma;
import Persistencia.MermasDAO;
import java.util.List;

/**
 *
 * @author roman
 */
public class CtrlMermas {

    public boolean agregar(Merma merma) {
        return new MermasDAO().agregar(merma);
    }

    public boolean actualizar(Long idMerma, Merma merma) {
        return new MermasDAO().actualizar(idMerma, merma);
    }

    public boolean eliminar(Long idMerma) {
        return new MermasDAO().eliminar(idMerma);
    }

    public Merma consultarPorId(Long idMerma) {
        return new MermasDAO().consultarPorId(idMerma);
    }

    public List<Merma> consultarTodos() {
        return new MermasDAO().consultarTodos();
    }
}
