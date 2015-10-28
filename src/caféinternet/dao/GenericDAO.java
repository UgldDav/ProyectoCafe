/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caféinternet.dao;

import caféinternet.dto.*;
import caféinternet.interfaces.IBaseDao;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class GenericDAO {
       private IBaseDao iBaseDato;

    public GenericDAO() {
    }
    
    public void insert(Object obj) throws SQLException {
        if (obj instanceof ClienteDTO) {
            iBaseDato = new ClienteDAO();
            
        }
        
        if(obj instanceof ArticuloDTO)
        {
            iBaseDato = new ArticuloDAO();
        }
        
        if(obj instanceof ArticuloPorProveedorDTO)
        {
            iBaseDato = new ArticuloPorProveedorDAO();
        }
        if (obj instanceof ComputadoraDTO) 
        {
            iBaseDato = new ComputadoraDAO();
        }
        if (obj instanceof FacturaDTO) 
        {
            iBaseDato = new FacturaDAO();
        }
        if (obj instanceof ProveedorDTO) 
        {
            iBaseDato = new ProveedorDAO();
        }
       
        if (obj instanceof UsuarioDTO) 
        {
            iBaseDato = new UsuarioDAO();
        }
        
        
        
        iBaseDato.insert(obj);
    }
    
    public void update(Object obj) throws SQLException {
         if (obj instanceof ClienteDTO) {
            iBaseDato = new ClienteDAO();
            
        }
        
          if(obj instanceof ArticuloDTO)
        {
            iBaseDato = new ArticuloDAO();
        }
        
        if(obj instanceof ArticuloPorProveedorDTO)
        {
            iBaseDato = new ArticuloPorProveedorDAO();
        }
        if (obj instanceof ComputadoraDTO) 
        {
            iBaseDato = new ComputadoraDAO();
        }
        if (obj instanceof FacturaDTO) 
        {
            iBaseDato = new FacturaDAO();
        }
        if (obj instanceof ProveedorDTO) 
        {
            iBaseDato = new ProveedorDAO();
        }
         
        
        if (obj instanceof UsuarioDTO) 
        {
            iBaseDato = new UsuarioDAO();
        }
        iBaseDato.update(obj);
    }
   
    public void delete(Object obj) throws SQLException {
         if (obj instanceof ClienteDTO) {
            iBaseDato = new ClienteDAO();
            
        }
          
          if(obj instanceof ArticuloDTO)
        {
            iBaseDato = new ArticuloDAO();
        }
        
        if(obj instanceof ArticuloPorProveedorDTO)
        {
            iBaseDato = new ArticuloPorProveedorDAO();
        }
        if (obj instanceof ComputadoraDTO) 
        {
            iBaseDato = new ComputadoraDAO();
        }
        if (obj instanceof FacturaDTO) 
        {
            iBaseDato = new FacturaDAO();
        }
        if (obj instanceof ProveedorDTO) 
        {
            iBaseDato = new ProveedorDAO();
        }
        
        if (obj instanceof UsuarioDTO) 
        {
            iBaseDato = new UsuarioDAO();
        }
        iBaseDato.delete(obj);
    }
    
    public Object obtenerPorId(Object obj) throws SQLException {
         if (obj instanceof ClienteDTO) {
            iBaseDato = new ClienteDAO();
            
        }
         
          if(obj instanceof ArticuloDTO)
        {
            iBaseDato = new ArticuloDAO();
        }
        
        if(obj instanceof ArticuloPorProveedorDTO)
        {
            iBaseDato = new ArticuloPorProveedorDAO();
        }
        if (obj instanceof ComputadoraDTO) 
        {
            iBaseDato = new ComputadoraDAO();
        }
        if (obj instanceof FacturaDTO) 
        {
            iBaseDato = new FacturaDAO();
        }
        if (obj instanceof ProveedorDTO) 
        {
            iBaseDato = new ProveedorDAO();
        }
         
        if (obj instanceof UsuarioDTO) 
        {
            iBaseDato = new UsuarioDAO();
        }
        return iBaseDato.obtenerPorId(obj);
    }
   
    public ArrayList readAll(Object obj)  throws SQLException {
         if (obj instanceof ClienteDTO) {
            iBaseDato = new ClienteDAO();
            
        }
         
          if(obj instanceof ArticuloDTO)
        {
            iBaseDato = new ArticuloDAO();
        }
        
        if(obj instanceof ArticuloPorProveedorDTO)
        {
            iBaseDato = new ArticuloPorProveedorDAO();
        }
        if (obj instanceof ComputadoraDTO) 
        {
            iBaseDato = new ComputadoraDAO();
        }
        if (obj instanceof FacturaDTO) 
        {
            iBaseDato = new FacturaDAO();
        }
        if (obj instanceof ProveedorDTO) 
        {
            iBaseDato = new ProveedorDAO();
        }
       
        if (obj instanceof UsuarioDTO) 
        {
            iBaseDato = new UsuarioDAO();
        }
        return iBaseDato.readAll();
    }
    
    public ArrayList obtenerConWhere (Object obj, String where)  throws SQLException {
         if (obj instanceof ClienteDTO) {
            iBaseDato = new ClienteDAO();
            
        }
         
          if(obj instanceof ArticuloDTO)
        {
            iBaseDato = new ArticuloDAO();
        }
        
        if(obj instanceof ArticuloPorProveedorDTO)
        {
            iBaseDato = new ArticuloPorProveedorDAO();
        }
        if (obj instanceof ComputadoraDTO) 
        {
            iBaseDato = new ComputadoraDAO();
        }
        if (obj instanceof FacturaDTO) 
        {
            iBaseDato = new FacturaDAO();
        }
        if (obj instanceof ProveedorDTO) 
        {
            iBaseDato = new ProveedorDAO();
        }
      
        if (obj instanceof UsuarioDTO) 
        {
            iBaseDato = new UsuarioDAO();
        }
        return iBaseDato.obtenerConWhere(where);
    }
}
