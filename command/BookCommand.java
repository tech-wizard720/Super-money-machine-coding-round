package command;

import service.MeetingRoomService;
import util.TimeUtil;

public class BookCommand implements Command {
    public void execute(String[] p, MeetingRoomService s) {
        s.bookRoom(p[1], TimeUtil.toMinutes(p[2]), TimeUtil.toMinutes(p[3]), p[4]);
    }
}
