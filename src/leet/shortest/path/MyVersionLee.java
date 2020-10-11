package leet.shortest.path;

import java.util.LinkedList;
import java.util.Queue;

public class MyVersionLee {

    private static class Square implements Comparable<Square>{
        public int x;
        public int y;
        public int distance;
        public Square parent;

        public Square(int x, int y, int distance, Square parent) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "Square{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }


        @Override
        public int compareTo(Square o) { // add reverse order
            return distance - o.distance;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0}
        };
        int[] start = {2,4};
        int[] end = {3,2};
        print(matrix, start, end);
    }

    private static void print(int[][] matrix, int[] start, int[] end) {
        if(matrix[start[0]][start[1]] == 0 || matrix[end[0]][end[1]] == 0) {
            return;
        }

        Square[][] squares = new Square[matrix.length][matrix[0].length];
        for(int i = 0; i< matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                squares[i][j] = new Square(i, j, Integer.MAX_VALUE, null); // we don't know parent yet!
            }
        }

        Square src = new Square(start[0], start[1], 0, null);

        Queue<Square> leeQueue = new LinkedList<>();
        leeQueue.add(src);

        Square interested = null;
        Square destination = null;
        while ((interested = leeQueue.poll()) != null) {

            //have we reached?
            if(interested.x == end[0] && interested.y == end[1]) {
                destination = interested;
                break;
            }

            visit(squares, interested.x-1, interested.y, leeQueue, interested);
            visit(squares, interested.x+1, interested.y, leeQueue, interested);
            visit(squares, interested.x, interested.y-1, leeQueue, interested);
            visit(squares, interested.x, interested.y+1, leeQueue, interested);
        }

        if(destination == null) {
            return;
        }

        Square print = destination;
        LinkedList<Square> printList = new LinkedList<>();
        do {
            printList.addFirst(print);
        } while((print = print.parent) != null);


        System.out.println(printList);
    }

    private static void visit(Square[][] squares, int x, int y, Queue<Square> leeQueue, Square interested) {
        if (x < 0 || x >= squares.length || y < 0 || y >= squares[0].length || squares[x][y] == null) {
            return;
        }

        int distance = interested.distance + 1;

        Square adjacentSquare = squares[x][y];
        if(distance < adjacentSquare.distance) {
            adjacentSquare.distance = distance;
            adjacentSquare.parent = interested;
            leeQueue.add(adjacentSquare);
        }
    }


}
