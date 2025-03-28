package dev.yoha_ni.week4.assignment.practice.customannotation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 제로베이스 35기 서요한.
 * 메서드 호출을 가로채어서 매개변수 로그 기록하는 메인 메소드
 */

class LoggingProxy implements InvocationHandler {
    // 실제 작업을 수행할 원본 객체
    private final Object target;

    // 생성자: 로깅할 대상 객체를 받음
    public LoggingProxy(Object target) {
        this.target = target;
    }

    // 메서드 호출을 가로채는 핵심 메서드
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // @LogParameters 어노테이션이 있는 메서드인지 확인
        if (method.isAnnotationPresent(LogParam.class)) {
            System.out.println("[LOG Param]: " + (args != null ? Arrays.toString(args) : "없음"));
        }

        return method.invoke(target, args);
    }

    // 동적 프록시 객체를 생성하는 정적 메서드
    @SuppressWarnings("unchecked")
    public static <T> T createProxy(T target, Class<T> interfaceType) {
        return (T) Proxy.newProxyInstance(
                // 클래스 로더: 인터페이스의 클래스 로더 사용
                interfaceType.getClassLoader(),
                
                // 프록시가 구현할 인터페이스들 단일 인터페이스만 전달
                new Class<?>[]{interfaceType},
                
                new LoggingProxy(target)
        );
    }
}