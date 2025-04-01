package dev.yoha_ni.study.week4.assignment.practice;

/**
 * 제로베이스 35기 서요한
 * Design Patterns Null Object 패턴
 * 설명 : null 참조 대신 사용할 기본 객체를 제공하여 null 체크를 줄이고 NPE(Null Pointer Exception)를 방지
 * 장점: 코드의 안정성 향상, null 체크 로직 간소화
 * 적합한 상황: 반환값이 null일 수 있는 메서드, Optional 대신 사용하고 싶을 때
 */
public class NullObjectPattern {

    /**
     * @param debug 가 true 여기선 -> null 일경우
     * @return NullLog 이동
     */
    public static Log getLog(boolean debug) {
        return debug ? new ConsoleLog() : new NullLog();
    }

    public static void main(String[] args) {
        Log log = getLog(true);
        log.log("제로베이스");

    }
}

/**
 * 로그 인터페이스
 */
interface Log {
    void log(String message);
}

/**
 * null이 아닌경우 로직 처리
 */
class ConsoleLog implements Log{
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}

/**
 * null인 경우 로직 처리
 */
class NullLog implements Log{
    @Override
    public void log(String message) {
        System.out.println("Null 일경우 나오는 문자 입니다.");
    }
}