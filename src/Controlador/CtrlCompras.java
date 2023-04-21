/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dominio.Compra;
import Persistencia.ComprasDAO;
import java.util.List;

/**
 *
 * @author roman
 */
public class CtrlCompras {

    public boolean agregar(Compra compra) {
        return new ComprasDAO().agregar(compra);
    }

    public boolean actualizar(Long idCompra, Compra compra) {
        return new ComprasDAO().actualizar(idCompra, compra);
    }

    public boolean eliminar(Long idCompra) {
        return new ComprasDAO().eliminar(idCompra);
    }

    public Compra consultarPorId(Long idCompra) {
        return new ComprasDAO().consultarPorId(idCompra);
    }

    public List<Compra> consultarTodos() {
        return new ComprasDAO().consultarTodos();
    }
}
