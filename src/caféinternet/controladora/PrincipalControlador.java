
package caféinternet.controladora;

import caféinternet.bl.ArticuloBL;
import caféinternet.bl.ArticuloPorProveedorBL;
import caféinternet.bl.ClienteBL;
import caféinternet.bl.ProveedorBL;
import caféinternet.bl.UsuarioBL;
import caféinternet.vistas.principales.*;
import caféinternet.vistas.mantenimientos.ManteArticulo;
import caféinternet.vistas.mantenimientos.ManteArticuloPorProveedor;
import caféinternet.vistas.mantenimientos.ManteCliente;
import caféinternet.vistas.mantenimientos.ManteProveedor;
import caféinternet.vistas.mantenimientos.ManteUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import caféinternet.Aplicaciones.*;

/**
 *
 * @author Jimenez Cordoba
 */
public class PrincipalControlador implements ActionListener
{
    private Principal principalView;

    public PrincipalControlador(Principal principalView) {
        this.principalView = principalView;
        this.principalView.jMenuItemArtPorProveedor.addActionListener(this);
        this.principalView.jMenuItemArticulo.addActionListener(this);
        this.principalView.jMenuItemCliente.addActionListener(this);
        this.principalView.jMenuItemProveedor.addActionListener(this);
        this.principalView.jMenuItemUsuario.addActionListener(this);
        this.principalView.jMenuItemSalir.addActionListener(this);
        this.principalView.servidor.addActionListener(this); 
    }

    public PrincipalControlador() {
    }

    public Principal getPrincipalView() {
        return principalView;
    }

    public void setPrincipalView(Principal principalView) {
        this.principalView = principalView;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==principalView.servidor)
        {
            Server ser= new Server();
            ser.setVisible(true); 
        }
        if(e.getSource()==principalView.jMenuItemArtPorProveedor)
        {
            ManteArticuloPorProveedor mAP = new ManteArticuloPorProveedor();
            ArticuloPorProveedorBL apBL = new ArticuloPorProveedorBL();
            ArticuloPorProveedorControlador apC = new ArticuloPorProveedorControlador(mAP, apBL);
            apC.getManteArPro().setLocationRelativeTo(null);
            apC.getManteArPro().setVisible(true);
        }
        if(e.getSource()==principalView.jMenuItemArticulo)
        {
            ManteArticulo mA = new ManteArticulo();
            ArticuloBL aBL = new ArticuloBL();
            MantControlArticulo mCA = new MantControlArticulo(mA, aBL);
            mCA.getMantArticuloView().setLocationRelativeTo(null); 
            mCA.getMantArticuloView().setVisible(true);
        }
        if(e.getSource()==principalView.jMenuItemCliente)
        {
            ManteCliente mC = new ManteCliente();
            ClienteBL cBL = new ClienteBL();
            MantControlCliente mcA = new MantControlCliente(mC,cBL);
            mcA.getMantClienteView().setLocationRelativeTo(null); 
            mcA.getMantClienteView().setVisible(true);
        }
        if(e.getSource()==principalView.jMenuItemProveedor)
        {
            ManteProveedor mP = new ManteProveedor();
            ProveedorBL pBL = new ProveedorBL();
            MantControlProveedor mcP = new MantControlProveedor(mP, pBL);
            mcP.getMantProveedorView().setLocationRelativeTo(null); 
            mcP.getMantProveedorView().setVisible(true);
        }
        if(e.getSource()==principalView.jMenuItemUsuario)
        {
            ManteUsuario mU = new ManteUsuario();
            UsuarioBL uBL = new UsuarioBL();
            MantControlUsuario mcU = new MantControlUsuario(mU, uBL);
            mcU.getMantUsuarioView().setLocationRelativeTo(null); 
            mcU.getMantUsuarioView().setVisible(true);                    
        }
        if(e.getSource()==principalView.jMenuItemSalir)
        {
            System.exit(1);
        }
    }   
}
