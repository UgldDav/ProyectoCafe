/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caféinternet.bl;
import caféinternet.interfaces.IBaseBL;
import caféinternet.dao.GenericDAO;
import caféinternet.dto.UsuarioDTO;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author David
 */
public class UsuarioBL implements IBaseBL<UsuarioDTO>{
    private GenericDAO UDao;
  public UsuarioBL() {
        UDao=new GenericDAO();
    }

    @Override
    public void insert(UsuarioDTO obj) throws SQLException {
        this.UDao.insert(obj);
    }

    @Override
    public void update(UsuarioDTO obj) throws SQLException {
        this.UDao.update(obj);
    }

    @Override
    public void delete(UsuarioDTO key) throws SQLException {
        this.UDao.delete(key);
    }

    @Override
    public ArrayList<UsuarioDTO> readAll() throws SQLException {
        return this.UDao.readAll(new UsuarioDTO());
    }

    @Override
    public UsuarioDTO obtenerPorId(UsuarioDTO obj) throws SQLException {
     return (UsuarioDTO)this.UDao.obtenerPorId(obj);
    }


    public ArrayList<UsuarioDTO> obtenerConWhere(UsuarioDTO obj,String where) throws SQLException {
        return this.UDao.obtenerConWhere(obj, where);
    }
    
}
