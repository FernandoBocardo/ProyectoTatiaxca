/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dominio.Venta;
import Dominio.Venta_Producto;
import Persistencia.VentasDAO;
import java.util.List;

/**
 *
 * @author roman
 */
public class CtrlVentas {
    
    private static volatile CtrlVentas instance;
    
    public static CtrlVentas getInstance() 
    {
        CtrlVentas result = instance;
        if (result != null) {
            return result;
        }
        synchronized(CtrlVentas.class) 
        {
            if(instance == null) 
            {
                instance = new CtrlVentas();
            }
        return instance;
        }
    }
    
    public boolean agregar(Venta venta, List<Venta_Producto> ventasProductos){
        return new VentasDAO().agregar(venta, ventasProductos);
    }
    
    public boolean eliminar(Long idVenta){
        return new VentasDAO().eliminar(idVenta);
    }
    
    public Venta consultarPorId(Long idVenta){
        return new VentasDAO().consultarPorId(idVenta);
    }
    
    public List<Venta> consultarTodos(){
        return new VentasDAO().consultarTodos();
    }
}
