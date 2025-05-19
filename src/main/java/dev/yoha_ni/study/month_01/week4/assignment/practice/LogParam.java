package dev.yoha_ni.study.month_01.week4.assignment.practice;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 어노테이션 정의 (가장 중요한 부분)
@Retention(RetentionPolicy.RUNTIME)  // 런타임 동안 어노테이션 정보 유지
@Target(ElementType.METHOD)           // 메서드에만 적용 가능
@interface LogParam {
    // 어노테이션 본문 (비어있어도 됨)
}
