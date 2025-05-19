package dev.yoha_ni.study.month_02.week8.day1;

import java.util.Scanner;

public class IgnitionExample {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(calculateIgnition(n));

        sc.close();
    }

    private static long calculateIgnition(int n) {
        long[] dp = new long[n + 1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }

        return dp[n];
    }
}
