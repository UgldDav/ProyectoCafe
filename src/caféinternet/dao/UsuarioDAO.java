/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caféinternet.dao;
import caféinternet.dto.UsuarioDTO;
import caféinternet.interfaces.IBaseDao;
import java.sql.*;
import caféinternet.conexion.Conector;
import java.util.ArrayList;
/**
 *
 * @author David
 */
public class UsuarioDAO implements IBaseDao<UsuarioDTO>{
   private static final String SQL_INSERT = " INSERT INTO usuario (PK_IdUsuario,NombreCompleto,Contraseña,ultUsuario,ultFecha) VALUES(?,?,?,?,curdate())";
   private static final String SQL_UPDATE = "UPDATE usuario SET NombreCompleto = ? , Contraseña = ? , ultUsuario = ? ,ultFecha = curdate() WHERE PK_IdUsuario = ?";
   private static final String SQL_DELETE = "DELETE FROM usuario WHERE PK_IdUsuario = ?";
   private static final String SQL_READALL = "SELECT * FROM usuario ";
   private static final String SQL_OBTENERPORID = "SELECT * FROM usuario WHERE PK_IdUsuario = ?";
   private static final String SQL_OBTENERCONQHERE = "SELECT * FROM usuario ";
   private final Conector Con;

    public UsuarioDAO() {
        Con= new Conector();
    }

    @Override
    public boolean insert(UsuarioDTO obj) throws SQLException {
        PreparedStatement ps;
        
        try {
            
            ps= Con.getCon().prepareStatement(SQL_INSERT);
            ps.setInt(1, obj.getPK_IdUsuario());            
            ps.setString(2, obj.getNombreCompleto());
            ps.setString(3,obj.getContraseña());
            ps.setString(4,obj.getUltUsuario());
            
            if(ps.executeUpdate() > 0)
            {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
        }
        
        finally
        {
            Con.cerrarConexion();
        }
        
        return false;
    }

    @Override
    public boolean update(UsuarioDTO obj) throws SQLException {
        PreparedStatement ps;
        
        try {

            ps= Con.getCon().prepareStatement(SQL_UPDATE);
           
            ps.setString(1, obj.getNombreCompleto());
             ps.setString(2,obj.getContraseña());
            ps.setString(3, obj.getUltUsuario());
            ps.setInt(4,obj.getPK_IdUsuario());
         
            
            if(ps.executeUpdate() >0)
            {
                return true;
            }
           
            
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
        }
        finally 
        {
            Con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean delete(UsuarioDTO key) throws SQLException {
        PreparedStatement ps;
        
        try {
            ps=Con.getCon().prepareStatement(SQL_DELETE);
            ps.setInt(1, key.getPK_IdUsuario());
            
            if(ps.executeUpdate()>0)
            {
                return true;
            }
            
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
        }
        
        finally
        {
            Con.cerrarConexion();
        }
        return false;
    }

    @Override
    public ArrayList<UsuarioDTO> readAll() throws SQLException {
     ArrayList<UsuarioDTO> l= new ArrayList();
     PreparedStatement ps;
     ResultSet res;
     
        try {
            ps=Con.getCon().prepareStatement(SQL_READALL);
            res= ps.executeQuery();
            
            while(res.next())
            {
                UsuarioDTO c = new UsuarioDTO();
                c.setPK_IdUsuario(res.getInt("PK_IdUsuario"));
                c.setContraseña(res.getString("Contraseña"));
                c.setNombreCompleto(res.getString("NombreCompleto"));
                c.setUltUsuario(res.getString("ultUsuario"));
                
                l.add(c);
                
                
            }
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
            return null;
        }
        
        finally{
        Con.cerrarConexion();
        }
        return l;
    }

    @Override
    public UsuarioDTO obtenerPorId(UsuarioDTO ar) throws SQLException {
        UsuarioDTO l = null; 
        PreparedStatement ps;
        ResultSet res;
        
        
        try{
        ps=Con.getCon().prepareCall(SQL_OBTENERPORID);
        ps.setInt(1,ar.getPK_IdUsuario());
        res= ps.executeQuery();
        
        while(res.next())
        {
            l= new UsuarioDTO();
                    l.setPK_IdUsuario(res.getInt("PK_IdUsuario"));
                    l.setNombreCompleto(res.getString("NombreCompleto"));
                    l.setContraseña(res.getString("Contraseña"));
                    l.setUltUsuario(res.getString("ultUsuario"));
                    
                    
        }
        }
        
        catch(Exception e)
        {
            System.out.println("Error"+e.getMessage());
        }
        
        finally 
        {
            Con.cerrarConexion();
        }
        return l;
    }

    @Override
    public ArrayList<UsuarioDTO> obtenerConWhere(String where) throws SQLException {
      ArrayList<UsuarioDTO> l= new ArrayList();
     PreparedStatement ps;
     ResultSet res;
     
        try {
            ps=Con.getCon().prepareStatement((SQL_OBTENERCONQHERE)+where);
            res= ps.executeQuery();
            
            while(res.next())
            {
                UsuarioDTO c = new UsuarioDTO();
                c.setPK_IdUsuario(res.getInt("PK_IdUsuario"));
                c.setContraseña(res.getString("Contraseña"));
                c.setNombreCompleto(res.getString("NombreCompleto"));
                c.setUltUsuario(res.getString("ultUsuario"));
                
                l.add(c);
                
                
            } 
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
            return null;
        }
        
        finally{
        Con.cerrarConexion();
        }
        return l;
    } 
}
