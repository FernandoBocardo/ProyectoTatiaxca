/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.List;

/**
 *
 * @author A515-52
 */
public class Proveedor {
    Long idProveedor;
    String nombre, contacto;
    List<Producto> listaProductos;

    public Proveedor() {
    }

    public Proveedor(Long idProveedor, String nombre, String contacto, List<Producto> listaProductos) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.contacto = contacto;
        this.listaProductos = listaProductos;
    }

    public Long getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Long idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
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
        final Proveedor other = (Proveedor) obj;
        return this.idProveedor == other.idProveedor;
    } 

//    @Override
//    public String toString() {
//        return "Proveedor{" + "idProveedor=" + idProveedor + ", nombre=" + nombre + ", contacto=" + contacto + ", listaProductos=" + listaProductos + '}';
//    } 
    
    @Override
    public String toString()
    {
        return nombre;
    }
    
}
