package ru.job4j.algo.hash;

import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubstring {
    public static String longestUniqueSubstring(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        Map<Character, Integer> indexByChar = new HashMap<>();

        int left = 0;
        int bestStart = 0;
        int bestLength = 0;

        for (int right = 0; right < str.length(); right++) {
            char current = str.charAt(right);

            if (indexByChar.containsKey(current)
                    && indexByChar.get(current) >= left) {
                left = indexByChar.get(current) + 1;
            }

            indexByChar.put(current, right);

            int currentLength = right - left + 1;
            if (currentLength > bestLength) {
                bestLength = currentLength;
                bestStart = left;
            }
        }

        return str.substring(bestStart, bestStart + bestLength);
    }

}