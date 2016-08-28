package org.maj.sm;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * Suppose you are given a puzzle that is represented as a matrix with 0s and 1s,
 * where a 0 indicates you’re allowed to move into that position and 1 means you’re not
 * allowed to move in that position. Write a function that given a start position and an end position,
 * returns a boolean value indicating if there exists a path from start to end. you are only allowed to
 * move up, left, right and down. Diagonal movement is not allowed.

 Example #1
 Input
 0 0 1 0 1
 0 0 0 0 0
 0 1 1 1 1
 0 1 1 0 0

 start: 0,3
 end 3,0

 Output - true

 Example #2
 Input
 0 0 1 1 1
 0 1 0 0 0
 1 1 1 1 1
 0 0 0 0 1

 start: 0,0
 end: 1,2

 Output - false

 * Solution is to find the

 * @author shamik.majumdar
 */
public class FindPath {

    private static class Point {
        public final int x;
        public final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
    public static boolean findPath(int[][] arr, int startX, int startY, int endX, int endY) {
        boolean visited[][] = new boolean[arr.length][arr[0].length];
        traverse(arr,startX,startY,visited);
        return visited[startX][startY] && visited[endX][endY];
    }

    private static void traverse(int[][] arr, int x, int y, boolean[][] visited) {
        Point p = new Point(x,y);
        Queue<Point> queue = new LinkedList<>();
        queue.add(p);
        while (!queue.isEmpty()){
            Point t = queue.poll();
            System.out.println("Checking node [" + t.x + "," + t.y + "]");
            visited[t.x][t.y] = true;
            //check up
            if (t.x -1 >=0 && !visited[t.x-1][t.y] && arr[t.x-1][t.y] == 0){
                queue.add(new Point(t.x-1,t.y));
            }
            //check down
            if (t.x + 1 < arr.length && !visited[t.x+1][t.y] && arr[t.x+1][t.y] == 0){
                queue.add(new Point(t.x+1,t.y));
            }
            //check right
            if (t.y + 1 < arr[x].length && !visited[t.x][t.y+1] && arr[t.x][t.y+1] == 0){
                queue.add(new Point(t.x,t.y+1));
            }
            //check left
            if (t.y - 1 >= 0 && !visited[t.x][t.y-1] && arr[t.x][t.y-1] == 0){
                queue.add(new Point(t.x,t.y-1));
            }
        }

    }

    public static void main(String... args){

        boolean result =
                FindPath.findPath(new int[][]{
                {0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 1, 1, 0, 0}
        },0,3,3,0);

        System.out.println(result);

    }

}
