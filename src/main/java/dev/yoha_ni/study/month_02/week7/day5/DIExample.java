package dev.yoha_ni.study.month_02.week7.day5;

public class DIExample {
    static final int INF = 987654321;
    static final int cnt = 0;

    public static void main(String[] args) {
        int x = 10;
        int result = f(x);
        System.out.println(result);
    }

    public static int f(int x) {
        if (x == 1) return 0;

        int ret = INF;

        if (x % 3 == 0) ret = Math.min(f(x / 3), ret);
        if (x % 2 == 0) ret = Math.min(f(x / 2), ret);

        return Math.min(f(x-1), ret) + 1;
    }
}
