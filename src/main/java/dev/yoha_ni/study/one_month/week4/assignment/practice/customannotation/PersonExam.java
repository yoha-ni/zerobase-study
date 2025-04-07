package dev.yoha_ni.study.one_month.week4.assignment.practice.customannotation;

import java.lang.reflect.InvocationTargetException;

/**
 * 제로베이스 35기 서요한.
 * 실행시키는 메인 클래스
 */

public class PersonExam {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        PersonInterface person = LoggingProxy.createProxy(
                new Person("신형만", 35, "떡잎마을"),
                PersonInterface.class
        );

        person.display("신형만", 35, "떡잎마을");

        person.mySon("신짱구", 5);

        person.myWife("봉미선");
    }
}
