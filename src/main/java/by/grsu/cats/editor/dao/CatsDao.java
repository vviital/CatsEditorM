package by.grsu.cats.editor.dao;

import by.grsu.cats.editor.beans.CatBean;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by vviital on 9.3.16.
 */
public class CatsDao {

    public static String dbUrl = "jdbc:mysql://localhost/CatsEditor";
    public static String dbClass = "com.mysql.jdbc.Driver";
    public static String username = "root";
    public static String password = "root";

    public CatsDao() {

    }

    public void create(CatBean catBean, Connection conn) {
        String sql = "insert into Cats (idCats, name, color) values (?, ?, ?)";
        int rowsChanged = 0;
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, catBean.getHash());
            stmt.setString(2, catBean.getName());
            stmt.setString(3, catBean.getColor());

            rowsChanged = stmt.executeUpdate();
            if (rowsChanged == 0) {
                throw new Exception("Cat hasn't been inserted");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(CatBean catBean, Connection conn) {
        String sql = "update Cats set name = ?, color = ? where idCats = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, catBean.getName());
            stmt.setString(2, catBean.getColor());
            stmt.setLong(3, catBean.getHash());
            int rowsChanged = stmt.executeUpdate();
            if (rowsChanged == 0) {
                throw new Exception("Cat hasn't been deleted");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(CatBean catBean, Connection conn) {
        String sql = "delete from Cats where idCats = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, catBean.getHash());
            int rowsChanged = stmt.executeUpdate();
            if (rowsChanged == 0) {
                throw new Exception("Cat hasn't been deleted");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CatBean getCat(long id, Connection conn) {
        CatBean cat = new CatBean();
        String sql = "SELECT idCats, name, color FROM Cats WHERE idCats =" + id;
        Map<Long, CatBean> map = getCats(sql, conn);
        return map.values().iterator().next();
    }


    public Map<Long, CatBean> getCats(Connection conn) {
        String sql = "SELECT idCats, name, color FROM Cats";
        return getCats(sql, conn);
    }

    private Map<Long, CatBean> getCats(String sql, Connection conn) {
        Map<Long, CatBean> map = new HashMap<Long, CatBean>();
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                long id = rs.getLong("idCats");
                String name = rs.getString("name");
                String color = rs.getString("color");
                map.put(id, new CatBean(id, name, color));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
