package by.grsu.cats.editor.benchmark;

import by.grsu.cats.editor.beans.Cat;
import by.grsu.cats.editor.beans.Collar;
import by.grsu.cats.editor.bo.CatsBo;
import by.grsu.cats.editor.bo.CollarBo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by vviital on 13.3.16.
 */
public class Benchmark {

    private Random random = new Random();
    private CatsBo catsBo;
    private CollarBo collarBo;

    public void benchmark(int number) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        catsBo = (CatsBo) applicationContext.getBean("CatsBo");
        collarBo = (CollarBo) applicationContext.getBean("CollarBo");
        List<Cat> cats = generateCats(number);
        int count = 1;
        long insertTime = 0, updateTime = 0, singleSelectTime = 0, fullSelectTime = 0, deleteTime = 0;
        for (int iter = 0; iter < count; ++iter) {
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

    private long insertTest(List<Cat> cats) {
        long startTime = System.currentTimeMillis();
        for (Cat cat : cats) {
            catsBo.create(cat);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private long updateTest(List<Cat> cats) {
        long startTime = System.currentTimeMillis();
        for (Cat cat : cats) {
            catsBo.update(cat);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private long singleSelectTest(List<Cat> cats) {
        long startTime = System.currentTimeMillis();
        for (Cat cat : cats) {
            Cat bean = catsBo.read(cat.getHash());
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private long fullSelectTest() {
        long startTime = System.currentTimeMillis();
        List<Cat> map = catsBo.getAll();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private long deleteTest(List<Cat> cats) {
        long startTime = System.currentTimeMillis();
        for (Cat cat : cats) {
            catsBo.delete(cat.getHash());
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private String getRandomString(int length) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < length; ++i) {
            builder.append((char)('a' + random.nextInt('z' - 'a' + 1)));
        }
        return builder.toString();
    }

    private Cat getNextRandomCat() {
        Cat cat = new Cat();
        cat.setName(getRandomString(20));
        cat.setColor(Integer.toHexString(random.nextInt(1 << 20)));
        Collar collar = new Collar(getRandomString(20), Integer.toHexString(random.nextInt(1 << 20)), cat);
        return cat;
    }

    private List<Cat> generateCats(int number) {
        List<Cat> cats = new ArrayList<Cat>();
        for (int i = 0; i < number; ++i) {
            cats.add(getNextRandomCat());
        }
        return cats;
    }
}
