/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dominio.Producto;
import Persistencia.ProductosDAO;
import java.util.List;

/**
 *
 * @author Oscar Roman
 */
public class CtrlProductos {
        
    private static volatile CtrlProductos instance;
    
    public static CtrlProductos getInstance() 
    {
        CtrlProductos result = instance;
        if (result != null) {
            return result;
        }
        synchronized(CtrlProductos.class) 
        {
            if(instance == null) 
            {
                instance = new CtrlProductos();
            }
        return instance;
        }
    }
    
    public boolean agregar(Producto producto){
        return new ProductosDAO().agregar(producto);      
    }
    
    public boolean actualizar(Long idProducto, Producto producto){
        return new ProductosDAO().actualizar(idProducto, producto);      
    }
    
    public boolean eliminar(Long idProducto){
        return new ProductosDAO().eliminar(idProducto);      
    }
    
    public Producto consultarPorId(Long idProducto){
        return new ProductosDAO().consultarPorId(idProducto);
    }
    
    public Producto consultarPorNombre(String nombreProducto){
        return new ProductosDAO().consultarPorNombre(nombreProducto);
    }
    
    public List<Producto> consultarPorCategoria(Long idCategoria){
        return new ProductosDAO().consultarPorCategoria(idCategoria);
    }
    
    public List<Producto> consultarTodos(){
        return new ProductosDAO().consultarTodos();
    }
}
