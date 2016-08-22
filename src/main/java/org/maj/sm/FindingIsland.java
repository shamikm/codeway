package org.maj.sm;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  In the below picture 1 = land and 0 = water. Find number of islands. In this case, there are 3
 *  1, [1,1] and [1,1,1]
 *
 *  | 1 0 0 0 1 1 0 |
 *  | 0 1 0 0 1 0 0 |
 *  | 0 1 0 0 0 0 0 |
 *  | 0 0 0 0 0 0 0 |
 *
 *  Solution is to use Depth First Search when you hit a node with value as 1.
 *
 * @author shamik.majumdar
 */
public class FindingIsland {
    private static class Node {
        private final int x;
        private final int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    /**
     * Pass the matrix of 1 and 0 to find number of islands
     * @param islands
     * @return
     */
    public int findNumberOfIlands(int[][] islands){
        //Make sure each node is visited only once while we traverse the whole matrix
        boolean[][] visited= new boolean[islands.length][islands[0].length];
        int count = 0;
        for (int i=0; i <islands.length; i++){
            for (int j=0; j <islands[0].length; j++){
                if (islands[i][j] == 1 && !visited[i][j]){
                    dfs(islands, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] islands, boolean[][] visited, int i, int j) {
        int allRow = islands.length;
        int allCol = islands[0].length;

        visited[i][j] = true;
        Node node = new Node(i,j);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node n = queue.poll(); // take the node
            int currRow = n.getX();
            int currCol = n.getY();

            if (currRow+1 < allRow && islands[currRow+1][currCol] == 1 && !visited[currRow+1][currCol]){
                queue.add(new Node(currRow+1,currCol));
                visited[currRow+1][currCol] = true;
            }
            if (currCol+1 < allCol && islands[currRow][currCol+1] == 1 && !visited[currRow][currCol+1]){
                queue.add(new Node(currRow,currCol+1));
                visited[currRow][currCol+1] = true;
            }
            /*if (currCol+1 < allCol && currRow+1 < allRow && islands[currRow+1][currCol+1] == 1 && !visited[currRow+1][currCol+1]){
                queue.add(new Node(currRow+1,currCol+1));
                visited[currRow+1][currCol+1] = true;
            }*/
        }
    }


}
