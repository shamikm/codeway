package org.maj.sm.rating;

import java.util.*;

/**
 * @author shamik.majumdar
 */
public class HotelService {

    public Set<Hotel> getHotels(List<Score> scores, int minAvgScore){
        //Step 1 : create a map of hotel id to list of reviews to find the average score
        Map<Integer,Hotel> hotelMap = new HashMap<>();

        scores.forEach(score -> {
            Hotel h = hotelMap.get(score.getHotelId());
            if (h == null){
                h = new Hotel(score.getHotelId());
                hotelMap.put(h.getHotelId(),h);
            }
            h.addScore(score.getScore());
        });
        //Step 2 : We need to store them in a TreeSet (backed by red-black balanced binary tree)
        TreeSet<Hotel> treeSet = new TreeSet<>();
        hotelMap.forEach((k,v) -> treeSet.add(v));
        //Step 3 : Since its in a tree set, so we can easily navigate for hotels which are more than x average
        Hotel temp = new Hotel(-1);
        temp.setAvgScore(minAvgScore);

        return treeSet.tailSet(temp,true);
    }
}
