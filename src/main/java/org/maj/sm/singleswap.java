package org.maj.sm;

/**
 * @author shamik.majumdar
 */
public class singleswap {
    public boolean solution(int[] A) {
        // write your code in Java SE 8
        if (A == null || A.length < 2) return true;
        //first iteration
        for (int i=0; i < A.length-1 ; i++){
            if (A[i] < A[i+1]) {
                //find the next MAX value
                int max = Integer.MIN_VALUE;
                int maxIndex = -1;
                for (int j = i+1; j < A.length;j++) {
                    if (A[j] > max) {
                        max = A[j];
                        maxIndex = j;
                    }
                }
                //swap the values
                int t = A[maxIndex];
                A[maxIndex] = A[i];
                A[i] = t;
            }
        }
        //Iterate one more time
        boolean result = true;
        for (int i=0 ; i < A.length - 1; i++) {
            if (A[i] < A[i+1]) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static void main(String... args){
        singleswap singleswap = new singleswap();
        System.out.println(singleswap.solution(new int[]{1,5,3,3,7}));
        System.out.println(singleswap.solution(new int[]{1,3,5,3,4}));
    }
}
