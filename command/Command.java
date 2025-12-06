package command;

import service.MeetingRoomService;

public interface Command {
    void execute(String[] parts, MeetingRoomService service);
}
