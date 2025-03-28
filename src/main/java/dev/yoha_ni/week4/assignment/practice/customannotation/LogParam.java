package dev.yoha_ni.week4.assignment.practice.customannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 제로베이스 35기 서요한
 * 어노테이션 클래스 런타임시 and 메소드에만 적용
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogParam {
}
