package dev.yoha_ni.study_test.week4.day3.stream;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class EtcTest {
    private final Faker faker = new Faker();

    @Test
    void streamCanNotBeReused() {
        // given
        Stream<String> names = Stream.generate(() -> faker.name().fullName())
                .limit(3);
        // when
        names.forEach(System.out::println);
        names.forEach(System.out::println);
        // then
    }

    @Test
    void streamNeedReused(){
        List<String> names = Stream.generate(() -> faker.name().fullName())
                .limit(2)
                .toList();

        names.stream().forEach(System.out::println);
        names.stream().forEach(System.out::println);
    }

    @Test
    void reduce(){
        String pokemonName = Stream.generate(() -> faker.pokemon().name())
                .limit(5)
                .peek(System.out::println)
                .reduce((String s1, String s2) -> s1 + "//" + s2)
                .orElse("No Name");
        System.out.println(pokemonName);
    }
}
