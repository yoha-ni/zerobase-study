package dev.yoha_ni.study_test.week4.day3.javachange.java8.defaultmethod;

public class InterfaceDefaultMethodExample {
    public static void main(String[] args) {
        J7Class j7Class = new J7Class();
        j7Class.printClassName();

        J8Class j8Class = new J8Class();
        J8Class2 j8Class2 = new J8Class2();
        J8Class3 j8Class3 = new J8Class3();
        System.out.println(j8Class.getTime());
        System.out.println(j8Class2.getTime());
        System.out.println(j8Class3.getTime());

    }
}
