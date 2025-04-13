package dev.yoha_ni.study.two_month.week6.day7;

public class SolutionW6_8 {

//    입력값 〉"105990", 1
//    기댓값 〉"5990"

    public static int solution(int[][] heights) {
        int cols = heights[0].length;
        int rows = heights.length;

        int min = minOutline(heights, cols, rows);

        int totalWater = 0;
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                int height = heights[i][j];
                if (height < min) {
                    totalWater += (min - height);
                }
            }
        }

        return totalWater;
    }

    public static int minOutline(int[][] heights, int cols, int rows){
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < rows; i++) {
            min = Math.min(min, heights[i][0]);
            min = Math.min(min, heights[i][cols - 1]);
        }

        for (int j = 1; j < cols - 1; j++) {
            min = Math.min(min, heights[0][j]);
            min = Math.min(min, heights[rows - 1][j]);
        }

        return min;
    }

    public static void main(String[] args) {

//        int[][] heights = {
//                {3, 3, 3, 3, 3, 3},
//                {3, 1, 3, 1, 1, 3},
//                {3, 1, 3, 2, 1, 3},
//                {3, 3, 3, 3, 3, 3}
//        };
        int[][] heights = {
                {3, 3, 3, 3, 3},
                {3, 1, 2, 1, 3},
                {3, 3, 3, 3, 3}
        };

        System.out.println(solution(heights));
    }
}
