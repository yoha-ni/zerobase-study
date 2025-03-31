package dev.yoha_ni.study.week4.assignment.optional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StreamInput {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("여러 개의 숫자를 입력하세요 (공백 또는 쉼표로 구분):");
        String num = sc.nextLine();

        // 입력값 split 후 정수 리스트 변환
        List<Integer> numbers = Arrays.stream(num.split("\\s*[, ]\\s*"))
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // 합계
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();

        // 평균
        double average = numbers.stream().mapToInt(Integer::intValue).average().orElse(0);

        // 짝수
        List<Integer> evenNumbers = numbers.stream().filter(n -> (n % 2) == 0).collect(Collectors.toList());
        // 홀수
        List<Integer> oddNumbers = numbers.stream().filter(n -> (n % 2) != 0).collect(Collectors.toList());

        // 가장 큰값
        int max = numbers.stream().max(Comparator.naturalOrder()).orElse(0);
        // 가장 작은값
        int min = numbers.stream().min(Comparator.naturalOrder()).orElse(0);

        // 중복 제거 및 정렬
        List<Integer> sortedNumbers = numbers.stream().distinct().sorted().collect(Collectors.toList());

        print(numbers, sum, average, evenNumbers, oddNumbers, max, min, sortedNumbers);

    }

    private static void print(List<Integer> numbers, int sum, double average, List<Integer> evenNumbers, List<Integer> oddNumbers, int max, int min, List<Integer> sortedNumbers) {
        System.out.println("\n==== 분석 결과 ====");
        System.out.println("입력한 숫자: " + numbers);
        System.out.println("합계: " + sum);
        System.out.println("평균: " + average);
        System.out.println("짝수: " + evenNumbers);
        System.out.println("홀수: " + oddNumbers);
        System.out.println("최대값: " + max);
        System.out.println("최소값: " + min);
        System.out.println("중복 제거 후 정렬: " + sortedNumbers);
    }
}
