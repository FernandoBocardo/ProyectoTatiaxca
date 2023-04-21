/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionBD;

import Negocio.IConexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que establece una conexión con una base de datos MySQL usando JDBC.
 * Implementa la interfaz IConexionBD.
 *
 * @author Oscar Roman
 */
public class ConexionBD implements IConexionBD {

    private String USERNAME = "root";
    private String PASSWORD = "1234";
    private String HOST = "localhost";
    private String PORT = "3306";
    private String DATABASE = "tatiaxca";
    private String CLASSNAME = "com.mysql.jdbc.Driver";
    private String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
    private Connection con;

    /**
     * Constructor de la clase ConexionBD. Se encarga de cargar el controlador
     * de la base de datos y establecer la conexión con la misma.
     *
     * @throws ClassNotFoundException si el controlador de la base de datos no
     * se encuentra.
     * @throws SQLException si ocurre un error al establecer la conexión con la
     * base de datos.
     *
     */
    public ConexionBD() {
        try {
            Class.forName(CLASSNAME);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("Error en: " + e);
        } catch (SQLException e) {
            System.err.println("Error en: " + e);
        }
    }

    /**
     * Regresa el objeto Connection utilizado para conectarse con la base de
     * datos.
     *
     * @return Objeto Connection utilizado para conectarse con la base de datos.
     */
    public Connection getConexion() {
        return con;
    }
}
