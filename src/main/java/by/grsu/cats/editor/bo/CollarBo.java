package by.grsu.cats.editor.bo;

import by.grsu.cats.editor.beans.Collar;
import by.grsu.cats.editor.dao.CollarDaoImpl;
import by.grsu.cats.editor.dao.GenericDao;

import java.util.List;

/**
 * Created by vviital on 27.3.16.
 */
public class CollarBo implements GenericBo<Collar, Long> {
    private GenericDao<Collar, Long> collarDao;

    public void setCollarDao(GenericDao<Collar, Long> collarDao) {
        this.collarDao = collarDao;
    }

    @Override
    public void create(Collar obj) {
        collarDao.create(obj);
    }

    @Override
    public Collar read(Long id) {
        return collarDao.read(id);
    }

    @Override
    public void update(Collar obj) {
        collarDao.update(obj);
    }

    @Override
    public void delete(Long id) {
        collarDao.delete(id);
    }

    @Override
    public List<Collar> getAll() {
        return collarDao.getAll();
    }
}
