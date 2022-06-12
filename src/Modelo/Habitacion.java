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
    
    private int idHabitacion = -1;
    private int idTipoHabitacion;
    private int piso;
    private int estado;
    private boolean activo;
    private TipoHabitacion tipoHabitacion;
    
    public Habitacion(int idHabitacion, int idTipoHabitacion, int piso, int estado, boolean activo){
        this.idHabitacion = idHabitacion;
        this.idTipoHabitacion = idTipoHabitacion;
        this.piso = piso;
        this.estado=estado;
        this.activo = activo;
    }
    
    public Habitacion(int idTipoHabitacion, int piso, int estado, boolean activo){
        this.idTipoHabitacion = idTipoHabitacion;
        this.piso = piso;
        this.estado=estado;
        this.activo = activo;
    }
    
    public Habitacion(TipoHabitacion tipo, int piso, int estado, boolean activo){
        this.tipoHabitacion=tipo;
        this.piso = piso;
        this.estado=estado;
        this.activo = activo;
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
    
    public int getIdTipoHabitacion(){
        return idTipoHabitacion;
    }
    
    public void setIdTipoHabitacion (int idTipoHabitacion)
    {
        this.idTipoHabitacion=idTipoHabitacion;
    }
    
    
    public int getPiso(){
        return piso;
    }
    
    public void setPiso(int piso){
        this.piso=piso;        
    }
    
    public int getEstado(){
        return estado;
    }
    
    public void setEstado(int estado){
        this.estado=estado;
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
    
    

    
    public void conocerEstado(){
        if (estado==0){
            System.out.println("La habitacion se encuentra en refaccion");
        }else if (estado==1){
            System.out.println("La Habitacion se encuentra habilitada");
        }
    }
    
    public void listaParaUsar(){
        if (this.estado == 1 && this.activo==true){
            System.out.println("La habitacion se encuentra disponible para usar");
        }else{
            System.out.println("La habitacion NO se encuentra disponible");
        }
    }
    
        @Override
    public String toString() {
        return "Habitacion " + idHabitacion + ": " + piso + " " + estado + " " + activo + " " + tipoHabitacion;
    }
    
}
