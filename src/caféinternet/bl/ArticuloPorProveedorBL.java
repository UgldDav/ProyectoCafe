/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caféinternet.bl;
import caféinternet.dao.GenericDAO;
import caféinternet.interfaces.IBaseBL;
import caféinternet.dto.ArticuloPorProveedorDTO;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author David
 */
public class ArticuloPorProveedorBL implements IBaseBL<ArticuloPorProveedorDTO>{
        private GenericDAO DDao;

    public ArticuloPorProveedorBL() {
        this.DDao= new GenericDAO();
    }

    @Override
    public void insert(ArticuloPorProveedorDTO obj) throws SQLException {
        this.DDao.insert(obj);
    }

    @Override
    public void update(ArticuloPorProveedorDTO obj) throws SQLException {
        this.DDao.update(obj);
    }

    @Override
    public void delete(ArticuloPorProveedorDTO key) throws SQLException {
        this.DDao.delete(key);
    }

    @Override
    public ArrayList<ArticuloPorProveedorDTO> readAll() throws SQLException {
        return this.DDao.readAll(new ArticuloPorProveedorDTO());
    }

    @Override
    public ArticuloPorProveedorDTO obtenerPorId(ArticuloPorProveedorDTO obj) throws SQLException {
     return (ArticuloPorProveedorDTO)this.DDao.obtenerPorId(obj);
    }


    public ArrayList<ArticuloPorProveedorDTO> obtenerConWhere(ArticuloPorProveedorDTO obj,String where) throws SQLException {
        return this.DDao.obtenerConWhere(obj, where);
    }
}
