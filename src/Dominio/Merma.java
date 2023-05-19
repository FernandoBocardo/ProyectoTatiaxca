/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author A515-52
 */
public class Merma {
    Long idMerma, idProducto, idCajero;
    int cantidad;
    String nota;

    public Merma() {
    }

    public Merma(Long idMerma, Long idProducto, int cantidad, String nota, Long idCajero) {
        this.idMerma = idMerma;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.nota = nota;
        this.idCajero = idCajero;
    }

    public Long getIdMerma() {
        return idMerma;
    }

    public void setIdMerma(Long idMerma) {
        this.idMerma = idMerma;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Long getIdCajero() {
        return idCajero;
    }

    public void setIdCajero(Long idCajero) {
        this.idCajero = idCajero;
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
        final Merma other = (Merma) obj;
        return this.idMerma == other.idMerma;
    }   

    @Override
    public String toString() {
        return "Merma{" + "idMerma=" + idMerma + ", idProducto=" + idProducto + ", cantidad=" + cantidad + ", nota=" + nota + '}';
    }
}
