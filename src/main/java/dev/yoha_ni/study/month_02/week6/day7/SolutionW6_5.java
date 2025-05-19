package dev.yoha_ni.study.month_02.week6.day7;

import java.util.*;

public class SolutionW6_5 {

    //    입력값 〉2, 20, [3, 6], [2, 1]
    //    기댓값 〉58
    public static int solution(int N, int M, int[] fry, int[] clean) {
        // 1단계: 치킨 튀기는 시간 시뮬레이션
        PriorityQueue<Fryer> fryerQueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            fryerQueue.offer(new Fryer(i, 0)); // 초기엔 전부 0분부터 시작
        }

        // 튀겨진 치킨 시간 기록 리스트
        List<Chicken> friedList = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            Fryer current = fryerQueue.poll();
            int fryerIndex = current.index;
            int nextTime = current.time + fry[fryerIndex];

            // 치킨 튀겨진 정보 기록
            friedList.add(new Chicken(fryerIndex, nextTime));

            // 다음 사용 가능한 시간으로 다시 큐에 넣음
            fryerQueue.offer(new Fryer(fryerIndex, nextTime));
        }

        // 2단계: 세척 시뮬레이션 (세척 시간 적용)
        // 각 튀김기별로 사용 가능한 세척 시간 관리
        PriorityQueue<Integer>[] cleanerQueue = new PriorityQueue[N];
        for (int i = 0; i < N; i++) {
            cleanerQueue[i] = new PriorityQueue<>();
        }

        int maxFinishTime = 0;

        for (Chicken ch : friedList) {
            int fryerIndex = ch.fryer;
            int fryFinishTime = ch.time;

            PriorityQueue<Integer> pq = cleanerQueue[fryerIndex];

            int earliestAvailable = 0;
            if (!pq.isEmpty()) {
                earliestAvailable = pq.poll(); // 가장 빨리 사용 가능한 시간
            }

            int cleanStart = Math.max(fryFinishTime + clean[fryerIndex], earliestAvailable);
            int cleanFinish = cleanStart + getCleanDuration(fryerIndex);

            // 다음 세척 가능 시간 큐에 등록
            pq.offer(cleanFinish);

            maxFinishTime = Math.max(maxFinishTime, cleanFinish);
        }

        return maxFinishTime;
    }

    // 튀김기 별 세척 시간 지정 (상황에 따라 하드코딩 or 전달인자로 변경 가능)
    private static int getCleanDuration(int fryerIndex) {
        // 예시: 0번 튀김기는 5분, 1번 튀김기는 7분
        if (fryerIndex == 0) return 5;
        else if (fryerIndex == 1) return 7;
        // 더 많은 튀김기 대응하려면 배열 등으로 변경 가능
        return 5; // 기본값
    }

    // 튀김기 상태를 나타내는 클래스 (시간 기준 정렬용)
    static class Fryer implements Comparable<Fryer> {
        int index;
        int time;

        Fryer(int index, int time) {
            this.index = index;
            this.time = time;
        }

        public int compareTo(Fryer o) {
            return this.time - o.time;
        }
    }

    // 튀겨진 치킨 정보
    static class Chicken {
        int fryer;
        int time;

        Chicken(int fryer, int time) {
            this.fryer = fryer;
            this.time = time;
        }
    }


    public static void main(String[] args) {
        int N = 2;
        int M = 20;
        int[] fry = {3, 6};
        int[] clean = {2, 1};

        System.out.println(solution(N, M, fry, clean));
    }
}
