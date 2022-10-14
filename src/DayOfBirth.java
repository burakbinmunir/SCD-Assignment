import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DayOfBirth {

    // This function parses the string date into the date
    // then we can utilize Date class function to get the format of day
    public static String calculateBornDay(String stringDate) throws ParseException { // might throw exception if data to be parsed is in wrong format
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat tempDate = new SimpleDateFormat("EEEE");

        Date date = simpleDateFormat.parse(stringDate);
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
