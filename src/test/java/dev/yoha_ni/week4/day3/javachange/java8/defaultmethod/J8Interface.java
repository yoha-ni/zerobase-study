package dev.yoha_ni.week4.day3.javachange.java8.defaultmethod;

public interface J8Interface {
    default void printTime(){
        System.out.println(getTime());
    }

    String getTime();
}
