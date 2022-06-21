
package Modelo;

/**
 *
 * @author pablo
 */
public class Huesped {
    
    /*Hace muchas reservas
    se vincula a la habitacion mediante reserva
    */
    
    
    private int idHuesped;
    private String dni;
    private String nombre;
    private String apellido;
    private String domicilio;
    private String email;
    private String celular;

    public Huesped(int idHuesped, String dni, String nombre, String apellido, String domicilio, String email, String celular) {
        this.idHuesped = -1;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.email = email;
        this.celular = celular;
    }

    public Huesped(String dni, String nombre, String apellido, String domicilio, String email, String celular) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.email = email;
        this.celular = celular;
    }
   

    public Huesped() {
        this.idHuesped = -1;
    }
    
    
    public int getIdHuesped(){
        return idHuesped;
    }

    public void setIdHuesped(int id_huesped) {
        this.idHuesped = id_huesped;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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


    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
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
        return "Huesped{" + "id_huesped=" + idHuesped + ", dni=" + dni + ", apellido=" + apellido + ", nombres=" + nombre + ", domicilio=" + domicilio + ", email=" + email + ", celular=" + celular  + "}";
    }   
    
    
    
    
}
