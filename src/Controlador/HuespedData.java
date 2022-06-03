
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
 * @author pablo
 */
public class HuespedData {
       
    private Connection con = null;

    public HuespedData(Conexion conexion) {
        try {
            con = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error de conexion");
        }
    }

    public void agregarHuesped(Huesped p_huesped) {
        String sql = "INSERT INTO huesped (dni, nombres, apellidos, domicilio, email, celular)  VALUES (?, ?, ?, ?, ?, ?)";

//        String sql = "INSERT INTO huesped (dni, nombres, apellidos, email, celular)  VALUES (?, ?, ?, ?, ?)";
        try {

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, p_huesped.getDni());
            ps.setString(2, p_huesped.getNombres());            
            ps.setString(3, p_huesped.getApellidos());
            ps.setString(4, p_huesped.getDomicilio());
            ps.setString(5, p_huesped.getEmail());
            ps.setString(6, p_huesped.getCelular());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                p_huesped.setId_huesped(rs.getInt(1));
                JOptionPane.showMessageDialog(null, " Numero de Huesped = " + p_huesped.getId_huesped() + " " + p_huesped.getApellidos() + "," + p_huesped.getNombres() + ":" + " agregado Ok.");

            } else {
                JOptionPane.showMessageDialog(null, "No genero el id del huesped");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion en agregar Huesped " + ex);

        }
    }    
    
    
    public Huesped buscarHuesped(int p_id_huesped) {

  
        Huesped huesped = null;

        String sql = "SELECT * FROM huesped WHERE id_huesped =?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, p_id_huesped);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                huesped = new Huesped();
                huesped.setId_huesped(rs.getInt("id_huesped"));
                huesped.setDni(rs.getLong("dni"));
                huesped.setNombres(rs.getString("nombres"));
                huesped.setApellidos(rs.getString("apellidos"));
                huesped.setDomicilio(rs.getString("domicilio"));
                huesped.setEmail(rs.getString("email"));
                huesped.setCelular(rs.getString("celular"));
                
                JOptionPane.showMessageDialog(null, " Se encontro Id:" + huesped.toString());

            } else {

                JOptionPane.showMessageDialog(null, " Id de Huesped inexistente");
            }
            ps.close();
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, " Error de conexion desde buscar Huesped " + ex);

        }

        return huesped;
    }



    public void modificarHuesped(int p_id_huesped, Huesped p_huesped) {

        String sql = "UPDATE huesped SET dni=?, nombres=?, apellidos=?, domicilio=?, email=?, celular=? WHERE id_huesped=?;";

        try {

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, p_huesped.getDni());
            ps.setString(2, p_huesped.getNombres());            
            ps.setString(3, p_huesped.getApellidos());
            ps.setString(4, p_huesped.getDomicilio());
            ps.setString(5, p_huesped.getEmail());
            ps.setString(6, p_huesped.getCelular());
            ps.setInt(7, p_id_huesped);

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

    public void borrarHuesped(int p_id_huesped) {

        // String de consulta a base de datos
        String sql = "DELETE FROM huesped WHERE id_huesped=?";

        try {

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, p_id_huesped);

            int rs = ps.executeUpdate();

            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Huesped borrado exitosamente ");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo borrar, Huesped inexistente ");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion desde insertar un Huesped " + ex);

        }
    }



    public List<Huesped> obtenerHuespedes() {

        ArrayList<Huesped> huespedes = new ArrayList<Huesped>();

        try {
            String sql = "SELECT * FROM huesped;";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            Huesped huesped;

            while (rs.next()) {
                // Creacion y llenado de Huespedes para ser insertados en la lista
                huesped = new Huesped();
                huesped.setId_huesped(rs.getInt("id_huesped"));
                huesped.setDni(rs.getLong("dni"));
                huesped.setNombres(rs.getString("nombres"));                
                huesped.setApellidos(rs.getString("apellidos"));
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

      public Huesped buscarHuespedxDni(int p_dni) {

        // Iniciacion null de la variable cliente
        Huesped huesped = null;

        // String de consulta a base de datos
        String sql = "SELECT * FROM huesped WHERE dni =?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, (int) p_dni);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                huesped = new Huesped();
                huesped.setId_huesped(rs.getInt("id_huesped"));
                huesped.setDni(rs.getLong("dni"));
                huesped.setNombres(rs.getString("nombres"));                
                huesped.setApellidos(rs.getString("apellidos"));
                huesped.setDomicilio(rs.getString("domicilio"));
                huesped.setEmail(rs.getString("email"));
                huesped.setCelular(rs.getString("celular"));
 

                JOptionPane.showMessageDialog(null, huesped.getApellidos() + " " + huesped.getNombres());

            } else {
                JOptionPane.showMessageDialog(null, " el dni: " + p_dni + ", no pertence a ningun Huesped");

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error de conexion desde buscar Huesped por dni " + ex);

        }

        return huesped;
    }    
    
    
}
