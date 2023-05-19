/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.Objects;

/**
 *
 * @author Fernando
 */
public class Venta_Producto {

    Long idVenta, idProducto;
    int cantidadProducto;
    float precioProducto;
    String notaProducto;
    String saborProducto;

    public Venta_Producto() {

    }

    public Venta_Producto(Long idVenta, Long idProducto, int cantidadProducto, float precioProducto, String notaProducto) {
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.cantidadProducto = cantidadProducto;
        this.precioProducto = precioProducto;
        this.notaProducto = notaProducto;
        this.saborProducto = saborProducto;
    }

    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public float getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(float precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getNotaProducto() {
        return notaProducto;
    }

    public void setNotaProducto(String notaProducto) {
        this.notaProducto = notaProducto;
    }

    public String getSaborProducto() {
       return saborProducto;
    }

    public void setSaborProducto(String saborProducto) {
        this.saborProducto = saborProducto;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idVenta);
        hash = 97 * hash + Objects.hashCode(this.idProducto);
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
        final Venta_Producto other = (Venta_Producto) obj;
        if (!Objects.equals(this.idVenta, other.idVenta)) {
            return false;
        }
        return Objects.equals(this.idProducto, other.idProducto);
    }

    @Override
    public String toString() {
        return "Venta_Producto{" + "idVenta=" + idVenta + ", idProducto=" + idProducto + ", cantidadProducto=" + cantidadProducto + ", precioProducto=" + precioProducto + ", notaProducto=" + notaProducto + ", saborProducto="  + '}';
    }

    

    

}
