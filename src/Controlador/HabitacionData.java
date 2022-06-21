/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Macarena Infante
 */
public class HabitacionData {
   
   
    private Connection con = null;

    public HabitacionData(Conexion conexion) {
        try {
            this.con = conexion.getConexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexion.");
        }
    }
    
    
    public void altaHabitacion(Habitacion habitacion) {
        String sql = "INSERT INTO habitacion (idHabitacion, piso, estado)  VALUES (?, ?, ?)";
        try {
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
              ps.setInt(1, habitacion.getIdTipoHabitacion() );
              ps.setInt(2, habitacion.getPiso() );            
              ps.setBoolean(3, habitacion.getEstado() );
              ps.executeUpdate();
              ResultSet rs = ps.getGeneratedKeys();            
              if (rs.next()) {
                habitacion.setIdHabitacion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Habitacion agregada correctamente");                
              } else {
                JOptionPane.showMessageDialog(null, "No se pudo agregar la habitacion");
              }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion desde Agregar Habitacion en HabitacionData");
        }
    }        
    
    
    public void bajaHabitacion(int idHabitacion){
        
        try {
            String sql = "UPDATE habitacion SET estado = 1 WHERE idHabitacion = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idHabitacion);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Habitacion eliminada correctamente");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexion desde borrar habitacion en HabitacionData");
        }
        
    }
    
    public Habitacion modificacionHabitacion(int idHabitacion, Habitacion habitacion){
        
        String sql = "UPDATE habitacion SET idTipoHabitacion=?, nroHabitacion =?, piso=?, estado=? WHERE idHabitacion=?";
        PreparedStatement ps = null;
        try {
                ps.setInt(1, habitacion.getIdTipoHabitacion() );
                ps.setInt(2, habitacion.getNroHabitacion() );
                ps.setInt(3, habitacion.getPiso() );            
                ps.setBoolean(4, habitacion.getEstado() );
                ps.setInt(5, habitacion.getIdHabitacion() );
                ps.executeUpdate();
                System.out.println("Habitacion modificada correctamente");
                
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion al modificar habitacion desde HabitacionData");
            
        }
        return habitacion;
    }
    
    
    public Habitacion buscarHabitacionPorId(int idHabitacion) {
                
               Habitacion habitacion = null; 
                String sql = "SELECT * FROM habitacion WHERE idHabitacion LIKE ?";

            

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idHabitacion);
            ResultSet rs = ps.executeQuery();
            ps.close();
            while (rs.next()) {
                habitacion = new Habitacion();

                habitacion.setIdHabitacion(rs.getInt(1));
                habitacion.setIdTipoHabitacion(rs.getInt(2));
                habitacion.setPiso(rs.getInt(3));
                habitacion.setEstado(rs.getBoolean(4));
                habitacion.setNroHabitacion(rs.getInt(5));
                habitacion.setActivo(rs.getBoolean(6));
                
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
        }
        return habitacion;

}
    
}
