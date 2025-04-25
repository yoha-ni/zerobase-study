package dev.yoha_ni.study.two_month.week8.day5;

import java.util.Arrays;

public class Solution8_1 {

    // 테스트 1
    // 입력값 〉3000,[1100,500,200,150,25]
    // 기댓값 〉5

    public static int solution(int money, int[] chips) {
        int[] dp = new int[money + 1];
        Arrays.fill(dp, money + 1); // 충분히 큰 값으로 초기화
        dp[0] = 0;

        for (int chip : chips) {
            for (int i = chip; i <= money; i++) {
                dp[i] = Math.min(dp[i], dp[i - chip] + 1);
            }
        }

        return (dp[money] > money) ? -1 : dp[money]; // 만들 수 없으면 -1
    }


    public static void main(String[] args) {
        int money = 6;
//        int money = 3000;
//        int[] chips = {1100, 500, 200, 150, 25};
        int[] chips = {1, 3, 4};

        System.out.println(solution(money, chips));
    }
}
