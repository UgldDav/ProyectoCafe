/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caféinternet.bl;

import caféinternet.interfaces.IBaseBL;
import caféinternet.dao.GenericDAO;
import caféinternet.dto.FacturaDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class FacturaBL implements IBaseBL<FacturaDTO> {
private GenericDAO FDao;
    public FacturaBL() {
        FDao=new GenericDAO();
    }

    @Override
    public void insert(FacturaDTO obj) throws SQLException {
        this.FDao.insert(obj);
    }

    @Override
    public void update(FacturaDTO obj) throws SQLException {
        this.FDao.update(obj);
    }

    @Override
    public void delete(FacturaDTO key) throws SQLException {
        this.FDao.delete(key);
    }

    @Override
    public ArrayList<FacturaDTO> readAll() throws SQLException {
        return this.FDao.readAll(new FacturaDTO());
    }

    @Override
    public FacturaDTO obtenerPorId(FacturaDTO obj) throws SQLException {
     return (FacturaDTO)this.FDao.obtenerPorId(obj);
    }


    public ArrayList<FacturaDTO> obtenerConWhere(FacturaDTO obj,String where) throws SQLException {
        return this.FDao.obtenerConWhere(obj, where);
    }
}
