package org.maj.sm;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author shamik.majumdar
 */
public class RopeTest {
    @Test
    public void testRope(){
        Ropes ropes = new Ropes();
        Assert.assertEquals(ropes.findMinCost(new int[]{4,3,2,6}),29);
        Assert.assertEquals(ropes.findMinCost(new int[]{5,8,1}),20);
    }
}
