package leet.paindrome.num;

public class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        String reverse = new StringBuilder(s).reverse().toString();
        if (s.equals(reverse)) {
            return true;
        }
        return false;
    }
}
