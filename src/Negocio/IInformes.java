/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;

import Dominio.Informe;
import java.util.List;

/**
 *
 * @author A515-52
 */
public interface IInformes {
    public boolean agregar(Informe informe);
    public boolean actualizar(Long idInforme, Informe informe);
    public boolean eliminar(Long idInforme);
    public Informe consultarPorId(Long idInforme);
    public List<Informe> consultarTodos();
}
