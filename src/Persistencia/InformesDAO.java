/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import ConexionBD.ConexionBD;
import Dominio.Informe;
import Negocio.IInformes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oscar Roman
 */
public class InformesDAO extends ConexionBD implements IInformes{

    @Override
    public boolean agregar(Informe informe) {
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement("INSERT INTO informes (descripcion, id_gerente, tipoInforme) VALUES (?, ?, ?)")) {
            pst.setString(1, informe.getDescripcion());
            pst.setLong(2, informe.getIdGerente());
            pst.setString(3, informe.getTipoInforme());
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
    public boolean actualizar(Long idInforme, Informe informe) {
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement("UPDATE informes SET descripcion=?, id_gerente=?, tipoInforme=? WHERE id_informe=?")) {
            pst.setString(1, informe.getDescripcion());
            pst.setLong(2, informe.getIdGerente());
            pst.setString(3, informe.getTipoInforme());
            pst.setLong(4, idInforme);
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
    public boolean eliminar(Long idInforme) {
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement("DELETE FROM informes WHERE id_informe = ?")) {
            pst.setLong(1, idInforme);
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
    public Informe consultarPorId(Long idInforme) {
        Informe informe = null;
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement("SELECT * FROM informes WHERE id_informe = ?")) {
            pst.setLong(1, idInforme);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                informe = new Informe();
                informe.setIdInforme(rs.getLong("id_informe"));
                informe.setDescripcion(rs.getString("descripcion"));
                informe.setIdGerente(rs.getLong("id_gerente"));
                informe.setTipoInforme(rs.getString("tipoInforme"));
            }
        } catch (SQLException e) {
            System.out.println("Error en: " + e.getMessage());
        }
        return informe;
    }

    @Override
    public List<Informe> consultarTodos() {
        List<Informe> informes = new ArrayList<>();
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement("SELECT * FROM informes");
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                Informe informe = new Informe();
                informe.setIdInforme(rs.getLong("id_informe"));
                informe.setDescripcion(rs.getString("descripcion"));
                informe.setIdGerente(rs.getLong("id_gerente"));
                informe.setTipoInforme(rs.getString("tipoInforme"));
                informes.add(informe);
            }
        } catch (SQLException e) {
            System.out.println("Error en: " + e.getMessage());
        }
        return informes;
    }
}
