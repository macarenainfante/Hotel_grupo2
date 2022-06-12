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
    double precioPorNoche;
    
    public TipoHabitacion(int codigo, int maxPersonas, int cantidadCamas, String tipoDeCama, double precioPorNoche){
        this.codigo = codigo;
        this.maxPersonas = maxPersonas;
        this.cantidadDeCamas=cantidadCamas;
        this.tipoDeCama=tipoDeCama;
        this.precioPorNoche=precioPorNoche;
    }
    
        public TipoHabitacion(int maxPersonas, int cantidadCamas, String tipoDeCama, double precioPorNoche){
        this.maxPersonas = maxPersonas;
        this.cantidadDeCamas=cantidadCamas;
        this.tipoDeCama=tipoDeCama;
        this.precioPorNoche=precioPorNoche;
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
        
        public double getPrecioPorNoche(){
            return precioPorNoche;
        }
        
        public void setPrecioPorNoche(double precioPorNoche){
            this.precioPorNoche=precioPorNoche;
        }
        
    
 
    
}
