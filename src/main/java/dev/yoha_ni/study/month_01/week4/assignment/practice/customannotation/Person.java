package dev.yoha_ni.study.month_01.week4.assignment.practice.customannotation;

/**
 * 제로베이스 35기 서요한.
 * 객체 생성 클래스
 */

public class Person implements PersonInterface {
    private String name;
    private Integer age;
    private String address;

    @Override
    public void display(String name, int age, String address) {
        System.out.printf("이름 %s 나이 %d 주소 %s\n", this.name, this.age, this.address);
    }

    @Override
    public void myWife(String name) {
        System.out.printf("나 %s의 와이프는 %s 이다!!\n", this.name, name);
    }

    @Override
    public void mySon(String name, int age) {
        System.out.printf("나는 %s 의 멋진아들 %s %d이다!!\n", this.name, name, age);
    }

    public Person(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
