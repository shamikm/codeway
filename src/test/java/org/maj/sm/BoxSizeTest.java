package org.maj.sm;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author shamik.majumdar
 */
public class BoxSizeTest {
    @Test
    public void testBox(){
        BoxSize boxSize = new BoxSize();
        Assert.assertEquals(boxSize.findItem(new int[]{7,9,12},10),12);
        Assert.assertEquals(boxSize.findItem(new int[]{7,9,12},7),7);
    }
}
