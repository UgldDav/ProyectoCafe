/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caféinternet.dao;
import java.sql.*;
import caféinternet.conexion.Conector;
import java.util.ArrayList;
import caféinternet.dto.ProveedorDTO;
import caféinternet.interfaces.IBaseDao;
/**
 *
 * @author David
 */
public class ProveedorDAO implements IBaseDao<ProveedorDTO>{
   private static final String SQL_INSERT = " INSERT INTO proveedor (PK_IdProveedor,Nombre,Direccion,Telefono,Correo,ultUsuario,ultFecha) VALUES(?,?,?,?,?,?,curdate())";
   private static final String SQL_UPDATE = "UPDATE proveedor SET Nombre = ?,Direccion = ?,Telefono = ?,Correo = ?, ultUsuario = ?, ultFecha = curdate() WHERE PK_IdProveedor = ?";
   private static final String SQL_DELETE = "DELETE FROM proveedor WHERE PK_IdProveedor = ?";
   private static final String SQL_READALL = "SELECT * FROM proveedor ";
   private static final String SQL_OBTENERPORID = "SELECT * FROM proveedor WHERE PK_IdProveedor = ?";
   private static final String SQL_OBTENERCONQHERE = "SELECT * FROM proveedor ";
   private final Conector Con;

    public ProveedorDAO() {
        Con= new Conector();
    }

    @Override
    public boolean insert(ProveedorDTO obj) throws SQLException {
        PreparedStatement ps;
        
        try {
            ps= Con.getCon().prepareStatement(SQL_INSERT);
            ps.setInt(1, obj.getPK_IdProveedor());
            ps.setString(2, obj.getNombre());
            ps.setString(3, obj.getDireccion());
            ps.setInt(4, obj.getTelefono());
            ps.setString(5,obj.getCorreo());
            ps.setString(6,obj.getUltUsuario());
            
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
    public boolean update(ProveedorDTO obj) throws SQLException {
        PreparedStatement ps;
        
        try {
            ps= Con.getCon().prepareStatement(SQL_UPDATE);
            ps.setString(1, obj.getNombre());
            ps.setString(2,obj.getDireccion());
             ps.setInt(3, obj.getTelefono());
            ps.setString(4,obj.getCorreo());
            ps.setString(5,obj.getUltUsuario());
            ps.setInt(6,obj.getPK_IdProveedor());
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
    public boolean delete(ProveedorDTO key) throws SQLException {
        PreparedStatement ps;
        
        try {
            ps=Con.getCon().prepareStatement(SQL_DELETE);
            ps.setInt(1, key.getPK_IdProveedor());
            
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
    public ArrayList<ProveedorDTO> readAll() throws SQLException {
     ArrayList<ProveedorDTO> l= new ArrayList();
     PreparedStatement ps;
     ResultSet res;
     
        try {
            ps=Con.getCon().prepareStatement(SQL_READALL);
            res= ps.executeQuery();
            
            while(res.next())
            {
                ProveedorDTO c = new ProveedorDTO();
                c.setPK_IdProveedor(res.getInt("PK_IdProveedor"));
                c.setNombre(res.getString("Nombre"));
                c.setDireccion(res.getString("Direccion"));
                c.setTelefono(res.getInt("Telefono"));
                c.setCorreo(res.getString("Correo"));
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
    public ProveedorDTO obtenerPorId(ProveedorDTO ar) throws SQLException {
           PreparedStatement ps;
        ResultSet res;
        ProveedorDTO l = null;
        
        try{
        ps=Con.getCon().prepareCall(SQL_OBTENERPORID);
        ps.setInt(1,ar.getPK_IdProveedor());
        res= ps.executeQuery();
        
        while(res.next())
        {
            l= new ProveedorDTO(res.getInt(1),res.getString(2),res.getString(3),res.getInt(4),res.getString(5),res.getString(6),res.getString(7));
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
    public ArrayList<ProveedorDTO> obtenerConWhere(String where) throws SQLException {
      ArrayList<ProveedorDTO> l= new ArrayList();
     PreparedStatement ps;
     ResultSet res;
     
        try {
            ps=Con.getCon().prepareStatement((SQL_OBTENERCONQHERE)+where);
            res= ps.executeQuery();
            
            while(res.next())
            {
                ProveedorDTO c = new ProveedorDTO();
                c.setPK_IdProveedor(res.getInt("PK_IdProveedor"));
                c.setNombre(res.getString("Nombre"));
                c.setDireccion(res.getString("Direccion"));
                c.setTelefono(res.getInt("Telefono"));
                c.setCorreo(res.getString("Correo"));
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
