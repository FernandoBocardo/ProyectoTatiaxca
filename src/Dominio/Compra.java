/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author A515-52
 */
public class Compra {
    Long idCompra, proveedor;
    Date fecha;
    String nota;

    public Compra() {
    }

    public Compra(Long idCompra, Date fecha, String nota, Long proveedor) {
        this.idCompra = idCompra;
        this.fecha = fecha;
        this.proveedor = proveedor;
        this.nota = nota;
    }

    public Long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Long idCompra) {
        this.idCompra = idCompra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getProveedor() {
        return proveedor;
    }

    public void setProveedor(Long proveedor) {
        this.proveedor = proveedor;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Compra other = (Compra) obj;
        return this.idCompra == other.idCompra;
    }

    @Override
    public String toString() {
        return "Compra{" + "idCompra=" + idCompra + ", fecha=" + fecha + ", proveedor=" + proveedor + ", nota=" + nota + '}';
    }

}
