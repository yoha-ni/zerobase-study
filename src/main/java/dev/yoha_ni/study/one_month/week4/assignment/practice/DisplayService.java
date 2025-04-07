package dev.yoha_ni.study.one_month.week4.assignment.practice;

public class DisplayService {
    @LogParam  // 어노테이션 적용
    public void printDisplay(String name, int age) {
        System.out.println("Displaying: " + name);
    }

    @LogParam  // 어노테이션 적용
    public void printDisplay2(String name, int age, String address) {
        System.out.println("Displaying: " + name + " at " + address);
    }

    @LogParam
    public void namePrint(String name){
        System.out.println("이름은 : " + name);
    }
}
