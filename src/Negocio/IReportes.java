/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;

import Dominio.Reporte;
import java.util.List;

/**
 *
 * @author A515-52
 */
public interface IReportes {
    public boolean agregar(Reporte reporte);
    public boolean actualizar(int idReporte, Reporte reporte);
    public boolean eliminar(int idReporte);
    public Reporte consultarPorId(int idReporte);
    public List<Reporte> consultarTodos();
}
