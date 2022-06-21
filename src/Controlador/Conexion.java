/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private String url = "jdbc:mysql://localhost/hotel";
    private String usuario = "root";
    private String password = "";

    private Connection conexion;

    public Conexion() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Mariadb no encontrado!");
        }

    }

    public Connection getConexion() throws SQLException {
        if (conexion == null) {
            conexion = DriverManager
                    .getConnection(url + "?useLegacyDatetimeCode=false&serverTimezone=UTC"
                            + "&user=" + usuario
                            + "&password=" + password);
        }
        return conexion;
    }
}