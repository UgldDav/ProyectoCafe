/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caféinternet.controladora;
import caféinternet.bl.ProveedorBL;
import caféinternet.dto.ProveedorDTO;
import caféinternet.vistas.mantenimientos.ManteProveedorBuscar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

class MantControlProveedorBuscar implements ActionListener {
    
    private ManteProveedorBuscar ProveedorBuscarView;
    private ProveedorBL modelProBuscar;
    private JTextField txtRespuesta;

    public MantControlProveedorBuscar(ManteProveedorBuscar ProveedorBuscarView, ProveedorBL modelProBuscar, JTextField txtRespuesta) {
        this.ProveedorBuscarView = ProveedorBuscarView;
        this.modelProBuscar = modelProBuscar;
        this.txtRespuesta = txtRespuesta;
        
        this.ProveedorBuscarView.btBuscar.addActionListener(this);
        this.ProveedorBuscarView.btSeleccionar.addActionListener(this);
      
        llenarTabla(this.ProveedorBuscarView.jTableProveedorBuscar);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
       
        
        if(e.getSource() == this.ProveedorBuscarView.btBuscar){
            llenarTabla(this.ProveedorBuscarView.jTableProveedorBuscar);
        }
        
        if(e.getSource() == this.ProveedorBuscarView.btSeleccionar)
        {
             if(this.ProveedorBuscarView.jTableProveedorBuscar.getSelectedRow()==-1)
            {
            JOptionPane.showMessageDialog(ProveedorBuscarView, "No se ha seleccionado una opcion", "Error", 0);
            }
             else{
            int fila = this.ProveedorBuscarView.jTableProveedorBuscar.getSelectedRow();
            Integer idCliente = Integer.parseInt(this.ProveedorBuscarView.jTableProveedorBuscar.getValueAt(fila, 0).toString());
            txtRespuesta.setText(String.valueOf(idCliente));
            this.ProveedorBuscarView.setVisible(false);
             }
        }
    }
    
    public void llenarTabla(JTable tablaClientes) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaClientes.setModel(modeloTabla);

        modeloTabla.addColumn("Id Proveedor");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Direccion");
        modeloTabla.addColumn("Telefono");
        modeloTabla.addColumn("Correo");

        Object fila[] = new Object[5];
        
        String Sql = "where PK_IdProveedor like '%"+ this.ProveedorBuscarView.txtNombreBuscar.getText() +"%'";

        try {
            for (Object oAux : modelProBuscar.obtenerConWhere(new ProveedorDTO(), Sql)) {
                ProveedorDTO c = (ProveedorDTO) oAux;
                fila[0] = c.getPK_IdProveedor();
                fila[1] = c.getNombre();
                fila[2] = c.getDireccion();
                fila[3] = c.getTelefono();
                fila[4] = c.getCorreo();
                modeloTabla.addRow(fila);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error (llenarTabla):" + ex.getMessage(), "Error en llenarTabla", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ManteProveedorBuscar getProveedorBuscarView() {
        return ProveedorBuscarView;
    }

    public void setProveedorBuscarView(ManteProveedorBuscar ProveedorBuscarView) {
        this.ProveedorBuscarView = ProveedorBuscarView;
    }

    public ProveedorBL getModelProBuscar() {
        return modelProBuscar;
    }

    public void setModelProBuscar(ProveedorBL modelProBuscar) {
        this.modelProBuscar = modelProBuscar;
    }

    public JTextField getTxtRespuesta() {
        return txtRespuesta;
    }

    public void setTxtRespuesta(JTextField txtRespuesta) {
        this.txtRespuesta = txtRespuesta;
    }

}
