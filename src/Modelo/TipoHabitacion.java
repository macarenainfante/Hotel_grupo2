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
    int cantidadCamas;
    String tipoDeCama;
    double precioPorNoche;
    
    
    public void cambiarPrecio(int precio){
    this.precioPorNoche = precio;
    }
    
}
