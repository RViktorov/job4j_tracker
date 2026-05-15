package ru.job4j.algo.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IntervalMerge {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        Arrays.sort(intervals, (first, second) -> Integer.compare(first[0], second[0]));
        List<int[]> result = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];
            if (currentStart <= end) {
                end = Math.max(end, currentEnd);
            } else {
                result.add(new int[]{start, end});
                start = currentStart;
                end = currentEnd;
            }
        }

        result.add(new int[]{start, end});
        int[][] merged = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            merged[i] = result.get(i);
        }
        return merged;
    }

}