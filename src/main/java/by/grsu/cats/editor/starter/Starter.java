package by.grsu.cats.editor.starter;

import by.grsu.cats.editor.beans.Cat;
import by.grsu.cats.editor.beans.Collar;
import by.grsu.cats.editor.benchmark.Benchmark;
import by.grsu.cats.editor.bo.CatsBo;
import by.grsu.cats.editor.bo.CollarBo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by vviital on 9.3.16.
 */
public class Starter {
    public static void main(String[] args) {

        Benchmark benchmark = new Benchmark();
        benchmark.benchmark(200);
//        for(int i = 10; i <= 200; i += 10) {
//            benchmark.benchmark(200);
//        }
//        (new Starter()).checkDataBase();
//        (new Starter()).checkSpringPlusHibernate();
    }

    public void checkSpringPlusHibernate() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        CatsBo catsBo = (CatsBo) applicationContext.getBean("CatsBo");
        CollarBo collarBo = (CollarBo) applicationContext.getBean("CollarBo");

//        Cat cat = catsBo.read(10L);
//        System.out.println(cat.toString());
//        cat.setName("Kon");
//        catsBo.update(cat);

        for(int i = 0; i < 10; ++i) {
            Cat meliodas = new Cat("112211", "Meliodas");
            Collar collar = new Collar("Meliodas color", "332211", meliodas);
            catsBo.create(meliodas);
        }

        List<Cat> cats = catsBo.getAll();
        for(Cat c : cats) {
            c.getCollar().setText("Bugaga");
            c.setName("Happy");
            collarBo.update(c.getCollar());
            System.out.println(c.toString());
        }
    }

    public void checkDataBase() {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//
//        session.beginTransaction();
//
//        Cat cat = new Cat();
//        cat.setName("Happy");
//        cat.setColor("ffffff");
//        Collar collar = new Collar();
//        collar.setColor("dddddd");
//        collar.setText("Happy Happy joe joe");
//        cat.setCollar(collar);
//        collar.setCat(cat);
//
//        session.save(cat);
//        session.getTransaction().commit();
//
//        System.out.println("Done");
    }
}
