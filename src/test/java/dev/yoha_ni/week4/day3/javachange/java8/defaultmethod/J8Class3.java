package dev.yoha_ni.week4.day3.javachange.java8.defaultmethod;

import java.time.ZonedDateTime;

public class J8Class3 implements J8Interface{
    @Override
    public String getTime() {
        return ZonedDateTime.now(java.time.ZoneId.of("Europe/Paris")).toString();
    }
}
