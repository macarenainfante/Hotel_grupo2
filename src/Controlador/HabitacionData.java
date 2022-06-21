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
            con = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error de conexion");
        }
    }
    
    
    public boolean altaHabitacion(Habitacion habitacion) {
        String sql = "INSERT INTO habitacion (id_tipo_habitacion, piso, estado)  VALUES (?, ?, ?)";

        try {
            ResultSet rs;
            try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, habitacion.getIdTipoHabitacion() );
                ps.setInt(2, habitacion.getPiso() );            
                ps.setBoolean(3, habitacion.getEstado() );

                ps.executeUpdate();
                rs = ps.getGeneratedKeys();
            }

            if (rs.next()) {
                habitacion.setIdHabitacion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Habitacion agregada correctamente");
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion al agregar habitacion");
            return false;
        }
    }        
    
    
    public boolean bajaHabitacion(Habitacion habitacion){
        
            String sql = "DELETE FROM habitacion WHERE id_habitacion=?";

        try {
            //ResultSet rs;
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, habitacion.getIdHabitacion());
                ps.executeUpdate();
                System.out.println("Habitacion dada de baja correctamente");
                return true; // falta hacer que retorne true solo si encontro y pudo modificar el alumno
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion al dar de baja a la habitacion");
            return false;
        }
        
    }
    
    public boolean modificacionHabitacion(Habitacion habitacion){
        
        String sql = "UPDATE habitacion (id_tipo_habitacion, piso, estado) VALUES (?, ?, ?) WHERE id_habitacion=?";

        try {
            //ResultSet rs;
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, habitacion.getIdTipoHabitacion() );
                ps.setInt(2, habitacion.getPiso() );            
                ps.setBoolean(3, habitacion.getEstado() );
                ps.setInt(4, habitacion.getIdHabitacion() );
                ps.executeUpdate();
                System.out.println("Habitacion modificada correctamente");
                return true; // falta hacer que retorne true solo si encontro y pudo modificar el alumno
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion al modificar habitacion");
            return false;
        }
        
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
