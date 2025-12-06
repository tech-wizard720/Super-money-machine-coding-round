package command;

import service.MeetingRoomService;

public class ListBookingsCommand implements Command {
    public void execute(String[] p, MeetingRoomService s) {
        s.listBookings(p[1]);
    }
}
