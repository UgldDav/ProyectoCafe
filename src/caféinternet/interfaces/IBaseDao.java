/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caféinternet.interfaces;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public interface IBaseDao<T> {
     public boolean insert(T obj) throws SQLException;
    public boolean update(T obb) throws SQLException;
    public boolean delete(T obj) throws SQLException;
    
    public T obtenerPorId(T obj) throws SQLException;
    public ArrayList<T> readAll() throws SQLException;
    public ArrayList<T> obtenerConWhere(String where) throws SQLException;
    
}
