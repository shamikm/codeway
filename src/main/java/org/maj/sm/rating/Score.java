package org.maj.sm.rating;

/**
 * @author shamik.majumdar
 */
public class Score {
    private final int hotelId;
    private final int userId;
    private final int score;

    public Score(int hotelId, int userId, int score) {
        this.hotelId = hotelId;
        this.userId = userId;
        this.score = score;
    }

    public int getHotelId() {
        return hotelId;
    }

    public int getUserId() {
        return userId;
    }

    public int getScore() {
        return score;
    }
}
