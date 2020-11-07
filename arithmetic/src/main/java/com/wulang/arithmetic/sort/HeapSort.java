package com.wulang.arithmetic.sort;

import com.wulang.arithmetic.base.heap.MaxHeap;
import com.wulang.util.DataUtil;

/**
 * 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        DataUtil.sortTest(HeapSort::heapSort, 20);
    }

    private static void heapSort(int[] input) {
        MaxHeap.buildMaxHeap(input);
        for (int i = 0; i < input.length - 1; i++) {
            DataUtil.swap(input, 0, input.length - 1 - i);
            MaxHeap.adjust(input, 0, input.length - 1 - i);
        }
    }
}
