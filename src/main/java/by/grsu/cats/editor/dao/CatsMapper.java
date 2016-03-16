package by.grsu.cats.editor.dao;

import by.grsu.cats.editor.beans.CatBean;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by vviital on 16.3.16.
 */
public class CatsMapper implements RowMapper<CatBean> {
    @Override
    public CatBean mapRow(ResultSet resultSet, int i) throws SQLException {
        CatBean cat = new CatBean();
        cat.setHash(resultSet.getLong("idCats"));
        cat.setName(resultSet.getString("name"));
        cat.setColor(resultSet.getString("color"));
        return cat;
    }
}
