package org.maj.sm.calservice;

/**
 * @author shamik.majumdar
 */
public class ConfRoom implements Comparable<ConfRoom>{
    private final String name;
    private final int capacity;
    private boolean reserved;

    public ConfRoom(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    @Override
    public int compareTo(ConfRoom o) {
        return capacity < o.capacity ? -1 : (capacity > o.capacity ? 1 : 0);
    }
}
