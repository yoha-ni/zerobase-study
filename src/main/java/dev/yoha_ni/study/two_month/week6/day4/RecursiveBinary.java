package dev.yoha_ni.study.two_month.week6.day4;

public class RecursiveBinary {

    private static int binarySearchWhile(int[] arr, int target, int left, int right) {
        if(left > right) return -1;
        int mid = (left + right) / 2;

        if (arr[mid] == target) return mid;
        else if (arr[mid] > target) right = mid - 1;
        else left = mid + 1;
        return binarySearchWhile(arr, target, left, right);
    }

    public static void main (String[] args){
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};
        int target = 11;
        int left = 0;
        int right =arr.length - 1;

        int index = binarySearchWhile(arr, target, left, right);
        System.out.println(index);
    }
}
