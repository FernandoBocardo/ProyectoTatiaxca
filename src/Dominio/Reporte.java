/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author A515-52
 */
public class Reporte {
    Long idReporte, idGerente;
    String descripcion;

    public Reporte() {
    }

    public Reporte(Long idReporte, Long idGerente, String descripcion) {
        this.idReporte = idReporte;
        this.idGerente = idGerente;
        this.descripcion = descripcion;
    }

    public Long getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(Long idReporte) {
        this.idReporte = idReporte;
    }

    public Long getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(Long idGerente) {
        this.idGerente = idGerente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        final Reporte other = (Reporte) obj;
        return this.idReporte == other.idReporte;
    }

    @Override
    public String toString() {
        return "Reporte{" + "idReporte=" + idReporte + ", idGerente=" + idGerente + ", descripcion=" + descripcion + '}';
    }   
}