package dev.yoha_ni.week4.assignment.practice;

// 예제 구현
interface Logger {
    void log(String message);
}

class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}

class NullLogger implements Logger {  // Null Object
    @Override
    public void log(String message) {
        // 아무것도 하지 않음
    }
}

// 사용 예시
public class Main {
    public static Logger getLogger(boolean debug) {
        return debug ? new ConsoleLogger() : new NullLogger();
    }
    
    public static void main(String[] args) {
        Logger logger = getLogger(false); // NullLogger 반환
        logger.log("이 메시지는 출력되지 않음"); // NPE 발생 없이 안전하게 호출
    }
}