/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * La interfaz IConexionBD define el método getConexion() que será implementado
 * por una clase que se encargue de establecer una conexión con una base de
 * datos. La implementación de esta interfaz permitirá obtener un objeto
 * Connection para conectarse con la base de datos. Además, esta interfaz
 * importa las clases Connection y SQLException de java.sql.
 *
 * @author A515-52
 */
public interface IConexionBD {
    
    /**
     * Regresa un objeto Connection que permite conectarse con una base de
     * datos.
     *
     * @return Un objeto Connection que permite conectarse con una base de
     * datos.
     * @throws SQLException si ocurre un error al establecer la conexión con la
     * base de datos.
     */
    public Connection getConexion() throws SQLException;
}
