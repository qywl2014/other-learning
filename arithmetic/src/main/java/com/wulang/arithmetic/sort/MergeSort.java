package com.wulang.arithmetic.sort;

import com.wulang.util.DataUtil;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        DataUtil.sortTest(MergeSort::sortV1, 20);
    }

    private static void sortV1(int[] input) {
        sortV1(input, 0, input.length - 1);
    }

    private static void sortV1(int[] input, int start, int end) {
        int middle = (start + end) / 2;

        int lEnd = start;
        if (start < middle) {
            lEnd = middle;
            sortV1(input, start, middle);
        }

        int rStart = end;
        if (middle + 1 < end) {
            rStart = middle + 1;
            sortV1(input, middle + 1, end);
        }

        int[] tempArray = new int[end - start + 1];
        for (int i = start, j = rStart, t = 0; t < end - start + 1; t++) {
            if (i > lEnd) {
                tempArray[t] = input[j];
                j++;
            } else if (j > end) {
                tempArray[t] = input[i];
                i++;
            } else if (input[i] <= input[j]) {
                tempArray[t] = input[i];
                i++;
            } else {
                tempArray[t] = input[j];
                j++;
            }
        }

        for (int i = start, t = 0; i <= end; i++, t++) {
            input[i] = tempArray[t];
        }
    }
}
