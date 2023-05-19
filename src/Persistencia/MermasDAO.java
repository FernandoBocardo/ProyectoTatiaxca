/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import ConexionBD.ConexionBD;
import Dominio.Merma;
import Negocio.IMermas;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oscar Roman
 */
public class MermasDAO extends ConexionBD implements IMermas{

    @Override
    public boolean agregar(Merma merma) {
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement("INSERT INTO mermas (id_producto, cantidad, nota, id_cajero) VALUES (?, ?, ?, ?)")) {
            pst.setLong(1, merma.getIdProducto());
            pst.setInt(2, merma.getCantidad());
            pst.setString(3, merma.getNota());
            pst.setLong(4, merma.getIdCajero());
            int filasAfectadas = pst.executeUpdate();
            if (filasAfectadas == 0) {
                return false; // no se insertó ningun registro
            }
            return true;
        } catch (SQLException e) {
            System.out.println("Error en: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(Long idMerma, Merma merma) {
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement(
                        "UPDATE mermas SET id_producto = ?, cantidad = ?, nota = ?, id_cajero = ? WHERE id_merma = ?"
                )) {
            pst.setLong(1, merma.getIdProducto());
            pst.setInt(2, merma.getCantidad());
            pst.setString(3, merma.getNota());
            pst.setLong(4, merma.getIdCajero());
            pst.setLong(5, idMerma);

            int filasAfectadas = pst.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error en: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(Long idMerma) {
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement("DELETE FROM mermas WHERE id_merma = ?")) {
            pst.setLong(1, idMerma);
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
    public List<Merma> consultarTodos() {
        List<Merma> listaMermas = new ArrayList<>();
        try (Connection conn = getConexion();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM mermas")) {
            while (rs.next()) {
                Merma merma = new Merma();
                merma.setIdMerma(rs.getLong("id_merma"));
                merma.setIdProducto(rs.getLong("id_producto"));
                merma.setCantidad(rs.getInt("cantidad"));
                merma.setNota(rs.getString("nota"));
                merma.setIdCajero(rs.getLong("id_cajero"));
                listaMermas.add(merma);
            }
        } catch (SQLException e) {
            System.out.println("Error en: " + e.getMessage());
        }
        return listaMermas;
    }

    @Override
    public Merma consultarPorId(Long idMerma) {
        Merma merma = null;
        try (Connection conn = getConexion(); PreparedStatement pst = conn.prepareStatement("SELECT * FROM mermas WHERE id_merma = ?")) {
            pst.setLong(1, idMerma);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    merma = new Merma();
                    merma.setIdMerma(rs.getLong("id_merma"));
                    merma.setIdProducto(rs.getLong("id_producto"));
                    merma.setCantidad(rs.getInt("cantidad"));
                    merma.setNota(rs.getString("nota"));
                    merma.setIdCajero(rs.getLong("id_cajero"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en: " + e.getMessage());
        }
        return merma;
    }
}
