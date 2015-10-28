/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caféinternet.dao;
import java.sql.*;
import caféinternet.conexion.Conector;
import java.util.ArrayList;
import caféinternet.dto.ClienteDTO;
import caféinternet.interfaces.IBaseDao;
/**
 *
 * @author David
 */
public class ClienteDAO implements IBaseDao<ClienteDTO>{
   private static final String SQL_INSERT = " INSERT INTO cliente (PK_IdCliente,Nombre,Apellidos,FechaNacimiento,Direccion,Telefono,Observaciones,ultUsuario,ultFecha) VALUES(?,?,?,?,?,?,?,?,curdate())";
   private static final String SQL_UPDATE = "UPDATE cliente SET Nombre = ?, Apellidos = ?,FechaNacimiento = ?,Direccion = ?,Telefono = ?,Observaciones = ?,ultUsuario = ?,ultFecha = curdate() WHERE PK_IdCliente = ?";
   private static final String SQL_DELETE = "DELETE FROM cliente WHERE PK_IdCliente = ?";
   private static final String SQL_READALL = "SELECT * FROM cliente ";
   private static final String SQL_OBTENERPORID = "SELECT * FROM cliente WHERE PK_IdCliente = ?";
   private static final String SQL_OBTENERCONQHERE = "SELECT * FROM cliente ";
   private final Conector Con;

    public ClienteDAO() {
        Con= new Conector();
    }

    @Override
    public boolean insert(ClienteDTO obj) throws SQLException {
        PreparedStatement ps;
        
        try {
            ps= Con.getCon().prepareStatement(SQL_INSERT);
            ps.setInt(1, obj.getPK_IdCliente());
            ps.setString(2, obj.getNombre());
            ps.setString(3, obj.getApellidos());
            ps.setString(4,obj.getFechaNacimiento());
            ps.setString(5,obj.getDireccion());
            ps.setInt(6, obj.getTelefono());
            ps.setString(7,obj.getObservaciones());            
            ps.setString(8,obj.getUltUsuario());
            
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
    public boolean update(ClienteDTO obj) throws SQLException {
        PreparedStatement ps;
        
        try {
            ps= Con.getCon().prepareStatement(SQL_UPDATE);
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getApellidos());
            ps.setString(3, obj.getFechaNacimiento());
            ps.setString(4, obj.getDireccion());
            ps.setInt(5,obj.getTelefono());
            ps.setString(6, obj.getObservaciones());
            ps.setString(7,obj.getUltUsuario());
            ps.setInt(8, obj.getPK_IdCliente());
            
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
    public boolean delete(ClienteDTO key) throws SQLException {
        PreparedStatement ps;
        
        try {
            ps=Con.getCon().prepareStatement(SQL_DELETE);
            ps.setInt(1, key.getPK_IdCliente());
            
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
    public ArrayList<ClienteDTO> readAll() throws SQLException {
     ArrayList<ClienteDTO> l= new ArrayList();
     PreparedStatement ps;
     ResultSet res;
     
        try {
            ps=Con.getCon().prepareStatement(SQL_READALL);
            res= ps.executeQuery();
            
            while(res.next())
            {
                ClienteDTO c = new ClienteDTO();
                c.setPK_IdCliente(res.getInt("PK_IdCliente"));
                c.setNombre(res.getString("Nombre"));
                c.setApellidos(res.getString ("Apellidos"));
                c.setFechaNacimiento(res.getString("FechaNacimiento"));
                c.setDireccion(res.getString("Direccion"));
                c.setObservaciones(res.getString("Observaciones"));
                c.setTelefono(res.getInt("Telefono")); 
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
    public ClienteDTO obtenerPorId(ClienteDTO ar) throws SQLException {
           PreparedStatement ps;
        ResultSet res;
        ClienteDTO l = null;
        
        try{
        ps=Con.getCon().prepareCall(SQL_OBTENERPORID);
        ps.setInt(1,ar.getPK_IdCliente());
        res= ps.executeQuery();
        
        while(res.next())
        {
           
            l= new ClienteDTO(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getInt(6), res.getString(7),res.getString(8),res.getString(9)); 
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
    public ArrayList<ClienteDTO> obtenerConWhere(String where) throws SQLException {
      ArrayList<ClienteDTO> l= new ArrayList();
     PreparedStatement ps;
     ResultSet res;
     
        try {
            ps=Con.getCon().prepareStatement((SQL_OBTENERCONQHERE)+where);
            res= ps.executeQuery();
            
            while(res.next())
            {
                ClienteDTO c = new ClienteDTO();
                c.setPK_IdCliente(res.getInt("PK_IdCliente"));
                c.setNombre(res.getString("Nombre"));
                c.setApellidos(res.getString ("Apellidos"));
                c.setFechaNacimiento(res.getString("FechaNacimiento"));
                c.setDireccion(res.getString("Direccion"));
                c.setTelefono(res.getInt("Telefono")); 
                c.setObservaciones(res.getString("Observaciones"));
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
