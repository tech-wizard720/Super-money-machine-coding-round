import java.util.Scanner;
import command.Command;
import factory.CommandFactory;
import service.MeetingRoomService;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MeetingRoomService service = new MeetingRoomService();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] p = line.split(" ");
            Command cmd = CommandFactory.getCommand(p[0]);
            if (cmd != null) cmd.execute(p, service);
        }
    }
}
