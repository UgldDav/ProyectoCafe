/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caféinternet.controladora;

/**
 *
 * @author David
 */


import caféinternet.bl.ProveedorBL;
import caféinternet.dto.ProveedorDTO;

import caféinternet.vistas.mantenimientos.ManteProveedor;
import caféinternet.vistas.mantenimientos.ManteProveedorBuscar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Element;

public class MantControlProveedor  implements ActionListener {
    
    private ManteProveedor mantProveedorView;
    private ProveedorBL modeloProveedor;

    public MantControlProveedor(ManteProveedor mantProveedorView, ProveedorBL modeloProveedor) {
        this.mantProveedorView = mantProveedorView;
        this.modeloProveedor = modeloProveedor;
        
        this.mantProveedorView.btBuscar.addActionListener(this);
        this.mantProveedorView.btCancelar.addActionListener(this);
        this.mantProveedorView.btCargar.addActionListener(this);
        this.mantProveedorView.btEliminar.addActionListener(this);
        this.mantProveedorView.btInsertar.addActionListener(this);
        this.mantProveedorView.btModificar.addActionListener(this);
       
        this.mantProveedorView.btEliminar.setEnabled(false);
        this.mantProveedorView.btModificar.setEnabled(false); 
                
               
    }

    public ManteProveedor getMantProveedorView() {
        return mantProveedorView;
    }

    public void setMantProveedorView(ManteProveedor mantProveedorView) {
        this.mantProveedorView = mantProveedorView;
    }

    public ProveedorBL getModeloProveedor() {
        return modeloProveedor;
    }

    public void setModeloProveedor(ProveedorBL modeloProveedor) {
        this.modeloProveedor = modeloProveedor;
    }

    
    private void cargarProveedor() {
        ProveedorDTO s = new ProveedorDTO();
        
        if (!this.mantProveedorView.txtIdProveedor.getText().isEmpty()) {
            s.setPK_IdProveedor(Integer.parseInt(this.mantProveedorView.txtIdProveedor.getText()));
            try {
                if(modeloProveedor.obtenerPorId(s)==null)
                {
                    JOptionPane.showMessageDialog(mantProveedorView, "No se encuentra el proveedor","Error", 0);
                }
                else{
          
                s = modeloProveedor.obtenerPorId(s);
                this.mantProveedorView.txtNombre.setText(s.getNombre());
                this.mantProveedorView.txtDireccion.setText(s.getDireccion());
                this.mantProveedorView.txtTelefono.setText(s.getTelefono().toString());
                this.mantProveedorView.txtCorreo.setText(s.getCorreo());
    
                
                this.mantProveedorView.txtIdProveedor.setEnabled(false);
                this.mantProveedorView.btEliminar.setEnabled(true);
                this.mantProveedorView.btModificar.setEnabled(true);
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(mantProveedorView, "Error no se pudo consultar al Proveedor (" + ex.getMessage() + ")", "Error al cargar Proveedor", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(MantControlClienteBuscar.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
      
        
        
    }  

    public void clear()
    {
         this.mantProveedorView.txtIdProveedor.setText(null);
            this.mantProveedorView.txtNombre.setText(null);
            this.mantProveedorView.txtDireccion.setText(null);
            this.mantProveedorView.txtCorreo.setText(null);
            
            this.mantProveedorView.txtTelefono.setText(null);
            
            this.mantProveedorView.btEliminar.setEnabled(false);
            this.mantProveedorView.btModificar.setEnabled(false);
            this.mantProveedorView.txtIdProveedor.setEnabled(true); 
           
           
    }   

    
    @Override
    public void actionPerformed(ActionEvent e) {
       
        
        if(e.getSource()==this.mantProveedorView.btInsertar)
        {
            
            if(this.mantProveedorView.txtIdProveedor.getText().isEmpty()
                    ||this.mantProveedorView.txtCorreo.getText().isEmpty()
                   ||this.mantProveedorView.txtDireccion.getText().isEmpty()
                      ||this.mantProveedorView.txtNombre.getText().isEmpty()
                      ||this.mantProveedorView.txtTelefono.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(mantProveedorView,"No se ha suministrado la informacion necesaria", "Error" , 0);
                }
            else{
                ProveedorDTO p= new ProveedorDTO();
                    p.setPK_IdProveedor(Integer.valueOf(this.mantProveedorView.txtIdProveedor.getText()));
                    p.setNombre(this.mantProveedorView.txtNombre.getText());
                    p.setCorreo(this.mantProveedorView.txtCorreo.getText());
                    p.setDireccion(this.mantProveedorView.txtDireccion.getText());
                    p.setUltUsuario(this.mantProveedorView.txtUsuarioActual.getText());
                    p.setTelefono(Integer.valueOf(this.mantProveedorView.txtTelefono.getText()));
                try {
                    
                    
                    if(modeloProveedor.obtenerPorId(p)!=null)
                    {
                        JOptionPane.showMessageDialog(mantProveedorView, "El Proveedor ya está en la lista","Error", 0);
                    }
                    else{
                        this.modeloProveedor.insert(p);
                        JOptionPane.showMessageDialog(mantProveedorView, "Proveedor ingresado correctamente","Felicidades", 1);
                        this.clear();
                        
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(MantControlProveedor.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
            
        }
        
        if(e.getSource()==this.mantProveedorView.btEliminar)
         {
            
                ProveedorDTO CD=new ProveedorDTO();
                
                CD.setPK_IdProveedor(Integer.valueOf(this.mantProveedorView.txtIdProveedor.getText()));
              
           try {
               this.modeloProveedor.delete(CD);
               JOptionPane.showMessageDialog(mantProveedorView, "Proveedor Eliminado", "Felicidades", 1);
           } catch (SQLException ex) {
               Logger.getLogger(MantControlCliente.class.getName()).log(Level.SEVERE, null, ex);
           }
           finally {this.clear();}
          
                }
        if(e.getSource()==this.mantProveedorView.btModificar)
         {
             
            
                ProveedorDTO c=new ProveedorDTO();
                
                c.setPK_IdProveedor(Integer.valueOf(this.mantProveedorView.txtIdProveedor.getText()));
                if(this.mantProveedorView.txtNombre.getText().isEmpty()
                   ||this.mantProveedorView.txtDireccion.getText().isEmpty()
                      ||this.mantProveedorView.txtCorreo.getText().isEmpty()
                      ||this.mantProveedorView.txtTelefono.getText().isEmpty())
                {
         JOptionPane.showMessageDialog(mantProveedorView,"No se ha suministrado la informacion necesaria", "Error" , 0);

         }
                else{
                    c.setNombre(this.mantProveedorView.txtNombre.getText());
                    c.setCorreo(this.mantProveedorView.txtCorreo.getText());
                    c.setDireccion(this.mantProveedorView.txtDireccion.getText());
                    c.setUltUsuario(this.mantProveedorView.txtUsuarioActual.getText());
                    c.setTelefono(Integer.valueOf(this.mantProveedorView.txtTelefono.getText()));
                      
                    try { 
                        this.modeloProveedor.update(c);
                    } catch (SQLException ex) {
                        Logger.getLogger(MantControlCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    finally {this.clear();}
                }
         }
        
          if(e.getSource()==this.mantProveedorView.btBuscar)
         {
              ManteProveedorBuscar CB=new ManteProveedorBuscar();
                MantControlProveedorBuscar CC;
                CC = new MantControlProveedorBuscar(CB, modeloProveedor, this.mantProveedorView.txtIdProveedor);
                CC.getProveedorBuscarView().setLocationRelativeTo(this.mantProveedorView); 
                CC.getProveedorBuscarView().setVisible(true);
               
         }
         
    
        
        if(e.getSource()==this.mantProveedorView.btCancelar)
        {
            this.clear();
        }
        
         if(e.getSource()==this.mantProveedorView.btCargar)
        {
            if(this.mantProveedorView.txtIdProveedor.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(mantProveedorView, "El campo del id del Poveedor está vacia", "Error", 0);
            }
            else{
            this.cargarProveedor();
            }
        }
    }
    
    
}
    /*
    
    public MantControlProveedor(ManteProveedor mantProveedorView, ProveedorBL modeloProveedor) {
        this.mantProveedorView = mantProveedorView;
        this.modeloProveedor = modeloProveedor;
        
        this.mantProveedorView.btBuscar.addActionListener(this);
        this.mantProveedorView.btCancelar.addActionListener(this);
        this.mantProveedorView.btEliminar.addActionListener(this);
        this.mantProveedorView.btIngresar.addActionListener(this);
        this.mantProveedorView.btModificar.addActionListener(this);
        this.mantProveedorView.btCargar.addActionListener(this);
               
        
        
        
        inicializarPantalla();
    }
    
    private void inicializarPantalla(){
        
        this.mantProveedorView.btEliminar.setEnabled(false);
        this.mantProveedorView.btModificar.setEnabled(false);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) { 
       if(e.getSource()==this.mantProveedorView.btCargar)
        {
            if(this.mantProveedorView.txtCedula.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(mantProveedorView, "El campo de cédula está vacia", "Error", 0);
            }
            else{
            this.cargarCliente();
            }
        }
        
       
        
        
         if(e.getSource()==this.mantClienteView.btInsertar)
         {
              if(this.mantProveedorView.txtCedula.getText().isEmpty()
                   ||this.mantClienteView.txtApellidos.getText().isEmpty()
                      ||this.mantClienteView.txtDireccion.getText().isEmpty()
                      ||this.mantClienteView.jDateChooser1.isValid()
                      ||this.mantClienteView.txtTel.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(mantProveedorView,"No se ha suministrado la informacion necesaria", "Error" , 0);
                }else{
                  try {
                      ProveedorDTO c = new ProveedorDTO();
                      c.setPK_IdCliente(Integer.valueOf(this.mantClienteView.txtCedula.getText()));
                      c.setNombre(this.mantClienteView.txtNombre.getText());
                      c.setApellidos(this.mantClienteView.txtApellidos.getText());
                      SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMdd");
                      c.setFechaNacimiento(formatoFecha.format(this.mantClienteView.jDateChooser1.getDate()));
                      c.setDireccion(this.mantClienteView.txtDireccion.getText());
                      c.setObservaciones(this.mantClienteView.txtObservaciones.getText());
                      c.setUltUsuario(this.mantClienteView.txtUsuarioActual.getText());
                      c.setTelefono(Integer.valueOf(this.mantClienteView.txtTel.getText()));
                      
                      if(this.clienteBLModelo.obtenerPorId(c)== null){
                          this.clienteBLModelo.insert(c);
                          JOptionPane.showMessageDialog (
                                  mantClienteView, "El Cliente ha sido ingresado correctamente",
                                  "Cliente Agregado", JOptionPane.INFORMATION_MESSAGE);
                      }
                      else
                      {
                          JOptionPane.showMessageDialog (
                                  mantClienteView, "El Cliente ya existe",
                                  "Cliente Agregado", JOptionPane.INFORMATION_MESSAGE);
                      }    } catch (SQLException ex) {
                      Logger.getLogger(MantControlCliente.class.getName()).log(Level.SEVERE, null, ex);
                  }
      finally {
                  this.clear();}
                  
            }
         }
               
         if(e.getSource()==this.mantClienteView.btBuscar)
         {
              ManteClienteBuscar CB=new ManteClienteBuscar();
                MantControlClienteBuscar CC;
                CC = new MantControlClienteBuscar(CB, clienteBLModelo, this.mantClienteView.txtCedula);
                CC.getClienteBuscarView().setVisible(true);
               
         }
         
         
         if(e.getSource()==this.mantClienteView.btCancelar){
             this.clear();
         }
         
         if(e.getSource()==this.mantClienteView.btEliminar)
         {
            
                ClienteDTO CD=new ClienteDTO();
                
                CD.setPK_IdCliente(Integer.valueOf(this.mantClienteView.txtCedula.getText()));
              
           try {
               this.clienteBLModelo.delete(CD);
           } catch (SQLException ex) {
               Logger.getLogger(MantControlCliente.class.getName()).log(Level.SEVERE, null, ex);
           }
           finally {this.clear();}
               
          
                }
            
         
         
         
         
     public void clear()
    {
         this.mantProveedorView.txtCedula.setText(null);
            this.mantProveedorView.txtNombre.setText(null);
            this.mantProveedorView.txtApellidos.setText(null);
            this.mantProveedorView.txtDireccion.setText(null);
            
            this.mantProveedorView.txtTel.setText(null);
            this.mantProveedorView.jDateChooser1.setCalendar(null);
            this.mantProveedorView.txtObservaciones.setText(null);
            this.mantProveedorView.btEliminar.setEnabled(false);
            this.mantProveedorView.btModificar.setEnabled(false);
            this.mantProveedorView.txtCedula.setEnabled(true); 
           
           
    }   

   
    private void cargarCliente() {
        ProveedorDTO s = new ProveedorDTO();
        
        if (!this.mantProveedorView.txtCedula.getText().isEmpty()) {
            s.setPK_IdCliente(Integer.parseInt(this.mantProveedorView.txtCedula.getText()));
            try {
                if(modeloProveedor.obtenerPorId(s)==null)
                {
                    JOptionPane.showMessageDialog(mantClienteView, "No se encuentra al cliente","Error", 0);
                }
                else{
          
                s = modeloProveedor.obtenerPorId(s);
                this.mantProveedorView.txtNombre.setText(s.getNombre());
                this.mantProveedorView.txtApellidos.setText(s.getApellidos());
                this.mantProveedorView.txtDireccion.setText(s.getDireccion());
                this.mantProveedorView.txtObservaciones.setText(s.getObservaciones());
                this.mantProveedorView.txtTel.setText(s.getTelefono().toString()); 
                String fecha[] = s.getFechaNacimiento().split("-");
                Date date = new GregorianCalendar(Integer.parseInt(fecha[0]), 
                         Integer.parseInt(fecha[1]), Integer.parseInt(fecha[2])).getTime();
                this.mantClienteView.jDateChooser1.setDate(date);
                
                this.mantClienteView.txtCedula.setEnabled(false);
                this.mantClienteView.btEliminar.setEnabled(true);
                this.mantClienteView.btModificar.setEnabled(true);
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(mantClienteView, "Error no se pudo consultar el cliente (" + ex.getMessage() + ")", "Error al cargar cliente", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(MantControlClienteBuscar.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
      
        
        
    }  
}

*/