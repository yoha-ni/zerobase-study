package dev.yoha_ni.week4.day3.javachange.java17;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwitchExpressionTest {
    enum Day{
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
    @Test
    void switchExpression() {
        Day targetDay = Day.MONDAY;

        // old
        String type1;
        switch (targetDay) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                type1 = "WORKDAY";
                break;
            case SATURDAY:
            case SUNDAY:
                type1 = "HOLIDAY";
                break;
            default:
                type1 = "UNKNOWN";
        }

        // new (switch expression)
        String type2 = switch (targetDay) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "WORKDAY";
            case SATURDAY, SUNDAY -> "HOLIDAY";
            default -> "UNKNOWN";
        };

        // 테스트
        assertEquals("WORKDAY", type1);
        assertEquals("WORKDAY", type2);
    }

    @Test
    void switchExpression2() {
        Day targetDay = Day.MONDAY;  // 오타 수정: NONDAY -> MONDAY

        // old
        String type1;
        switch (targetDay) {
            case MONDAY:
                type1 = "월요일";
                break;
            case TUESDAY:
                type1 = "화요일";
                break;
            case WEDNESDAY:
                type1 = "수요일";
                break;
            case THURSDAY:
                type1 = "목요일";
                break;
            case FRIDAY:
                type1 = "금요일";
                break;
            case SATURDAY:
                type1 = "토요일";
                break;
            case SUNDAY:
                type1 = "일요일";
                break;
            default:
                type1 = "알 수 없는 요일";
        }

        // new (switch expression)
        String type2 = switch (targetDay) {
            case MONDAY -> "월요일";
            case TUESDAY -> "화요일";
            case WEDNESDAY -> "수요일";
            case THURSDAY -> "목요일";
            case FRIDAY -> "금요일";
            case SATURDAY -> "토요일";
            case SUNDAY -> "일요일";
            default -> "알 수 없는 요일";
        };

        // 테스트
        assertEquals("월요일", type1);
        assertEquals("월요일", type2);
    }
}
