package leet.longest.common.prefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }

        String pre = "";
        int i = 1;
        while (true) {
            final String firstExample = strs[0];
            if (firstExample.length() == 0) {
                return "";
            }

            if (i > firstExample.length()) {
                return pre;
            }

            final String substring = firstExample.substring(0, i);

            for (String str : strs) {
                if (!str.startsWith(substring) || str.equals(pre)) {
                    return pre;
                }
            }
            pre = substring;
            i++;
        }

    }
}
