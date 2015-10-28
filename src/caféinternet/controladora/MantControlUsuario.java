/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caféinternet.controladora;
import caféinternet.vistas.mantenimientos.ManteUsuario;
import caféinternet.bl.UsuarioBL;
import caféinternet.dto.UsuarioDTO;
import caféinternet.vistas.mantenimientos.ManteUsuarioBuscar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPasswordField;

/**
 *
 * @author David
 */
public class MantControlUsuario implements ActionListener{

    private ManteUsuario mantUsuarioView;
    private UsuarioBL modeloUsuario;
    
    
private static boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
}
    public ManteUsuario getMantUsuarioView() {
        return mantUsuarioView;
    }

    public void setMantUsuarioView(ManteUsuario mantUsuarioView) {
        this.mantUsuarioView = mantUsuarioView;
    }

    public UsuarioBL getModeloUsuario() {
        return modeloUsuario;
    }

    public void setModeloUsuario(UsuarioBL modeloUsuario) {
        this.modeloUsuario = modeloUsuario;
    }

    public MantControlUsuario(ManteUsuario mantUsuarioView, UsuarioBL modeloUsuario) {
        this.mantUsuarioView = mantUsuarioView;
        this.modeloUsuario = modeloUsuario;
        
        this.mantUsuarioView.btCancelar.addActionListener(this);
        this.mantUsuarioView.btEliminar.addActionListener(this);
        this.mantUsuarioView.btInsertar.addActionListener(this);
        this.mantUsuarioView.btModificar.addActionListener(this);
        this.mantUsuarioView.btBuscar.addActionListener(this);
        this.mantUsuarioView.btCargar.addActionListener(this);
       
        
        
    
        inicializarPantalla();
    }
    
     private void inicializarPantalla() {
        
         this.mantUsuarioView.btEliminar.setEnabled(false);
         this.mantUsuarioView.btModificar.setEnabled(false);
       
     
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
       
        if(e.getSource()==this.mantUsuarioView.btCargar)
        {
            if(this.mantUsuarioView.txtUsuario.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(mantUsuarioView, "Id de Usuario en blanco","Error", 0);
            }
            else{
            this.cargarUsuario();
            }
        }
       if(e.getSource()== this.mantUsuarioView.btBuscar)
       {
           ManteUsuarioBuscar Ubuscar=new ManteUsuarioBuscar();
                MantControlUsuarioBuscar usCB;
                usCB = new MantControlUsuarioBuscar(Ubuscar, modeloUsuario, this.mantUsuarioView.txtUsuario);
                usCB.getMantUsuarioBuscarView().setLocationRelativeTo(this.mantUsuarioView); 
                usCB.getMantUsuarioView().setVisible(true);
               
       }
        
       if(e.getSource()== this.mantUsuarioView.btInsertar)
       {
           if(this.mantUsuarioView.txtNombreCompleto.getText().isEmpty()
                   ||this.mantUsuarioView.txtUsuario.getText().isEmpty())
           {
            JOptionPane.showMessageDialog(mantUsuarioView,"No se ha suministrado la informacion completa", "Error" , 0);
           }
           else{
               if(!this.isNumeric(this.mantUsuarioView.txtUsuario.getText()))
               {
                   JOptionPane.showMessageDialog(mantUsuarioView, "El id no es una entrada valida", "error", 0);
               }
               else{
            
            UsuarioDTO a = new UsuarioDTO();
            a.setPK_IdUsuario(Integer.valueOf(this.mantUsuarioView.txtUsuario.getText()));
            a.setNombreCompleto(this.mantUsuarioView.txtNombreCompleto.getText());
            a.setContraseña(String.valueOf(this.mantUsuarioView.txtPassword.getPassword()));
            a.setUltUsuario(this.mantUsuarioView.txtUsuarioActual.getText());
      
            try {
                
                if(this.modeloUsuario.obtenerPorId(a)== null)
                {
                    this.modeloUsuario.insert(a);
                    JOptionPane.showMessageDialog (
                            mantUsuarioView, "El Usuario ha sido ingresado correctamente",
                            "Usuario Agreagado", JOptionPane.INFORMATION_MESSAGE);

                }
                
                else
                {
                    JOptionPane.showMessageDialog(mantUsuarioView,"Error de registro","Cliente: "+a.getPK_IdUsuario()+" ya existe" , 0);
                }
                
              
                
            } catch (SQLException ex) {
                Logger.getLogger(MantControlUsuario.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantUsuarioView, "Error al agregar el Usuario:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(MantControlUsuario.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantUsuarioView, "Error al agregar el Usuario:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
           }
       }
        
       }
       
       
       if(e.getSource() == mantUsuarioView.btEliminar)
       {
            UsuarioDTO s = new UsuarioDTO();
           if(this.mantUsuarioView.txtUsuario.getText().isEmpty())
           {
               JOptionPane.showMessageDialog(mantUsuarioView, "Usuario Vacio","Error", 0);
           }
            s.setPK_IdUsuario(Integer.valueOf(this.mantUsuarioView.txtUsuario.getText()));
            try {
                modeloUsuario.delete(s);
                 this.clear();
                JOptionPane.showMessageDialog(mantUsuarioView, "El Usuario ha sido eliminado correctamente", "Socio Eliminado", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(MantControlUsuario.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantUsuarioView, "Error al eliminar el Usuario:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(MantControlUsuario.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantUsuarioView, "Error al eliminar el Usuario:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
       }
       
        if(e.getSource() == this.mantUsuarioView.btModificar)
        {
            UsuarioDTO a = new UsuarioDTO();
            a.setPK_IdUsuario(Integer.valueOf(this.mantUsuarioView.txtUsuario.getText()));
           if(this.mantUsuarioView.txtUsuario.getText().isEmpty()
                   &&this.mantUsuarioView.txtNombreCompleto.getText().isEmpty())
           {
               JOptionPane.showMessageDialog(mantUsuarioView, "Error de modificación", "Informacion incompleta",0);
           }
           else
           {
               a.setPK_IdUsuario(Integer.valueOf(this.mantUsuarioView.txtUsuario.getText()));
               a.setNombreCompleto(this.mantUsuarioView.txtNombreCompleto.getText());
               a.setContraseña(String.valueOf(this.mantUsuarioView.txtPassword.getPassword()));
               a.setUltUsuario(this.mantUsuarioView.txtUsuarioActual.getText());
           
           }
           
           try {
               this.modeloUsuario.update(a);
               this.clear();
           } catch (SQLException ex) {
               Logger.getLogger(MantControlUsuario.class.getName()).log(Level.SEVERE, null, ex);
           }
           
        }
        if (e.getSource() == this.mantUsuarioView.btCancelar)
        {
           this.clear();
        }
       
    }

    public void clear()
    {
         this.mantUsuarioView.txtUsuario.setText(null);
            this.mantUsuarioView.txtNombreCompleto.setText(null);
            this.mantUsuarioView.txtPassword.setText(null);
            this.mantUsuarioView.btEliminar.setEnabled(false);
            this.mantUsuarioView.btModificar.setEnabled(false);
            this.mantUsuarioView.txtUsuario.setEnabled(true);
    }   
     
    private void cargarUsuario() {
        UsuarioDTO a = new UsuarioDTO();
        if (!this.mantUsuarioView.txtUsuario.getText().isEmpty()) {
          
            a.setPK_IdUsuario(Integer.parseInt(this.mantUsuarioView.txtUsuario.getText()));
            try {
                if(modeloUsuario.obtenerPorId(a)==null)
                {
                    JOptionPane.showMessageDialog(mantUsuarioView, "Fatal, no se encuentra el usuario ", "Error", 0);
                }
                else{
                this.mantUsuarioView.txtUsuario.setEnabled(false);
                this.mantUsuarioView.btEliminar.setEnabled(true);
                this.mantUsuarioView.btModificar.setEnabled(true);
                a = modeloUsuario.obtenerPorId(a);
                this.mantUsuarioView.txtUsuario.setText(String.valueOf(a.getPK_IdUsuario()));
                this.mantUsuarioView.txtNombreCompleto.setText(a.getNombreCompleto());
                this.mantUsuarioView.txtPassword.setText(a.getContraseña());
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(mantUsuarioView, "Error no se pudo consultar el Usuario (" + ex.getMessage() + ")", "Error al cargar Articulo", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(MantControlUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
