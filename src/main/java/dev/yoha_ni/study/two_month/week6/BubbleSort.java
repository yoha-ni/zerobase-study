package dev.yoha_ni.study.two_month.week6;

import java.io.*;
import java.util.*;

public class BubbleSort {

    private static void bubbleSort(int[] arr) {
        int size = arr.length;
        boolean swap;

        for (int i = 0; i < size - 1; i++) {
            swap = false;
            for (int j = 0; j < size - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1] = temp;
                    swap = true;
                }
            }
            System.out.println("Round" + (i+1) + " : " + Arrays.toString(arr));
            if (!swap) break;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] stArr = br.readLine().split(" ");
        int[] arr = new int[stArr.length];
        for (int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(stArr[i]);

        System.out.println("정렬 전 : " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("정렬 후 : " + Arrays.toString(arr));
    }
}
