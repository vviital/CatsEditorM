package by.grsu.cats.editor.util;

import java.util.Random;

/**
 * Created by vviital on 5.3.16.
 */
public class HashGenerator {

    private static Random random = new Random(System.currentTimeMillis());

    public static long getNext() {
        long rnd = random.nextLong();
        System.out.println(rnd);
        return rnd;
    }
}
