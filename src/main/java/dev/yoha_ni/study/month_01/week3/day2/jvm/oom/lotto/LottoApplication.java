package dev.yoha_ni.study.month_01.week3.day2.jvm.oom.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoApplication {
    // 정적 리스트에 계속 데이터를 추가하여 GC가 회수하지 못하게 함
    private static final List<Object> MEMORY_HOLDER = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("로또 번호 생성 및 OOM 테스트 시작...");
        LottoNumberGenerator generator = new LottoNumberGenerator();

        try {
            int count = 0;
            while (true) {
                count++;
                List<Integer> lottoNumbers = generator.generateLottoNumbers();
                System.out.println(count + "번째 로또 번호: " + lottoNumbers);

                // 중요: 이 정적 리스트에 참조를 계속 추가하면 GC가 메모리를 회수할 수 없음
                MEMORY_HOLDER.add(new MemoryConsumer(1024 * 1024)); // 1MB 데이터 + 객체 오버헤드

                // 이렇게 하면 메모리가 올라갔다 내려갔다 하지 않고 지속적으로 증가함
                if (count % 10 == 0) {
                    System.out.println("현재 메모리 사용량: 약 " + (count * 1) + "MB");
                }
            }
        } catch (OutOfMemoryError e) {
            System.out.println("성공적으로 OOM 발생! " + e.getMessage());
            e.printStackTrace();
        }
    }
}

/**
 * 메모리를 소비하는 클래스
 */
class MemoryConsumer {
    private byte[] memory;
    private String[] stringArray;

    public MemoryConsumer(int size) {
        // 바이트 배열로 메모리 할당
        this.memory = new byte[size];

        // 문자열 배열도 할당하여 더 많은 메모리 사용
        this.stringArray = new String[1000];
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = "메모리 소비 문자열 #" + i + " " + System.nanoTime();
        }
    }

    // finalize 메서드를 오버라이드하여 GC가 더 느리게 동작하게 함
    @Override
    protected void finalize() throws Throwable {
        try {
            // 의도적으로 finalize 메서드를 복잡하게 만들어 GC를 방해
            Thread.sleep(1);
        } finally {
            super.finalize();
        }
    }
}

/**
 * 로또 번호를 생성하는 클래스
 */
class LottoNumberGenerator {
    private static final int LOTTO_SIZE = 6;
    private static final int MAX_NUMBER = 45;
    private Random random;

    public LottoNumberGenerator() {
        this.random = new Random();
    }

    /**
     * 1부터 45까지의 숫자 중 중복되지 않는 6개의 숫자를 생성합니다.
     *
     * @return 생성된 로또 번호 목록
     */
    public List<Integer> generateLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();

        // 1부터 45까지의 숫자 목록 생성
        List<Integer> pool = new ArrayList<>();
        for (int i = 1; i <= MAX_NUMBER; i++) {
            pool.add(i);
        }

        // 숫자 목록을 섞고 앞에서 6개 선택
        Collections.shuffle(pool, random);
        for (int i = 0; i < LOTTO_SIZE; i++) {
            numbers.add(pool.get(i));
        }

        // 번호 정렬
        Collections.sort(numbers);
        return numbers;
    }
}