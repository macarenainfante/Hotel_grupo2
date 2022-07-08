/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Habitacion;
import Modelo.Huesped;
import Modelo.Reserva;
import Modelo.TipoHabitacion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Macarena Infante
 */
public class ReservaData {
    
    private Conexion conexion;
    private Connection con = null;
    private HabitacionData habitacionData;

    public ReservaData(Conexion conexion) {
        try {
            this.conexion = conexion;
            this.con = conexion.getConexion();
            habitacionData = new HabitacionData(conexion);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexion en Reserva Data");
        }
    }
    
    public Reserva buscarReservaPorHuesped(int dni){
        
        Reserva reserva = new Reserva();

        try {
            String sql = "SELECT * FROM reserva WHERE dniHuesped = ?;";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, dni);

            ResultSet resultSet = statement.executeQuery();

            //Reserva reserva;

            while (resultSet.next()) {

                reserva = new Reserva();
                reserva.setIdReserva(resultSet.getInt("idReserva"));

                Huesped h = buscarHuesped(resultSet.getInt("idHuesped"));
                reserva.setHuesped(h);

                Habitacion hab = habitacionData.buscarHabitacionPorId(resultSet.getInt("idHabitacion"));
                reserva.setHabitacion(hab);
                
                //reservas.add(reserva);
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las reservas del huesped " + ex.getMessage());
        }

        return reserva;
        
    }
    
    public void cancelarReserva(int idReserva){
       
    try {   
        String sql = "UPDATE reserva SET activo = 0 WHERE idReserva = ?";
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, idReserva);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Reserva cancelada correctamente");
        ps.close();
    }
    catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error de conexion al eliminar reserva");            
    }
        
   }
    

    
    public void crearReserva(Reserva reserva){
        ZoneId defaultZoneId = ZoneId.systemDefault();
        
        String sql = "INSERT INTO reserva (idHuesped, idHabitacion, cantidadPers, checkIn, checkOut, total, activo)  VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, reserva.getHuesped().getIdHuesped() );
            ps.setInt(2, reserva.getHabitacion().getIdHabitacion() );            
            ps.setInt(3, reserva.getCantPersonas() );
            ps.setDate(4,  Date.valueOf(reserva.getCheckIn()));
            ps.setDate(5,  Date.valueOf(reserva.getCheckOut() ));
            ps.setDouble(6, reserva.getTotal() );
            ps.setInt(7, reserva.getEstado());
                

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                reserva.setIdReserva(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Reserva agregada correctamente");
                
            } else {
                JOptionPane.showMessageDialog(null, "Error al agregar reserva");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion al agregar reserva");
            
        }
    }
        
    public Huesped buscarHuesped(int idHuesped) {
  
        Huesped huesped = new Huesped();

        String sql = "SELECT * FROM huesped WHERE idHuesped =?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idHuesped);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                huesped = new Huesped();
                huesped.setIdHuesped(rs.getInt("idHuesped"));
                huesped.setDni(rs.getString("dniHuesped"));
                huesped.setNombre(rs.getString("nombreHuesped"));
                huesped.setApellido(rs.getString("apellidoHuesped"));
                huesped.setDomicilio(rs.getString("domicilioHuesped"));
                huesped.setEmail(rs.getString("emailHuesped"));
                huesped.setCelular(rs.getString("celularHuesped"));
             

            } else {

                JOptionPane.showMessageDialog(null, " Id de Huesped inexistente");
            }
            ps.close();
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, " Error de conexion desde buscar Huesped " + ex);

        }

        return huesped;
    }
    
    public Huesped buscarHuespedxDni(String dni) {

        Huesped huesped = new Huesped();

        String sql = "SELECT * FROM huesped WHERE dniHuesped =?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dni);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                huesped = new Huesped();
                huesped.setIdHuesped(rs.getInt("idHuesped"));
                huesped.setDni(rs.getString("dniHuesped"));
                huesped.setNombre(rs.getString("nombreHuesped"));
                huesped.setApellido(rs.getString("apellidoHuesped"));
                huesped.setDomicilio(rs.getString("domicilioHuesped"));
                huesped.setEmail(rs.getString("emailHuesped"));
                huesped.setCelular(rs.getString("celularHuesped"));
                
                //JOptionPane.showMessageDialog(null, " Se encontro Huesped:" + huesped.toString());

            } else {

                JOptionPane.showMessageDialog(null, "Dni de Huesped inexistente");
            }
            ps.close();
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, " Error de conexion desde buscar Huesped por DNI " + ex);

        }

        return huesped;
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
        

     public ArrayList<Habitacion> obtenerHabitacionesLibres(LocalDate checkIn, LocalDate checkOut,int cantPerso) {
        ArrayList<Habitacion> habitaciones = new ArrayList<>();
        try {
            String sql = "select h.idHabitacion, h.idTipoHabitacion, h.nroHabitacion, h.piso, h.estado from habitacion h , tipo_habitacion t \n"
                    + "where h.idTipoHabitacion=t.idTipoHabitacion and  h.estado = 1 and t.cantidadPers >= ? \n"
                    + "and h.idHabitacion not in (select r.idHabitacion from reserva r \n"
                    + "where (? >= r.checkIn \n" 
                    + "and ? <= r.checkOut)\n" 
                    + "or (? >= r.checkIn \n" 
                    + "and ? <= r.checkOut \n)"
                    + "and r.activo=1)";
                    
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cantPerso);
            //localDate a Date
            ps.setDate(2, Date.valueOf(checkIn));
            ps.setDate(3, Date.valueOf(checkIn));
            ps.setDate(4, Date.valueOf(checkOut));
            ps.setDate(5, Date.valueOf(checkOut));
            //ps.setInt(6, cantPerso);
            
           
            ResultSet rs = ps.executeQuery();
           
            while (rs.next()) {
                Habitacion habitacion = new Habitacion();               
                habitacion.setIdHabitacion(rs.getInt("idHabitacion"));
                habitacion.setNroHabitacion(rs.getInt("nroHabitacion"));
                habitacion.setPiso(rs.getInt("piso"));
                TipoHabitacion tipoHabitacion = buscarTipoHabitacion(rs.getInt("idTipoHabitacion"));
                habitacion.setTipoHabitacion(tipoHabitacion);
                habitacion.setEstado(rs.getBoolean("estado"));
                habitaciones.add(habitacion);
            }
            ps.close();
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener habitaciones sin reserva "+ex);
        }
        return habitaciones;
    }
     
     
          public ArrayList<Habitacion> obtenerHabitacionesOcupadas(LocalDate checkIn, LocalDate checkOut,int cantPerso) {
        ArrayList<Habitacion> habitaciones = new ArrayList<>();
        try {
            String sql = "select h.idHabitacion, h.idTipoHabitacion, h.nroHabitacion, h.piso, h.estado from habitacion h , tipo_habitacion t \n"
                    + "where h.idTipoHabitacion=t.idTipoHabitacion and  h.estado = 1 and t.cantidadPers >= ? \n"
                    + "and h.idHabitacion not in (select r.idHabitacion from reserva r \n"
                    + "where (? <= r.checkIn \n" 
                    + "and ? >= r.checkOut)\n" 
                    + "or (? <= r.checkIn \n" 
                    + "and ? >= r.checkOut \n)"
                    + "and r.activo=1)";
                    
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cantPerso);
            //localDate a Date
            ps.setDate(2, Date.valueOf(checkIn));
            ps.setDate(3, Date.valueOf(checkIn));
            ps.setDate(4, Date.valueOf(checkOut));
            ps.setDate(5, Date.valueOf(checkOut));
            //ps.setInt(6, cantPerso);
            
           
            ResultSet rs = ps.executeQuery();
           
            while (rs.next()) {
                Habitacion habitacion = new Habitacion();               
                habitacion.setIdHabitacion(rs.getInt("idHabitacion"));
                habitacion.setNroHabitacion(rs.getInt("nroHabitacion"));
                habitacion.setPiso(rs.getInt("piso"));
                TipoHabitacion tipoHabitacion = buscarTipoHabitacion(rs.getInt("idTipoHabitacion"));
                habitacion.setTipoHabitacion(tipoHabitacion);
                habitacion.setEstado(rs.getBoolean("estado"));
                habitaciones.add(habitacion);
            }
            ps.close();
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener habitaciones sin reserva "+ex);
        }
        return habitaciones;
    }
     
     



    public TipoHabitacion buscarTipoHabitacion(int idTipoHabitacion) {
        TipoHabitacionData th = new TipoHabitacionData(conexion);
        return th.buscarTipoHabitacion(idTipoHabitacion);

    }
    
    
    public ArrayList<Reserva> buscarReservas(int id){
        
        ArrayList<Reserva> reservas = new ArrayList();
        String sql = "SELECT * FROM reserva WHERE idHuesped = ? and activo=1";
        
        try {       

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);     

            ResultSet resultSet = ps.executeQuery();

            //Reserva reserva;

            while (resultSet.next()) {

                Reserva reserva = new Reserva();
                
                reserva.setIdReserva(resultSet.getInt("idReserva"));

                Huesped h = buscarHuesped(resultSet.getInt("idHuesped"));
                reserva.setHuesped(h);

                Habitacion hab = habitacionData.buscarHabitacionPorId(resultSet.getInt("idHabitacion"));
                reserva.setHabitacion(hab);
                
                reserva.setCantPersonas(resultSet.getInt("cantidadPers"));
                
                Date fechaIn=resultSet.getDate("checkIn");
                
                LocalDate checkIn = Instant.ofEpochMilli(fechaIn.getTime())
                  .atZone(ZoneId.systemDefault())
                  .toLocalDate();
                
                
                reserva.setCheckIn(checkIn);                
                
                
                Date fechaOut=resultSet.getDate("checkOut");
                
                LocalDate checkOut = Instant.ofEpochMilli(fechaOut.getTime())
                  .atZone(ZoneId.systemDefault())
                  .toLocalDate();
                
                
                reserva.setCheckOut(checkOut);
                
                
                
                reserva.setTotal(resultSet.getInt("total"));
                
                reservas.add(reserva);
                
                //reservas.add(reserva);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las reservas del huesped " + ex.getMessage());
        }

        return reservas;
        
    }
     
}
