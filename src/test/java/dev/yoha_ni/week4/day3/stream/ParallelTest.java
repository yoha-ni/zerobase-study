package dev.yoha_ni.week4.day3.stream;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

public class ParallelTest {
    private final Faker faker = new Faker();

    @Test
    void sequentialVsParallel(){
        List<Integer> numbers = IntStream.range(0, 100)
                .boxed()
                .toList();

        long sequentialStartAt = System.currentTimeMillis();
        numbers.stream().forEach(
                i ->{
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
        System.out.println("Sequential:  " + (System.currentTimeMillis() - sequentialStartAt));

        long parallelStartAt = System.currentTimeMillis();
        numbers.parallelStream().forEach(
                i -> {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
        System.out.println("parallel:  " + (System.currentTimeMillis() - parallelStartAt));

    }

}
