/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;

import Dominio.Compra;
import java.util.List;

/**
 *
 * @author A515-52
 */
public interface ICompras {
    public boolean agregar(Compra compra);
    public boolean actualizar(Long idCompra, Compra compra);
    public boolean eliminar(Long idCompra);
    public Compra consultarPorId(Long idCompra);
    public List<Compra> consultarTodos();
}
