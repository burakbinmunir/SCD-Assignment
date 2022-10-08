import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DayOfBirth {

    public static String calculateBornDay(String s1) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat tempDate = new SimpleDateFormat("EEEE");

        Date date = simpleDateFormat.parse(s1);
        String day = tempDate.format(date);
        return day.toUpperCase();
    }

    public static void main(String[] args) throws ParseException {
        System.out.print("Enter your date of birth: ");
        Scanner scanner = new Scanner(System.in);

        String dateOfBirth = scanner.nextLine();
        String dayOfBirth = calculateBornDay(dateOfBirth);
        System.out.println("Your day of birth was: "+ dayOfBirth);
    }
}
