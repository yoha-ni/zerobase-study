package dev.yoha_ni.study.week3.day2.annotation.custom;

import dev.yoha_ni.study.week3.day2.annotation.custom.validator.Validator;

public class CustomAnnotationMain {
    public static void main(String[] args) {
        CarRequest carRequest = new CarRequest("BMW", 2025); // CarRequest는 커스텀 어노테이션이 적용된 클래스 객체
        Validator.validateYear(carRequest);

        Car car = new Car(carRequest.getModel(), carRequest.getYear());
        System.out.println(car);


    }
}
