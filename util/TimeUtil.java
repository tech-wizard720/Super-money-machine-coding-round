package util;

public class TimeUtil {
    public static int toMinutes(String t) {
        String[] p = t.split(":");
        return Integer.parseInt(p[0]) * 60 + Integer.parseInt(p[1]);
    }

    public static String format(int m) {
        return String.format("%02d:%02d", m / 60, m % 60);
    }
}
