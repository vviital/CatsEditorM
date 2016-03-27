package by.grsu.cats.editor.bo;

import java.util.List;

/**
 * Created by vviital on 27.3.16.
 */
public interface GenericBo<T,PK> {
    void create(T obj);

    T read(PK id);

    void update(T obj);

    void delete(PK id);

    List<T> getAll();
}
