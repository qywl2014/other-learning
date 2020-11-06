package com.wulang.arithmetic.sort;

import com.wulang.util.DataUtil;
import java.util.Random;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        DataUtil.sortTest(QuickSort::sort, 20);
    }

    private static void sort(int[] input) {
        sort(input, 0, input.length - 1);
    }

    private static void sort(int[] input, int start, int end) {
        if (start >= end) {
            return;
        }
        Random random = new Random();
        int pivotIndex = random.nextInt(end - start + 1) + start;
        swap(input, pivotIndex, end);
        int pivot = input[end];
        boolean isMark = false;
        int i = 0;
        for (int j = end - 1; i <= j; ) {
            if (isMark) {
                if (input[j] >= pivot) {
                    j--;
                } else {
                    swap(input, i, j);
                    j--;
                    i++;
                    isMark = false;
                }
            } else {
                if (input[i] <= pivot) {
                    i++;
                } else {
                    isMark = true;
                }
            }
        }
        swap(input, i, end);
        sort(input, start, i - 1);
        sort(input, i + 1, end);
    }

    private static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
