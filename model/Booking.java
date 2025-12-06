package model;

public class Booking {
    public String roomName;
    public int start;
    public int end;
    public String person;

    public Booking(String roomName, int start, int end, String person) {
        this.roomName = roomName;
        this.start = start;
        this.end = end;
        this.person = person;
    }
}
