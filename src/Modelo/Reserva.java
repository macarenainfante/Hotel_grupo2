/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

/**
 *
 * @author Macarena Infante
 */
public class Reserva {
    
    /**/
    private int idReserva;
    private Huesped huesped;
    private Habitacion habitacion;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private int cantPersonas;
    private int dias;
    private double monto;
    private int estado;

    public Reserva(int idReserva, Huesped huesped, Habitacion habitacion, LocalDate checkIn, LocalDate checkOut, int cantPersonas, int dias, double monto, int estado) {
        this.idReserva = idReserva;
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.cantPersonas = cantPersonas;
        this.dias = dias;
        this.monto = monto;
        this.estado = estado;
    }
    
    
    
    
  
   
    
    public Reserva(Huesped huesped, Habitacion habitacion, int cantPersonas, LocalDate checkIn, LocalDate checkOut, int dias, int estado){
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.cantPersonas=cantPersonas;
        this.checkIn = checkIn;
        this.checkOut = checkOut; 
        this.dias=dias;
        this.estado=estado;
    }
    
    public Reserva(Huesped huesped, Habitacion habitacion, int cantPersonas, LocalDate checkIn, LocalDate checkOut, int estado, double monto){
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.cantPersonas=cantPersonas;
        this.checkIn = checkIn;
        this.checkOut = checkOut; 
        this.estado=estado;
        this.monto=monto;
    }
    
    public Reserva(){       
    }
    
    public int getIdReserva(){
        return idReserva;
    }
    
    public void setIdReserva(int idReserva){
        this.idReserva=idReserva;
    }
    
    public Huesped getHuesped(){
        return huesped;
    }
    
    public void setHuesped(Huesped huesped){
        this.huesped = huesped;
    }
    
    public Habitacion getHabitacion(){
        return habitacion;
    }
    
    public void setHabitacion(Habitacion habitacion){
        this.habitacion = habitacion;
    }
    
    public LocalDate getCheckIn(){
        return checkIn;
    }
    
    public void setCheckIn(LocalDate checkIn){
        this.checkIn = checkIn;
    }
    
    public LocalDate getCheckOut(){
        return checkOut;
    }
    
    public void setCheckOut(LocalDate checkOut){
        this.checkOut=checkOut;
    }
    
    public int getCantPersonas(){
        return cantPersonas;
    }
    
    public void setCantPersonas(int cantPersonas){
        this.cantPersonas = cantPersonas;
    }
    
    public double getTotal(){
        return monto;
    }
    
    public void setTotal(double total){
        this.monto = total;
    }
    
    public void calcularDias(LocalDate checkIn, LocalDate checkOut){
        this.dias = (int) DAYS.between(checkIn, checkOut);
    }
    
    public void calcularMontoTotal(int dias, Habitacion habitacon){
        this.monto = dias * habitacion.getTipoHabitacion().precioPorNoche;
    }
    
    public int getEstado(){
        return estado;
    }
    
}