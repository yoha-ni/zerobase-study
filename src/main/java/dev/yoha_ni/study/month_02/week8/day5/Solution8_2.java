package dev.yoha_ni.study.month_02.week8.day5;

class Item{
    int weight, value;

    Item(int w, int v) {
        this.weight = w;
        this.value = v;
    }
}

public class Solution8_2 {

    // 테스트 1
    // 입력값 〉8, 10, 15, [6, 4, 5, 6, 8, 9, 10, 3], [10, 4, 6, 8, 2, 8, 5, 6]
    // 기댓값 〉34

    public static int solution(int N, int K1, int K2, int[] W, int[] V) {
        Item[] items = new Item[N];
        for (int i = 0; i < N; i++) {
            items[i] = new Item(W[i], V[i]);
        }

        int[][] dp = new int[K1 + 1][K2 + 1];

        for (Item item : items) {
            int[][] next = new int[K1 + 1][K2 + 1];

            for (int w1 = 0; w1 <= K1; w1++) {
                for (int w2 = 0; w2 <= K2; w2++) {
                    next[w1][w2] = Math.max(next[w1][w2], dp[w1][w2]);

                    if (w1 + item.weight <= K1) {
                        next[w1 + item.weight][w2] = Math.max(next[w1 + item.weight][w2], dp[w1][w2] + item.value);
                    }

                    if (w2 + item.weight <= K2) {
                        next[w1][w2 + item.weight] = Math.max(next[w1][w2 + item.weight], dp[w1][w2] + item.value);
                    }
                }
            }

            dp = next;
        }

        int max = 0;
        for (int w1 = 0; w1 <= K1; w1++) {
            for (int w2 = 0; w2 <= K2; w2++) {
                max = Math.max(max, dp[w1][w2]);
            }
        }

       return max;
    }


    public static void main(String[] args) {
        int n = 8;
        int k1 = 10;
        int k2 = 15;
        int[] w = {6, 4, 5, 6, 8, 9, 10, 3};
        int[] v = {10, 4, 6, 8, 2, 8, 5, 6};


        System.out.println(solution(n, k1, k2, w, v));
    }
}
