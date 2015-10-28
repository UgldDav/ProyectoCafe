
package caféinternet.controladora;
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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class MantControlArticuloBuscar implements ActionListener{
private ManteArticuloBuscar arView;
private ArticuloBL modeAr;
private JTextField Respuesta;

    public MantControlArticuloBuscar(ManteArticuloBuscar arView, ArticuloBL modeAr, JTextField Respuesta) {
        this.arView = arView;
        this.modeAr = modeAr;
        this.Respuesta = Respuesta;
        
        this.arView.btSeleccionar.addActionListener(this);
        this.arView.btBuscar.addActionListener(this);
    
        llenarTabla(this.arView.jTableArticuloBuscar);
        
    }

    public ManteArticuloBuscar getArView() {
        return arView;
    }

    public void setArView(ManteArticuloBuscar arView) {
        this.arView = arView;
    }

    public ArticuloBL getModeAr() {
        return modeAr;
    }

    public void setModeAr(ArticuloBL modeAr) {
        this.modeAr = modeAr;
    }

    public JTextField getRespuesta() {
        return Respuesta;
    }

    public void setRespuesta(JTextField Respuesta) {
        this.Respuesta = Respuesta;
    }
    
    public void llenarTabla(JTable TablaArticulos)
    {
        DefaultTableModel modeloTabla = new DefaultTableModel();
            TablaArticulos.setModel(modeloTabla);
            
            modeloTabla.addColumn("Id Articulo");
            modeloTabla.addColumn("Nombre");
            modeloTabla.addColumn("Descripcion");
            modeloTabla.addColumn("Cantidad");
            modeloTabla.addColumn("Precio Unitario");
            
            Object fila[]= new Object[5];
            
            String Sql = " WHERE PK_IdArticulo like '%"+this.arView.txtNombreBuscar.getText()+"%'";
            
    try {
        for(Object oAux : modeAr.obtenerConWhere(new ArticuloDTO(), Sql))
        {
            ArticuloDTO a = (ArticuloDTO) oAux;
            fila[0]= a.getPK_IdArticulo();
            fila[1]=a.getNombre();
            fila[2]=a.getDescripcion();
            fila[3] = a.getCantidad();
            fila[4]= a.getPrecioUnitario();
            modeloTabla.addRow(fila);
        }
    } catch (SQLException ex) {
        Logger.getLogger(MantControlArticuloBuscar.class.getName()).log(Level.SEVERE, null, ex);
    }
            
           
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if(e.getSource()==this.arView.btBuscar)
        {
            llenarTabla(this.arView.jTableArticuloBuscar);
        }
        
        if(e.getSource()==this.arView.btSeleccionar)
        {
            if(this.arView.jTableArticuloBuscar.getSelectedRow()==-1)
            {
            JOptionPane.showMessageDialog(arView, "No se ha seleccionado una opcion", "Error", 0);
            }
            else{
            int fila = this.arView.jTableArticuloBuscar.getSelectedRow();
            Integer idArticulo = Integer.valueOf(this.arView.jTableArticuloBuscar.getValueAt(fila, 0).toString());
            Respuesta.setText(String.valueOf(idArticulo));    
            this.arView.setVisible(false);
            }
        }
    }
    
}
