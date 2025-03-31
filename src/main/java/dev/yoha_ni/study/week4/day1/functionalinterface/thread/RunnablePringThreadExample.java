package dev.yoha_ni.study.week4.day1.functionalinterface.thread;

public class RunnablePringThreadExample {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("["+Thread.currentThread().getName() +"] 안녕 세상");

        Thread thread = new Thread(task);
        thread.start();
        Thread thread1 = new Thread(task);
        thread1.start();
        Thread thread2 = new Thread(task);
        thread2.start();

        System.out.println("["+Thread.currentThread().getName() +"] Hello, World");
    }
}
