package dev.yoha_ni.study.two_month.week7.day6;

import java.util.*;

class Node{
    int totalTime;
    List<Integer> remaining;
    int lastSkill;

    public Node(int totalTime, List<Integer> remaining, int lastSkill) {
        this.totalTime = totalTime;
        this.remaining = remaining;
        this.lastSkill = lastSkill;
    }
}

public class SolutionW7_3 {
    public int solution(int N, int[] boss, int[] skill) {

        List<Integer> initialRemaining = new ArrayList<>();
        for (int i = 0; i < N; i++) initialRemaining.add(i);
        Node start = new Node(0, initialRemaining, 0);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);

        int minTime = 987654321;
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.remaining.isEmpty()) {
                minTime = Math.min(minTime, current.totalTime);
            } else {
                for (int i = 0; i < current.remaining.size(); i++) {
                    int bossIndex = current.remaining.get(i);

                    int timeNeeded = Math.max(0, boss[bossIndex] - current.lastSkill);

                    List<Integer> newRemaining = new ArrayList<>(current.remaining);
                    newRemaining.remove(i);

                    int newTotalTime = current.totalTime + timeNeeded;
                    int newSkill = skill[bossIndex];

                    Node next = new Node(newTotalTime, newRemaining, newSkill);
                    queue.offer(next);

                }
            } 
        }

        return minTime;
    }
}