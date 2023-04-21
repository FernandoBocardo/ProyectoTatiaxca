/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dominio.Reporte;
import Persistencia.ReportesDAO;
import java.util.List;

/**
 *
 * @author roman
 */
public class CtrlReportes {

    public boolean agregar(Reporte reporte) {
        return new ReportesDAO().agregar(reporte);
    }

    public boolean actualizar(int idReporte, Reporte reporte) {
        return new ReportesDAO().actualizar(idReporte, reporte);
    }

    public boolean eliminar(int idReporte) {
        return new ReportesDAO().eliminar(idReporte);
    }

    public Reporte consultarPorId(int idReporte) {
        return new ReportesDAO().consultarPorId(idReporte);
    }

    public List<Reporte> consultarTodos() {
        return new ReportesDAO().consultarTodos();
    }
}
