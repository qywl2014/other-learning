package com.wulang.arithmetic.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并集合
 */
public class TwoWeiArraySort {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {8, 10}, {15, 18}, {2, 6}};

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if ((i == (intervals.length - 1)) || intervals[i][1] < intervals[i + 1][0]) {
                list.add(intervals[i]);
            } else {
                intervals[i + 1][0] = intervals[i][0];
                intervals[i + 1][1] = Math.max(intervals[i][1], intervals[i + 1][1]);
            }
        }

        for (int[] ints : list.toArray(new int[list.size()][2])) {
            System.out.println(ints[0] + "," + ints[1]);
        }
    }
}
