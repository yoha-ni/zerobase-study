package dev.yoha_ni.study.two_month.week8.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SteppingExample {
    static final int UND = -1;
    static int[] dp;
    static final int MAX = 10;

    private static int f(int n) {
        if(n < 0) return 0;
        if(n == 0) return 1;
        if(dp[n] != UND) return dp[n];
        dp[n] = f(n-1) + f(n-2) + f(n-3);

        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        dp = new int[MAX + 1];
        for (int i = 0; i <= MAX; i++) {
            dp[i] = UND;
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(f(N));
        }

    }
}
