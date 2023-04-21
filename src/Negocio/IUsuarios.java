/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;

import Dominio.Usuario;
import java.util.List;

/**
 *
 * @author A515-52
 */
public interface IUsuarios {

    public boolean agregar(Usuario usuario);

    public boolean actualizar(Long idUsuario, Usuario usuario);

    public boolean eliminar(Long idUsuario);

    public Usuario consultarPorId(Long idUsuario);

    public List<Usuario> consultarTodos();
}
