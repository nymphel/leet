package leet.longest.palindromic;

// Given a string s, find the longest palindromic substring in s.
// You may assume that the maximum length of s is 1000.
// Input: "babad"
// Output: "bab"
// Note: "aba" is also a valid answer.
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.longestPalindrome("a"));
        //System.out.println(solution.longestPalindrome("bb"));
        //System.out.println(solution.longestPalindrome("abb"));
        // System.out.println(solution.longestPalindrome("abba"));
        //System.out.println(solution.longestPalindrome("aba"));
        // System.out.println(solution.longestPalindrome("abbahannahkoohho"));
        System.out.println(solution.longestPalindrome("lejyqjcpluiggwlmnumqpxljlcwdsirzwlygexejhvojztcztectzrepsvwssiixfmpbzshpilmojehqyqpzdylxptsbvkgatzdlzphohntysrbrcdgeaiypmaaqilthipjbckkfbxtkreohabrjpmelxidlwdajmkndsdbbaypcemrwlhwbwaljacijjmsaqembgtdcskejplifnuztlmvasbqcyzmvczpkimpbbwxdtviptzaenkbddaauyvqppagvqfpednnckooxzcpuudckakutqyknuqrxjgfdtsxsoztjkqvfvelrklforpjnrbvyyvxigjhkjmxcphjzzilvbjbvwiwnnkbmboiqamgoimujtswdqesighoxsprhnsceshotakvmoxqkqjvbpqucvafiuqwmrlfjpjijbctfupywkbawquchbclgvhxbanybret"));

    }

    public String longestPalindrome(String s) {

        if (s == null || s.length() > 1000 || s.length() < 1) {
            return "";
        }
        if(s.length() == 1) {
            return s;
        }

        String longest = "";
        int stepOut = 1; // minimum addition
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + stepOut; j <= s.length(); j++) {
                String candidate = s.substring(i,j);
                boolean palindrome = isPalindrome(candidate);
                if(palindrome && candidate.length() > longest.length()) {
                    longest = candidate;
                    stepOut = longest.length() + 1;
                }
            }

        }
        return longest;
    }

    private boolean isPalindrome(String s) {
        int len = s.length();
        if (len < 1) {
            return false;
        }
        for (int i = 0, j = len - 1; i < len; i++, j--) {
            if (s.charAt(i)!= s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}
