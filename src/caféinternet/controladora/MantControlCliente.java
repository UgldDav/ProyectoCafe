
package caféinternet.controladora;

import caféinternet.bl.ClienteBL;
import caféinternet.dto.ClienteDTO;


import caféinternet.vistas.mantenimientos.ManteCliente;
import caféinternet.vistas.mantenimientos.ManteClienteBuscar;
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

public class MantControlCliente implements ActionListener {
    
    private ManteCliente mantClienteView;
    private ClienteBL clienteBLModelo;

    public ManteCliente getMantClienteView() {
        return mantClienteView;
    }

    public void setMantClienteView(ManteCliente mantClienteView) {
        this.mantClienteView = mantClienteView;
    }

    public ClienteBL getClienteBLModelo() {
        return clienteBLModelo;
    }

    public void setClienteBLModelo(ClienteBL clienteBLModelo) {
        this.clienteBLModelo = clienteBLModelo;
    }

    public MantControlCliente(ManteCliente mantClienteView, ClienteBL clienteBLModelo) {
        this.mantClienteView = mantClienteView;
        this.clienteBLModelo = clienteBLModelo;
        
        this.mantClienteView.btBuscar.addActionListener(this);
        this.mantClienteView.btCancelar.addActionListener(this);
        this.mantClienteView.btEliminar.addActionListener(this);
        this.mantClienteView.btInsertar.addActionListener(this);
        this.mantClienteView.btModificar.addActionListener(this);
        this.mantClienteView.btCargar.addActionListener(this);
        
        
        
        
        inicializarPantalla();
    }
    
    private void inicializarPantalla(){
        
        this.mantClienteView.btEliminar.setEnabled(false);
        this.mantClienteView.btModificar.setEnabled(false);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) { 
        
         
       if(e.getSource()==this.mantClienteView.btCargar)
        {
            if(this.mantClienteView.txtCedula.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(mantClienteView, "El campo de cédula está vacia", "Error", 0);
            }
            else{
            this.cargarCliente();
            }
        }
        
       
        
        
         if(e.getSource()==this.mantClienteView.btInsertar)
         {
              if(this.mantClienteView.txtCedula.getText().isEmpty()
                   ||this.mantClienteView.txtApellidos.getText().isEmpty()
                      ||this.mantClienteView.txtDireccion.getText().isEmpty()
                      ||this.mantClienteView.jDateChooser1.isValid()
                      ||this.mantClienteView.txtTel.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(mantClienteView,"No se ha suministrado la informacion necesaria", "Error" , 0);
                }else{
                  try {
                      ClienteDTO c = new ClienteDTO();
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
                CC.getClienteBuscarView().setLocationRelativeTo(this.mantClienteView); 
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
            
         
         
         
         if(e.getSource()==this.mantClienteView.btModificar)
         {
             
            
                ClienteDTO c=new ClienteDTO();
                
                c.setPK_IdCliente(Integer.valueOf(this.mantClienteView.txtCedula.getText()));
                if(this.mantClienteView.txtCedula.getText().isEmpty()
                   ||this.mantClienteView.txtApellidos.getText().isEmpty()
                      ||this.mantClienteView.txtDireccion.getText().isEmpty()
                      ||this.mantClienteView.jDateChooser1.isValid()
                      ||this.mantClienteView.txtTel.getText().isEmpty())
                {
         JOptionPane.showMessageDialog(mantClienteView,"No se ha suministrado la informacion necesaria", "Error" , 0);

         }
                else{
                    c.setNombre(this.mantClienteView.txtNombre.getText());
                      c.setApellidos(this.mantClienteView.txtApellidos.getText());
                      SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMdd");
                      c.setFechaNacimiento(formatoFecha.format(this.mantClienteView.jDateChooser1.getDate()));
                      c.setDireccion(this.mantClienteView.txtDireccion.getText());
                      c.setObservaciones(this.mantClienteView.txtObservaciones.getText());
                      c.setUltUsuario(this.mantClienteView.txtUsuarioActual.getText());
                      c.setTelefono(Integer.valueOf(this.mantClienteView.txtTel.getText()));
                      
                    try { 
                        this.clienteBLModelo.update(c);
                    } catch (SQLException ex) {
                        Logger.getLogger(MantControlCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    finally {this.clear();}
                }
         }
              
    }
     public void clear()
    {
         this.mantClienteView.txtCedula.setText(null);
            this.mantClienteView.txtNombre.setText(null);
            this.mantClienteView.txtApellidos.setText(null);
            this.mantClienteView.txtDireccion.setText(null);
            
            this.mantClienteView.txtTel.setText(null);
            this.mantClienteView.jDateChooser1.setCalendar(null);
            this.mantClienteView.txtObservaciones.setText(null);
            this.mantClienteView.btEliminar.setEnabled(false);
            this.mantClienteView.btModificar.setEnabled(false);
            this.mantClienteView.txtCedula.setEnabled(true); 
           
           
    }   

   
    private void cargarCliente() {
        ClienteDTO s = new ClienteDTO();
        
        if (!this.mantClienteView.txtCedula.getText().isEmpty()) {
            s.setPK_IdCliente(Integer.parseInt(this.mantClienteView.txtCedula.getText()));
            try {
                if(clienteBLModelo.obtenerPorId(s)==null)
                {
                    JOptionPane.showMessageDialog(mantClienteView, "No se encuentra al cliente","Error", 0);
                }
                else{
          
                s = clienteBLModelo.obtenerPorId(s);
                this.mantClienteView.txtNombre.setText(s.getNombre());
                this.mantClienteView.txtApellidos.setText(s.getApellidos());
                this.mantClienteView.txtDireccion.setText(s.getDireccion());
                this.mantClienteView.txtObservaciones.setText(s.getObservaciones());
                this.mantClienteView.txtTel.setText(s.getTelefono().toString()); 
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

