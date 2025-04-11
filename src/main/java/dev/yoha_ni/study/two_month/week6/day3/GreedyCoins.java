package dev.yoha_ni.study.two_month.week6.day3;

import java.io.*;
import java.util.*;

public class GreedyCoins {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int amount = Integer.parseInt(br.readLine());
        int[] coins = {500, 100, 50, 10};
        int count = 0;

        for (int coin : coins) {
            count += amount / coin;
            amount = amount % coin;
        }

        System.out.println(count);

    }
}
