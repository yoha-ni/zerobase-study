package dev.yoha_ni.study.month_02.week5.day1.array;

import java.io.*;

/**
 * 10개의 입력을 받아 총합과 최소값을 출력하세요.
 */
public class ArrProblemAlone1 {
    public static void main(String[] args) throws IOException{
        // 1. 사용자에게 10개 숫자 입력 받기.
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];
        int total = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine());
            // 2. 입력 받는 값 총합 구하기
            total += arr[i];
            // 3. 최소값 구하기.
            min = Integer.min(min, arr[i]);
            // 4. 최대값 구하기.
            max = Integer.max(max, arr[i]);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("총합: " + total).append("\n최소값: " + min).append("\n최대값: " + max);
        System.out.println(stringBuffer.toString());



    }
}
