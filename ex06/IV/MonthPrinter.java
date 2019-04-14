package ex06.IV;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class MonthPrinter {
    static String monthName[] = {
            "Jan", "Feb", "Mar", "Apr",
            "May", "Jun", "Jul", "Aug",
            "Sep", "Oct", "Nov", "Dec"
    };

    static void PrintMonth(int year, int month) {
        MyDate.IfDateLegal(year, month, 1); //检测年月是否合法
        int lineBreakCount = 0; //换行计数
        int startWeek = MyDate.CalWeek(year, month, 1); //计算该月第一天是星期几
        System.out.println("         " + MonthPrinter.monthName[month - 1]); //打印月份
        System.out.println("Mo Tu We Th Fr Sa Su"); //打印表头
        for (int i = 0; i < startWeek - 1; i++) {
            System.out.print("  " + " ");
            lineBreakCount++;
        } //打印月开头至第一天的空格
        for (int i = 1; i <= MyDate.DayOfMonth(year, month); i++) {
            if (i < 10) System.out.print(" "); //如果是个位数日期，打印补空空格
            System.out.print(i + " "); //打印日期
            lineBreakCount++; //换行计数加一
            if (lineBreakCount == 7) {
                System.out.print('\n');
                lineBreakCount = 0;
            } //如果已经达到换行次数，换行
        }
        System.out.print('\n');
    }
}
