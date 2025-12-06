package factory;

import command.*;

public class CommandFactory {
    public static Command getCommand(String cmd) {
        switch (cmd) {
            case "ADD_ROOM":
                return new AddRoomCommand();
            case "BOOK":
                return new BookCommand();
            case "CANCEL":
                return new CancelCommand();
            case "LIST_BOOKINGS":
                return new ListBookingsCommand();
            case "SUGGEST":
                return new SuggestCommand();
            default:
                return null;
        }
    }
}
