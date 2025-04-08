package dev.yoha_ni.study.two_month.week6;

import java.util.*;
import java.io.*;

public class SelectionSort {

    public static void selectionSort(int[] arr){
        int size = arr.length;

        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < size; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }

            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
            System.out.println("Round" + (i+1) + " : " + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(", ");
        int[] arr = new int[st.length];

        for (int i = 0; i < st.length; i++) {
            arr[i] = Integer.parseInt(st[i]);
        }

        System.out.println("정렬 전 : " + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("정렬 후 : " + Arrays.toString(arr));
    }
}
