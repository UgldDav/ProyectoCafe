/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caféinternet.dao;
import caféinternet.interfaces.IBaseDao;
import caféinternet.dto.ArticuloPorProveedorDTO;
import caféinternet.conexion.Conector;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author David
 */
public class ArticuloPorProveedorDAO implements  IBaseDao<ArticuloPorProveedorDTO>{
   private static final String SQL_INSERT = " INSERT INTO articuloproveedor (FK_PK_IdArticulo,FK_PK_IdProveedor,ultUsuario,ultFecha) VALUES(?,?,?,curdate())";
   private static final String SQL_UPDATE = "UPDATE articuloproveedor SET FK_PK_IdArticulo = ?,ultUsuario = ?,ultFecha = curdate() WHERE FK_PK_IdProveedor = ?";
   private static final String SQL_DELETE = "DELETE FROM articuloproveedor WHERE FK_PK_IdProveedor = ? AND FK_PK_IdArticulo = ?";
   private static final String SQL_READALL = "SELECT * FROM articuloproveedor ";
   private static final String SQL_OBTENERPORID = "SELECT * FROM articuloproveedor WHERE FK_PK_IdProveedor = ? AND FK_PK_IdArticulo = ?";
   private static final String SQL_OBTENERCONQHERE = "SELECT * FROM articuloproveedor ";
   private final Conector Con;

    public ArticuloPorProveedorDAO() {
        Con= new Conector();
    }

    @Override
    public boolean insert(ArticuloPorProveedorDTO obj) throws SQLException {
        PreparedStatement ps;
        
        try {
            
            ps= Con.getCon().prepareStatement(SQL_INSERT);
            ps.setInt(1, obj.getFK_PK_IdArticulo());            
            ps.setInt(2,obj.getFK_PK_IdProveedor());
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
    public boolean update(ArticuloPorProveedorDTO obj) throws SQLException {
        PreparedStatement ps;
        
        try {

            ps= Con.getCon().prepareStatement(SQL_UPDATE);
            ps.setInt(1,obj.getFK_PK_IdArticulo());
            ps.setString(2, obj.getUltUsuario());
            ps.setInt(3, obj.getFK_PK_IdProveedor());
            
            
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
    public boolean delete(ArticuloPorProveedorDTO key) throws SQLException {
        PreparedStatement ps;
        
        try {
            ps=Con.getCon().prepareStatement(SQL_DELETE);
            ps.setInt(1, key.getFK_PK_IdProveedor());
            ps.setInt(2,key.getFK_PK_IdArticulo());
            
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
    public ArrayList<ArticuloPorProveedorDTO> readAll() throws SQLException {
     ArrayList<ArticuloPorProveedorDTO> l= new ArrayList();
     PreparedStatement ps;
     ResultSet res;
     
        try {
            ps=Con.getCon().prepareStatement(SQL_READALL);
            res= ps.executeQuery();
            
            while(res.next())
            {
                ArticuloPorProveedorDTO c = new ArticuloPorProveedorDTO();
                c.setFK_PK_IdArticulo(res.getInt("FK_PK_IdArticulo"));
                c.setFK_PK_IdProveedor(res.getInt("FK_PK_IdProveedor"));
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
    public ArticuloPorProveedorDTO obtenerPorId(ArticuloPorProveedorDTO ar) throws SQLException {
           PreparedStatement ps;
        ResultSet res;
        ArticuloPorProveedorDTO l = null;
        
        try{
        ps=Con.getCon().prepareCall(SQL_OBTENERPORID);
        ps.setInt(1,ar.getFK_PK_IdProveedor());
        ps.setInt(2, ar.getFK_PK_IdArticulo());
        res= ps.executeQuery();
        
        while(res.next())
        {
            l= new ArticuloPorProveedorDTO(res.getInt(1),res.getInt(2),res.getString(3),res.getString(4));
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
    public ArrayList<ArticuloPorProveedorDTO> obtenerConWhere(String where) throws SQLException {
      ArrayList<ArticuloPorProveedorDTO> l= new ArrayList();
     PreparedStatement ps;
     ResultSet res;
     
        try {
            ps=Con.getCon().prepareStatement((SQL_OBTENERCONQHERE)+where);
            res= ps.executeQuery();
            
            while(res.next())
            {
                ArticuloPorProveedorDTO c = new ArticuloPorProveedorDTO();
                c.setFK_PK_IdArticulo(res.getInt("FK_PK_IdArticulo"));
                c.setFK_PK_IdProveedor(res.getInt("FK_PK_IdProveedor"));
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
