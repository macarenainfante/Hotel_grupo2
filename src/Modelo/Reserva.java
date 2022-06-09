/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDate;

/**
 *
 * @author Macarena Infante
 */
public class Reserva {
    
    /**/
    private Huesped huesped;
    private Habitacion habitacion;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private int dias;
    private double monto;
    private int estado;
    
    public Reserva(Huesped huesped, Habitacion habitacion, int cantPersonas, LocalDate checkIn, LocalDate checkOut){
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.checkIn = checkIn;
        this.checkOut = checkOut;       
    }
    
    public void buscarReservaPorHuesped(){
        
    }
    
    public void cancelarReserva(){
        
    }
    
    public void calcularImporteTotal(){
                
    }
    
    public void crearReserva(){
        
    }
    
    
    
}
