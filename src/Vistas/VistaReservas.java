/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.Conexion;
import Controlador.HuespedData;
import Controlador.ReservaData;
import Modelo.Habitacion;
import Modelo.Huesped;
import Modelo.Reserva;
import Modelo.TipoHabitacion;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Macarena
 */
public class VistaReservas extends javax.swing.JInternalFrame {
    
    private HuespedData huespedData;
    private Conexion conexion;
    private ArrayList <Huesped> listarHuesped;
    private DefaultTableModel modelo;
    private ReservaData reservaData;

    /**
     * Creates new form VistaReservas
     */
    public VistaReservas() {
        initComponents();
        this.conexion = new Conexion();
        this.huespedData = new HuespedData(conexion);
        this.listarHuesped = huespedData.obtenerHuespedes();
        cargarHuespedes();
        modelo = new DefaultTableModel();   
        armarCabeceraTabla();
        this.reservaData = new ReservaData(conexion);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbHuespedes = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        textCantidadPersonas = new javax.swing.JTextField();
        jCalendarCheckIn = new com.toedter.calendar.JCalendar();
        jLabel4 = new javax.swing.JLabel();
        jCalendarCheckOut = new com.toedter.calendar.JCalendar();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textCantidadPersonas1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaHabitaciones = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        botonConfirmar = new javax.swing.JButton();
        botonBorrar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Formulario de Reservas");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("Huesped:");

        cbHuespedes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHuespedesActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("Cantidad de Personas:");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("CheckIn");

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setText("CheckOut");

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 153));
        jLabel6.setText("Precio total:");

        textCantidadPersonas1.setEditable(false);

        tablaHabitaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaHabitaciones);

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 153));
        jLabel7.setText("Habitaciones disponibles:");

        botonConfirmar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonConfirmar.setForeground(new java.awt.Color(0, 0, 153));
        botonConfirmar.setText("Confirmar");
        botonConfirmar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConfirmarActionPerformed(evt);
            }
        });

        botonBorrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonBorrar.setForeground(new java.awt.Color(0, 0, 153));
        botonBorrar.setText("Borrar");
        botonBorrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonBorrar.setEnabled(false);
        botonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarActionPerformed(evt);
            }
        });

        botonSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonSalir.setForeground(new java.awt.Color(0, 0, 153));
        botonSalir.setText("Salir");
        botonSalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(cbHuespedes, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(botonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(botonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(textCantidadPersonas1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textCantidadPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCalendarCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(84, 84, 84)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(66, 66, 66)
                                        .addComponent(jCalendarCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbHuespedes, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCantidadPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCalendarCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCalendarCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCantidadPersonas1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(137, 137, 137))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbHuespedesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHuespedesActionPerformed
        // TODO add your handling code here:

        DefaultTableModel model;
        model = (DefaultTableModel) tablaHabitaciones.getModel();
        model.setRowCount(0);


    }//GEN-LAST:event_cbHuespedesActionPerformed

    private void botonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConfirmarActionPerformed
        // TODO add your handling code here:

        int filaSeleccionada=tablaHabitaciones.getSelectedRow();
    
        if(filaSeleccionada!=-1){
                
            Huesped h=(Huesped)cbHuespedes.getSelectedItem();
            
            
            int idHabitacion=(Integer)modelo.getValueAt(filaSeleccionada,0);
            int numeroHabitacion=(int)modelo.getValueAt(filaSeleccionada,1);
            TipoHabitacion tipoHabitacion=(TipoHabitacion)modelo.getValueAt(filaSeleccionada, 2);
            int piso=(int)modelo.getValueAt(filaSeleccionada,3);
            
            Habitacion hab = new Habitacion(idHabitacion,tipoHabitacion, piso, true, numeroHabitacion, true);
            
            //jCalendar
            
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            String fechaIn = formato.format(jCalendarCheckIn.getDate());
            String fechaOut = formato.format(jCalendarCheckOut.getDate());
            DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate checkIn = LocalDate.parse(fechaIn, formato2);
            LocalDate checkOut = LocalDate.parse(fechaOut, formato2);
            
            Reserva reserva= new Reserva(h, hab, Integer.parseInt(textCantidadPersonas.getText()),checkIn, checkOut, 1);
            
            
            reservaData.crearReserva(reserva);
            
            borrarFilasTabla();
       
        }
        
    }//GEN-LAST:event_botonConfirmarActionPerformed

    private void botonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarActionPerformed
        // TODO add your handling code here:

        int filaSeleccionada=tablaHabitaciones.getSelectedRow();
        if(filaSeleccionada!=-1){
                    
            Huesped h=(Huesped)cbHuespedes.getSelectedItem();
                        
            int idHabitacion=(Integer)modelo.getValueAt(filaSeleccionada,0);
            
           
            reservaData.borrarReservaDeHuesped(h.getIdHuesped(), idHabitacion);
            borrarFilasTabla();
      
        }
    }//GEN-LAST:event_botonBorrarActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:

        dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void cargarHuespedes(){
    //Carga las materias al ComboBox
    for(Huesped item:listarHuesped){
            cbHuespedes.addItem(item);  
        }
    }
    
    private void armarCabeceraTabla(){
        ArrayList<Object> columnas=new ArrayList<Object>();
        columnas.add("Id Habitacion");
        columnas.add("Número de Habitacion");
        columnas.add("Tipo de Habitacion");
        columnas.add("Piso");
        for(Object it:columnas){
        
            modelo.addColumn(it);
        }
        tablaHabitaciones.setModel(modelo);
  }
    
    private void borrarFilasTabla(){
        int a = modelo.getRowCount() - 1;
        for (int i= a ; i>=0; i--){
            modelo.removeRow(i);
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBorrar;
    private javax.swing.JButton botonConfirmar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JComboBox<Huesped> cbHuespedes;
    private com.toedter.calendar.JCalendar jCalendarCheckIn;
    private com.toedter.calendar.JCalendar jCalendarCheckOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaHabitaciones;
    private javax.swing.JTextField textCantidadPersonas;
    private javax.swing.JTextField textCantidadPersonas1;
    // End of variables declaration//GEN-END:variables
}
