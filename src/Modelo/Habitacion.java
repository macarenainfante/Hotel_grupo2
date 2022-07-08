/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Macarena Infante
 */
public class Habitacion {
    
    /*1 al 200
    tiene un piso
    estado: 1 es habilitada y 0 es en refaccion
    es de una categoria Tipo de Habitacion (simple, doble, triple, suit de lujo)
    
    */
    
    private int idHabitacion;
    private int piso;
    private boolean estado;
    private int nroHabitacion;
    private boolean activo;
    private TipoHabitacion tipoHabitacion;

    public Habitacion(int idHabitacion, int piso, boolean estado, int nroHabitacion, boolean activo, TipoHabitacion tipoHabitacion) {
        this.idHabitacion = idHabitacion;
        this.piso = piso;
        this.estado = estado;
        this.nroHabitacion = nroHabitacion;
        this.activo = activo;
        this.tipoHabitacion = tipoHabitacion;
    }
    
    
    

    public Habitacion(int piso, boolean estado, int nroHabitacion, boolean activo, TipoHabitacion tipoHabitacion) {
        this.piso = piso;
        this.estado = estado;
        this.nroHabitacion = nroHabitacion;
        this.activo = activo;
        this.tipoHabitacion = tipoHabitacion;
    }
    
    
    
    
    
    
    public Habitacion(){
        
    }
    
    public int getIdHabitacion(){
        return idHabitacion;
    }
    
    public void setIdHabitacion(int id)
    {
        this.idHabitacion=id;
    }
        
    
    public int getPiso(){
        return piso;
    }
    
    public void setPiso(int piso){
        this.piso=piso;        
    }
    
    public boolean getEstado(){
        return estado;
    }
    
    public void setEstado(boolean estado){
        this.estado=estado;
    }
    
    public int getNroHabitacion(){
        return nroHabitacion;
    }
    
    public void setNroHabitacion(int nro){
        this.nroHabitacion=nro;
    }
    
    public boolean getActivo(){
        return activo;
    }
    
    public void setActivo(boolean activo){
        this.activo = activo;
    }
    
    public TipoHabitacion getTipoHabitacion(){
        return tipoHabitacion;
    }
    
    public void setTipoHabitacion(TipoHabitacion tipoHabitacion){
        this.tipoHabitacion=tipoHabitacion;
    }
    
    public int getIdTipoHabitacion(){
        return tipoHabitacion.getCodigo();
    }
    
    public int estadoEnNum(){
        if (estado=true){
            return 1;
        }else{
            return 0;
        }
    }
    
    

    
    public void conocerEstado(){
        if (estado==true){
            System.out.println("La habitacion se encuentra en refaccion");
        }else if (estado==false){
            System.out.println("La Habitacion se encuentra habilitada");
        }
    }
    
    public boolean listaParaUsar(){
        if (this.estado == false && this.activo==true){            
            System.out.println("La habitacion se encuentra disponible para usar");
            return true;
        }else{
            System.out.println("La habitacion NO se encuentra disponible");
            return false;
        }
    }
    
        @Override
    public String toString() {
        return "Habitacion " + idHabitacion + ": " + piso + " " + estado + " " + activo + " " + tipoHabitacion;
    }
    
}
