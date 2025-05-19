package dev.yoha_ni.study.month_01.week3.day2.jvm.oom.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoGenerator {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBERS_TO_GENERATE = 6;

    public List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
        Random random = new Random();

        while (lottoNumbers.size() < NUMBERS_TO_GENERATE) {
            int number = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
            if (!lottoNumbers.contains(number)) {
                lottoNumbers.add(number);
            }
        }

        return lottoNumbers;
    }

    public void generateLottoNumbersInfinitely() {
        List<List<Integer>> lottoNumbersList = new ArrayList<>();
        while (true) {
            lottoNumbersList.add(generateLottoNumbers());
            System.out.println(lottoNumbersList);
        }
    }
}