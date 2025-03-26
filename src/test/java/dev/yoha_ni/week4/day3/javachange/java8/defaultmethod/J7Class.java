package dev.yoha_ni.week4.day3.javachange.java8.defaultmethod;

public class J7Class implements J7Interface {
    @Override
    public void printClassName() {
        System.out.println(getClass().getSimpleName());
    }
}
