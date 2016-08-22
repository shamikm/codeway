package org.maj.sm;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author shamik.majumdar
 */
public class FindingIslandTest {
    @Test
    public void testIslandFinding(){
        FindingIsland findingIsland = new FindingIsland();
        int islands = findingIsland.findNumberOfIlands(new int[][]{
                {1, 0, 0, 0, 1, 1, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        });

        Assert.assertEquals(3,islands);
    }
}
