/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caféinternet.controladora;
import caféinternet.bl.UsuarioBL;
import caféinternet.dto.UsuarioDTO;
import caféinternet.vistas.mantenimientos.ManteUsuarioBuscar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author David
 */
public class MantControlUsuarioBuscar implements ActionListener{
    private ManteUsuarioBuscar MantUsuarioBuscarView;
    private UsuarioBL usuarioBL;
    private JTextField txtRespuestas;
   

    public MantControlUsuarioBuscar(ManteUsuarioBuscar MantUsuarioView, UsuarioBL usuarioBL, JTextField txtRespuestas) {
        this.MantUsuarioBuscarView = MantUsuarioView;
        this.usuarioBL = usuarioBL;
        this.txtRespuestas = txtRespuestas;
        
        this.MantUsuarioBuscarView.btBuscar.addActionListener(this);
        this.MantUsuarioBuscarView.btSeleccionar.addActionListener(this);
       
        llenarTabla(this.MantUsuarioBuscarView.jTUsuarios);
        

    }

    public ManteUsuarioBuscar getMantUsuarioBuscarView() {
        return MantUsuarioBuscarView;
    }

    public void setMantUsuarioBuscarView(ManteUsuarioBuscar MantUsuarioBuscarView) {
        this.MantUsuarioBuscarView = MantUsuarioBuscarView;
    }


    public ManteUsuarioBuscar getMantUsuarioView() {
        return MantUsuarioBuscarView;
    }

    public void setMantUsuarioView(ManteUsuarioBuscar MantUsuarioView) {
        this.MantUsuarioBuscarView = MantUsuarioView;
    }

    public UsuarioBL getUsuarioBL() {
        return usuarioBL;
    }

    public void setUsuarioBL(UsuarioBL usuarioBL) {
        this.usuarioBL = usuarioBL;
    }

    public JTextField getTxtRespuestas() {
        return txtRespuestas;
    }

    public void setTxtRespuestas(JTextField txtRespuestas) {
        this.txtRespuestas = txtRespuestas;
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
     
        if(e.getSource()== this.MantUsuarioBuscarView.btBuscar)
        {
            llenarTabla(this.MantUsuarioBuscarView.jTUsuarios);
            
        }
        if(e.getSource()==this.MantUsuarioBuscarView.btSeleccionar)
        {
             if(this.MantUsuarioBuscarView.jTUsuarios.getSelectedRow()==-1)
            {
            JOptionPane.showMessageDialog(MantUsuarioBuscarView, "No se ha seleccionado una opcion", "Error", 0);
            }
             else{
            int fila = this.MantUsuarioBuscarView.jTUsuarios.getSelectedRow();
            Integer idCliente = Integer.parseInt(this.MantUsuarioBuscarView.jTUsuarios.getValueAt(fila, 0).toString());
            txtRespuestas.setText(String.valueOf(idCliente));
            this.MantUsuarioBuscarView.setVisible(false);
             }
        }

    }
    
    public void llenarTabla(JTable Tablausuarios)
    {
            DefaultTableModel modeloTabla = new DefaultTableModel();
        Tablausuarios.setModel(modeloTabla);

        modeloTabla.addColumn("Id Usuario");
        modeloTabla.addColumn("Nombre Usuario");

        Object fila[] = new Object[2];
        
        String Sql = "where Pk_IdUsuario like '%"+ this.MantUsuarioBuscarView.txtBuscarUsuario.getText() +"%'";

        try {
            for (Object oAux : usuarioBL.obtenerConWhere(new UsuarioDTO(), Sql)) {
                UsuarioDTO c = (UsuarioDTO) oAux;
                fila[0] = c.getPK_IdUsuario();
                fila[1] = c.getNombreCompleto();
                modeloTabla.addRow(fila);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error (llenarTabla):" + ex.getMessage(), "Error en llenarTabla", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
}
