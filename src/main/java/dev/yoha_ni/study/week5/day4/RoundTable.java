package dev.yoha_ni.study.week5.day4;

import java.io.*;
import java.util.*;

public class RoundTable {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Queue<Integer> qu = new LinkedList<>();
        for (int i = 1; i <= N; i++)
            qu.offer(i);

        StringBuffer sb = new StringBuffer();
        while(!qu.isEmpty()){
            sb.append(qu.poll()).append(" ");

            if(qu.isEmpty()) break;

            for (int m = 1; m < M; m++) {
                qu.offer(qu.poll());
            }
        }

        System.out.println(sb.toString());
    }
}
