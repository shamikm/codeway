package org.maj.sm;

import java.util.PriorityQueue;

/**
 * There are given n ropes of different lengths, we need to connect these ropes into one rope.
 * The cost to connect two ropes is equal to sum of their lengths. We need to connect the ropes with minimum cost.
 * For example if we are given 4 ropes of lengths 4, 3, 2 and 6. We can connect the ropes in following ways
 * 1) First connect ropes of lengths 2 and 3. Now we have three ropes of lengths 4, 6 and 5.
 * 2) Now connect ropes of lengths 4 and 5. Now we have two ropes of lengths 6 and 9.
 * 3) Finally connect the two ropes and all ropes have connected.
 *
 * Total cost for connecting all ropes is 5 + 9 + 15 = 29.
 * This is the optimized cost for connecting ropes. Other ways of connecting ropes would always have same or more cost.
 * For example, if we connect 4 and 6 first (we get three strings of 3, 2 and 10), then connect 10 and 3 (we get two strings
 * of 13 and 2). Finally we connect 13 and 2. Total cost in this way is 10 + 13 + 15 = 38.

 *
 * 5 8 1  = 6, 14 = 20; 9, 14 = 23
 *
 * Solution, create a minHeap - PriorityQueue is an ideal implementation of minHeap
 * remove the first two smallest numbers , add them up and then add to the heap again
 * @author shamik.majumdar
 */
public class Ropes {
    public int findMinCost(int[] arr){
        int result = 0;
        if (arr.length == 1){
            result = arr[0];
        }
        else {
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            for (int i : arr) {
                heap.add(i);
            }

            while (heap.size() > 1) {
                int t = heap.remove() + heap.remove();
                result += t;
                heap.add(t);
            }
        }
        return result;
    }
}
