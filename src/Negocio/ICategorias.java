/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;

import Dominio.Categoria;
import java.util.List;

/**
 *
 * @author A515-52
 */
public interface ICategorias {
    public boolean agregar(Categoria categoria);
    public boolean actualizar(Long idCategoria, Categoria categoria);
    public boolean eliminar(Long idCategoria);
    public Categoria consultarPorId(Long idCategoria);
    public List<Categoria> consultarTodos();
    public Categoria consultarPorNombre(String nombreCategoria);
}
