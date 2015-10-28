/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caféinternet.interfaces;
import java.util.ArrayList;
import java.sql.SQLException;
/**
 *
 * @author David
 */
public interface IBaseBL<T> {
         public void insert(T obj) throws SQLException;
    public void update(T obj) throws SQLException;
    public void delete(T key) throws SQLException;
    public ArrayList<T> readAll() throws SQLException;
    public T obtenerPorId(T obj) throws SQLException;
}
