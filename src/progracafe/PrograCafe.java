/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progracafe;
import caféinternet.controladora.*;
import caféinternet.bl.*;
import caféinternet.dao.*;
import caféinternet.dto.*;
import caféinternet.vistas.principales.*;
import caféinternet.vistas.mantenimientos.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 *
 * @author David
 */
public class PrograCafe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException  {
 
      
      
        /*
        UsuarioBL usBL= new UsuarioBL();
        MantUsuario usVie = new MantUsuario();
        MantControlUsuario usCo= new MantControlUsuario(usVie, usBL);
        usCo.getMantUsuarioView().setVisible(true);
        */
        
       /*
        ArticuloBL arBL = new ArticuloBL();
        ManteArticulo arView=new ManteArticulo();
        MantControlArticulo arControl = new MantControlArticulo(arView, arBL);
        arControl.getMantArticuloView().setVisible(true);
       */
       
     /* 
        ClienteBL clBL = new ClienteBL();
        ManteCliente clView = new ManteCliente();
       
        MantControlCliente clControl=new MantControlCliente(clView, clBL);
        clControl.getMantClienteView().setVisible(true);
        
   */
     /*      
        ProveedorBL PB=new ProveedorBL();
        ManteProveedor PV=new ManteProveedor();
       MantControlProveedor PC=new MantControlProveedor(PV, PB);
       PC.getMantProveedorView().setVisible(true); 
     */
        /*
        ArticuloPorProveedorBL APP =new ArticuloPorProveedorBL();
        ManteArticuloPorProveedor MAPP=new ManteArticuloPorProveedor();
        
        ArticuloPorProveedorControlador APPC = new ArticuloPorProveedorControlador(MAPP, APP);
        APPC.getManteArPro().setVisible(true); 
      */
       
          Principal p = new Principal();
       PrincipalControlador pc = new PrincipalControlador(p);
       pc.getPrincipalView().setLocationRelativeTo(null); 
       pc.getPrincipalView().setVisible(true);
      
        
        
 }
    
   
}

