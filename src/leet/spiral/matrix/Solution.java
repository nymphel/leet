package leet.spiral.matrix;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        List<Integer> result = solution.spiralOrder(matrix);
        System.out.println(result);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if(matrix.length == 0) {
            return result;
        }

        int row = 0;
        int col = 0;
        result.add(matrix[row][col]);

        Point forward = new Point(0, 1);
        Point down = new Point(1, 0);
        Point back = new Point(0, -1);
        Point up = new Point(-1, 0);

        Queue<Point> directions = new LinkedList<>();
        directions.add(forward);
        directions.add(down);
        directions.add(back);
        directions.add(up);

        Point direction;
        while((direction = directions.peek()) != null) {
            int futureRow = row + direction.x;
            int futureCol = col + direction.y;

            if(result.size() == matrix.length * matrix[0].length) {
                break;
            }

            if (futureRow < 0 || futureRow >= matrix.length
                    || futureCol < 0 || futureCol >= matrix[futureRow].length
                    || result.contains(matrix[futureRow][futureCol])) {
                directions.remove(direction);
                directions.add(direction);
                continue;
            }

            row = futureRow;
            col = futureCol;
            result.add(matrix[row][col]);
        }
        return result;
    }


}

