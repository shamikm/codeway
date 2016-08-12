package org.maj.sm.calservice;

import java.time.LocalDateTime;

/**
 * @author shamik.majumdar
 */
public class Reservation {
    private final ConfRoom confRoom;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;

    public Reservation(ConfRoom confRoom, LocalDateTime startTime, LocalDateTime endTime) {
        this.confRoom = confRoom;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public ConfRoom getConfRoom() {
        return confRoom;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
}
