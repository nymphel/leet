package leet.zigzag.conversion;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().convert("PAYPALISHIRING", 3));
        System.out.println(new Solution().convert("PAYPALISHIRING", 4));
    }

    public String convert(String s, int numRows) {
        if(s == null || numRows < 1) {
            return "";
        }
        if(numRows == 1) {
            return s;
        }

        String[][] matrix = new String[numRows][s.length()]; // row, column

        int letters = 0;
        out:
        for (int col = 0; col < s.length(); col++) {
            for (int row = 0; row < numRows; row++) {
                if (col % (numRows - 1) == 0 || col % (numRows - 1) == numRows - row - 1) {
                    matrix[row][col] = String.valueOf(s.charAt(letters));
                    if (letters == s.length() - 1) {
                        break out;
                    }
                    letters++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < s.length(); col++) {
                if (matrix[row][col] != null) {
                    sb.append(matrix[row][col]);
                }
            }
        }

        return sb.toString();
    }
}
