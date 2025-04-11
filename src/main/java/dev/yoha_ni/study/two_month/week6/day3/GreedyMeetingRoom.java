package dev.yoha_ni.study.two_month.week6.day3;

import java.util.*;
import java.io.*;

public class GreedyMeetingRoom {

    public static class Meeting implements Comparable<Meeting> {
        private int start;
        private int end;

        public Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting other){
            if(this.end == other.end) return this.start - other.start;
            return this.end - other.end;
        }

        @Override
        public String toString(){
            return String.format("[%s, %s]", this.start, this.end);
        }

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] inputData = br.readLine().split(" ");
            int start = Integer.parseInt(inputData[0]);
            int end = Integer.parseInt(inputData[1]);
            meetings.add(new Meeting(start, end));
        }

//        for (Meeting m : meetings) {
//            System.out.println(m);
//        }
//        System.out.println("-------------------");
        Collections.sort(meetings);

        for (Meeting m : meetings) {
            System.out.println(m);
        }

        int count = 0;
        int lastEndTime = 0;

        for (Meeting m : meetings) {
            if (m.start >= lastEndTime) {
                count++;
                lastEndTime = m.end;
            }
        }
        System.out.println(count);

    }
}
