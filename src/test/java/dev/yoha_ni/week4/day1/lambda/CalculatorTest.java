package dev.yoha_ni.week4.day1.lambda;

import dev.yoha_ni.study.week4.day1.lambda.Calculator;
import dev.yoha_ni.study.week4.day1.lambda.Operate;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    @Test
    void testAdd(){
        Calculator calculator = new Calculator(10, 20);
        int result = calculator.calculate(
                new Operate() {
                    @Override
                    public int operate(int a, int b) {
                        return a + b;
                    }
                }
        );

        System.out.println(result);
    }

    @Test
    void testAddLambda(){
        Calculator calculator = new Calculator(10, 30);
        int result = calculator.calculate((int a, int b) -> a + b);

        System.out.println(result);
    }

    @Test
    void testAddLambda2() {
        Calculator calculator = new Calculator(20, 30);
        Operate operate = (int a, int b) -> (a + b);
        int result = calculator.calculate(operate);

        System.out.println(result);
    }

    @Test
    void testAddLambda3() {
        // given
        Calculator calculator = new Calculator(30, 30);
        // when
        int result = calculator.calculate(Integer::sum);
        // then
        System.out.println(result);
    }

    @Test
    void tsetAddLambda4(){
        Calculator calculator = new Calculator(30, 40);
        int resutl = calculator.calculate(getcalculater());
        System.out.println(resutl);
    }

    private Operate getcalculater() {
        return Integer::sum;
    }

}