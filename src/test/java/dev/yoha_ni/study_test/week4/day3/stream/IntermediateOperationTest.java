package dev.yoha_ni.study_test.week4.day3.stream;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.InstanceOfAssertFactories.list;
import static org.junit.jupiter.api.Assertions.*;

class IntermediateOperationTest {
    private final Faker faker = new Faker();

    @Test
    void filter() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // when
        List<Integer> evenNumbers = numbers.stream()
                .filter(number -> (number % 2) == 0)
                .toList();
        // then
        System.out.println(evenNumbers);
    }

    @Test
    void filter2() {
        // given and when
        List<Integer> evenNumbers = IntStream.rangeClosed(1, 10)
                .filter(number -> number % 2 == 0)
                .boxed()
                .toList();

        // then
        System.out.println(evenNumbers);
    }

    @Test
    void mapVsFlatMap() {
        // given
        List<String> names = Stream.generate( () -> faker.name().firstName() )
                .limit(10)
                .toList();

        // when
        List<List<String>> nameCharacters = names.stream()
                .map( s -> List.of(s.split("")))
                .toList(); // map

        List<String> nameCharacters2 = names.stream()
                .flatMap( s -> Stream.of(s.split("")))
                .toList(); // flatMap

        // then
        System.out.println(names); // given
        System.out.println(nameCharacters); // map
        System.out.println(nameCharacters2); // flatMap
    }

    @Test
    void distinct(){
        List<Integer> numbers = IntStream.rangeClosed(1, 100)
                .map(i -> i % 5)
                .boxed()
                .toList();
        System.out.println(numbers);

        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .toList();
        System.out.println(distinctNumbers);
    }

    @Test
    void sorted() {
        List<Integer> numbers = Stream.generate(() -> faker.number().numberBetween(1, 46))
                .limit(6)
                .toList();
        System.out.println(numbers);

        List<Integer> sortedNumbers =numbers.stream()
                .sorted()
                .toList();
        System.out.println(sortedNumbers);
    }

    @Test
    void skip() {
        // given
        List<Integer> numbers = Stream.generate( () -> faker.number().numberBetween(1, 100) )
                .limit(10)
                .toList();

        List<Integer> skipNumbers = numbers.stream()
                .skip(4)
                .toList();
        System.out.println(numbers);
        System.out.println(skipNumbers);
        // when
        // then
    }















}