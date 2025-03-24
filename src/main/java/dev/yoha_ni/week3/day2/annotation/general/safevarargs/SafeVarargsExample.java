package dev.yoha_ni.week3.day2.annotation.general.safevarargs;

public class SafeVarargsExample {
    @SafeVarargs
    public static <T> void printMessage(T... messages) {
        for (T message : messages) {
            System.out.println(message);
        }
    }
}
