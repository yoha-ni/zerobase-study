package dev.yoha_ni.study.two_month.week8.day1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class PascalTriangle {
    static int UND = -1;
    static List<List<Integer>> memo;

    public static int comb(int n, int k) {
        if (n == k || k == 0) {
            return 1;
        }
        if (memo.get(n).get(k) != UND) {
            return memo.get(n).get(k);
        }

        memo.get(n).set(k, comb(n - 1, k - 1) + comb(n - 1, k));
        return memo.get(n).get(k);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        memo = new ArrayList<>(Collections.nCopies(K + 1, null));
        for (int i = 0; i <= N; i++) {
            memo.set(i, new ArrayList<>(Collections.nCopies(K + 1, UND)));
        }

        System.out.println(comb(N - 1, K - 1));
    }
}
