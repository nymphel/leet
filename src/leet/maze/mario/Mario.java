package leet.maze.mario;

import java.util.*;
import java.util.List;

public class Mario {

    public static void main(String[] args) {
        char[][] maze = {
                {'m', '1', '0', '1', '1', '1', '1', '1', '1', '0'},
                {'0', '1', '0', '0', '1', '0', '0', '0', '1', '1'},
                {'1', '1', '0', '1', '1', '1', '0', '0', '0', '1'},
                {'1', '0', '0', '1', '0', '1', '1', '0', '1', '1'},
                {'1', '1', '0', '0', '0', '0', '1', '0', '1', '0'},
                {'0', '1', '1', '1', '1', '1', '1', '0', '1', '0'},
                {'p', '0', '0', '0', '0', '0', '0', '0', '1', '1'},
                {'1', '0', '0', '1', '0', '1', '1', '1', '0', '1'},
                {'1', '1', '1', '1', '0', '1', '0', '1', '0', '1'},
                {'1', '0', '0', '1', '1', '1', '0', '1', '1', '1'}
        };

        printSymbolicMaze(maze);

        Cell start = new Cell(0,0);

        List<Cell> way = findPrincess(maze,start);
        System.out.println(way);
    }

    public static void printSymbolicMaze(char[][]maze) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                sb.append(maze[i][j] == '0' ? " " : maze[i][j]);
                sb.append("  ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static List<Cell> findPrincess(char[][] maze, Cell start) {
        LinkedList<Cell> way = new LinkedList<>();
        way.add(start);

        Set<Cell> deadEnd = new HashSet<>();

        Queue<Cell> directions = populateDirections();

        Cell position = start;
        int attempt = 1;

        while (!way.isEmpty()) {
            Cell direction = directions.peek();
            int nextRow = position.row + direction.row;
            int nextCol = position.col + direction.col;
            Cell nextP = new Cell(nextRow, nextCol);

            attempt++;

            if(nextRow < 0 || nextRow >= maze.length
                    || nextCol < 0 || nextCol >= maze[0].length
                    || maze[nextRow][nextCol] == '0'
                    || way.contains(nextP)
                    || deadEnd.contains(nextP)) {

                directions.remove(direction);

                if(directions.isEmpty()) {
                    directions = populateDirections();
                    System.out.println("Dead end found: " + position);
                    deadEnd.add(position);

                    way.remove(position);

                    if(way.isEmpty()) {
                        System.out.println("\nNo way to go.. exiting! " + position);
                        break;
                    }

                    position = way.getLast();
                    System.out.println("Going back to: " + position);
                }

                continue;
            }

            position = nextP;
            way.add(position);
            directions = populateDirections();

            System.out.println(position);
            if(maze[nextRow][nextCol] == 'p') {
                System.out.println("\n\nPrincess found in: " + position);
                break;
            }

        }


        System.out.println("\nTotal attempts: " + attempt);
        System.out.println("\nOne way total steps: " + way.size());
        return new ArrayList<>(way);
    }

    private static Queue<Cell> populateDirections() {
        Cell right = new Cell(0, 1);
        Cell left = new Cell(0, -1);
        Cell down = new Cell(1, 0);
        Cell up = new Cell(-1, -0);

        Queue<Cell> directions = new LinkedList<>();
        directions.add(right);
        directions.add(left);
        directions.add(down);
        directions.add(up);
        return directions;
    }

    public static class Cell {
        public int row;
        public int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return row == cell.row &&
                    col == cell.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }
}
