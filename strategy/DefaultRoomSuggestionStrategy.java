package strategy;

import model.*;
import java.util.*;

public class DefaultRoomSuggestionStrategy implements RoomSuggestionStrategy {

    @Override
    public List<Room> suggest(Map<String, Building> buildings, int start, int end, int minCapacity) {
        List<Room> available = new ArrayList<>();
        for (Building b : buildings.values()) {
            for (Room r : b.rooms.values()) {
                if (r.capacity >= minCapacity && isAvailable(r, start, end)) {
                    available.add(r);
                }
            }
        }
        return available;
    }

    private boolean isAvailable(Room room, int start, int end) {
        for (Booking b : room.bookings) {
            if (!(end <= b.start || start >= b.end)) return false;
        }
        return true;
    }
}
