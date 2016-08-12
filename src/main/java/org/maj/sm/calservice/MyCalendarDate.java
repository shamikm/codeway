package org.maj.sm.calservice;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    //key = name of the conf room and times when its booked (sorted by time)
    private Map<String,TreeSet<Reservation>> reservations = new HashMap<>();
    //list of conf room sorted by their capacity
    private Map<Integer,List<ConfRoom>> confRoomsBySize = new HashMap<>();
    private TreeSet<Integer> confRoomSizes = new TreeSet<>();

    public MyCalendarDate(LocalDate date) {
        this.date = date;
    }

    public void addConfRoom(ConfRoom confRoom){
        List<ConfRoom> confRooms = confRoomsBySize.get(confRoom.getCapacity());
        if (confRooms == null){
            confRooms = new LinkedList<>();
            confRoomsBySize.put(confRoom.getCapacity(),confRooms);
        }
        confRooms.add(confRoom);
        confRoomSizes.add(confRoom.getCapacity());
    }

    public List<ConfRoom> getAvailableRooms(int capacity, LocalDateTime startTime, LocalDateTime endTime){
        List<ConfRoom> rooms = new ArrayList<>();
        //Step 1 : get the conf room that is big enough
        Set<Integer> sizesThatFit = confRoomSizes.tailSet(capacity);
        //Step 2 : for those rooms, see if they are available
        for(Integer size : sizesThatFit){
            List<ConfRoom> confRooms = confRoomsBySize.get(size);
            if (confRooms != null) {
                for (ConfRoom confRoom : confRooms) {
                    Reservation reservation = new Reservation(confRoom, startTime, endTime);
                    boolean isConflict = checkConflict(reservations.get(confRoom.getName()), reservation);
                    if (!isConflict) {
                        rooms.add(confRoom);
                    }
                }
            }
        }

        return rooms;
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
        if (!checkConflict(res,reservation)) {
            res.add(reservation);
        }

    }

    private boolean checkConflict(TreeSet<Reservation> existingReservations, Reservation newReservation) {
        boolean isConflict = false;
        if (existingReservations != null && existingReservations.size() > 0){
            //Step 1 : find out the reservation that starts before the current reservation time
            Reservation existingRes = existingReservations.lower(newReservation);
            //Step 2 : find out if the new reservation starts before the exising finishes
            if (existingRes != null && newReservation.getStartTime().isBefore(existingRes.getEndTime())) {
                isConflict = true;
            }
            //Step 3 : find out the reservation that starts after the current reservation time
            existingRes = existingReservations.higher(newReservation);
            //Step 4 : find out if the new reservation ends after the existing starts
            if (existingRes != null && newReservation.getEndTime().isAfter(existingRes.getStartTime())) {
                isConflict = true;
            }
        }

        return isConflict;
    }
}
