/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author A515-52
 */
public class Venta {
    Long idVenta;
    Long idCajero;
    List<Producto> listaProductos;
    Date fecha;
    String nota;

    public Venta() {
    }

    public Venta(Long idVenta, Long idCajero, List<Producto> listaProductos, Date fecha, String nota) {
        this.idVenta = idVenta;
        this.idCajero = idCajero;
        this.listaProductos = listaProductos;
        this.fecha = fecha;
        this.nota = nota;
    }

    public Venta(Long idCajero, List<Producto> listaProductos, Date fecha, String nota) {
        this.idCajero = idCajero;
        this.listaProductos = listaProductos;
        this.fecha = fecha;
        this.nota = nota;
    }
    
    public Long getIdCajero() {
        return idCajero;
    }

    public void setIdCajero(Long idCajero) {
        this.idCajero = idCajero;
    }
    
    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
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
        final Venta other = (Venta) obj;
        return this.idVenta == other.idVenta;
    }

    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", listaProductos=" + listaProductos + ", fecha=" + fecha + ", nota=" + nota + '}';
    }   
}
