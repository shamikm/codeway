package org.maj.sm;

import com.google.common.primitives.Ints;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author shamik.majumdar
 */
public class LinkedListSwapTest {
    private LinkedList<Integer> linkedList;
    @BeforeTest
    public void setup(){
        linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(7);
        linkedList.add(8);
    }
    @Test
    public void testSwap(){
        //1,2,4,5,7,8
        LinkedListSwap linkedListSwap = new LinkedListSwap();
        List<Integer> result =  linkedListSwap.swap(linkedList,2);
        int[] arr = Ints.toArray(result);
        Assert.assertEquals(arr,new int[]{1,7,4,5,2,8});

    }
}
