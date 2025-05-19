package dev.yoha_ni.study.month_02.week5.day1.array;

import java.util.*;

/**
 * 혼자 풀어본 문제
 */
public class ArrProblemAlone {
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        display();
    }

    static void display(){
        System.out.print("배열의 크기를 입력해주세요: ");
        int size = sc.nextInt();
        sc.nextLine();

        System.out.print(size + "크기에 랜덤한 난수(1~10)중에 찾고싶은 값을 입력해주세요: ");
        int find = sc.nextInt();
        sc.nextLine();

        makeArr(size, find);
    }

    static void makeArr(int size, int find){
        int[] arr = new int[size];

        Random rd = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(10) + 1;
        }

        int cnt = 0;

        for(int num : arr){
            if(find == num){
                cnt++;
            }
        }

        System.out.println(Arrays.toString(arr) + "중 찾는값 " + find);
        System.out.println("찾는값: " + find + "갯수: " + cnt);
    }
}
