package leet.valid.sudoku;

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {{'5','3','.','.','7','.','.','.','.'} ,{'6','.','.','1','9','5','.','.','.'} ,{'.','9','8','.','.','.','.','6','.'} ,{'8','.','.','.','6','.','.','.','3'} ,{'4','.','.','8','.','3','.','.','1'} ,{'7','.','.','.','2','.','.','.','6'} ,{'.','6','.','.','.','.','2','8','.'} ,{'.','.','.','4','1','9','.','.','5'} ,{'.','.','.','.','8','.','.','7','9'}};
        //System.out.println(solution.isValidSudoku(board));

        char[][] board2 = {{'8','3','.','.','7','.','.','.','.'} ,{'6','.','.','1','9','5','.','.','.'} ,{'.','9','8','.','.','.','.','6','.'} ,{'8','.','.','.','6','.','.','.','3'} ,{'4','.','.','8','.','3','.','.','1'} ,{'7','.','.','.','2','.','.','.','6'} ,{'.','6','.','.','.','.','2','8','.'} ,{'.','.','.','4','1','9','.','.','5'} ,{'.','.','.','.','8','.','.','7','9'}};
        //System.out.println(solution.isValidSudoku(board2));

        char[][] board3 = {{'5','3','.','.','7','.','.','.','.'} ,{'6','5','.','1','9','5','.','.','.'} ,{'.','5','8','.','.','.','.','6','.'} ,{'8','.','.','.','6','.','.','.','3'} ,{'4','.','.','8','.','3','.','.','1'} ,{'7','.','.','.','2','.','.','.','6'} ,{'.','6','.','.','.','.','2','8','.'} ,{'.','.','.','4','1','9','.','.','5'} ,{'.','.','.','.','8','.','.','7','9'}};
        //System.out.println(solution.isValidSudoku(board3));

        char[][] board4 = {{'.','.','4','.','.','.','6','3','.'},{'.','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','9','.'},{'.','.','.','5','6','.','.','.','.'},{'4','.','3','.','.','.','.','.','1'},{'.','.','.','7','.','.','.','.','.'},{'.','.','.','5','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'}};
        System.out.println(solution.isValidSudoku(board4));
    }

    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> bag1 = new HashSet<>();
        HashSet<Character> bag2 = new HashSet<>();
        HashSet<Character> bag3 = new HashSet<>();
        HashSet<Character> rows = new HashSet<>();
        HashSet<Character> cols = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            System.out.println("rows -> "+rows);
            System.out.println("cols -> "+cols);
            rows.clear();
            cols.clear();

            if(i%3 == 0) {
                System.out.println("bag1 -> "+bag1);
                System.out.println("bag2 -> "+bag2);
                System.out.println("bag3 -> "+bag3);
                bag1.clear();
                bag2.clear();
                bag3.clear();
            }

            for (int j = 0; j < 9; j++) {
                char interestedRow = board[i][j];
                if(interestedRow != '.') {
                    if (rows.contains(interestedRow))
                        return false;
                    rows.add(interestedRow);
                }

                char interestedCol = board[j][i];
                if(interestedCol != '.') {
                    if (cols.contains(interestedCol))
                        return false;
                    cols.add(interestedCol);
                }

                if(interestedRow == '.')
                    continue;
                if(j < 3) {
                    if(bag1.contains(interestedRow))
                        return false;
                    bag1.add(interestedRow);
                } else if(j >= 3 && j<6) {
                    if(bag2.contains(interestedRow))
                        return false;
                    bag2.add(interestedRow);
                } else {
                    if(bag3.contains(interestedRow))
                        return false;
                    bag3.add(interestedRow);
                }

            }
        }


        return true;
    }
}
