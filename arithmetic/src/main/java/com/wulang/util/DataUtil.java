package com.wulang.util;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataUtil {

    private static int[] randomArray() {
        List<Integer> collect = Stream.of(3, 1, 5, 2, 4, 6, 6, 7, 9, 10, 11, 8, 13, 12, 15, 14)
                .collect(Collectors.toList());
        Collections.shuffle(collect);
        return collect.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void printArray(int[] input) {
        for (int i : input) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;

    }

    public static void sortTest(Consumer<int[]> sort, int times) {
        for (int i = 0; i < times; i++) {
            int[] array = randomArray();
            sort.accept(array);
            printArray(array);
        }
    }
}
