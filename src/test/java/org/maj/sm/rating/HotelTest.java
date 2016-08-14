package org.maj.sm.rating;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * {'hotel_id': 1001, 'user_id': 501, 'score': 7},
 {'hotel_id': 1001, 'user_id': 502, 'score': 7},
 {'hotel_id': 1001, 'user_id': 503, 'score': 7},
 {'hotel_id': 2001, 'user_id': 504, 'score': 10},
 {'hotel_id': 3001, 'user_id': 505, 'score': 5},
 {'hotel_id': 2001, 'user_id': 506, 'score': 5}
 * @author shamik.majumdar
 */
public class HotelTest {
    public List<Score> scoreList = new ArrayList<>();

    @BeforeTest
    public void setUp(){
        scoreList.add(new Score(1001,501,7));
        scoreList.add(new Score(1001,502,7));
        scoreList.add(new Score(1001,503,7));
        scoreList.add(new Score(2001,504,10));
        scoreList.add(new Score(3001,505,5));
        scoreList.add(new Score(2001,506,5));
    }

    @Test
    public void testScore(){
        HotelService hotelService = new HotelService();
        Set<Hotel> hotelSet = hotelService.getHotels(scoreList,5);
        hotelSet.forEach(h -> System.out.println(h.getHotelId() + "::" + h.getAvgScore()));
        Assert.assertEquals(hotelSet.size(),3);
    }

    @Test
    public void testScoreMoreThan7(){
        HotelService hotelService = new HotelService();
        Set<Hotel> hotelSet = hotelService.getHotels(scoreList,7);
        hotelSet.forEach(h -> System.out.println(h.getHotelId() + "::" + h.getAvgScore()));
        Assert.assertEquals(hotelSet.size(),2);
    }
}
