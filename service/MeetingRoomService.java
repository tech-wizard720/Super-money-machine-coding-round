package service;

import java.util.*;
import model.*;
import util.TimeUtil;
import strategy.*;

public class MeetingRoomService {

    private Map<String, Building> buildings = new HashMap<>();
    private RoomSuggestionStrategy suggestionStrategy = new DefaultRoomSuggestionStrategy();

    public void addRoom(String building, String roomName, int capacity) {
        buildings.putIfAbsent(building, new Building(building));
        buildings.get(building).rooms.put(roomName, new Room(roomName, capacity));
        System.out.println("Room '" + roomName + "' added to " + building + ".");
    }

    public void bookRoom(String roomName, int start, int end, String person) {
        Room room = getRoom(roomName);
        if (room == null) return;

        for (Booking b : room.bookings) {
            if (!(end <= b.start || start >= b.end)) {
                System.out.println("Booking Failed: " + roomName +
                        " is already booked during " + TimeUtil.format(start) +
                        " - " + TimeUtil.format(end));
                return;
            }
        }

        room.bookings.add(new Booking(roomName, start, end, person));
        room.bookings.sort(Comparator.comparingInt(b -> b.start));
        System.out.println("Booking Created: " + roomName +
                " (" + TimeUtil.format(start) + " - " + TimeUtil.format(end) + ") for " + person);
    }

    public void cancelBooking(String roomName, int start, int end) {
        Room room = getRoom(roomName);
        if (room == null) return;

        if (room.bookings.removeIf(b -> b.start == start && b.end == end)) {
            System.out.println("Booking Cancelled: " + roomName +
                    " (" + TimeUtil.format(start) + " - " + TimeUtil.format(end) + ")");
        }
    }

    public void listBookings(String roomName) {
        Room room = getRoom(roomName);
        if (room == null) return;

        System.out.println("Bookings for " + roomName + ":");
        if (room.bookings.isEmpty()) {
            System.out.println("(No bookings found)");
            return;
        }

        for (Booking b : room.bookings) {
            System.out.println("- " + TimeUtil.format(b.start) +
                    " - " + TimeUtil.format(b.end) + " for " + b.person);
        }
    }

    public void suggestRooms(int start, int end, int minCapacity) {
        System.out.println("Suggestions for " +
                TimeUtil.format(start) + " - " + TimeUtil.format(end) +
                " (Min Capacity: " + minCapacity + "):");

        List<Room> result = suggestionStrategy.suggest(buildings, start, end, minCapacity);

        if (result.isEmpty()) {
            System.out.println("(No rooms available)");
            return;
        }

        for (Room r : result) {
            System.out.println("- " + r.name + " (Capacity: " + r.capacity + ")");
        }
    }

    private Room getRoom(String roomName) {
        for (Building b : buildings.values()) {
            if (b.rooms.containsKey(roomName)) return b.rooms.get(roomName);
        }
        return null;
    }
}
