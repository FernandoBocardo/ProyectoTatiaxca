/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author A515-52
 */
public class Informe {
    Long idInforme, idGerente;
    String descripcion, tipoInforme;

    public Informe() {
    }

    public Informe(Long idInforme, Long idGerente, String descripcion, String tipoInforme) {
        this.idInforme = idInforme;
        this.idGerente = idGerente;
        this.descripcion = descripcion;
        this.tipoInforme = tipoInforme;
    }

    public Long getIdInforme() {
        return idInforme;
    }

    public void setIdInforme(Long id) {
        this.idInforme = id;
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

    public String getTipoInforme() {
        return tipoInforme;
    }

    public void setTipoInforme(String tipoInforme) {
        this.tipoInforme = tipoInforme;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Informe other = (Informe) obj;
        return this.idInforme == other.idInforme;
    }

    @Override
    public String toString() {
        return "Informe{" + "idInforme=" + idInforme + ", idGerente=" + idGerente + ", descripcion=" + descripcion + ", tipoInforme=" + tipoInforme + '}';
    }
}
