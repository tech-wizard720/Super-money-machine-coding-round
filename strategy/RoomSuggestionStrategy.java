package strategy;

import java.util.List;
import java.util.Map;
import model.*;

public interface RoomSuggestionStrategy {
    List<Room> suggest(Map<String, Building> buildings, int start, int end, int minCapacity);
}
