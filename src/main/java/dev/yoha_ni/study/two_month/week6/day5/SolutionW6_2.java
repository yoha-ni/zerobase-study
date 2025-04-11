package dev.yoha_ni.study.two_month.week6.day5;

import java.util.Arrays;

public class SolutionW6_2 {

//    입력값 〉[6, 2, 10]
//    기댓값 〉"6210"
    public static String solution(int[] numbers) {
        StringBuffer sb = new StringBuffer();

        String[] strNum = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        for (int i = 0; i < strNum.length - 1; i++) {
            for (int j = 0; j < strNum.length - i - 1; j++) {
                String a = strNum[j];
                String b = strNum[j + 1];
                if ((a + b).compareTo(b + a) < 0) {
                    String temp = strNum[j];
                    strNum[j] = strNum[j + 1];
                    strNum[j + 1] = temp;
                }
            }
        }

        for(String st : strNum)
            sb.append(st);

        return sb.toString();
    }

    public static void main(String[] args) {
//        int n = 4;
        int[] numbers = {6, 2, 10};
//        int[][] trust = {{1, 2}, {1, 4}, {1, 3}, {2, 1}, {4, 3}};
//        String[] arr = {"mv.song.mp3 11b", "greatSong.flac 1000b", "not3.txt 5b", "video.mp4 200b", "game.exe 100b", "mov1e.mkv 10000b"};


        System.out.println(solution(numbers));
    }
}
