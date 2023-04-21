/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cafemanager;

import Controlador.CtrlProductos;
import guis.frmCategorias;
import guis.frmProductos;

/**
 *
 * @author A515-52
 */
public class CafeManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        CtrlProductos ctrlProductos = new CtrlProductos();
////        ctrlProductos.consultarPorId(5L);
//        System.out.println(ctrlProductos.consultarPorId(5L));

        new frmCategorias().setVisible(true);
        
    }

}
