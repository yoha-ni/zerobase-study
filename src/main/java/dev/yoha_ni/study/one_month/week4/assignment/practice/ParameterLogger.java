package dev.yoha_ni.study.one_month.week4.assignment.practice;

public class ParameterLogger {
    // 리플렉션을 사용한 메서드 파라미터 로깅
    public static void logParameters(Object[] args) {
        System.out.print("paramLog[");
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i] + (i < args.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}

