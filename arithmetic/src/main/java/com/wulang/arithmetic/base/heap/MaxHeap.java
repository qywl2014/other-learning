package com.wulang.arithmetic.base.heap;

import com.wulang.util.DataUtil;

import java.util.stream.IntStream;

public class MaxHeap {
    public static void main(String[] args) {
        int[] array = IntStream.of(5, 6, 4, 7, 1, 2, 8, 3, 9, 0).toArray();
        new MaxHeap(array);
        DataUtil.printArray(array);
    }

    private int[] elementData;

    private int size;

    public MaxHeap(int[] array) {
        elementData = array;
        size = elementData.length;
        buildMaxHeap(elementData);
    }

    public static void buildMaxHeap(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int parentIndex = (i - 1) / 2;
            if (array[i] > array[parentIndex]) {
                DataUtil.swap(array, i, parentIndex);
                adjust(array, i, array.length);
            }
        }
    }

    public static void adjust(int[] array, int index, int size) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if ((left > size - 1 || array[index] >= array[left])
                && (right > size - 1 || array[index] >= array[right])) {
            return;
        }
        if (array[left] >= array[index] && (right > size - 1 || array[left] >= array[right])) {
            DataUtil.swap(array, left, index);
            adjust(array, left, size);
            return;
        }
        DataUtil.swap(array, right, index);
        adjust(array, right, size);
    }

    public int pop() {
        int min = elementData[0];
        elementData[0] = elementData[size - 1];
        size--;
        adjust(elementData, 0, size);
        return 1;
    }
}
