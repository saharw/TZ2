package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

public class NumberProcessor {

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


}
