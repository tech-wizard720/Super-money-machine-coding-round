package command;

import service.MeetingRoomService;
import util.TimeUtil;

public class SuggestCommand implements Command {
    public void execute(String[] p, MeetingRoomService s) {
        s.suggestRooms(TimeUtil.toMinutes(p[1]), TimeUtil.toMinutes(p[2]), Integer.parseInt(p[3]));
    }
}
