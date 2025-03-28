package dev.yoha_ni.week4.assignment.practice.customannotation;

/**
 * 제로베이스 35기 서요한
 * 어노테이션 적용시킨 인터페이스 클래스
 */
public interface PersonInterface {
    @LogParam
    void display(String name, int age, String address);

    @LogParam
    void myWife(String name);

    @LogParam
    void mySon(String name, int age);
}
