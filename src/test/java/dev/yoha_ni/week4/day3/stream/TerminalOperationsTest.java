package dev.yoha_ni.week4.day3.stream;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class TerminalOperationsTest {
    private final Faker faker = new Faker();

    @Test
    void forEach() {
        // given
        List<String> names = Stream.generate(() -> faker.name().fullName())
                .limit(10)
                .toList();
        System.out.println(names);

        // when
        Stream.generate(() -> faker.name().fullName())
                .limit(10)
                .forEach(System.out::println);
        // then
    }

    @Test
    void count() {
        long count = Stream.generate(() -> faker.name().fullName())
                .limit(10)
                .count();
        System.out.println(count);
    }

    @Test
    void match(){
        boolean anyMatch = Stream.generate(() -> faker.number().numberBetween(1, 5))
                .limit(10)
                .peek(System.out::println)
                .anyMatch(i -> i == 3);
        System.out.println(anyMatch);

        boolean allMatch = Stream.generate(() -> faker.number().numberBetween(1, 5))
                .limit(10)
                .peek(System.out::println)
                .allMatch(i -> i == 3);
        System.out.println(allMatch);

        boolean noneMatch = Stream.generate(() -> faker.number().numberBetween(1, 5))
                .limit(10)
                .peek(System.out::println)
                .noneMatch(i -> i == 3);
        System.out.println(noneMatch);
    }

    @Test
    void findFirst(){
        String name = Stream.generate(() -> faker.name().fullName())
                .limit(10)
                .peek(System.out::println)
                .findFirst()
                .orElse("No Name");
        System.out.println(name);
    }


}
