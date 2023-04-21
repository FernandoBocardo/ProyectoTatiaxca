/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import ConexionBD.ConexionBD;
import Dominio.Compra;
import Negocio.ICompras;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Oscar Roman
 */
public class ComprasDAO extends ConexionBD implements ICompras {

//    @Override
//    public boolean agregar(Compra compra) {
//        try (Connection conn = getConexion();
//                PreparedStatement pst = conn.prepareStatement("INSERT INTO compras (fecha, nota, id_proveedor) VALUES (?, ?, ?)")) {
//            pst.setTimestamp(1, new Timestamp(compra.getFecha().getTime()));
//            pst.setString(2, compra.getNota());
//            pst.setLong(3, compra.getProveedor());
//            int filasAfectadas = pst.executeUpdate();
//            if (filasAfectadas == 0) {
//                return false; // no se agregó ninguna fila
//            }
//            return true;
//        } catch (SQLException e) {
//            System.out.println("Error en: " + e.getMessage());
//            return false;
//        }
//    }
//
//    @Override
//    public boolean actualizar(Long idCompra, Compra compra) {
//        try (Connection conn = getConexion();
//                PreparedStatement pst = conn.prepareStatement("UPDATE compras SET fecha = ?, nota = ?, id_proveedor = ? WHERE id_compra = ?")) {
//            pst.setTimestamp(1, new Timestamp(compra.getFecha().getTime()));
//            pst.setString(2, compra.getNota());
//            pst.setLong(3, compra.getProveedor());
//            pst.setLong(4, idCompra);
//            int filasAfectadas = pst.executeUpdate();
//            if (filasAfectadas == 0) {
//                return false; // no se actualizó ninguna fila
//            }
//            return true;
//        } catch (SQLException e) {
//            System.out.println("Error en: " + e.getMessage());
//            return false;
//        }
//    }
    
     @Override
    public boolean agregar(Compra compra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(Long idCompra, Compra compra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean eliminar(Long idCompra) {
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement("DELETE FROM compras WHERE id_compra = ?")) {
            pst.setLong(1, idCompra);
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
    public Compra consultarPorId(Long idCompra) {
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement("SELECT * FROM compras WHERE id_compra = ?")) {
            pst.setLong(1, idCompra);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Compra compra = new Compra();
                compra.setIdCompra(rs.getLong("id_compra"));
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(rs.getTimestamp("fecha").getTime());
                Date fecha = (Date) calendar.getTime();
                compra.setFecha(fecha);
                compra.setNota(rs.getString("nota"));
                compra.setProveedor(rs.getLong("id_proveedor"));
                return compra;
            }
            return null;
        } catch (SQLException e) {
            System.out.println("Error en: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Compra> consultarTodos() {
        List<Compra> compras = new ArrayList<>();
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement("SELECT * FROM compras")) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setIdCompra(rs.getLong("id_compra"));
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(rs.getTimestamp("fecha").getTime());
                Date fecha = (Date) calendar.getTime();
                compra.setFecha(fecha);
                compra.setNota(rs.getString("nota"));
                compra.setProveedor(rs.getLong("id_proveedor"));
                compras.add(compra);
            }
        } catch (SQLException e) {
            System.out.println("Error en: " + e.getMessage());
        }
        return compras;
    }

}
