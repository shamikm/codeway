package org.maj.sm.calservice;
import com.sun.javafx.collections.MappingChange;

import java.time.LocalDate;
import java.util.*;

/**
 * Each calendar date has a date
 * set of rooms in ascending order (BST) - we shall use it to get the first one which has capacity as much required
 * its sorted by capacity in a Binary search tree so we can navigate quickly at O(logN) time
 * We shall use TreeSet to
 * @author shamik.majumdar
 */
public class MyCalendarDate {
    private final LocalDate date;
    //private List<Reservation> reservations = new ;
    private Map<String,TreeSet<Reservation>> reservations = new HashMap<>();
    private TreeSet<ConfRoom> confRooms = new TreeSet<>();

    public MyCalendarDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Add a new reservation
     * @param reservation
     */
    public void addReservation(Reservation reservation){
        TreeSet<Reservation> res = this.reservations.get(reservation.getConfRoom().getName());
        if (res == null) {
            //the list is sorted by time
            res = new TreeSet<>(new Comparator<Reservation>() {
                @Override
                public int compare(Reservation o1, Reservation o2) {
                    return o1.getStartTime().compareTo(o2.getStartTime());
                }
            });
            this.reservations.put(reservation.getConfRoom().getName(),res);
        }
        res.add(reservation);
    }
}
