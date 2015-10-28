/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caféinternet.bl;
import caféinternet.dao.GenericDAO;
import caféinternet.interfaces.IBaseBL;
import caféinternet.dto.ClienteDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class ClienteBL implements IBaseBL<ClienteDTO> {
private GenericDAO cDao;

    public ClienteBL() {
        this.cDao= new GenericDAO();
    }

    @Override
    public void insert(ClienteDTO obj) throws SQLException {
        this.cDao.insert(obj);
    }

    @Override
    public void update(ClienteDTO obj) throws SQLException {
        this.cDao.update(obj);
    }

    @Override
    public void delete(ClienteDTO key) throws SQLException {
        this.cDao.delete(key);
    }

    @Override
    public ArrayList<ClienteDTO> readAll() throws SQLException {
        return this.cDao.readAll(new ClienteDTO());
    }

    @Override
    public ClienteDTO obtenerPorId(ClienteDTO obj) throws SQLException {
     return (ClienteDTO)this.cDao.obtenerPorId(obj);
    }


    public ArrayList<ClienteDTO> obtenerConWhere(ClienteDTO obj,String where) throws SQLException {
        return this.cDao.obtenerConWhere(obj, where);
    }

   
}
