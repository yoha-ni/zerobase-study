package dev.yoha_ni.study.one_month.week4.assignment.practice;

public class AnnotationReflectionDemo {
    public static void main(String[] args) throws Exception {
        DisplayService displayService = new DisplayService();

        // 일반적인 메서드 호출
        displayService.printDisplay("John", 30);
        displayService.printDisplay2("Jane", 25, "123 Main St");
        displayService.namePrint("시발 서요한");

    }
}
