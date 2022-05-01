import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateTimeExample {
    public static void main(String... args) throws ParseException {
        String input = "12:01:00AM";
        System.out.println(ampmToMilitary(input));
    }

    private static String ampmToMilitary(String input) throws ParseException {
        input = input.substring(0,8)+" "+input.substring(8);
        SimpleDateFormat militaryFormat = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat ampmFormat = new SimpleDateFormat("hh:mm:ss a");
        return militaryFormat.format(ampmFormat.parse(input));
    }
}
