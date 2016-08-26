package org.maj.sm.codility.binarygap;

/**
 * @author shamik.majumdar
 */
public class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        int max = 0;
        int count = -1;
        int r ;

        while (N > 0) {
            // get right most bit & shift right
            // if the right bit is 1, then reset the counter
            // otherwise keep counting
            r = N & 1;
            N = N >> 1;

            if (0 == r && count >= 0) {
                count++;
            }

            if (1 == r) {
                max = Math.max(count,max);
                count = 0;
            }
        }

        return max;
    }
}
