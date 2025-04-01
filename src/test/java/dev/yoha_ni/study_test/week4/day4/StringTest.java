package dev.yoha_ni.study_test.week4.day4;

import org.junit.jupiter.api.Test;

import java.util.Map;

public class StringTest {

    @Test
    void java8() {
        // String join
        String str1 = String.join(",", "a", "b", "c");
        System.out.println(str1);

        // String.join with Collection
        String str2 = String.join(",", java.util.List.of("A", "B", "C"));
        System.out.println(str2);
    }

    // java11
    @Test
    void java11() {
        // given - String.isBlank
        System.out.println(" ".isBlank());
        System.out.println("abc".isBlank());

        // String.strip, string.stripLeading, string.stripTrailing
        System.out.println("   abc   ".strip());
        System.out.println("   abc   ".stripLeading());
        System.out.println("   abc   ".stripTrailing());

        // String.liens
        String str = "abc\ndef\nghi";
//        System.out.println(str);
//        str.lines().forEach(System.out::println);
        String line = str.lines().toList().get(1);
        System.out.println(line);

        // String.repeat
        System.out.println("abc".repeat(3));
    }

    @Test
    void java13() {
        // String TextBlock
        String textBlock = """
                Hello, \s
                World!
                World
                """;
        System.out.println(textBlock);
    }

    @Test
    void testJava14() {
        // String.transform
        String str = "hello";
        String result = str.transform(s -> s.toUpperCase());
        System.out.println(result);

        // String.transform chaining
        String result2 = str.transform(s -> s.toUpperCase()).transform(s -> s + " world");
        System.out.println(result2);

    }


    @Test
    void testJava16() {
        // String formatting .formatted
        String formattedString = "My name is %s and I am %d years old.".formatted("John", 30);
        System.out.println(formattedString);

        Map<String, Integer> map = Map.of(
                "apple", 1,
                "banana", 2,
                "cherry", 3
        );
        map.forEach( (k, v) -> System.out.println("i'm %s: %d age".formatted(k, v)) );
    }
}
