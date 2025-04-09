package dev.yoha_ni.study.two_month.week6.day2;

public class BinarySearch {

    public static void main (String[] args){
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};
        int find = 1;
        int left = 0;
        int right = arr.length;
        int mid = arr.length / 2;

        for (int i = 0; i < arr.length / 2; i++) {

            if (arr[mid] == find) {
                break;
            }
            if (arr[mid] > find) {
                mid = (left + mid) / 2;
            }
            if (arr[mid] < find) {
                mid = (mid + right) / 2;
            }
        }

        System.out.println(arr[mid]);
    }
}
