
package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Modelo.Huesped;
/**
 *
 * 
 */
public class HuespedData {
       
    Connection con=null;

    public HuespedData(Conexion con) {
       try{ this.con = con.getConexion();
       }catch(Exception e)
       { JOptionPane.showMessageDialog(null, "Error de conexion");
       }
    }

    public void agregarHuesped(Huesped huesped) {
        String sql = "INSERT INTO huesped (dniHuesped, nombreHuesped, apellidoHuesped, domicilioHuesped, emailHuesped, celularHuesped) VALUES (?,?,?,?,?,?);";
  
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, huesped.getDni());
            ps.setString(2, huesped.getNombre());
            ps.setString(3, huesped.getApellido());
            ps.setString(4, huesped.getDomicilio());
            ps.setString(5, huesped.getEmail());
            ps.setString(6, huesped.getCelular());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                huesped.setIdHuesped(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Huesped agregado correctamente");
                
            } else {
                JOptionPane.showMessageDialog(null, "Error al agregar Huesped");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion desde HuespedData");
            
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
                huesped.setDni(rs.getString("dni"));
                huesped.setNombre(rs.getString("nombre"));
                huesped.setApellido(rs.getString("apellido"));
                huesped.setDomicilio(rs.getString("domicilio"));
                huesped.setEmail(rs.getString("email"));
                huesped.setCelular(rs.getString("celular"));
                
                JOptionPane.showMessageDialog(null, " Se encontro Huesped:" + huesped.toString());

            } else {

                JOptionPane.showMessageDialog(null, " Id de Huesped inexistente");
            }
            ps.close();
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, " Error de conexion desde buscar Huesped " + ex);

        }

        return huesped;
    }



    public void modificarHuesped(int idHuesped, Huesped p_huesped) {

        String sql = "UPDATE huesped SET dni=?, nombre=?, apellido=?, domicilio=?, email=?, celular=? WHERE idHuesped=?;";

        try {

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p_huesped.getDni());
            ps.setString(2, p_huesped.getNombre());            
            ps.setString(3, p_huesped.getApellido());
            ps.setString(4, p_huesped.getDomicilio());
            ps.setString(5, p_huesped.getEmail());
            ps.setString(6, p_huesped.getCelular());
            ps.setInt(7, idHuesped);

            int rs = ps.executeUpdate();

            if (rs > 0) {
                JOptionPane.showMessageDialog(null, " Huesped se actualizo exitosamente ");
            } else {
                JOptionPane.showMessageDialog(null, " Huesped No se pudo actualizar ");
            }

            ps.close();
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error de conexion desde insertar huesped " + ex);

        }
    }
// borrado logico tambien funciona para desactivar al cliente //

    public void borrarHuesped(int idHuesped) {

        // String de consulta a base de datos
        String sql = "DELETE FROM huesped WHERE idHuesped=?";

        try {

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, idHuesped);

            int rs = ps.executeUpdate();

            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Huesped borrado exitosamente ");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo borrar, Huesped inexistente ");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion desde borrar un Huesped " + ex);

        }
    }



    public ArrayList<Huesped> obtenerHuespedes() {

        ArrayList<Huesped> huespedes = new ArrayList<Huesped>();

        try {
            String sql = "SELECT * FROM huesped;";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            Huesped huesped;

            while (rs.next()) {
                // Creacion y llenado de Huespedes para ser insertados en la lista
                huesped = new Huesped();
                huesped.setIdHuesped(rs.getInt("idHuesped"));
                huesped.setDni(rs.getString("dni"));
                huesped.setNombre(rs.getString("nombre"));                
                huesped.setApellido(rs.getString("apellido"));
                huesped.setDomicilio(rs.getString("domicilio"));
                huesped.setEmail(rs.getString("email"));
                huesped.setCelular(rs.getString("celular"));
 

                huespedes.add(huesped);
            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al obtener los Huespedes: " + ex.getMessage());
        }
        return huespedes;
    }

      public Huesped buscarHuespedxDni(String dni) {

        Huesped huesped = new Huesped();

        String sql = "SELECT * FROM huesped WHERE idHuesped =?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dni);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                huesped = new Huesped();
                huesped.setIdHuesped(rs.getInt("idHuesped"));
                huesped.setDni(rs.getString("dni"));
                huesped.setNombre(rs.getString("nombre"));
                huesped.setApellido(rs.getString("apellido"));
                huesped.setDomicilio(rs.getString("domicilio"));
                huesped.setEmail(rs.getString("email"));
                huesped.setCelular(rs.getString("celular"));
                
                JOptionPane.showMessageDialog(null, " Se encontro Huesped:" + huesped.toString());

            } else {

                JOptionPane.showMessageDialog(null, "Dni de Huesped inexistente");
            }
            ps.close();
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, " Error de conexion desde buscar Huesped por DNI " + ex);

        }

        return huesped;
    }    
    
    
}
