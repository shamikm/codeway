package org.maj.sm.rating;

import com.google.common.base.Objects;

import java.util.LinkedList;
import java.util.List;

/**
 * @author shamik.majumdar
 */
public class Hotel implements Comparable<Hotel> {
    private final int hotelId;
    private final List<Integer> scores = new LinkedList<>();
    private int avgScore;

    public Hotel(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void addScore(int score){
        scores.add(score);
        avgScore = calculateAvg();
    }

    public void setAvgScore(int avgScore) {
        this.avgScore = avgScore;
    }

    public int getAvgScore(){
        return avgScore;
    }

    private int calculateAvg() {
        int sum = 0;
        for (Integer i : scores) {
            sum += i;
        }
        return sum/scores.size();
    }

    /**
     * Compare to should return 0 only and only if equals returns 0.
     * if two objects are not same then compare to shouldn't say they are same
     * this can cause unnecessary bugs
     * @param o
     * @return
     */
    @Override
    public int compareTo(Hotel o) {
        return getAvgScore() > o.getAvgScore() ? 1 : getAvgScore() < o.getAvgScore() ? -1 : getHotelId() == o.getHotelId() ? 0 : -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return hotelId == hotel.hotelId &&
                avgScore == hotel.avgScore;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(hotelId, avgScore);
    }
}
