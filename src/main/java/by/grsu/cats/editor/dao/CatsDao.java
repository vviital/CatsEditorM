package by.grsu.cats.editor.dao;

import by.grsu.cats.editor.beans.CatBean;

import java.util.List;
import java.util.Map;

/**
 * Created by vviital on 16.3.16.
 */
public interface CatsDao {

    void create(CatBean catBean);

    void update(CatBean catBean);

    void delete(CatBean catBean);

    void update(List<CatBean> cats);

    CatBean getCat(long id);

    Map<Long, CatBean> getCats();
}
