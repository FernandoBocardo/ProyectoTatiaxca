/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dominio.Informe;
import Persistencia.InformesDAO;
import java.util.List;

/**
 *
 * @author roman
 */
public class CtrlInformes {
    
    public boolean agregar(Informe informe) {
        return new InformesDAO().agregar(informe);
    }

    public boolean actualizar(Long idInforme, Informe informe) {
        return new InformesDAO().actualizar(idInforme, informe);
    }

    public boolean eliminar(Long idInforme) {
        return new InformesDAO().eliminar(idInforme);
    }

    public Informe consultarPorId(Long idInforme) {
        return new InformesDAO().consultarPorId(idInforme);
    }

    public List<Informe> consultarTodos() {
        return new InformesDAO().consultarTodos();
    }
}
