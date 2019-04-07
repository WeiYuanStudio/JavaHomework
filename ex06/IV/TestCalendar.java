package ex06.IV;

import java.util.Scanner;

/**
 * 测试Calendar类，由于Calendar类使用了大量的递归，所以需要在运行前手动加入参数以增加栈空间，防止溢出
 * 可以参考我的运行参数，如下
 * java -Xss32M ex06.IV.TestCalendar
 * 实测分配32M的空间已经足够从1900计算到2099年，若要想计算后的年份，可以酌情增加一下内存分配
 * 参考资料 https://stackoverflow.com/questions/3700459/how-to-increase-the-java-stack-size?rq=1
 * BTW,该题应该可以使用另一种思路来实现，通过在堆中建立日期链表，杜绝因递归过多占用大量的栈空间的问题
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

//        System.out.println(MyDate.CalWeek(testDay)); 这行代码计算星期有效率问题，待研究
        System.out.println(testDay.getWeek()); //是上面那行代码的另一种实现，极大的加快了计算速度

        System.out.println("请输入年月，打印该月日历");
        scanYear = sc.nextInt();
        scanMonth = sc.nextInt();
        MonthPrinte.PrintMonth(scanYear, scanMonth);
    }
}