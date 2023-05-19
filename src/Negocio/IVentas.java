/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;

import Dominio.Venta;
import Dominio.Venta_Producto;
import java.util.List;

/**
 *
 * @author A515-52
 */
public interface IVentas {
    public boolean agregar(Venta venta, List<Venta_Producto> ventasProductos);
    public boolean eliminar(Long idVenta);
    public Venta consultarPorId(Long idVenta);
    public List<Venta> consultarTodos(); 
}
