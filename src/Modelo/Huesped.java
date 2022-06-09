
package Modelo;

/**
 *
 * @author pablo
 */
public class Huesped {
    
    /*Hace muchas reservas
    se vincula a la habitacion mediante reserva
    */
    
    
    private int id_huesped;
    private long dni;
    private String nombres;
    private String apellidos;
    private String domicilio;
    private String email;
    private String celular;

    public Huesped(int id_huesped, long dni, String nombres, String apellidos, String domicilio, String email, String celular) {
        this.id_huesped = -1;
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.domicilio = domicilio;
        this.email = email;
        this.celular = celular;
    }

    public Huesped(long dni, String nombres, String apellidos, String domicilio, String email, String celular) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.domicilio = domicilio;
        this.email = email;
        this.celular = celular;
    }
   

    public Huesped() {
        this.id_huesped = -1;
    }
    
    
    

    public void setId_huesped(int id_huesped) {
        this.id_huesped = id_huesped;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }


    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getId_huesped() {
        return id_huesped;
    }

    public long getDni() {
        return dni;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDomicilio() {
        return domicilio;
    }


    public String getEmail() {
        return email;
    }

    public String getCelular() {
        return celular;
    }
    
    
      @Override
    public String toString() {
        return "Huesped{" + "id_huesped=" + id_huesped + ", dni=" + dni + ", apellido=" + apellidos + ", nombres=" + nombres + ", domicilio=" + domicilio + ", email=" + email + ", celular=" + celular  + "}";
    }   
    
    
    
    
}
