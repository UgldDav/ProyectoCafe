/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caféinternet.dao;
import java.sql.*;
import caféinternet.conexion.Conector;
import java.util.ArrayList;
import caféinternet.dto.ComputadoraDTO;
import caféinternet.interfaces.IBaseDao;
/**
 *
 * @author David
 */
public class ComputadoraDAO implements IBaseDao<ComputadoraDTO>{
    private static final String SQL_INSERT = " INSERT INTO computadora (PK_IdComputadora,estado,ultUsuario,ultFecha) VALUES(?,?,?,curdate())";
   private static final String SQL_UPDATE = "UPDATE computadora SET estado = ?,ultUsuario = ?,ultFecha = curdate() WHERE PK_IdCliente = ?";
   private static final String SQL_DELETE = "DELETE FROM computadora WHERE PK_IdCliente = ?";
   private static final String SQL_READALL = "SELECT * FROM computadora ";
   private static final String SQL_OBTENERPORID = "SELECT * FROM computadora WHERE PK_IdCliente = ?";
   private static final String SQL_OBTENERCONQHERE = "SELECT * FROM computadora ";
   private final Conector Con;

    public ComputadoraDAO() {
        Con= new Conector();
    }

    @Override
    public boolean insert(ComputadoraDTO obj) throws SQLException {
        PreparedStatement ps;
        
        try {
            
            ps= Con.getCon().prepareStatement(SQL_INSERT);
            ps.setInt(1, obj.getPK_IdComputadora());            
            ps.setInt(2,obj.getEstado());
            ps.setString(3,obj.getUltUsuario());
            
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
    public boolean update(ComputadoraDTO obj) throws SQLException {
        PreparedStatement ps;
        
        try {

            ps= Con.getCon().prepareStatement(SQL_UPDATE);
            ps.setInt(1,obj.getEstado());
            ps.setString(2, obj.getUltUsuario());
            ps.setInt(3, obj.getPK_IdComputadora());
            
            
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
    public boolean delete(ComputadoraDTO key) throws SQLException {
        PreparedStatement ps;
        
        try {
            ps=Con.getCon().prepareStatement(SQL_DELETE);
            ps.setInt(1, key.getPK_IdComputadora());
            
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
    public ArrayList<ComputadoraDTO> readAll() throws SQLException {
     ArrayList<ComputadoraDTO> l= new ArrayList();
     PreparedStatement ps;
     ResultSet res;
     
        try {
            ps=Con.getCon().prepareStatement(SQL_READALL);
            res= ps.executeQuery();
            
            while(res.next())
            {
                ComputadoraDTO c = new ComputadoraDTO();
                c.setPK_IdComputadora(res.getInt("PK_IdComputadora"));
                c.setEstado(res.getInt("estado"));
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
    public ComputadoraDTO obtenerPorId(ComputadoraDTO ar) throws SQLException {
           PreparedStatement ps;
        ResultSet res;
        ComputadoraDTO l = null;
        
        try{
        ps=Con.getCon().prepareCall(SQL_OBTENERPORID);
        ps.setInt(1,ar.getPK_IdComputadora());
        res= ps.executeQuery();
        
        while(res.next())
        {
            l= new ComputadoraDTO(res.getInt(1),res.getInt(2),res.getString(3),res.getString(4));
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
    public ArrayList<ComputadoraDTO> obtenerConWhere(String where) throws SQLException {
      ArrayList<ComputadoraDTO> l= new ArrayList();
     PreparedStatement ps;
     ResultSet res;
     
        try {
            ps=Con.getCon().prepareStatement((SQL_OBTENERCONQHERE)+where);
            res= ps.executeQuery();
            
            while(res.next())
            {
                ComputadoraDTO c = new ComputadoraDTO();
                c.setPK_IdComputadora(res.getInt("PK_IdComputadora"));
                c.setEstado(res.getInt("estado"));
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
