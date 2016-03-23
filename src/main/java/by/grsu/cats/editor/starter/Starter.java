package by.grsu.cats.editor.starter;

import by.grsu.cats.editor.beans.CatBean;
import by.grsu.cats.editor.beans.Collar;
import by.grsu.cats.editor.benchmark.Benchmark;
import org.hibernate.Session;

/**
 * Created by vviital on 9.3.16.
 */
public class Starter {
    public static void main(String[] args) {

        //Benchmark benchmark = new Benchmark();
        //for(int i = 10; i <= 200; i += 10) {
        //    benchmark.benchmark(200);
        //}
        (new Starter()).checkDataBase();
    }

    public void checkDataBase() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        CatBean cat = new CatBean();
        cat.setName("Happy");
        cat.setColor("ffffff");
        Collar collar = new Collar();
        collar.setColor("dddddd");
        collar.setText("Happy Happy joe joe");
        cat.setCollar(collar);
        collar.setCatBean(cat);

        session.save(cat);
        session.getTransaction().commit();

        System.out.println("Done");
    }
}
