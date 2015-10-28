/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package caféinternet.controladora;
import caféinternet.bl.ArticuloPorProveedorBL;
import caféinternet.bl.*;
import caféinternet.dto.*;
import caféinternet.vistas.mantenimientos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
/**
 *
 * @author David
 */


public class ArticuloPorProveedorControlador implements ActionListener,DocumentListener{
    private ManteArticuloPorProveedor manteArPro;
    private ArticuloPorProveedorBL modeloArPro;

    public ArticuloPorProveedorControlador(ManteArticuloPorProveedor manteArPro, ArticuloPorProveedorBL modeloArPro) {
        this.manteArPro = manteArPro;
        this.modeloArPro = modeloArPro;
        
        this.manteArPro.btBuscarArticulo.addActionListener(this);
        this.manteArPro.btBuscarProveedor.addActionListener(this);
        this.manteArPro.btCancelar.addActionListener(this);
        this.manteArPro.btEliminar.addActionListener(this);  
        this.manteArPro.btInsertar.addActionListener(this);
        this.manteArPro.btEliminar.setEnabled(false);
        this.manteArPro.txtIdArticulo.setEnabled(false);
        this.manteArPro.txtIdProveedor.setEnabled(false);
        this.manteArPro.txtIdArticulo.getDocument().addDocumentListener(this);
        this.manteArPro.txtIdProveedor.getDocument().addDocumentListener(this); 
        
        
    }
   
    

    public ManteArticuloPorProveedor getManteArPro() {
        return manteArPro;
    }

    public void setManteArPro(ManteArticuloPorProveedor manteArPro) {
        this.manteArPro = manteArPro;
    }

    public ArticuloPorProveedorBL getModeloArPro() {
        return modeloArPro;
    }

    public void setModeloArPro(ArticuloPorProveedorBL modeloArPro) {
        this.modeloArPro = modeloArPro;
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if(e.getSource()==this.manteArPro.btBuscarProveedor)
        {
            ProveedorBL PB=new ProveedorBL();
            ManteProveedorBuscar MPB=new ManteProveedorBuscar();
            MantControlProveedorBuscar MCPB;
            MCPB =new MantControlProveedorBuscar(MPB,PB, this.manteArPro.txtIdProveedor);
            MCPB.getProveedorBuscarView().setLocationRelativeTo(this.manteArPro);  
            MCPB.getProveedorBuscarView().setVisible(true); 
            
        }
        
        if(e.getSource()==this.manteArPro.btBuscarArticulo)
        {
            ArticuloBL AB=new ArticuloBL();
            ManteArticuloBuscar MAB=new ManteArticuloBuscar();
            MantControlArticuloBuscar MCAB;
            MCAB =new MantControlArticuloBuscar(MAB, AB, this.manteArPro.txtIdArticulo);
            MCAB.getArView().setVisible(true); 
            
        }
        
        if(e.getSource()==this.manteArPro.btInsertar)
        {
            if(this.manteArPro.txtIdProveedor.getText().isEmpty()
                    ||this.manteArPro.txtIdArticulo.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(manteArPro, "No se ha suministrado la informacion requerida", "Error", 0);
            }else{
                try {
                    ArticuloBL ABL=new ArticuloBL();
                    ArticuloDTO ADTO=new ArticuloDTO();
                    ProveedorBL PBL=new ProveedorBL();
                    ProveedorDTO PDTO=new ProveedorDTO();
                    ADTO.setPK_IdArticulo(Integer.valueOf(this.manteArPro.txtIdArticulo.getText()));
                    PDTO.setPK_IdProveedor(Integer.valueOf(this.manteArPro.txtIdProveedor.getText()));
                    if(ABL.obtenerPorId(ADTO)==null || PBL.obtenerPorId(PDTO)==null)
                    {
                        JOptionPane.showMessageDialog(manteArPro, "No se puede añadir el articulo al proveedor, favor revise que existan", "Error", 0);
                    }else{
                        ArticuloPorProveedorDTO APP=new ArticuloPorProveedorDTO();
                        APP.setFK_PK_IdProveedor(PDTO.getPK_IdProveedor());
                        APP.setFK_PK_IdArticulo(ADTO.getPK_IdArticulo());
                        APP.setUltUsuario(this.manteArPro.txtUsuarioActual.getText());
                        
                        if(this.modeloArPro.obtenerPorId(APP)!=null)
                        {
                            JOptionPane.showMessageDialog(manteArPro, "Error el articulo ya está inscrito a este proveedor", "Error", 0);
                        }else{
                            modeloArPro.insert(APP);
                            JOptionPane.showMessageDialog(manteArPro, "Felicidades", "El Articulo fue inscrito a este proveedor", 1);
                            this.cargarArtProveedor(this.manteArPro.jTArticulo);
                        }
                        
                    }
                } catch (SQLException ex) {                    
                    Logger.getLogger(ArticuloPorProveedorControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        }
        
        if(e.getSource()==this.manteArPro.btCancelar)
        {
            this.clear();
        }
        
        if(e.getSource()==this.manteArPro.btEliminar)
        {
            try {
                ArticuloPorProveedorDTO APP=new ArticuloPorProveedorDTO();
                APP.setFK_PK_IdProveedor(Integer.valueOf(this.manteArPro.txtIdProveedor.getText()));
                APP.setFK_PK_IdArticulo(Integer.valueOf(this.manteArPro.txtIdArticulo.getText()));
                
                if(modeloArPro.obtenerPorId(APP)==null)
                {
                    JOptionPane.showMessageDialog(manteArPro, "Este proveedor no pose este articulo asignado", "Error", 0);
                }
                else
                {
                    modeloArPro.delete(APP);
                    JOptionPane.showMessageDialog(manteArPro, "El articulo a sido desasignado correctamente", "Felicidades", 1);
                    this.cargarArtProveedor(this.manteArPro.jTArticulo);
                }} catch (SQLException ex) {
                Logger.getLogger(ArticuloPorProveedorControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
       
    }
    
    public void cargarProveedor(JTable tablaArt)
    {
        try {
            DefaultTableModel tabla=new DefaultTableModel();
            tablaArt.setModel(tabla);
            
            tabla.addColumn("Id Proveedor");
            tabla.addColumn("Nombre");
            tabla.addColumn("Direccion");
            tabla.addColumn("Telefono");
            tabla.addColumn("Correo");
            
            Object fila[]=new Object[5];
            
            ProveedorBL PBL=new ProveedorBL();
            ProveedorDTO PDTO=new ProveedorDTO();
            
            PDTO.setPK_IdProveedor(Integer.valueOf(this.manteArPro.txtIdProveedor.getText()));
            if(PBL.obtenerPorId(PDTO)==null)
            {
                JOptionPane.showMessageDialog(manteArPro, "No se puede cargar al proveedor", "Error", 0);
            }
            else
            {
                PDTO=PBL.obtenerPorId(PDTO);
                fila[0]=PDTO.getPK_IdProveedor();
                fila[1]=PDTO.getNombre();
                fila[2]=PDTO.getDireccion();
                fila[3]=PDTO.getTelefono();
                fila[4]=PDTO.getCorreo();
                tabla.addRow(fila); 
                
                this.cargarArtProveedor(this.manteArPro.jTArticulo); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloPorProveedorControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cargarArtProveedor(JTable tablaAP)
    {
        DefaultTableModel tabla=new DefaultTableModel();
        tablaAP.setModel(tabla);
        
        tabla.addColumn("ID Articulo");
        tabla.addColumn("Nombre");
        tabla.addColumn("Descripcion");
        tabla.addColumn("Cantidad");
        tabla.addColumn("Precio Unitario");
        
        Object fila[]= new Object [5];
        
        String sql= "where FK_PK_IdProveedor ="+this.manteArPro.txtIdProveedor.getText();
        ArticuloBL ABL=new ArticuloBL();
        try {
            for(Object Aox :modeloArPro.obtenerConWhere(new ArticuloPorProveedorDTO(), sql))
            {
                ArticuloPorProveedorDTO a=(ArticuloPorProveedorDTO) Aox;
                ArticuloDTO ADTO=new ArticuloDTO();
                ADTO.setPK_IdArticulo(a.getFK_PK_IdArticulo()); 
                ADTO=ABL.obtenerPorId(ADTO);
                fila[0]=ADTO.getPK_IdArticulo();
                fila[1]=ADTO.getNombre();
                fila[2]=ADTO.getDescripcion();
                fila[3]=ADTO.getCantidad();
                fila[4]=ADTO.getPrecioUnitario();
                tabla.addRow(fila); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloPorProveedorControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void cargar()
    {
    if(!this.manteArPro.txtIdProveedor.getText().isEmpty())
    {
           this.cargarProveedor(this.manteArPro.jTProveedor);
    }   
        if(!this.manteArPro.txtIdArticulo.getText().isEmpty()
                &&!this.manteArPro.txtIdProveedor.getText().isEmpty())
        {
            this.manteArPro.btEliminar.setEnabled(true);
        }
    }
    public void clear()
    {
        this.manteArPro.txtIdProveedor.setText(null);
        this.manteArPro.txtIdArticulo.setText(null);
        this.manteArPro.btEliminar.setEnabled(false);
        this.clearTable(this.manteArPro.jTArticulo);
        this.clearTable(this.manteArPro.jTProveedor); 
     
    }
    
    public void clearTable(JTable Tabla)
    {
        DefaultTableModel modelo = (DefaultTableModel) Tabla.getModel();
        while(modelo.getRowCount()>0)modelo.removeRow(0);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
     this.cargar();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        this.cargar();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        this.cargar();
    }
    
}
    

