package org.maj.sm;

import java.util.TreeSet;

/**
 * There are n boxes given that are 1-D. You have to find the best fit for the given item that can fit into the box.
 * For example, an array of boxes is given as {7,9,12} and we need to find the best match for the item of size 10 then
 * the box with dimension 12 will be our best match.
 *
 * Solution is to create a tree - and find it .. one way to do it using TreeSet of java - which is a balanced binary tree
 * (red black tree) implementation
 * @author shamik.majumdar
 */
public class BoxSize {

    public int findItem(int[] sizes, int size){

        TreeSet<Integer> bst = new TreeSet<>();
        for (int s : sizes){
            bst.add(s);
        }
        return bst.ceiling(size);
    }
}
