package org.maj.sm;

import org.maj.sm.url.MapSort;
import org.testng.annotations.Test;

/**
 * @author shamik.majumdar
 */
public class MapSortTest {
    @Test
    public void testUser(){
        MapSort mapSort = new MapSort();
        System.out.println(mapSort.sortUserEntries("user1,user4, user2, user1, user3, user1, user2, user3",2));
    }
}
