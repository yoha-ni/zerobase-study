package dev.yoha_ni.study.week5.day5;

import java.io.*;
import java.util.*;

/**
 * 스택 2개를 이용해서, 오름차순 정렬을 해보세요.
 * 입력 : 5 6 1 3 2 4
 * 출력 : 1 2 3 4 5 6
 */
public class NumberSort {

    public static int[] solution(int[] a, int[] b) {

        if(a.length == 0 && b.length == 0) {return a;}
        if(a.length == 0) {return b;}
        if(b.length == 0) {return a;}

        int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        boolean up = false;

        for (int i = a.length - 1; i >= 0; i--) {
            int sum;
            for (int j = b.length - 1; i >= 0; j--) {

                if (up = true) {
                    sum = a[i] + b[j] + 1;
                } else sum = a[i] + b[j];

                if (sum > 10) {
                    up = true;
                    stack.push( sum % 10);
                } else stack.push(sum);
                break;
            }
        }
        for (int num : stack) {

            System.out.println(num + " " );
        }
        return answer;
    }


    public static void main(String[] args) throws IOException{
        int[] a ={5, 2, 1, 4, 6},b = {6, 1, 0, 4, 4};
        System.out.println(solution(a, b));


//        int a = 13 % 10;
//        System.out.println(a);

    }
}
