/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.TipoHabitacion;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Macarena Infante
 */
public class TipoHabitacionData {    private Connection con = null;

    public TipoHabitacionData(Conexion conexion) {
        try {
            con = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error de conexion");
        }
    }
    
    public void cambiarPrecio(TipoHabitacion habitacion, double precio){
        habitacion.setPrecioPorNoche(precio);
        System.out.println("Precio de la habitacion actualizado correctamente");
    }
    
}
