package dev.yoha_ni.study.month_01.week4.day1.functionalinterface.thread;

public class RunnableExample {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("안녕 세상");

        Thread thread = new Thread(task);
        thread.start();
    }
}
