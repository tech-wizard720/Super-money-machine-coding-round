package model;

import java.util.*;

public class Room {
    public String name;
    public int capacity;
    public List<Booking> bookings = new ArrayList<>();

    public Room(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}
