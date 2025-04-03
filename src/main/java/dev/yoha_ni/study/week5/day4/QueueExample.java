package dev.yoha_ni.study.week5.day4;

import java.io.*;
import java.util.*;

public class QueueExample {

    public static class Queue{
        private int[] arr;
        private int front, rear, size;

        public Queue(){
            this.arr = new int[10];
            front = 0;
            rear = -1;
            size = 0;
        }

        public void enqueue(int value) {
            if(size == arr.length) return;
            this.arr[(++rear) % arr.length] = value;
            size++;
        }

        public void dequeue(){
            front++;
            size--;
        }

        public void printQueue(){
            StringBuffer sb = new StringBuffer();
            for(int data : arr)
                sb.append(data).append(" ");
            System.out.println(sb.toString());
        }

        public int peek(){
            return arr[front % arr.length];
        }

        public void printSize(){
            System.out.println(size);
        }
    }

    public static class QueueSole{
        int[] arr;
        int front, rear, size;

        public QueueSole() {
            this.arr = new int[5];
            this.front = 0;
            this.rear = 0; // 왜 -1? -> enqueue 할떄 rear를 ++ 하니깐 0이면 첫번재 요소가
            this.size = 0;
        }

        public void enqueue(int value) {
            if (arr.length == size) return;
            this.arr[(rear++) % arr.length] = value;
            this.size++;
        }

        public int dequeue(){
            size--;
            return arr[front++];
        }

        public int peek(){
            if (size == 0) return -1;
            return this.arr[front % arr.length];
        }

        public boolean isEmpty(){
            if(size == 0) return true;
            return false;
        }

        public int size(){
            return size;
        }

        public void printQueue(){
            StringBuffer sb = new StringBuffer();
            for (int i = front; i < size; i++) {
                sb.append(arr[i]).append(" ");
            }
            System.out.println(sb);
        }

    }

    public static void main(String[] arge){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        QueueSole qu = new QueueSole();

        for (int data = 1; data <= 5; data++) {
            qu.enqueue(data * 10);
        }

//        qu.printQueue();
        System.out.println(qu.peek());
//        System.out.println(qu.dequeue());
//        qu.printQueue();
        for (int i = 1; i <= 5; i++) {
            qu.dequeue();
            System.out.println(qu.peek());
        }
        qu.enqueue(123);
        System.out.println(qu.peek());
        System.out.println(qu.size());


//        Queue queue = new Queue();
//        for (int i = 1; i <= 10; i++) {
//            queue.enqueue(10 * i);
//        }
//
//        System.out.println(queue.peek());
//        for (int i = 1; i <= 10; i++) {
//            queue.dequeue();
//            System.out.println(queue.peek());
//        }
    }
}
