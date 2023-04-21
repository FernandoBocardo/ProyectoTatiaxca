/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;

import Dominio.Merma;
import java.util.List;

/**
 *
 * @author A515-52
 */
public interface IMermas {
    public boolean agregar(Merma merma);
    public boolean actualizar(Long idMerma, Merma merma);
    public boolean eliminar(Long idMerma);
    public Merma consultarPorId(Long idMerma);
    public List<Merma> consultarTodos();    
}
