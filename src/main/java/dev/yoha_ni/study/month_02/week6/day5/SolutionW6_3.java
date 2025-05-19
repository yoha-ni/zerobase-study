package dev.yoha_ni.study.month_02.week6.day5;

public class SolutionW6_3 {

//    입력값 〉"221123"
//    기댓값 〉"2 1 3 0 4 5 6 7 8 9"
    public static String solution(String s) {
        StringBuffer sb = new StringBuffer();
        int[] numCount = new int[10];
        boolean[] check = new boolean[10];

        for (char c : s.toCharArray()) {
            int num = c - '0';
            numCount[num]++;
        }

        int index = 0;
        for (int i = 0; i < numCount.length; i++) {
            int count = -1;
            int value = -1;

            for (int j = 0; j < numCount.length; j++) {
                if(numCount[j] > count && !check[j]){
                    count = numCount[j];
                    value = j;
                }
            }

            if(count == -1) break;

            check[value] = true;
            sb.append(value + " ");
        }

        return sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        String s = "221123";
//        int n = 4;
//        int[] numbers = {6, 2, 10};
//        int[][] trust = {{1, 2}, {1, 4}, {1, 3}, {2, 1}, {4, 3}};
//        String[] arr = {"mv.song.mp3 11b", "greatSong.flac 1000b", "not3.txt 5b", "video.mp4 200b", "game.exe 100b", "mov1e.mkv 10000b"};


        System.out.println(solution(s));
    }
}
