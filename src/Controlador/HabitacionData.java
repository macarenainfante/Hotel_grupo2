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
   
    private Conexion conexion;
    private Connection con=null;
    private TipoHabitacionData tipo;
    
        /**
     *
     * @param conexion
     */
    
    public HabitacionData(Conexion conexion) {
        try{ 
           this.con = conexion.getConexion();
           tipo = new TipoHabitacionData(conexion);
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Error de conexion en Habitacion");
       }
       
    }
    
    
    public void altaHabitacion(Habitacion habitacion) {
        String sql = "INSERT INTO habitacion(idTipoHabitacion, piso, estado, nroHabitacion, activo) VALUES (?,?,?,?,?)";
        try {
              PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
             // ps.setInt(1, habitacion.getIdHabitacion() );
             //System.out.println("Tipo " + habitacion.getIdHabitacion());
              ps.setInt(1, habitacion.getTipoHabitacion().getCodigo() );
              ps.setInt(2, habitacion.getPiso() );            
              ps.setBoolean(3, habitacion.getEstado() );
              ps.setInt(4, habitacion.getNroHabitacion()); 
              ps.setBoolean(5, habitacion.getActivo());
              ps.executeUpdate();
              ResultSet rs = ps.getGeneratedKeys(); 
              
              if (rs.next()) {
                habitacion.setIdHabitacion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Habitacion agregada correctamente");                
              } else {
                JOptionPane.showMessageDialog(null, "No se pudo agregar la habitacion");
              }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error de conexion desde Agregar Habitacion en HabitacionData " + ex);
                System.out.println("Error "+ ex);
        }
    }        
    
    
    public void bajaHabitacion(int idHabitacion){
        String sql = "UPDATE habitacion SET activo = 0 WHERE idHabitacion = ? ";        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idHabitacion);
            int rs = ps.executeUpdate();
            
            if (rs > 0){
                JOptionPane.showMessageDialog(null, "Habitacion eliminada correctamente");
            } else{
                JOptionPane.showMessageDialog(null, "No se encuentra la habitacion");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexion desde borrar habitacion en HabitacionData");
        }
        
    }
    
    public void modificacionHabitacion(Habitacion habitacion){          
    
    String sql = "UPDATE habitacion SET idTipoHabitacion=?, piso=?, estado=?, nroHabitacion=? WHERE idHabitacion=?";
     PreparedStatement ps = null;

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, habitacion.getTipoHabitacion().getCodigo() );
            ps.setInt(2, habitacion.getPiso() );            
            ps.setInt(3, habitacion.estadoEnNum());
            ps.setInt(4, habitacion.getNroHabitacion());
            ps.setInt(5, habitacion.getIdHabitacion());

            int rs = ps.executeUpdate();
            
            if (rs > 0){
                JOptionPane.showMessageDialog(null, "Habitacion modificada correctamente");
            } else{
                JOptionPane.showMessageDialog(null, "No se encuentra la habitacion");
            }
            ps.close();
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error de conexion desde modificar habitacion " + ex);

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
                habitacion.setTipoHabitacion(tipo.buscarTipoHabitacion(rs.getInt(2)));
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
    
    
        public Habitacion buscarHabitacionPorNum(int nro) {
                
               Habitacion habitacion = null; 
                String sql = "SELECT * FROM habitacion WHERE nroHabitacion LIKE ?";

            

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, nro);
            ResultSet rs = ps.executeQuery();
            ps.close();
            while (rs.next()) {
                habitacion = new Habitacion();

                habitacion.setIdHabitacion(rs.getInt(1));
                habitacion.setTipoHabitacion(tipo.buscarTipoHabitacion(rs.getInt(2)));
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
