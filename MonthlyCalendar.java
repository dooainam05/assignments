import java.util.*;

public class MonthlyCalendar {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Year: ");
        int year = sc.nextInt();
        System.out.print("Enter Month (1-12): ");
        int month = sc.nextInt();
        
        // Calendar instance
        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, 1); // Month -1 bcz Jan=0
        
        String[] months = {"January","February","March","April","May","June","July",
                           "August","September","October","November","December"};

        int firstDay = c.get(Calendar.DAY_OF_WEEK);     // Which day month starts
        int daysInMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH); // Total days
        
        System.out.println("\nCalendar for the month of " + months[month-1] + ", " + year + "\n");
        System.out.println("Su  Mo  Tu  We  Th  Fr  Sa");

        
        for (int i = 1; i < firstDay; i++) {
            System.out.print("    ");
        }

        // for days
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%-4d", day);
            
            // for weeks
            if ((day + firstDay - 1) % 7 == 0) {
                System.out.println();
            }
        }

        sc.close();
    }
}

