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
public class TipoHabitacion {
    
    /**/
    
    int codigo;
    int maxPersonas;
    int cantidadDeCamas;
    String tipoDeCama;
    String nombreTipoHabitacion;
    double precioPorNoche;
    boolean activo;
    
    public TipoHabitacion(int codigo, int maxPersonas, int cantidadCamas, String tipoDeCama, String nombre, double precioPorNoche, boolean activo){
        this.codigo = codigo;
        this.maxPersonas = maxPersonas;
        this.cantidadDeCamas=cantidadCamas;
        this.tipoDeCama=tipoDeCama;
        this.nombreTipoHabitacion = nombre;
        this.precioPorNoche=precioPorNoche;
        this.activo=activo;
    }
    
        public TipoHabitacion(int maxPersonas, int cantidadCamas, String tipoDeCama, String nombre, double precioPorNoche, boolean activo){
        this.maxPersonas = maxPersonas;
        this.cantidadDeCamas=cantidadCamas;
        this.tipoDeCama=tipoDeCama;
        this.nombreTipoHabitacion = nombre;
        this.precioPorNoche=precioPorNoche;
        this.activo=activo;
    }
        
        public TipoHabitacion(){

    }
        
        public int getCodigo(){
            return codigo;
        }
        
        public void setCodigo(int codigo){
            this.codigo=codigo;
        }
        
        public int getMaxPersonas(){
            return maxPersonas;
        }
        
        public void setMaxPersonas(int maxPersonas){
            this.maxPersonas=maxPersonas;
        }
        
        public int getCantidadDeCamas(){
            return cantidadDeCamas;
        }
        
        public void setCantidadDeCamas(int cantidadDeCamas){
            this.cantidadDeCamas = cantidadDeCamas;
        }
        
        public String getTipoDeCama(){
            return tipoDeCama;
        }
        
        public void setTipoDeCama(String tipoDeCama){
            this.tipoDeCama=tipoDeCama;
        }
        
        public String getNombreTipoHabitacion(){
            return nombreTipoHabitacion;
        }
        
        public void setNombreTipoHabitacion(String nombre){
            this.nombreTipoHabitacion=nombre;
        }
        
        public double getPrecioPorNoche(){
            return precioPorNoche;
        }
        
        public void setPrecioPorNoche(double precioPorNoche){
            this.precioPorNoche=precioPorNoche;
        }
        
        public boolean getActivo(){
            return activo;
        }
        
        public void setActivo(boolean activo){
            this.activo = activo;
        }
        
    
     @Override
    public String toString() {
        return "Tipo de Habitacion " + codigo + ": " + nombreTipoHabitacion + " " + " Personas: "+maxPersonas;
    }
    
}
