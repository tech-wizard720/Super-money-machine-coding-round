package command;

import service.MeetingRoomService;

public class AddRoomCommand implements Command {
    public void execute(String[] p, MeetingRoomService s) {
        s.addRoom(p[1], p[2], Integer.parseInt(p[3]));
    }
}
