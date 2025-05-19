package dev.yoha_ni.study.month_02.week6.day4;

import java.io.*;

public class RecursiveFactorial {

    private static int factorial(int num, int total) {
        if(num == 1) return total;
        int n = num - 1;
        total *= n;
        return factorial(n, total);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int total = num;


        System.out.println(factorial(num, total));
    }
}
