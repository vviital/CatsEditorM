package by.grsu.cats.editor.starter;

import by.grsu.cats.editor.benchmark.Benchmark;

/**
 * Created by vviital on 9.3.16.
 */
public class Starter {
    public static void main(String[] args) {

        Benchmark benchmark = new Benchmark();
        //for(int i = 10; i <= 200; i += 10) {
            benchmark.benchmark(200);
        //}
    }
}
