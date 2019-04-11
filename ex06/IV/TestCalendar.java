package ex06.IV;

import java.util.Scanner;

/**
 * 测试Calendar类，由于Calendar类使用了大量的递归，所以需要在运行前手动加入参数以增加栈空间，防止溢出
 * 可以参考我的运行参数，如下
 * java -Xss32M ex06.IV.TestCalendar
 * 实测分配32M的空间已经足够从1900计算到2099年，若要想计算后的年份，可以酌情增加一下内存分配
 * java运行参数参考资料 https://stackoverflow.com/questions/3700459/how-to-increase-the-java-stack-size
 *
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class TestCalendar {
    public static void main(String[] args) {
        System.out.println("请输入年月日，将计算出星期几，格式示范 (1900 1 1)");
        Scanner sc = new Scanner(System.in);
        int scanYear = sc.nextInt();
        int scanMonth = sc.nextInt();
        int scanDay = sc.nextInt();

        MyDate testDay = new MyDate(scanYear, scanMonth, scanDay);

        System.out.println("这天是星期" + testDay.getWeek());

        System.out.println("请输入年月，打印该月日历");
        scanYear = sc.nextInt();
        scanMonth = sc.nextInt();
        MonthPrinter.PrintMonth(scanYear, scanMonth);

        System.out.println("2008年各位数与相应星期相等的天");
        MyDate day = new MyDate(2008, 12, 31);
        MyDate dayEnd = new MyDate(2008, 1, 1);
        int sameDay = 0;
        while (!day.equals(dayEnd)) {
            if (day.getDay() % 10 == day.getWeek()) {
                sameDay++;
                System.out.println(day.getMonth() + "月" + day.getDay() + "日 星期" + day.getWeek());
            }
            day = day.Yesterday();
        }
        System.out.println(sameDay);
    }
}