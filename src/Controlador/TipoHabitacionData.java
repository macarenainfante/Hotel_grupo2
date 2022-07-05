/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Huesped;
import Modelo.TipoHabitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Macarena Infante
 */
public class TipoHabitacionData {    
    private Conexion conexion;
    private Connection con=null;

    /**/

    /**
     *
     * @param conexion
     */


    public TipoHabitacionData(Conexion conexion) {
        try{ 
           this.con = conexion.getConexion();
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Error de conexion en Tipo de Habitacion");
       }
    }
    
    
        public void agregarTipoHabitacion(TipoHabitacion tipoHabitacion) {
        String sql = "INSERT INTO tipo_habitacion(idTipoHabitacion, cantidadPers, cantCamas, tipoCamas, nombreTipoHabitacion, precio, activo) VALUES (?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, tipoHabitacion.getCodigo());
            ps.setInt(2, tipoHabitacion.getMaxPersonas());
            ps.setInt(3, tipoHabitacion.getCantidadDeCamas());            
            ps.setString(4, tipoHabitacion.getTipoDeCama() );
            ps.setString(5, tipoHabitacion.getNombreTipoHabitacion() );
            ps.setDouble(6, tipoHabitacion.getPrecioPorNoche() );
            ps.setBoolean(7, tipoHabitacion.getActivo() );
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            

            if (rs.next()) {
                tipoHabitacion.setCodigo(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Tipo de habitacion agregada correctamente");
        
            } else {
                JOptionPane.showMessageDialog(null, "Error al agregar tipo de habitacion");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion al agregar tipo de habitacion " + ex);
        
        }
      
    }
        
        
        public TipoHabitacion buscarTipoHabitacion(int idTipoHabitacion) {

  
        TipoHabitacion tipoHabitacion = null;

        String sql = "SELECT * FROM tipo_habitacion WHERE idTipoHabitacion =?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idTipoHabitacion);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                tipoHabitacion = new TipoHabitacion();
                tipoHabitacion.setCodigo(rs.getInt("idTipoHabitacion"));
                tipoHabitacion.setMaxPersonas(rs.getInt("cantidadPers"));
                tipoHabitacion.setCantidadDeCamas(rs.getInt("cantCamas"));
                tipoHabitacion.setTipoDeCama(rs.getString("tipoCamas"));
                tipoHabitacion.setNombreTipoHabitacion(rs.getString("nombreTipoHabitacion"));
                tipoHabitacion.setPrecioPorNoche(rs.getDouble("precio"));
                tipoHabitacion.setActivo(rs.getBoolean("activo"));
                
               
            } else {
                JOptionPane.showMessageDialog(null, " Id de Tipo de Habitacion inexistente");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error de conexion desde buscar Tipo de Habitacion " + ex);
        }

        return tipoHabitacion;
    }
    
    
        public void modificarTipoHabitacion(int idTipoHabitacion, TipoHabitacion tipoHabitacion) {

        String sql = "UPDATE tipo_habitacion SET cantidadPers=?, cantCamas=?, tipoCamas=?, nombreTipoHabitacion=?, precio=?, activo=? WHERE idTipoHabitacion=?;";
        PreparedStatement ps=null;
        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, tipoHabitacion.getMaxPersonas());
            ps.setInt(2, tipoHabitacion.getCantidadDeCamas());            
            ps.setString(3, tipoHabitacion.getTipoDeCama());
            ps.setString(4, tipoHabitacion.getNombreTipoHabitacion());
            ps.setDouble(5, tipoHabitacion.getPrecioPorNoche());
            ps.setBoolean(6, tipoHabitacion.getActivo());
            ps.setInt(7, idTipoHabitacion);

            int rs = ps.executeUpdate();

            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Tipo de Habitacion se actualizo exitosamente ");
            } else {
                JOptionPane.showMessageDialog(null, "Tipo de Habitacion no se pudo actualizar ");
            }

            ps.close();
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error de conexion desde modificar tipo de habitacion" + ex);

        }
    }
        
        
        public void borrarTipoHabitacion(int idTipoHabitacion) {

        // String de consulta a base de datos
        String sql = "DELETE FROM tipo_habitacion WHERE idTipoHabitacion=?";

        try {

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idTipoHabitacion);

            int rs = ps.executeUpdate();
            
            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Tipo de habitacion borrada exitosamente ");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo borrar el tipo de habitacion, id inexistente");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion desde borrar Tipo de habitacion " + ex);

        }
    }
        
        public ArrayList<TipoHabitacion> obtenerTiposDeHabitaciones() {

        ArrayList<TipoHabitacion> tipoHabitaciones = new ArrayList<TipoHabitacion>();

        try {
            String sql = "SELECT * FROM tipo_habitacion WHERE activo = 1;";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            TipoHabitacion tipoHabitacion;

            while (rs.next()) {
                // Creacion y llenado de Huespedes para ser insertados en la lista
                tipoHabitacion = new TipoHabitacion();
                tipoHabitacion.setCodigo(rs.getInt("idTipoHabitacion"));
                tipoHabitacion.setMaxPersonas(rs.getInt("cantidadPers"));
                tipoHabitacion.setCantidadDeCamas(rs.getInt("cantCamas"));
                tipoHabitacion.setTipoDeCama(rs.getString("tipoCamas"));
                tipoHabitacion.setNombreTipoHabitacion(rs.getString("nombreTipoHabitacion"));
                tipoHabitacion.setPrecioPorNoche(rs.getDouble("precio"));
                tipoHabitacion.setActivo(rs.getBoolean("activo"));
 

                tipoHabitaciones.add(tipoHabitacion);
            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al obtener la lista de tipo de habitaciones: " + ex.getMessage());
        }
        return tipoHabitaciones;
    }
        
    public void cambiarPrecio(TipoHabitacion habitacion, double precio){
        habitacion.setPrecioPorNoche(precio);
        System.out.println("Precio de la habitacion actualizado correctamente");
    }
    
}
