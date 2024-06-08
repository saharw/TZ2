package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

public class NumberProcessor {
    //
    private BigInteger[] numbers;

    public NumberProcessor(String path) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String content = reader.readLine();
            String[] numberStrings = content.split("\\s+");
            numbers = Arrays.stream(numberStrings)
                    .map(BigInteger::new)
                    .toArray(BigInteger[]::new);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BigInteger _min() {
        return Arrays.stream(numbers).min(BigInteger::compareTo).orElse(BigInteger.ZERO);


    }

    public BigInteger _max() {
        return Arrays.stream(numbers).max(BigInteger::compareTo).orElse(BigInteger.ZERO);
    }

    public BigInteger _sum() {
        return Arrays.stream(numbers).reduce(BigInteger.ZERO, BigInteger::add);



    }

    public BigInteger _mult() {
        return Arrays.stream(numbers).reduce(BigInteger.ONE, BigInteger::multiply);
    }
    public void testAveragePerformance() {
        int[] sizes = {10, 100, 1000,10000, 100000, 1000000};
        for (int size : sizes) {
            String fileName = "example_" + size + ".txt";
            double totalDuration = 0;

            for (int i = 0; i < 100; i++) {
                long startTime = System.nanoTime();
                NumberProcessor test = new NumberProcessor(fileName);
                test._max();
                test._min();
                test._sum();

                long endTime = System.nanoTime();
                double duration = (endTime - startTime) / 1000000.0  ; // в миллисекундах
                totalDuration += duration;
            }

            double averageDuration = Math.round(totalDuration) / 100.0;
            System.out.println("Среднее время выполнения для файла размером " + size + ": " + averageDuration + " миллисекунд");
        }
    }

}
