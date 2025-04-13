package dev.yoha_ni.study.two_month.week6.day7;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SolutionW6_7 {

//    입력값 〉"105990", 1
//    기댓값 〉"5990"

    public static String solution(String s, int k) {
        StringBuilder answer = new StringBuilder();

        for(char c : s.toCharArray()){
            while (answer.length() > 0 && answer.charAt(answer.length() - 1) > c && k > 0) {
                answer.deleteCharAt(answer.length() - 1);
                k--;
            }
            answer.append(c);
        }

        while (k > 0) {
            answer.deleteCharAt(answer.length() - 1);
            k--;
        }

        int idx = 0;
        while (idx < answer.length() && answer.charAt(idx) == '0') {
            idx++;
        }

        String result = answer.substring(idx);
        return result.isEmpty() ? "0" : result;
    }

    public static void main(String[] args) {
        String s = "105990";
        int k = 3;

        System.out.println(solution(s, k));
    }
}
