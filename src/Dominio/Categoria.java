/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author A515-52
 */
public class Categoria {
    Long idCategoria;
    Long idGerente;
    String nombre, descripcion;

    public Categoria() {
    }

    public Categoria(Long idGerente, String nombre, String descripcion) {
        this.idGerente = idGerente;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Categoria(Long idCategoria, Long idGerente, String nombre, String descripcion) {
        this.idCategoria = idCategoria;
        this.idGerente = idGerente;
        this.nombre = nombre;
        this.descripcion = descripcion;
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
        final Categoria other = (Categoria) obj;
        return this.idCategoria == other.idCategoria;
    }

//    @Override
//    public String toString() {
//        return "Categoria{" + "idCategoria=" + idCategoria + ", idGerente=" + idGerente + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
//    }
    
    @Override
    public String toString()
    {
        return nombre;
    }
    
}
