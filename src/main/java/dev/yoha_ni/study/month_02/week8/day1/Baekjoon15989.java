package dev.yoha_ni.study.month_02.week8.day1;

import java.io.*;
import java.util.*;

public class Baekjoon15989 {
    static final int UND = -1;
    static final int NUMBERS = 3;
    static final int MAX = 10000;
    static List<List<Integer>> memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        memo = new ArrayList<>(Collections.nCopies(MAX + 1, null));
        for (int i = 0; i <= MAX; i++) {
            memo.set(i, new ArrayList<>(Collections.nCopies(NUMBERS + 1, UND)));
        }

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(f(N, NUMBERS));
            
        }
    }

    private static int f(int n, int pre) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (memo.get(n).get(pre) != UND) return memo.get(n).get(pre);
        memo.get(n).set(pre, 0);

        for (int cur = 1; cur <= NUMBERS; cur++) {
            if (cur <= pre) memo.get(n).set(pre, memo.get(n).get(pre) + f(n - cur, cur));
        }
        return memo.get(n).get(pre);
    }
}
