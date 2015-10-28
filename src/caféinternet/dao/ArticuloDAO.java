/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caféinternet.dao;
import java.sql.*;
import caféinternet.conexion.Conector;
import java.util.ArrayList;
import caféinternet.dto.ArticuloDTO;
import caféinternet.interfaces.IBaseDao;
/**
 *
 * @author David
 */
public class ArticuloDAO implements IBaseDao<ArticuloDTO>{
   private static final String SQL_INSERT = " INSERT INTO articulo (PK_IdArticulo,Nombre,Descripcion,Cantidad,PrecioUnitario,ultUsuario,ultFecha) VALUES(?,?,?,?,?,?,curdate())";
   private static final String SQL_UPDATE = "UPDATE articulo SET Nombre = ?, Descripcion = ?,Cantidad = ?,PrecioUnitario = ?,ultUsuario = ?,ultFecha = curdate() WHERE PK_IdArticulo = ?";
   private static final String SQL_DELETE = "DELETE FROM articulo WHERE PK_IdArticulo = ?";
   private static final String SQL_READALL = "SELECT * FROM articulo ";
   private static final String SQL_OBTENERPORID = "SELECT * FROM articulo WHERE PK_IdArticulo = ?";
   private static final String SQL_OBTENERCONQHERE = "SELECT * FROM articulo ";
   private final Conector Con;

    public ArticuloDAO() {
        Con= new Conector();
    }

    @Override
    public boolean insert(ArticuloDTO obj) throws SQLException {
        PreparedStatement ps;
        
        try {
            ps= Con.getCon().prepareStatement(SQL_INSERT);
            ps.setInt(1, obj.getPK_IdArticulo());
            ps.setString(2, obj.getNombre());
            ps.setString(3,obj.getDescripcion());
            ps.setInt(4, obj.getCantidad());
            ps.setDouble(5,obj.getPrecioUnitario());            
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
    public boolean update(ArticuloDTO obj) throws SQLException {
        PreparedStatement ps;
        
        try {
            ps= Con.getCon().prepareStatement(SQL_UPDATE);
            ps.setString(1, obj.getNombre());
            ps.setString(2,obj.getDescripcion());
            ps.setInt(3, obj.getCantidad());
            ps.setDouble(4,obj.getPrecioUnitario());            
            ps.setString(5,obj.getUltUsuario());
            ps.setInt(6, obj.getPK_IdArticulo());
            
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
    public boolean delete(ArticuloDTO key) throws SQLException {
        PreparedStatement ps;
        
        try {
            ps=Con.getCon().prepareStatement(SQL_DELETE);
            ps.setInt(1, key.getPK_IdArticulo());
            
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
    public ArrayList<ArticuloDTO> readAll() throws SQLException {
     ArrayList<ArticuloDTO> l= new ArrayList();
     PreparedStatement ps;
     ResultSet res;
     
        try {
            ps=Con.getCon().prepareStatement(SQL_READALL);
            res= ps.executeQuery();
            
            while(res.next())
            {
                ArticuloDTO c = new ArticuloDTO();
                c.setPK_IdArticulo(res.getInt("PK_IdArticulo"));
                c.setNombre(res.getString("Nombre"));
                c.setDescripcion(res.getString ("Descripcion"));
                c.setCantidad(res.getInt("Cantidad"));
                c.setPrecioUnitario(res.getDouble("PrecioUnitario"));
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
    public ArticuloDTO obtenerPorId(ArticuloDTO ar) throws SQLException {
           PreparedStatement ps;
        ResultSet res;
        ArticuloDTO l = null;
        
        try{
        ps=Con.getCon().prepareCall(SQL_OBTENERPORID);
        ps.setInt(1,ar.getPK_IdArticulo());
        res= ps.executeQuery();
        
        while(res.next())
        {
            l= new ArticuloDTO(res.getInt(1),res.getString(2),res.getString(3),
                              res.getInt(4),res.getDouble(5),res.getString(6),
                              res.getString(7));
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
    public ArrayList<ArticuloDTO> obtenerConWhere(String where) throws SQLException {
      ArrayList<ArticuloDTO> l= new ArrayList();
     PreparedStatement ps;
     ResultSet res;
     
        try {
            ps=Con.getCon().prepareStatement((SQL_OBTENERCONQHERE)+where);
            res= ps.executeQuery();
            
            while(res.next())
            {
                 ArticuloDTO c = new ArticuloDTO();
                c.setPK_IdArticulo(res.getInt("PK_IdArticulo"));
                c.setNombre(res.getString("Nombre"));
                c.setDescripcion(res.getString ("Descripcion"));
                c.setCantidad(res.getInt("Cantidad"));
                c.setPrecioUnitario(res.getDouble("PrecioUnitario"));
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
