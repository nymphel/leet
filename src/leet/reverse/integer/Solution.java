package leet.reverse.integer;

public class Solution {
    public int reverse(int x) {
        String s = String.valueOf(x);

        String prefix = "";
        if (s.contains("-")) {
            prefix = "-";
            s = s.substring(1, s.length());
        }
        s = new StringBuilder(s).reverse().toString();
        s = prefix + s;
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return 0;
        }

    }
}
