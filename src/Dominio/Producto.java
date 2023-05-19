/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author A515-52
 */
public class Producto {
    Long idProducto, idCategoria, idGerente, idProveedor, idMenu; 
    int stock;
    float precioCompra, precioVenta;
    String nombre, descripcion, unidadMedida;

    public Producto() {
    }

    public Producto(String nombre, float precioCompra, float precioVenta, int stock, String descripcion, String unidadMedida, Long idCategoria, Long idGerente, Long idProveedor, Long idMenu) {
        this.idCategoria = idCategoria;
        this.idGerente = idGerente;
        this.idProveedor = idProveedor;
        this.idMenu = idMenu;
        this.stock = stock;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidadMedida = unidadMedida;
    }
    
    public Producto(Long idProducto, String nombre, float precioCompra, float precioVenta, int stock, String descripcion, String unidadMedida, Long idCategoria, Long idGerente, Long idProveedor, Long idMenu) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.stock = stock;
        this.descripcion = descripcion;
        this.unidadMedida = unidadMedida;
        this.idCategoria = idCategoria;
        this.idGerente = idGerente;
        this.idProveedor = idProveedor;
        this.idMenu = idMenu;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Long getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(Long idGerente) {
        this.idGerente = idGerente;
    }

    public Long getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Long idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Long getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Long idMenu) {
        this.idMenu = idMenu;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        return this.idProducto == other.idProducto;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", idCategoria=" + idCategoria + ", idGerente=" + idGerente + ", idProveedor=" + idProveedor + ", idMenu=" + idMenu + ", stock=" + stock + ", precioCompra=" + precioCompra + ", precioVenta=" + precioVenta + ", nombre=" + nombre + ", descripcion=" + descripcion + ", unidadMedida=" + unidadMedida + '}';
    }
}
