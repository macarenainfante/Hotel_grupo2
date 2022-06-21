/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Habitacion;
import Modelo.Huesped;
import Modelo.Reserva;
import java.sql.Connection;
import java.sql.Date;
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
public class ReservaData {
    
        private Connection con = null;

    public ReservaData(Conexion conexion) {
        try {
            con = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error de conexion");
        }
    }
    
    public ArrayList<Reserva> buscarReservaPorHuesped(int idHuesped){
        
        ArrayList<Reserva> reservas = new ArrayList<>();

        try {
            String sql = "SELECT * FROM inscripcion WHERE idHuesped = ?;";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idHuesped);

            ResultSet resultSet = statement.executeQuery();

            Reserva reserva;

            while (resultSet.next()) {

                reserva = new Reserva();
                reserva.setIdReserva(resultSet.getInt("idReserva"));

                Huesped h = buscarHuesped(resultSet.getInt("idHuesped"));
                reserva.setHuesped(h);

                Habitacion hab = buscarHabitacion(resultSet.getInt("idHabitacion"));
                reserva.setHabitacion(hab);
                
                reservas.add(reserva);
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las reservas del huesped " + ex.getMessage());
        }

        return reservas;
        
    }
    
    public boolean cancelarReserva(int idReserva){
        
        String sql = "UPDATE reserva SET activo = 0 WHERE idReserva = ?";

        try {
            ResultSet rs;
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, idReserva);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Reserva cancelada correctamente");
                return true; // falta hacer que retorne true solo si encontro y pudo modificar el alumno
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion al eliminar reserva");
            return false;
        }
        
    }
    

    
    public boolean crearReserva(Reserva reserva){
        
        String sql = "INSERT INTO reserva (idHuesped, idHabitacion, cantidadPers, checkIn, checkOut, total)  VALUES (?, ?, ?, ?, ?, ?)";

        try {
            ResultSet rs;
            try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, reserva.getHuesped().getIdHuesped() );
                ps.setInt(2, reserva.getHabitacion().getIdHabitacion() );            
                ps.setInt(3, reserva.getCantPersonas() );
                ps.setDate(4, Date.valueOf(reserva.getCheckIn() ) );
                ps.setDate(5, Date.valueOf(reserva.getCheckOut() ) );
                ps.setDouble(6, reserva.getTotal() );
                

                ps.executeUpdate();
                rs = ps.getGeneratedKeys();
            }

            if (rs.next()) {
                reserva.setIdReserva(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Reserva agregada correctamente");
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion al agregar reserva");
            return false;
        }
    }
        
    public Huesped buscarHuesped(int idHuesped) {
        Huesped huesped = null;
        String sql = "SELECT * FROM huesped WHERE activo=1 AND idHuesped LIKE ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idHuesped);
            ResultSet rs = ps.executeQuery();
            ps.close();
            while (rs.next()) {
                huesped = new Huesped();
                huesped.setIdHuesped(rs.getInt(1));
                huesped.setDni(rs.getString(2));
                huesped.setNombre(rs.getString(3));
                huesped.setApellido(rs.getString(4));
                huesped.setDomicilio(rs.getString(5));
                huesped.setEmail(rs.getString(6));
                huesped.setCelular(rs.getString(7));
                               
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion al buscar Huesped");
        }
        return huesped;
    }
    
        public Habitacion buscarHabitacion(int idHabitacion) {
        Habitacion habitacion = null;
        String sql = "SELECT * FROM huesped WHERE activo=1 AND idHuesped LIKE ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
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
            JOptionPane.showMessageDialog(null, "Error de conexion al buscar Habitacion");
        }
        return habitacion;
    }
        
        public void borrarReservaDeHuesped(int idHuesped, int idHabitacion){
        try {
            String sql = "DELETE FROM reserva WHERE idHuesped = ? AND idHabitacion = ?";
            
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setDouble(1, idHuesped);
                ps.setInt(2, idHabitacion);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Reserva eliminada correctamente");
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion al borrar reserva por huesped");
        }
    }
        
        
    
}