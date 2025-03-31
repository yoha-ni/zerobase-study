package dev.yoha_ni.study.week5.day1.array;

import java.util.*;
import java.util.stream.*;

public class ArrayExample {

    public static void main(String[] args) {
        int[] arr = new int[5];
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {10, 20, 30};
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = new int[5];
        Random rand = new Random();
        for (int index = 0; index < arr3.length; index++) {
            arr3[index] = rand.nextInt(10);
        }
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = new int[5];
        Arrays.fill(arr4, 10);
        System.out.println(Arrays.toString(arr4));

        int[] arr5 = IntStream.range(0, 5).toArray();
        System.out.println(Arrays.toString(arr5));


    }
}
