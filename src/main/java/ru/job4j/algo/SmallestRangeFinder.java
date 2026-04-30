package ru.job4j.algo;

import java.util.Arrays;

public class SmallestRangeFinder {

    public static int[] findSmallestRange(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return null;
        }

        int n = nums.length;
        int left = 0;
        int right = 0;
        int distinct = 1;
        int bestLeft = -1;
        int bestRight = -1;

        while (right < n) {

            while (right + 1 < n && distinct < k) {
                right++;
                if (nums[right] != nums[right - 1]) {
                    distinct++;
                }
            }

            if (distinct < k) {
                break;
            }
            while (left < right && nums[left] == nums[left + 1]) {
                left++;
            }
            int length = right - left + 1;
            if (bestLeft == -1 || length < (bestRight - bestLeft + 1)) {
                bestLeft = left;
                bestRight = right;
            }
            left++;

            if (left < n && nums[left] != nums[left - 1]) {
                distinct--;
            }
        }
        return bestLeft == -1 ? null : new int[]{bestLeft, bestRight};
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        int k = 4;
        int[] result = findSmallestRange(nums, k);
        if (result != null) {
            System.out.println("Наименьший диапазон с " + k + " различными элементами: " + Arrays.toString(result));
        } else {
            System.out.println("Такой диапазон не существует.");
        }
    }

}