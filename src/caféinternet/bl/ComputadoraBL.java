/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caféinternet.bl;

import caféinternet.interfaces.IBaseBL;
import caféinternet.dao.GenericDAO;
import caféinternet.dto.ComputadoraDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class ComputadoraBL implements IBaseBL<ComputadoraDTO>{
private GenericDAO CDao;
    public ComputadoraBL() {
        CDao=new GenericDAO();
    }

    @Override
    public void insert(ComputadoraDTO obj) throws SQLException {
        this.CDao.insert(obj);
    }

    @Override
    public void update(ComputadoraDTO obj) throws SQLException {
        this.CDao.update(obj);
    }

    @Override
    public void delete(ComputadoraDTO key) throws SQLException {
        this.CDao.delete(key);
    }

    @Override
    public ArrayList<ComputadoraDTO> readAll() throws SQLException {
        return this.CDao.readAll(new ComputadoraDTO());
    }

    @Override
    public ComputadoraDTO obtenerPorId(ComputadoraDTO obj) throws SQLException {
     return (ComputadoraDTO)this.CDao.obtenerPorId(obj);
    }


    public ArrayList<ComputadoraDTO> obtenerConWhere(ComputadoraDTO obj,String where) throws SQLException {
        return this.CDao.obtenerConWhere(obj, where);
    }

}
