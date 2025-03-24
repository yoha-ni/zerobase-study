package dev.yoha_ni.week4.day1.functionalinterface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceExample {

    public static void main(String[] args) {

        // Consumer : 입력값을 받아 처리만 하고 반환값은 없음
        Consumer<String> printConsumer = (String s) -> System.out.println("Consumer " + s);
        printConsumer.accept("안녕하세요");

        // Supplier : 입력값 없이 결과값을 공급함
        Supplier<String> stringSupplier = () -> "공급된 문자열";
        System.out.println("Supplier: " + stringSupplier.get());

        // Predicate : 입력값을 받아 boolean 값을 반환함
        Predicate<Integer> isEven = (a) -> a % 2 == 0;
        System.out.println("Predicate is Even : " + isEven.test(2));

        // Function : 입력값을 받아 결과값을 반환함
        Function<String, Integer> stringLength = (String s) -> s.length();
        System.out.println("Function 문자열 길이: " + stringLength.apply("안녕하세요"));

    }
}
