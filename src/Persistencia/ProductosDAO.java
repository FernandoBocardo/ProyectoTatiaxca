/*
 * Café Tatiaxca Obregón
 * Proyecto de Software Integrador
 * 2023 - ITSON
 */
package Persistencia;

import ConexionBD.ConexionBD;
import Dominio.Producto;
import Negocio.IProductos;
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
public class ProductosDAO extends ConexionBD implements IProductos {

    @Override
    public boolean agregar(Producto producto) {
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement("INSERT INTO productos (nombre, precioCompra, precioVenta, stock, descripcion, unidadMedida, id_categoria, id_gerente, id_proveedor, id_menu) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            pst.setString(1, producto.getNombre());
            pst.setFloat(2, producto.getPrecioCompra());
            pst.setFloat(3, producto.getPrecioVenta());
            pst.setInt(4, producto.getStock());
            pst.setString(5, producto.getDescripcion());
            pst.setString(6, producto.getUnidadMedida());
            pst.setLong(7, producto.getIdCategoria());
            pst.setLong(8, producto.getIdGerente());
            pst.setLong(9, producto.getIdProveedor());
            pst.setLong(10, producto.getIdMenu());
            int filasAfectadas = pst.executeUpdate();
            if (filasAfectadas == 0) {
                return false; // no se insertó ninguna fila
            }
            return true;
        } catch (SQLException e) {
            System.out.println("Error en: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(Long idProducto, Producto producto) {
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement("UPDATE productos SET nombre = ?, precioCompra = ?, precioVenta = ?, stock = ?, descripcion = ?, unidadMedida = ?, id_categoria = ?, id_gerente = ?, id_proveedor = ?, id_menu = ? WHERE id_producto = ?")) {
            pst.setString(1, producto.getNombre());
            pst.setFloat(2, producto.getPrecioCompra());
            pst.setFloat(3, producto.getPrecioVenta());
            pst.setInt(4, producto.getStock());
            pst.setString(5, producto.getDescripcion());
            pst.setString(6, producto.getUnidadMedida());
            pst.setLong(7, producto.getIdCategoria());
            pst.setLong(8, producto.getIdGerente());
            pst.setLong(9, producto.getIdProveedor());
            pst.setLong(10, producto.getIdMenu());
            pst.setLong(11, idProducto);
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
    public boolean eliminar(Long idProducto) {
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement("DELETE FROM productos WHERE id_producto = ?")) {
            pst.setLong(1, idProducto);
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
    public Producto consultarPorId(Long idProducto) {
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement("SELECT * FROM productos WHERE id_producto = ?")) {
            pst.setLong(1, idProducto);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getLong("id_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecioCompra(rs.getFloat("precioCompra"));
                producto.setPrecioVenta(rs.getFloat("precioVenta"));
                producto.setStock(rs.getInt("stock"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setUnidadMedida(rs.getString("unidadMedida"));
                producto.setIdCategoria(rs.getLong("id_categoria"));
                producto.setIdGerente(rs.getLong("id_gerente"));
                producto.setIdProveedor(rs.getLong("id_proveedor"));
                producto.setIdMenu(rs.getLong("id_menu"));
                return producto;
            } else {
                return null; // No se encontró un producto con el id dado por el parametro.
            }
        } catch (SQLException e) {
            System.out.println("Error en: " + e.getMessage());
            return null;
        }
    }
    
    @Override
    public Producto consultarPorNombre(String nombreProducto) {
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement("SELECT * FROM productos WHERE nombre = ?")) {
            pst.setString(1, nombreProducto);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getLong("id_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecioCompra(rs.getFloat("precioCompra"));
                producto.setPrecioVenta(rs.getFloat("precioVenta"));
                producto.setStock(rs.getInt("stock"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setUnidadMedida(rs.getString("unidadMedida"));
                producto.setIdCategoria(rs.getLong("id_categoria"));
                producto.setIdGerente(rs.getLong("id_gerente"));
                producto.setIdProveedor(rs.getLong("id_proveedor"));
                producto.setIdMenu(rs.getLong("id_menu"));
                return producto;
            } else {
                return null; // No se encontró un producto con el id dado por el parametro.
            }
        } catch (SQLException e) {
            System.out.println("Error en: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Producto> consultarTodos() {
        List<Producto> listaProductos = new ArrayList<>();
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement("SELECT * FROM productos");
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getLong("id_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecioCompra(rs.getFloat("precioCompra"));
                producto.setPrecioVenta(rs.getFloat("precioVenta"));
                producto.setStock(rs.getInt("stock"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setUnidadMedida(rs.getString("unidadMedida"));
                producto.setIdCategoria(rs.getLong("id_categoria"));
                producto.setIdGerente(rs.getLong("id_gerente"));
                producto.setIdProveedor(rs.getLong("id_proveedor"));
                producto.setIdMenu(rs.getLong("id_menu"));
                listaProductos.add(producto);
            }
        } catch (SQLException e) {
            System.out.println("Error en: " + e.getMessage());
        }
        return listaProductos;
    }
    
    @Override
    public List<Producto> consultarPorCategoria(Long idCategoria) {
        List<Producto> listaProductos = new ArrayList<>();
        try (Connection conn = getConexion();
                PreparedStatement pst = conn.prepareStatement("SELECT * FROM productos WHERE id_categoria = "+idCategoria);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getLong("id_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecioCompra(rs.getFloat("precioCompra"));
                producto.setPrecioVenta(rs.getFloat("precioVenta"));
                producto.setStock(rs.getInt("stock"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setUnidadMedida(rs.getString("unidadMedida"));
                producto.setIdCategoria(rs.getLong("id_categoria"));
                producto.setIdGerente(rs.getLong("id_gerente"));
                producto.setIdProveedor(rs.getLong("id_proveedor"));
                producto.setIdMenu(rs.getLong("id_menu"));
                listaProductos.add(producto);
            }
        } catch (SQLException e) {
            System.out.println("Error en: " + e.getMessage());
        }
        return listaProductos;
    }
    
}
