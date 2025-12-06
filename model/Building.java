package model;

import java.util.*;

public class Building {
    public String name;
    public Map<String, Room> rooms = new HashMap<>();

    public Building(String name) {
        this.name = name;
    }
}
