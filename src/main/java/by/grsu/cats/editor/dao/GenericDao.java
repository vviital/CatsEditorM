package by.grsu.cats.editor.dao;

import java.util.List;

/**
 * Created by vviital on 27.3.16.
 */
public interface GenericDao<T, PK> {

    void create(T obj);

    T read(PK id);

    void update(T obj);

    void delete(PK id);

    List<T> getAll();
}
