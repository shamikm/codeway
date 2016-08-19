package org.maj.sm;

import java.util.LinkedList;
import java.util.List;

/**
 * Swap the elements in Kth position from the start and end of a link list.
 * Example : input --> list: 1,2,4,5,7,8 & K=2
 * output: 1,7,4,5,2,8
 *
 * @author shamik.majumdar
 */
public class LinkedListSwap {
    public List<Integer> swap(LinkedList<Integer> list, int k){
        if (k*2 <= list.size()) {
            int val = list.get(k-1);
            list.set(k-1, list.get(list.size() - k));
            list.set(list.size() - k, val);
        }
        return list;
    }
}
