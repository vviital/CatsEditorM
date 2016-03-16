package by.grsu.cats.editor.dao;

import by.grsu.cats.editor.beans.CatBean;

import java.util.Map;

/**
 * Created by vviital on 16.3.16.
 */
public interface CatsDao {

    void create(CatBean catBean);

    void update(CatBean catBean);

    void delete(CatBean catBean);

    CatBean getCat(long id);

    Map<Long, CatBean> getCats();
}
