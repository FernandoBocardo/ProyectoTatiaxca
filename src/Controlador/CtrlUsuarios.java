/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dominio.Usuario;
import Persistencia.UsuariosDAO;
import java.util.List;

/**
 *
 * @author Oscar Roman
 */
public class CtrlUsuarios {
    
    public boolean agregar(Usuario usuario){
        return new UsuariosDAO().agregar(usuario);
    }
    public boolean actualizar(Long idUsuario, Usuario usuario){
        return new UsuariosDAO().actualizar(idUsuario, usuario);
    }
    public boolean eliminar(Long idUsuario){
        return new UsuariosDAO().eliminar(idUsuario);
    }
    public Usuario consultarPorId(Long idUsuario){
        return new UsuariosDAO().consultarPorId(idUsuario);
    }
    public List<Usuario> consultarTodos(){
        return new UsuariosDAO().consultarTodos();
    }
}
