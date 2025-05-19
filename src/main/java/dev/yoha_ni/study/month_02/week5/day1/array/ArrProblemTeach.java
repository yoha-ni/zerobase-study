package dev.yoha_ni.study.month_02.week5.day1.array;

import java.io.*; // 미리 임포트
import java.util.*;

public class ArrProblemTeach {
    public static void main (String[] args) throws IOException { // 미리 예외처리
        // 사용자에게 입력(input)을 받는다.
        // 결과를 출력(output)한다.
        // > IO (input / output) -> IO import를 미리 해놓자
        // 오류의 가능성을 갖고있다. -> 예외 처리를 미리 해놓자
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        // 1. 사용자에게 배열의 크기를 입력받는다.
        int size = Integer.parseInt(buffer.readLine()); // 사용자가 무엇을 입력할지 모르기 때문에 str으로 입력받은후 정수 변환
        int[] arr = new int[size];
        // 2. 랜덤하게 배열을 초기화 한다.
        Random rd = new Random();
        for (int index = 0; index < arr.length; index++)
            arr[index] = rd.nextInt(10);

        System.out.println(Arrays.toString(arr)); // 디버깅용


        // 3. 사용자에게 특정 숫자를 입력받는다.
        int findNumber = Integer.parseInt(buffer.readLine());

        // 4. 개수를 세어 출력한다.
        int cnt = 0;
        for(int num : arr){
            if(num != findNumber) continue;
            cnt++;
        }
        System.out.println(cnt);
    }
}
