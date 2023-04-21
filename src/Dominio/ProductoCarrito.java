/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author Fernando
 */
public class ProductoCarrito {
    String nombre, unidadMedida, sabor, tamaño, nota;
    int cantidad;
    float precio;

    public ProductoCarrito() {
    }

    public ProductoCarrito(String nombre, String unidadMedida, String sabor, int cantidad, float precio, String tamaño, String nota) {
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.sabor = sabor;
        this.cantidad = cantidad;
        this.precio = precio;
        this.tamaño = tamaño;
        this.nota = nota;
    }

    public ProductoCarrito(String nombre, String unidadMedida, int cantidad, float precio, String tamaño, String nota) {
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.cantidad = cantidad;
        this.precio = precio;
        this.tamaño = tamaño;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
    
    
    
}
