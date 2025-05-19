package dev.yoha_ni.study.month_02.week8.day1;

import java.util.*;
import java.io.*;

class Task{
    int time;
    int price;

    public Task(int time, int price) {
        this.time = time;
        this.price = price;
    }
}

public class Baekjoon14501 {
    static final int UND = -1;
    static int N;
    static List<Task> tasks;
    static List<Integer> memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        tasks = new ArrayList<>();
        tasks.add(null);

        memo = new ArrayList<>(Collections.nCopies(N + 1, UND));

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            tasks.add(new Task(time, price));
        }

        System.out.println(f(1));
    }

    private static int f(int n) {
        if (n>N) return 0;
        if (memo.get(n) != UND) return memo.get(n);

        int ret = f(n+1);

        Task cur = tasks.get(n);
        int nextDay = n + cur.time;

        if (nextDay <= N + 1) ret = Math.max(ret, f(nextDay) + cur.price);

        memo.set(n, ret);
        return ret;
    }
}
