package dev.yoha_ni.study.month_02.week5.day1.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 사용자 원하는 개수 입력받고, 연달아 오는 개수만큼 값을 초기화하기
 * 합/평균/최소/최대값 순서대로 출력
 */
public class ArrProblemAlone2 {
    public static void main(String[] args) throws IOException {
        // 1. 사용자에게 10개 숫자 입력 받기.
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());

        int[] arr = new int[size];

        int total = 0 , min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine());
            // 2. 입력 받는 값 총합 구하기
            total += arr[i];
            // 3. 최소값 구하기.
            min = Integer.min(min, arr[i]);
            // 4. 최대값 구하기.
            max = Integer.max(max, arr[i]);
        }

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("총합: " + total).append("\n평균: "+ (double) total / size).append("\n최소값: " + min).append("\n최대값: " + max);
        System.out.println(stringBuffer.toString());



    }
}
