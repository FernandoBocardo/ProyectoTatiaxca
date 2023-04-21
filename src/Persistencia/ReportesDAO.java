/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import ConexionBD.ConexionBD;
import Dominio.Reporte;
import Negocio.IReportes;
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
public class ReportesDAO extends ConexionBD implements IReportes {

    @Override
    public boolean agregar(Reporte reporte) {
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement("INSERT INTO reportes (descripcion, id_gerente) VALUES (?, ?)")) {
            pst.setString(1, reporte.getDescripcion());
            pst.setLong(2, reporte.getIdGerente());
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
    public boolean actualizar(int idReporte, Reporte reporte) {
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement("UPDATE reportes SET descripcion = ?, id_gerente = ? WHERE id_reporte = ?")) {
            pst.setString(1, reporte.getDescripcion());
            pst.setLong(2, reporte.getIdGerente());
            pst.setInt(3, idReporte);
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
    public boolean eliminar(int idReporte) {
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement("DELETE FROM reportes WHERE id_reporte = ?")) {
            pst.setInt(1, idReporte);
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
    public Reporte consultarPorId(int idReporte) {
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement("SELECT * FROM reportes WHERE id_reporte = ?")) {
            pst.setInt(1, idReporte);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Reporte reporte = new Reporte();
                reporte.setIdReporte(rs.getLong("id_reporte"));
                reporte.setDescripcion(rs.getString("descripcion"));
                reporte.setIdGerente(rs.getLong("id_gerente"));
                return reporte;
            }
            return null;
        } catch (SQLException e) {
            System.out.println("Error en: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Reporte> consultarTodos() {
        List<Reporte> reportes = new ArrayList<>();
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement("SELECT * FROM reportes")) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Reporte reporte = new Reporte();
                reporte.setIdReporte(rs.getLong("id_reporte"));
                reporte.setDescripcion(rs.getString("descripcion"));
                reporte.setIdGerente(rs.getLong("id_gerente"));
                reportes.add(reporte);
            }
        } catch (SQLException e) {
            System.out.println("Error en: " + e.getMessage());
        }
        return reportes;
    }
}