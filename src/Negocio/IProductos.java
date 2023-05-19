/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;

import Dominio.Producto;
import java.util.List;

/**
 *
 * @author A515-52
 */
public interface IProductos {
    public boolean agregar(Producto producto);
    public boolean actualizar(Long idProducto, Producto producto);
    public boolean eliminar(Long idProducto);
    public Producto consultarPorId(Long idProducto);
    public Producto consultarPorNombre(String nombreProducto);
    public List<Producto> consultarTodos();
    public List<Producto> consultarPorCategoria(Long idCategoria);
}
