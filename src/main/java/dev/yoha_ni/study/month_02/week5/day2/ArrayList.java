package dev.yoha_ni.study.month_02.week5.day2;

import java.util.*;

public class ArrayList {

    public static class CustomArrayList{
        private int defaultSize = 10;
        private int[] data;
        private int size = 0;

        public CustomArrayList(){
            data = new int[defaultSize];
        }

        public CustomArrayList(int size){
            data = new int[size];
        }

        public void add(int value) {
            resizeDataSize();
            data[size] = value;
            size++;
        }

        public void add(int index, int value) {
            if (index < 0 || index > size) {
                System.out.println("인덱스 범위 초과");
                return;
            }

            resizeDataSize();
            for (int i = size; i > index; i--) {
                data[i] = data[i - 1];
            }

            data[index] = value;
            size++;
        }

        public void remove(){
            size--;
        }
        public void get() {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < size; i++)
                sb.append(i).append(" ");
            System.out.println(sb.toString());
        }


        public void print(){
//            System.out.println(Arrays.toString(data));
            StringBuffer sb = new StringBuffer();
            sb.append("[");
            for (int i = 0; i < size; i++) {
                sb.append(data[i]);
                if(i< size - 1) sb.append(", ");
            }
            sb.append("]");
            System.out.println(sb.toString());
        }

        public void realPrint(){
            System.out.println(Arrays.toString(data));
        }

        private void resizeDataSize(){
            if (data.length > size) return;
            int newSize = data.length * 2;
            int[] newArr = new int[newSize];

            for (int i = 0; i < data.length; i++)
                newArr[i] = data[i];
            data = newArr;
        }
    }

    public static void main(String[] args) {
        CustomArrayList list1 = new CustomArrayList();
        list1.print();
        list1.add(10);
        list1.add(20);
        list1.print();
        list1.remove();
        list1.realPrint();
    }
}
