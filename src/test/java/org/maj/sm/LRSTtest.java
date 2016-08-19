package org.maj.sm;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author shamik.majumdar
 */
public class LRSTtest {
    @Test
    public void testLRS(){
        Assert.assertEquals(LRS.lrs("banana"),"ana");
        Assert.assertEquals(LRS.lrs("aaaa"),"aaa");
    }

}
