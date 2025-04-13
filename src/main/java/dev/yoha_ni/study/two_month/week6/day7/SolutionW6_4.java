package dev.yoha_ni.study.two_month.week6.day7;

import java.util.Arrays;
import java.util.Stack;

public class SolutionW6_4 {

//    입력값 〉"imfinethankyou", "atfhinemnoyuki"
//    기댓값 〉true
    public static boolean solution(String s, String t) {
//        if (s.length() != t.length()) return false;
//        String[] findArray = t.split("");
//        int size = findArray.length;
//        boolean answer = true;
//        Stack<Character> sStack = new Stack<>();
//
//        for(char c : s.toCharArray()) sStack.push(c);
//
//        while (!sStack.isEmpty()) {
//            char c = sStack.pop();
//            boolean check = false;
//
//            for(int i = 0; i < size; i++){
//                if (findArray[i].charAt(0) == c) {
//                    findArray[i] = "check";
//                    check = true;
//                    break;
//                }
//            }
//            if(!check) return false;
//        }
//
//        return answer;

        if (s.length() != t.length()) return false;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        if(Arrays.equals(sArr, tArr)) return true;
        return false;
    }

    public static void main(String[] args) {
        String s = "imfinethankyou";
        String t = "atfhinemnoyuki";
//        int n = 4;
//        int[] numbers = {6, 2, 10};
//        int[][] trust = {{1, 2}, {1, 4}, {1, 3}, {2, 1}, {4, 3}};
//        String[] arr = {"mv.song.mp3 11b", "greatSong.flac 1000b", "not3.txt 5b", "video.mp4 200b", "game.exe 100b", "mov1e.mkv 10000b"};


        System.out.println(solution(s, t));
    }
}
