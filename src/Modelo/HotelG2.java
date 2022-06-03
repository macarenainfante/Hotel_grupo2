/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import Controlador.Conexion;
import Controlador.HuespedData;
/**
 *
 * @author pablo
 */
public class HotelG2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
                try {
   
            Conexion conex = new Conexion();
            HuespedData hd1 = new HuespedData(conex);

            Huesped huesped1 = new Huesped(21212121, "Huesped nombre1", "Apellido1","calle colon", "pablo@gmail.com", "2664878662");
            Huesped huesped2 = new Huesped(22222222, "Huesped nombre2", "Apellido2","calle colon", "pablo@gmail.com", "2664222222");
            Huesped huesped3 = new Huesped(23232323, "Huesped nombre3", "Apellido3","calle colon", "pablo@gmail.com", "2664333333");
            Huesped huesped4 = new Huesped(24242424, "Huesped nombre4", "Apellido4","calle colon", "pablo@gmail.com", "2664444444");
           
            //hd1.agregarHuesped(huesped1);
            //hd1.agregarHuesped(huesped2);
            //hd1.agregarHuesped(huesped3);
            //hd1.agregarHuesped(huesped4);
            
            hd1.buscarHuespedxDni(22222222);
            hd1.buscarHuesped(4);
            System.out.println(hd1.obtenerHuespedes());
            hd1.buscarHuesped(2);
            hd1.borrarHuesped(4); 
            
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HotelG2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
 