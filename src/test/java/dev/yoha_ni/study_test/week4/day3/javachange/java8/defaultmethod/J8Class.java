package dev.yoha_ni.study_test.week4.day3.javachange.java8.defaultmethod;

import java.time.ZonedDateTime;

public class J8Class implements J8Interface{
    @Override
    public String getTime() {
        return ZonedDateTime.now(java.time.ZoneId.of("Asia/Seoul")).toString();
    }
}
