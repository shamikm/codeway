package org.maj.sm;

/**
 * Find the area of max rectangle
 * @author shamik.majumdar
 */
public class MaxRectangle {
    public int maxRecTangle(int[] arr){
        int maxArea = 0;
        for (int i=0; i<arr.length;i++){
            int minL = Integer.MAX_VALUE, w = 0;//length and width
            for (int j=i;j<arr.length;j++){
                w = w + 1;
                minL = arr[j] < minL ? arr[j] : minL;
            }
            int t = minL * w;
            maxArea = Math.max(maxArea,t);
        }
        return maxArea;
    }

    public static void main(String... args){
        MaxRectangle maxRectangle = new MaxRectangle();
        System.out.println(maxRectangle.maxRecTangle(new int[]{1,4,5,3,3,5}));
    }
}
