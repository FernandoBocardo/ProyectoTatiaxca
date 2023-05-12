/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import ConexionBD.ConexionBD;
import Dominio.Categoria;
import Negocio.ICategorias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author roman
 */
public class CategoriasDAO extends ConexionBD implements ICategorias{

    @Override
    public boolean agregar(Categoria categoria) {
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement("INSERT INTO categorias (nombre, descripcion, id_gerente) VALUES (?, ?, ?)")) {
            pst.setString(1, categoria.getNombre());
            pst.setString(2, categoria.getDescripcion());
            pst.setLong(3, categoria.getIdGerente());
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
    public boolean actualizar(Long idCategoria, Categoria categoria) {
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement("UPDATE categorias SET nombre = ?, descripcion = ?, id_gerente = ? WHERE id_categoria = ?")) {
            pst.setString(1, categoria.getNombre());
            pst.setString(2, categoria.getDescripcion());
            pst.setLong(3, categoria.getIdGerente());
            pst.setLong(4, idCategoria);
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
    public boolean eliminar(Long idCategoria) {
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement("DELETE FROM categorias WHERE id_categoria = ?")) {
            pst.setLong(1, idCategoria);
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
    public Categoria consultarPorId(Long idCategoria) {
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement("SELECT * FROM categorias WHERE id_categoria = ?")) {
            pst.setLong(1, idCategoria);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getLong("id_categoria"));
                categoria.setNombre(rs.getString("nombre"));
                categoria.setDescripcion(rs.getString("descripcion"));
                categoria.setIdGerente(rs.getLong("id_gerente"));
                return categoria;
            }
            return null;
        } catch (SQLException e) {
            System.out.println("Error en: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Categoria> consultarTodos() {
        List<Categoria> categorias = new ArrayList<>();
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement("SELECT * FROM categorias");
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getLong("id_categoria"));
                categoria.setNombre(rs.getString("nombre"));
                categoria.setDescripcion(rs.getString("descripcion"));
                categoria.setIdGerente(rs.getLong("id_gerente"));
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            System.out.println("Error en: " + e.getMessage());
        }
        return categorias;
    }

    @Override
    public Categoria consultarPorNombre(String nombreCategoria) 
    {
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement("SELECT * FROM categorias WHERE nombre = ?")) {
            pst.setString(1, nombreCategoria);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getLong("id_categoria"));
                categoria.setNombre(rs.getString("nombre"));
                categoria.setDescripcion(rs.getString("descripcion"));
                categoria.setIdGerente(rs.getLong("id_gerente"));
                return categoria;
            }
            return null;
        } catch (SQLException e) {
            System.out.println("Error en: " + e.getMessage());
            return null;
        }
    }

}
