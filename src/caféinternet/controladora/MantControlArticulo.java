
package caféinternet.controladora;

import caféinternet.vistas.mantenimientos.ManteArticulo;
import caféinternet.bl.ArticuloBL;
import caféinternet.dto.ArticuloDTO;
import caféinternet.vistas.mantenimientos.ManteArticuloBuscar;
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

public class MantControlArticulo implements ActionListener{
   private ManteArticulo MantArticuloView;
   private ArticuloBL modeloArBL;

    public ManteArticulo getMantArticuloView() {
        return MantArticuloView;
    }

    public void setMantArticuloView(ManteArticulo MantArticuloView) {
        this.MantArticuloView = MantArticuloView;
    }

    public ArticuloBL getModeloArBL() {
        return modeloArBL;
    }

    public void setModeloArBL(ArticuloBL modeloArBL) {
        this.modeloArBL = modeloArBL;
    }

   
    public MantControlArticulo(ManteArticulo MantArticuloView, ArticuloBL modeloArBL) {
        this.MantArticuloView = MantArticuloView;
        this.modeloArBL = modeloArBL;
        
        this.MantArticuloView.btAgregar.addActionListener(this);
        this.MantArticuloView.btModificar.addActionListener(this);
        this.MantArticuloView.btBuscar.addActionListener(this);
        this.MantArticuloView.btCancelar.addActionListener(this);
        this.MantArticuloView.btEliminar.addActionListener(this);
        this.MantArticuloView.btCargar.addActionListener(this);
       
        
        this.iniciarPantalla();
    }
    
    public void iniciarPantalla()
    {
        this.MantArticuloView.btEliminar.setEnabled(false);
        this.MantArticuloView.btModificar.setEnabled(false);    
    }
   
   public void clear()
   {
       this.MantArticuloView.txtCantidad.setText(null);
       this.MantArticuloView.txtDescripcion.setText(null);
       this.MantArticuloView.txtIdArticulo.setText(null);
       this.MantArticuloView.txtNombre.setText(null);
       this.MantArticuloView.txtPrecioUnitario.setText(null);
       this.MantArticuloView.txtIdArticulo.setEnabled(true);
       this.MantArticuloView.btEliminar.setEnabled(false);
       this.MantArticuloView.btModificar.setEnabled(false); 
              
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if(e.getSource()==this.MantArticuloView.btCargar)
        {
            if(this.MantArticuloView.txtIdArticulo.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(MantArticuloView, "El Id de articulo está en blanco", "Error", 0);
            }
            else{
                this.cargar();
            }
        }
        if(e.getSource()==this.MantArticuloView.btAgregar)
        {
            if(this.MantArticuloView.txtIdArticulo.getText().isEmpty()
                    ||this.MantArticuloView.txtNombre.getText().isEmpty()
                    ||this.MantArticuloView.txtCantidad.getText().isEmpty()
                    ||this.MantArticuloView.txtPrecioUnitario.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(MantArticuloView, "Debe llenar minimo la informacion con *" ,"Error al ingresar Articulo", 0);
            }
            
            else
            {
                ArticuloDTO arDTO = new ArticuloDTO();
                
                arDTO.setPK_IdArticulo(Integer.valueOf(this.MantArticuloView.txtIdArticulo.getText()));
                arDTO.setNombre(this.MantArticuloView.txtNombre.getText());
                arDTO.setDescripcion(this.MantArticuloView.txtDescripcion.getText());
                arDTO.setPrecioUnitario(Double.valueOf(this.MantArticuloView.txtPrecioUnitario.getText()));
                arDTO.setCantidad(Integer.valueOf(this.MantArticuloView.txtCantidad.getText()));
                arDTO.setUltUsuario(this.MantArticuloView.txtUsuarioActual.getText()); 
                
                try {
                    if(modeloArBL.obtenerPorId(arDTO)==null){
                    modeloArBL.insert(arDTO);
                    this.clear();
                    }
                    else{
                        JOptionPane.showMessageDialog(MantArticuloView, "El articulo ya Existe","Error al ingresar el Articulo", 0);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(MantControlArticulo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if(e.getSource()==this.MantArticuloView.btBuscar)
        {
            ManteArticuloBuscar mantArView = new ManteArticuloBuscar();
            MantControlArticuloBuscar arBuscar;
            arBuscar= new MantControlArticuloBuscar(mantArView, modeloArBL, this.MantArticuloView.txtIdArticulo);
          arBuscar.getArView().setLocationRelativeTo(this.MantArticuloView); 
            arBuscar.getArView().setVisible(true);
        
        }
        if(e.getSource()==this.MantArticuloView.btCancelar)
        {
        this.clear();
        }
        if(e.getSource()==this.MantArticuloView.btEliminar)
        {
            ArticuloDTO a = new ArticuloDTO();
            
            a.setPK_IdArticulo(Integer.valueOf(this.MantArticuloView.txtIdArticulo.getText()));
            
            try {
                this.modeloArBL.delete(a);
                this.clear();
            } catch (SQLException ex) {
                Logger.getLogger(MantControlArticulo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource()==this.MantArticuloView.btModificar)
        {
            if(this.MantArticuloView.txtIdArticulo.getText().isEmpty()
                    ||this.MantArticuloView.txtCantidad.getText().isEmpty()
                    ||this.MantArticuloView.txtPrecioUnitario.getText().isEmpty()
                    ||this.MantArticuloView.txtPrecioUnitario.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(MantArticuloView, "Error", "Informacion incompleta el articulo no puede modificarse", 0);
            
            }
            else
            {
                ArticuloDTO a =new ArticuloDTO();
                
                a.setPK_IdArticulo(Integer.valueOf(this.MantArticuloView.txtIdArticulo.getText()));
                a.setNombre(this.MantArticuloView.txtNombre.getText());
                a.setCantidad(Integer.valueOf(this.MantArticuloView.txtCantidad.getText()));
                a.setDescripcion(this.MantArticuloView.txtDescripcion.getText());
                a.setPrecioUnitario(Double.valueOf(this.MantArticuloView.txtPrecioUnitario.getText()));
                a.setUltUsuario(this.MantArticuloView.txtUsuarioActual.getText());
                
                try {
                    this.modeloArBL.update(a);
                    this.clear();
                } catch (SQLException ex) {
                    Logger.getLogger(MantControlArticulo.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        
        }
        
    }
    
    public void cargar()
    {
        if(!this.MantArticuloView.txtIdArticulo.getText().isEmpty())
        {
            ArticuloDTO arDTO = new ArticuloDTO();
            arDTO.setPK_IdArticulo(Integer.parseInt(this.MantArticuloView.txtIdArticulo.getText()));
            
            try {
                 if(modeloArBL.obtenerPorId(arDTO)==null)
                {
                    JOptionPane.showMessageDialog(MantArticuloView, "Fatal, no se encuentra el articulo ", "Error", 0);
                }
                 else{
                     this.MantArticuloView.txtIdArticulo.setEnabled(false); 
                     this.MantArticuloView.btEliminar.setEnabled(true);
                     this.MantArticuloView.btModificar.setEnabled(true); 
                arDTO=this.modeloArBL.obtenerPorId(arDTO);
                
                this.MantArticuloView.txtIdArticulo.setText(String.valueOf(arDTO.getPK_IdArticulo()));
                this.MantArticuloView.txtNombre.setText(arDTO.getNombre());
                this.MantArticuloView.txtCantidad.setText(String.valueOf(arDTO.getCantidad()));
                this.MantArticuloView.txtPrecioUnitario.setText(String.valueOf(arDTO.getPrecioUnitario()));
                this.MantArticuloView.txtDescripcion.setText(arDTO.getDescripcion());
                 }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(MantArticuloView, "Error no se pudo consultar el Articulo (" + ex.getMessage() + ")", "Error al cargar Articulo", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(MantControlUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}
