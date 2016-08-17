package org.maj.sm.url;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author shamik.majumdar
 */
public class URLShortnerTest {
    @Test
    public void testUrl(){
        UrlShortnerService service = new UrlShortnerService();
        Assert.assertEquals(125,service.idToShortUrl(service.idToShortUrl(125)));
    }
}
