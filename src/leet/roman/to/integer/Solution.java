package leet.roman.to.integer;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int romanToInt(String s) {
        Map<String, Long> romanLetters = new HashMap<>();
        romanLetters.put("I", 1L);
        romanLetters.put("V", 5L);
        romanLetters.put("X", 10L);
        romanLetters.put("L", 50L);
        romanLetters.put("C", 100L);
        romanLetters.put("D", 500L);
        romanLetters.put("M", 1000L);
        romanLetters.put("IV", 4L);
        romanLetters.put("IX", 9L);
        romanLetters.put("XL", 40L);
        romanLetters.put("XC", 90L);
        romanLetters.put("CD", 400L);
        romanLetters.put("CM", 900L);

        Long actual = 0L;
        int i = 0;
        while (true) {
            if (i + 1 > s.length()) {
                break;
            }

            final String first = s.substring(i, i + 1);

            if (s.length() > i + 1) {
                final String second = s.substring(i + 1, i + 2);

                String combinationOfTwo = first + second;
                final Long specialVal = romanLetters.get(combinationOfTwo);
                if (specialVal != null) {
                    actual += specialVal;
                    i = i + 2;
                    continue;
                }
            }

            final Long singleVal = romanLetters.get(first);
            if (singleVal == null) {
                return 0;
            }
            actual += singleVal;
            i = i + 1;
        }


        return actual.intValue();

    }
}
