package dev.yoha_ni.study.two_month.week8.day3;

import com.sun.source.tree.WhileLoopTree;

import java.util.*;
import java.io.*;

class Vertex{
    int n;
    int w;

    public Vertex(int n, int w) {
        this.n = n;
        this.w = w;
    }
}

public class Zero_OneBFS {
    static final int UND = -1;
    static int N, K, MAX;

    static List<Integer> visited;
    static Deque<Vertex> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        MAX = Math.max(N, 2 * K);

        visited = new ArrayList<>(Collections.nCopies(MAX + 1, UND));
        dq.addLast(new Vertex(N, 0));

        while (!dq.isEmpty()) {
            Vertex cur = dq.pollFirst();
            if (visited.get(cur.n) == UND) {
                visited.set(cur.n, cur.w);
                List<Vertex> nxtList = Arrays.asList(
                        new Vertex(cur.n * 2, cur.w),
                        new Vertex(cur.n + 1, cur.w + 1),
                        new Vertex(cur.n - 1, cur.w + 1)
                );
                for (Vertex nxt : nxtList) {
                    if (0 <= nxt.n && nxt.n <= MAX) {
                        if (nxt.w == cur.w) {
                            dq.addFirst(nxt);
                        } else {
                            dq.addLast(nxt);
                        }
                    }
                }
            }
        }
        System.out.println(visited.get(K));
    }
}
