/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caféinternet.bl;

import caféinternet.interfaces.IBaseBL;
import caféinternet.dao.GenericDAO;
import caféinternet.dto.ProveedorDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class ProveedorBL implements IBaseBL<ProveedorDTO> {
    private GenericDAO PDao;
  public ProveedorBL() {
        PDao=new GenericDAO();
    }

    @Override
    public void insert(ProveedorDTO obj) throws SQLException {
        this.PDao.insert(obj);
    }

    @Override
    public void update(ProveedorDTO obj) throws SQLException {
        this.PDao.update(obj);
    }

    @Override
    public void delete(ProveedorDTO key) throws SQLException {
        this.PDao.delete(key);
    }

    @Override
    public ArrayList<ProveedorDTO> readAll() throws SQLException {
        return this.PDao.readAll(new ProveedorDTO());
    }

    @Override
    public ProveedorDTO obtenerPorId(ProveedorDTO obj) throws SQLException {
     return (ProveedorDTO)this.PDao.obtenerPorId(obj);
    }


    public ArrayList<ProveedorDTO> obtenerConWhere(ProveedorDTO obj,String where) throws SQLException {
        return this.PDao.obtenerConWhere(obj, where);
    }
}
