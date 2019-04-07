package ex06.IV;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class MonthPrinte {
    static String monthName[] = {
            "Jan", "Feb", "Mar", "Apr",
            "May", "Jun", "Jul", "Aug",
            "Sep", "Oct", "Nov", "Dec"
    };

    static void PrintMonth(int year, int month) {
        MyDate.IfDateLegal(year, month, 1);
        int lineBreakCount = 0;
        int startWeek = MyDate.CalWeek(year, month, 1);
        System.out.println("         " + MonthPrinte.monthName[month - 1]);
        System.out.println("Mo Tu We Th Fr Sa Su");
        for (int i = 0; i < startWeek - 1; i++) {
            System.out.print("  " + " ");
            lineBreakCount++;
        }
        for (int i = 1; i <= MyDate.DayOfMonth(year, month); i++) {
            if (i < 10) System.out.print(" ");
            System.out.print(i + " ");
            lineBreakCount++;
            if (lineBreakCount == 7) {
                System.out.print('\n');
                lineBreakCount = 0;
            }
        }
        System.out.print('\n');
    }
}
