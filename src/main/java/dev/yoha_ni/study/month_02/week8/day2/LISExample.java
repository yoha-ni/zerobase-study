package dev.yoha_ni.study.month_02.week8.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class LISExample {
    static final int UND = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();
        List<Integer> table = new ArrayList<>(Collections.nCopies(N + 1, 0));
        arr.add(UND);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 1; n <= N; n++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        int result = 0;

        for (int cur = 1; cur <= N; cur++) {
            int mx= 0;
            for (int pre = 1; pre < cur; pre++) {
                if (arr.get(pre) < arr.get(cur) && mx < table.get(pre)) {
                    mx = table.get(pre);
                }
            }
            table.set(cur, mx + 1);
            result = Math.max(result, table.get(cur));
        }
        System.out.println(result);
    }
}
