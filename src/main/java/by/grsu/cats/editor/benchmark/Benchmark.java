package by.grsu.cats.editor.benchmark;

import by.grsu.cats.editor.beans.CatBean;
import by.grsu.cats.editor.dao.CatsDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by vviital on 13.3.16.
 */
public class Benchmark {

    private Random random = new Random();
    private CatsDao dao = new CatsDao();

    public void benchmark(int number) {
        List<CatBean> cats = generateCats(number);
        int count = 3;
        long insertTime = 0, updateTime = 0, singleSelectTime = 0, fullSelectTime = 0, deleteTime = 0;
        for(int iter = 0; iter < count; ++iter) {
            insertTime += insertTest(cats);

            updateTime += updateTest(cats);

            singleSelectTime += singleSelectTest(cats);

            fullSelectTime += fullSelectTest();

            deleteTime += deleteTest(cats);
        }

        System.out.println("Cats number: " + number);
        System.out.println("insertTime = " + insertTime / count);
        System.out.println("updateTime = " + updateTime / count);
        System.out.println("singleSelectTime = " + singleSelectTime / count);
        System.out.println("fullSelectTime = " + fullSelectTime / count);
        System.out.println("deleteTime = " + deleteTime / count);
        System.out.println("--------------------------------------------");
    }

    private long insertTest(List<CatBean> cats) {
        long startTime = System.currentTimeMillis();
        for(CatBean cat : cats) {
            dao.create(cat);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private long updateTest(List<CatBean> cats) {
        long startTime = System.currentTimeMillis();
        for(CatBean cat : cats) {
            cat.setName(cat.getName().concat(" " + cat.getName()));
            dao.update(cat);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private long singleSelectTest(List<CatBean> cats) {
        long startTime = System.currentTimeMillis();
        for(CatBean cat : cats) {
            CatBean bean = dao.getCat(cat.getHash());
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private long fullSelectTest() {
        long startTime = System.currentTimeMillis();
        Map<Long, CatBean> map = dao.getCats();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private long deleteTest(List<CatBean> cats) {
        long startTime = System.currentTimeMillis();
        for(CatBean cat : cats) {
            dao.delete(cat);
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
