
package caféinternet.bl;
import caféinternet.dao.GenericDAO;
import caféinternet.interfaces.IBaseBL;
import caféinternet.dto.ArticuloDTO;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArticuloBL implements IBaseBL<ArticuloDTO>{
    private GenericDAO ArDao;

    public ArticuloBL() {
        this.ArDao= new GenericDAO();
    }

    @Override
    public void insert(ArticuloDTO obj) throws SQLException {
        this.ArDao.insert(obj);
    }

    @Override
    public void update(ArticuloDTO obj) throws SQLException {
        this.ArDao.update(obj);
    }

    @Override
    public void delete(ArticuloDTO key) throws SQLException {
        this.ArDao.delete(key);
    }

    @Override
    public ArrayList<ArticuloDTO> readAll() throws SQLException {
        return this.ArDao.readAll(new ArticuloDTO());
    }

    @Override
    public ArticuloDTO obtenerPorId(ArticuloDTO obj) throws SQLException {
     return (ArticuloDTO)this.ArDao.obtenerPorId(obj);
    }


    public ArrayList<ArticuloDTO> obtenerConWhere(ArticuloDTO obj,String where) throws SQLException {
        return this.ArDao.obtenerConWhere(obj, where);
    }
}

