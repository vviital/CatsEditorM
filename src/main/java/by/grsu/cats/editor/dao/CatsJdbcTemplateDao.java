package by.grsu.cats.editor.dao;

import by.grsu.cats.editor.beans.CatBean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by vviital on 9.3.16.
 */
public class CatsJdbcTemplateDao implements CatsDao {

    private JdbcTemplate jdbcTemplate;

    public CatsJdbcTemplateDao() {

    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(CatBean catBean) {
        String sql = "insert into Cats (idCats, name, color) values (?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{catBean.getHash(), catBean.getName(), catBean.getColor()});
    }

    @Override
    public void update(CatBean catBean) {
        String sql = "update Cats set name = ?, color = ? where idCats = ?";
        jdbcTemplate.update(sql, new Object[]{catBean.getName(), catBean.getColor(), catBean.getHash()});
    }

    @Override
    public void delete(CatBean catBean) {
        String sql = "delete from Cats where idCats = ?";
        jdbcTemplate.update(sql, catBean.getHash());
    }

    @Override
    public CatBean getCat(long id) {
        String sql = "SELECT idCats, name, color FROM Cats WHERE idCats =" + id;
        CatBean cat = jdbcTemplate.query(sql, new CatsMapper()).get(0);
        return cat;
    }

    @Override
    public Map<Long, CatBean> getCats() {
        String sql = "SELECT idCats, name, color FROM Cats";
        List<CatBean> beans = jdbcTemplate.query(sql, new CatsMapper());
        Map<Long, CatBean> cats = new HashMap<Long, CatBean>();
        for(CatBean x : beans) {
            cats.put(x.getHash(), x);
        }
        return cats;
    }
}
