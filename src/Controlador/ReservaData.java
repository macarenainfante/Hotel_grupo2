/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Macarena Infante
 */
public class ReservaData {
    
        private Connection con = null;

    public ReservaData(Conexion conexion) {
        try {
            con = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error de conexion");
        }
    }
    
        public void buscarReservaPorHuesped(){
        
    }
    
    public void cancelarReserva(){
        
    }
    
    public void calcularImporteTotal(){
                
    }
    
    public void crearReserva(){
        
    }
    
}
