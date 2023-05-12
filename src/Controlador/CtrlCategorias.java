/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dominio.Categoria;
import Persistencia.CategoriasDAO;
import java.util.List;

/**
 *
 * @author roman
 */
public class CtrlCategorias {

    private static volatile CtrlCategorias instance;
    
    public static CtrlCategorias getInstance() 
    {
        CtrlCategorias result = instance;
        if (result != null) {
            return result;
        }
        synchronized(CtrlProductos.class) 
        {
            if(instance == null) 
            {
                instance = new CtrlCategorias();
            }
        return instance;
        }
    }
    
    public boolean agregar(Categoria categoria) {
        return new CategoriasDAO().agregar(categoria);
    }

    public boolean actualizar(Long idCategoria, Categoria categoria) {
        return new CategoriasDAO().actualizar(idCategoria, categoria);

    }

    public boolean eliminar(Long idCategoria) {
        return new CategoriasDAO().eliminar(idCategoria);

    }

    public Categoria consultarPorId(Long idCategoria) {
        return new CategoriasDAO().consultarPorId(idCategoria);

    }

    public List<Categoria> consultarTodos() {
        return new CategoriasDAO().consultarTodos();

    }
    
    public Categoria consultarPorNombre(String nombreCategoria){
        return new CategoriasDAO().consultarPorNombre(nombreCategoria);
    }
    
}
