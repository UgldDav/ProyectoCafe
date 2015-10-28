
package caféinternet.controladora;

import caféinternet.bl.ClienteBL;
import caféinternet.dto.ClienteDTO;
import caféinternet.vistas.mantenimientos.ManteClienteBuscar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

class MantControlClienteBuscar implements ActionListener {
    
    private ManteClienteBuscar clienteBuscarView;
    private ClienteBL clienteBLModelo;
    private JTextField txtRespuesta;

    public MantControlClienteBuscar(ManteClienteBuscar clienteBuscarView, ClienteBL clienteBLModelo, JTextField txtRespuesta) {
        this.clienteBuscarView = clienteBuscarView;
        this.clienteBLModelo = clienteBLModelo;
        this.txtRespuesta = txtRespuesta;
        
        this.clienteBuscarView.btBuscar.addActionListener(this);
        this.clienteBuscarView.btSeleccionar.addActionListener(this);
        
        llenarTabla(this.clienteBuscarView.jTableBuscarCliente);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        
        if(e.getSource() == this.clienteBuscarView.btBuscar){
            llenarTabla(this.clienteBuscarView.jTableBuscarCliente);
        }
        
        if(e.getSource() == this.clienteBuscarView.btSeleccionar)
        {
             if(this.clienteBuscarView.jTableBuscarCliente.getSelectedRow()==-1)
            {
            JOptionPane.showMessageDialog(clienteBuscarView, "No se ha seleccionado una opcion", "Error", 0);
            }
             else{
            int fila = this.clienteBuscarView.jTableBuscarCliente.getSelectedRow();
            Integer idCliente = Integer.parseInt(this.clienteBuscarView.jTableBuscarCliente.getValueAt(fila, 0).toString());
            txtRespuesta.setText(String.valueOf(idCliente));
            this.clienteBuscarView.setVisible(false);
             }
        }
    }
    
    public void llenarTabla(JTable tablaClientes) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaClientes.setModel(modeloTabla);

        modeloTabla.addColumn("Id Cliente");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellidos");
        modeloTabla.addColumn("Fecha Nacimiento");
        modeloTabla.addColumn("Direccion");
        modeloTabla.addColumn("Observaciones");

        Object fila[] = new Object[6];
        
        String Sql = "where PK_IdCliente like '%"+ this.clienteBuscarView.txtbuscarNombre.getText() +"%'";

        try {
            for (Object oAux : clienteBLModelo.obtenerConWhere(new ClienteDTO(), Sql)) {
                ClienteDTO c = (ClienteDTO) oAux;
                fila[0] = c.getPK_IdCliente();
                fila[1] = c.getNombre();
                fila[2] = c.getApellidos();
                fila[3] = c.getFechaNacimiento();
                fila[4] = c.getDireccion();
                fila[5] = c.getObservaciones();
                modeloTabla.addRow(fila);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error (llenarTabla):" + ex.getMessage(), "Error en llenarTabla", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ManteClienteBuscar getClienteBuscarView() {
        return clienteBuscarView;
    }

    public void setClienteBuscarView(ManteClienteBuscar clienteBuscarView) {
        this.clienteBuscarView = clienteBuscarView;
    }

    public ClienteBL getClienteBLModelo() {
        return clienteBLModelo;
    }

    public void setClienteBLModelo(ClienteBL clienteBLModelo) {
        this.clienteBLModelo = clienteBLModelo;
    }

    public JTextField getTxtRespuesta() {
        return txtRespuesta;
    }

    public void setTxtRespuesta(JTextField txtRespuesta) {
        this.txtRespuesta = txtRespuesta;
    }
   
    
}
