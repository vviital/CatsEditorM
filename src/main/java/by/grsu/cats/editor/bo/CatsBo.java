package by.grsu.cats.editor.bo;

import by.grsu.cats.editor.beans.Cat;
import by.grsu.cats.editor.dao.GenericDao;

import java.util.List;

/**
 * Created by vviital on 27.3.16.
 */
public class CatsBo implements GenericBo<Cat, Long> {

    private GenericDao<Cat, Long> catsDao;

    public void setCatsDao(GenericDao<Cat, Long> catsDao) {
        this.catsDao = catsDao;
    }

    @Override
    public void create(Cat obj) {
        catsDao.create(obj);
    }

    @Override
    public Cat read(Long id) {
        return catsDao.read(id);
    }

    @Override
    public void update(Cat obj) {
        catsDao.update(obj);
    }

    @Override
    public void delete(Long id) {
        catsDao.delete(id);
    }

    @Override
    public List<Cat> getAll() {
        return catsDao.getAll();
    }
}
