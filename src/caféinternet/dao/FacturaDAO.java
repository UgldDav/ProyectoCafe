/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caféinternet.dao;
import java.sql.*;
import caféinternet.conexion.Conector;
import java.util.ArrayList;
import caféinternet.dto.FacturaDTO;
import caféinternet.interfaces.IBaseDao;
/**
 *
 * @author David
 */
public class FacturaDAO implements IBaseDao<FacturaDTO>{
       private static final String SQL_INSERT = " INSERT INTO factura (PK_IdFactura,FK_PK_IdCliente,Fecha,ultUsuario,ultFecha) VALUES(?,?,?,?,curdate())";
   private static final String SQL_UPDATE = "UPDATE factura SET FK-PK_IdCliente = ?,Fecha = ?, ultUsuario = ? WHERE PK_IdFactura = ?";
   private static final String SQL_DELETE = "DELETE FROM factura WHERE PK_IdFactura = ?";
   private static final String SQL_READALL = "SELECT * FROM factura ";
   private static final String SQL_OBTENERPORID = "SELECT * FROM factura WHERE PK_IdFactura = ?";
   private static final String SQL_OBTENERCONQHERE = "SELECT * FROM factura ";
   private final Conector Con;

    public FacturaDAO() {
        Con= new Conector();
    }

    @Override
    public boolean insert(FacturaDTO obj) throws SQLException {
        PreparedStatement ps;
        
        try {
            ps= Con.getCon().prepareStatement(SQL_INSERT);
            ps.setInt(1, obj.getPK_IdFactura());
            ps.setInt(2, obj.getFK_PK_IdCliente());
            ps.setString(3, obj.getFecha());
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
    public boolean update(FacturaDTO obj) throws SQLException {
        PreparedStatement ps;
        
        try {
            ps= Con.getCon().prepareStatement(SQL_UPDATE);
            ps.setInt(1, obj.getFK_PK_IdCliente());
            ps.setString(2,obj.getFecha());
            ps.setString(3,obj.getUltUsuario());
            ps.setInt(4, obj.getPK_IdFactura());
            
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
    public boolean delete(FacturaDTO key) throws SQLException {
        PreparedStatement ps;
        
        try {
            ps=Con.getCon().prepareStatement(SQL_DELETE);
            ps.setInt(1, key.getPK_IdFactura());
            
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
    public ArrayList<FacturaDTO> readAll() throws SQLException {
     ArrayList<FacturaDTO> l= new ArrayList();
     PreparedStatement ps;
     ResultSet res;
     
        try {
            ps=Con.getCon().prepareStatement(SQL_READALL);
            res= ps.executeQuery();
            
            while(res.next())
            {
                FacturaDTO c = new FacturaDTO();
                c.setPK_IdFactura(res.getInt("PK_IdFactura"));
                c.setFK_PK_IdCliente(res.getInt("FK_PK_IdCliente"));
                c.setFecha(res.getString("Fecha"));
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
    public FacturaDTO obtenerPorId(FacturaDTO ar) throws SQLException {
           PreparedStatement ps;
        ResultSet res;
        FacturaDTO l = null;
        
        try{
        ps=Con.getCon().prepareCall(SQL_OBTENERPORID);
        ps.setInt(1,ar.getPK_IdFactura());
        res= ps.executeQuery();
        
        while(res.next())
        {
            l= new FacturaDTO(res.getInt(1),res.getInt(2),res.getString(3),res.getString(4),res.getString(5));
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
    public ArrayList<FacturaDTO> obtenerConWhere(String where) throws SQLException {
      ArrayList<FacturaDTO> l= new ArrayList();
     PreparedStatement ps;
     ResultSet res;
     
        try {
            ps=Con.getCon().prepareStatement((SQL_OBTENERCONQHERE)+where);
            res= ps.executeQuery();
            
            while(res.next())
            {
                FacturaDTO c = new FacturaDTO();
                c.setPK_IdFactura(res.getInt("PK_IdFactura"));
                c.setFK_PK_IdCliente(res.getInt("FK_PK_IdCliente"));
                c.setFecha(res.getString("Fecha"));
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
