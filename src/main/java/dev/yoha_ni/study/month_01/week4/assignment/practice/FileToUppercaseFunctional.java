package dev.yoha_ni.study.month_01.week4.assignment.practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 제로베이스 35기 서요한
 * 파일 Stream 처리
 */
public class FileToUppercaseFunctional {
    final static String FILEPATH = "src\\main\\java\\dev\\yoha_ni\\week4\\assignment\\practice\\assignment.txt"; // 파일위치 경로

    public static void main(String[] args) {
        Function<String, String> toUpperCase = line -> line.toUpperCase();
        Predicate<String> nonEmptyLine = line -> !line.trim().isEmpty();

        try (Stream<String> lines = Files.lines(Paths.get(FILEPATH))) {
            List<String> upperCaseLines = lines
                    .filter(nonEmptyLine)
                    .map(toUpperCase)
                    .collect(Collectors.toList());

            upperCaseLines.forEach(System.out::println);

            System.out.println("\n총 라인 수: " + upperCaseLines.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}