package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumberProcessorTest {

    private static final String TEST_FILE = "example.txt";
    private static final String LARGE_TEST_FILE = "example1.txt";

    @BeforeAll
    public static void setUp() throws IOException {
        // Подготовка данных для тестирования

        createFile(TEST_FILE, "1 4 2 3");
        createBigFile(LARGE_TEST_FILE, 1000000); // уменьшен размер до 1 млн для тестов

        createBigFile("example_10.txt", 10);
        createBigFile("example_100.txt", 100);
        createBigFile("example_1000.txt", 1000);
        createBigFile("example_10000.txt", 10000);

        createBigFile("example_100000.txt", 100000);
        createBigFile("example_1000000.txt", 1000000);
    }



    @Test
    public void testMin() {
        NumberProcessor test = new NumberProcessor(TEST_FILE);
        assertEquals(new BigInteger("1"), test._min());
    }

    @Test
    @Disabled
    public void testMax() {
        NumberProcessor test = new NumberProcessor(TEST_FILE);
        assertEquals(new BigInteger("5"), test._max());
    }

    @Test
    public void testSum() {
        NumberProcessor test = new NumberProcessor(TEST_FILE);
        assertEquals(new BigInteger("10"), test._sum());
    }

    @Test
    public void testMult() {
        NumberProcessor test = new NumberProcessor(TEST_FILE);
        assertEquals(new BigInteger("24"), test._mult());
    }

    @Test
    public void testLargeFileMin() {
        NumberProcessor test = new NumberProcessor(LARGE_TEST_FILE);
        assertEquals(new BigInteger("1"), test._min());
    }

    @Test
    public void testLargeFileMax() {
        NumberProcessor test = new NumberProcessor(LARGE_TEST_FILE);
        assertEquals(new BigInteger("1000000"), test._max());
    }

    @Test
    public void testLargeFileSum() {
        NumberProcessor test = new NumberProcessor(LARGE_TEST_FILE);
        BigInteger expectedSum = BigInteger.valueOf(1000000L)
                .multiply(BigInteger.valueOf(1000000L + 1))
                .divide(BigInteger.valueOf(2));
        assertEquals(expectedSum, test._sum());
    }
    @Test
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




    public static void createFile(String name, String data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(name))) {
            writer.write(data);
        }
    }

    public static void createBigFile(String name, int size) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(name))) {
            for (int i = 1; i <= size; i++) {
                writer.write(i + " ");
            }
        }
    }
}
