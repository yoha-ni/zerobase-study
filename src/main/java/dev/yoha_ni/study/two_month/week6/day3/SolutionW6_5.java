package dev.yoha_ni.study.two_month.week6.day3;

import java.util.ArrayList;
import java.util.List;

public class SolutionW6_5 {

    public static int solution(int N, int[][] trust) {
        int judge = trust[0][1];

        List<Integer> people = new ArrayList<>();
        for (int i = 1; i <= N; i++)
            people.add(i);

        for (int[] t : trust) {
            int notJudge = t[0];
            people.remove(Integer.valueOf(notJudge));
        }
        int answer = people.get(0);

        int count = 0;
        for (int[] t : trust) {
            if(t[1] == answer) count++;
        }
        if(count == N -1) return answer;
        return -1;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] trust = {{1, 2}, {1, 4}, {1, 3}, {2, 1}, {4, 3}};
        System.out.println(solution(n, trust));
    }
}
