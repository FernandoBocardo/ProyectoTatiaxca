/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import ConexionBD.ConexionBD;
import Dominio.Producto;
import Dominio.Venta;
import Dominio.Venta_Producto;
import Negocio.IProductos;
import Negocio.IVentas;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author A515-52
 */
public class VentasDAO extends ConexionBD implements IVentas {

    @Override
    public boolean agregar(Venta venta, List<Venta_Producto> ventas_productos) {
        Connection conn = null;
        try {
            conn = getConexion();
            PreparedStatement pstVenta = conn.prepareStatement(
                    "INSERT INTO ventas (fecha, nota, id_cajero) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            PreparedStatement pstVentaProducto = conn.prepareStatement(
                    "INSERT INTO venta_producto (id_venta, id_producto, precioProducto, cantidadProducto, saborProducto) VALUES (?, ?, ?, ?, ?)");
            PreparedStatement pstProducto = conn.prepareStatement(
                    "UPDATE productos SET stock = stock - ? WHERE id_producto = ? AND stock != -1");

            // Iniciar una transacción
            conn.setAutoCommit(false);

            // Insertar la venta
            pstVenta.setTimestamp(1, new Timestamp(venta.getFecha().getTime()));
            pstVenta.setString(2, venta.getNota());
            pstVenta.setLong(3, venta.getIdCajero());
            int filasAfectadasVenta = pstVenta.executeUpdate();
            if (filasAfectadasVenta == 0) {
                conn.rollback();
                return false; // no se insertó 
            }

            // Obtener el ID de la venta
            ResultSet rsVenta = pstVenta.getGeneratedKeys();
            rsVenta.next();
            Long idVenta = rsVenta.getLong(1);

            // Insertar los registros de venta_producto y actualizar el stock de los productos
            for (Venta_Producto vp : ventas_productos) {
                pstVentaProducto.setLong(1, idVenta);
                pstVentaProducto.setLong(2, vp.getIdProducto());
                pstVentaProducto.setDouble(3, vp.getPrecioProducto());
                pstVentaProducto.setInt(4, vp.getCantidadProducto());
                pstVentaProducto.setString(5, vp.getSaborProducto());
                int filasAfectadasVentaProducto = pstVentaProducto.executeUpdate();
                if (filasAfectadasVentaProducto == 0) {
                    conn.rollback();
                    return false; // no se insertó
                }
                pstProducto.setInt(1, vp.getCantidadProducto());
                pstProducto.setLong(2, vp.getIdProducto());
                int filasAfectadasProducto = pstProducto.executeUpdate();

            }

            // Confirmar la transacción
            conn.commit();
            return true;
        } catch (SQLException e) {
            System.out.println("Error en: " + e.getMessage());
            // Hacer rollback en caso de excepción para asegurarse de que se revierta la transacción
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println("Error al hacer rollback: " + ex.getMessage());
                }
            }
            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("Error al cerrar la conexión: " + ex.getMessage());
                }
            }
        }
    }

    @Override
    public boolean eliminar(Long idVenta) {
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement("DELETE FROM ventas WHERE id_venta = ?")) {
            pst.setLong(1, idVenta);
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
    public Venta consultarPorId(Long idVenta) {
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement("SELECT * FROM ventas WHERE id_venta = ?")) {
            pst.setLong(1, idVenta);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Venta venta = new Venta();
                venta.setIdVenta(rs.getLong("id_venta"));

                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(rs.getTimestamp("fecha").getTime());
                Date fecha = (Date) calendar.getTime();
                venta.setFecha(fecha);

                venta.setNota(rs.getString("nota"));
                venta.setIdCajero(rs.getLong("id_cajero"));
                return venta;
            }
            return null;
        } catch (SQLException e) {
            System.out.println("Error en: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Venta> consultarTodos() {
        List<Venta> ventas = new ArrayList<>();
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement("SELECT * FROM ventas");
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                Venta venta = new Venta();
                venta.setIdVenta(rs.getLong("id_venta"));
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(rs.getTimestamp("fecha").getTime());
                Date fecha = (Date) calendar.getTime();
                venta.setFecha(fecha);
                venta.setNota(rs.getString("nota"));
                venta.setIdCajero(rs.getLong("id_cajero"));
                ventas.add(venta);
            }
        } catch (SQLException e) {
            System.out.println("Error en: " + e.getMessage());
        }
        return ventas;
    }

}
