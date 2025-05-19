package dev.yoha_ni.study.month_02.week5.day2;

import java.io.*;
import java.util.*;

public class ArrayExpansion {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // 기준점 : 어떨때, 데이터를 (배열을) 확장해야할까?
        // 즉, 배열의 index의 위치가 초과되었을 때 를 확인해 확장한다.

        int[] arr = new int[1];
        int index = 0;

        while (true) {
            int value = Integer.parseInt(bufferedReader.readLine());

            if (index == arr.length) arr = expandArr(arr);


            arr[index] = value;
            index++;
            System.out.println(Arrays.toString(arr));
        }
    }

    private static int[] expandArr(int[] originalArr) {
        // 확장하는 시점 : index가 범위를 막 초과한 경우
        int[] newArr = new int[originalArr.length + 1];
        for (int i = 0; i < originalArr.length; i++)
            newArr[i] = originalArr[i];
        return newArr;
    }
}
