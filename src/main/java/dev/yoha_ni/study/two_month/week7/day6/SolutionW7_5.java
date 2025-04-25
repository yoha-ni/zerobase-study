package dev.yoha_ni.study.two_month.week7.day6;

public class SolutionW7_5 {

//    입력값 〉"105990", 1
//    기댓값 〉"5990"

    public static int solution(int N, int[] cards) {
        int total = 0;
        for (int num : cards) total += num;

        boolean[] dp = new boolean[total / 2 + 1];
        dp[0] = true;

        for (int num : cards) {
            for (int i = total / 2; i >= num; i--) {
                if (dp[i - num]) {
                    dp[i] = true;
                }
            }
        }

        for (int i = total / 2; i >= 0; i--) {
            if (dp[i]) {
                return total - 2 * i;
            }
        }

        return total;

    }

    public static void main(String[] args) {
        int n = 10;
        int[] cards = {19, 7, 18, 12, 15, 2, 17, 7, 20, 8};

        System.out.println(solution(n, cards));

    }
}
