/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import ConexionBD.ConexionBD;
import Dominio.Usuario;
import Negocio.IUsuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author A515-52 - Roman
 */
public class UsuariosDAO extends ConexionBD implements IUsuarios {

    @Override
    public boolean agregar(Usuario usuario) {
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement(
                        "INSERT INTO usuarios (nombre, apellidos, nombreUsuario, contrasena, telefono, tipoUsuario) VALUES (?, ?, ?, ?, ?, ?)")) {
            pst.setString(1, usuario.getNombre());
            pst.setString(2, usuario.getApellido());
            pst.setString(3, usuario.getNombreUsuario());
            pst.setString(4, usuario.getContraseña());
            pst.setString(5, usuario.getTelefono());
            pst.setString(6, usuario.getTipoUsuario());
            int filasAfectadas = pst.executeUpdate();
            if (filasAfectadas == 0) {
                return false; // no se agregó ninguna fila
            }
            return true;
        } catch (SQLException e) {
            System.out.println("Error en: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(Long idUsuario, Usuario usuario) {
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement(
                        "UPDATE usuarios SET nombre = ?, apellidos = ?, nombreUsuario = ?, contrasena = ?, telefono = ?, tipoUsuario = ? WHERE id_usuario = ?")) {
            pst.setString(1, usuario.getNombre());
            pst.setString(2, usuario.getApellido());
            pst.setString(3, usuario.getNombreUsuario());
            pst.setString(4, usuario.getContraseña());
            pst.setString(5, usuario.getTelefono());
            pst.setString(6, usuario.getTipoUsuario());
            pst.setLong(7, idUsuario);

            int filasAfectadas = pst.executeUpdate();
            if (filasAfectadas == 0) {
                return false; // no se actualizó ninguna fila
            }
            return true;
        } catch (SQLException e) {
            System.out.println("Error en: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(Long idUsuario) {
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement("DELETE FROM usuarios WHERE id_usuario = ?")) {
            pst.setLong(1, idUsuario);
            int filasAfectadas = pst.executeUpdate();
            if (filasAfectadas == 0) {
                return false; // no se eliminó ninguna fila
            }
            return true;
        } catch (SQLException e) {
            System.out.println("Error en: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Usuario consultarPorId(Long idUsuario) {
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement("SELECT * FROM usuarios WHERE id_usuario = ?")) {
            pst.setLong(1, idUsuario);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setIdUsuario(rs.getLong("id_usuario"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setApellido(rs.getString("apellidos"));
                    usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                    usuario.setContraseña(rs.getString("contrasena"));
                    usuario.setTelefono(rs.getString("telefono"));
                    usuario.setTipoUsuario(rs.getString("tipoUsuario"));
                    return usuario;
                }
                return null; // no se encontró un usuario con ese ID
            }
        } catch (SQLException e) {
            System.out.println("Error en: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Usuario> consultarTodos() {
        List<Usuario> usuarios = new ArrayList<>();
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement("SELECT * FROM usuarios")) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getLong("id_usuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellidos"));
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                usuario.setContraseña(rs.getString("contrasena"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setTipoUsuario(rs.getString("tipoUsuario"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Error en: " + e.getMessage());
        }
        return usuarios;
    }
}
