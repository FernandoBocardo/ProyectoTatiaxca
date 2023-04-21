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
public class Menu {
    Long idMenu;
    List<Producto> listaProductos;

    public Menu() {
    }

    public Menu(Long idMenu, List<Producto> listaProductos) {
        this.idMenu = idMenu;
        this.listaProductos = listaProductos;
    }

    public Long getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Long idMenu) {
        this.idMenu = idMenu;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
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
        final Menu other = (Menu) obj;
        return this.idMenu == other.idMenu;
    }

    @Override
    public String toString() {
        return "Menu{" + "idMenu=" + idMenu + ", listaProductos=" + listaProductos + '}';
    }   
}
