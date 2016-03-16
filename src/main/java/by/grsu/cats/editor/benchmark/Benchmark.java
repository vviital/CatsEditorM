package by.grsu.cats.editor.benchmark;

import by.grsu.cats.editor.beans.CatBean;
import by.grsu.cats.editor.dao.CatsDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by vviital on 13.3.16.
 */
public class Benchmark {

    public static String dbUrl = "jdbc:mysql://localhost/CatsEditor";
    public static String dbClass = "com.mysql.jdbc.Driver";
    public static String username = "root";
    public static String password = "root";

    private Random random = new Random();
    private CatsDao dao = new CatsDao();

    public void benchmark(int number) {
        try {
            Class.forName(dbClass);
            List<Connection> connections = new ArrayList<Connection>();
            for(int i = 0; i < 150; ++i) {
                connections.add(DriverManager.getConnection(dbUrl, username, password));
            }
            int cnt = 1;
            for(Connection conn : connections) {
                List<CatBean> cats = generateCats(number);
                int count = 1;
                long insertTime = 0, updateTime = 0, singleSelectTime = 0, fullSelectTime = 0, deleteTime = 0;
                for (int iter = 0; iter < count; ++iter) {
//                    insertTime += insertTest(cats, conn);
//
//                    updateTime += updateTest(cats, conn);
//
//                    singleSelectTime += singleSelectTest(cats, conn);
//
                    fullSelectTime += fullSelectTest(conn);
//
//                    deleteTime += deleteTest(cats, conn);

//                    System.out.println("Cats number: " + number);
//                    System.out.println("insertTime = " + insertTime / count);
//                    System.out.println("updateTime = " + updateTime / count);
//                    System.out.println("singleSelectTime = " + singleSelectTime / count);
                    System.out.println(cnt++ + " fullSelectTime = " + fullSelectTime / count);
//                    System.out.println("deleteTime = " + deleteTime / count);
                    System.out.println("--------------------------------------------");
                }
            }
        } catch (Exception e) {

        }
    }

    private long insertTest(List<CatBean> cats, Connection conn) {
        long startTime = System.currentTimeMillis();
        for(CatBean cat : cats) {
            dao.create(cat, conn);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private long updateTest(List<CatBean> cats, Connection conn) {
        long startTime = System.currentTimeMillis();
        for(CatBean cat : cats) {
            cat.setName(cat.getName().concat(" " + cat.getName()));
            dao.update(cat, conn);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private long singleSelectTest(List<CatBean> cats, Connection conn) {
        long startTime = System.currentTimeMillis();
        for(CatBean cat : cats) {
            CatBean bean = dao.getCat(cat.getHash(), conn);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private long fullSelectTest(Connection conn) {
        long startTime = System.currentTimeMillis();
        Map<Long, CatBean> map = dao.getCats(conn);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private long deleteTest(List<CatBean> cats, Connection conn) {
        long startTime = System.currentTimeMillis();
        for(CatBean cat : cats) {
            dao.delete(cat, conn);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private List<CatBean> generateCats(int number) {
        List<CatBean> cats = new ArrayList<CatBean>();
        for(int i = 0; i < number; ++i) {
            CatBean cat = new CatBean();
            cat.setColor(Integer.toHexString(random.nextInt(1 << 20)));
            cat.setName("Happy");
            cats.add(cat);
        }
        return cats;
    }
}
