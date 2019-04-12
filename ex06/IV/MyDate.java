package ex06.IV;

import java.util.Date;

/**
 * 命名MyDate与Java标准库内的Data区分
 *
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class MyDate {
    /*在这里修改起始计算的日期，星期靠此处的参数进行推算
     * 如果设置的起始年份过于久远，会加大运算时的负担
     * 该类只能运算设定日期之后的日期，还没有完善向前推算的功能*/
    private static final int setYear = 1900;
    private static final int setMonth = 1;
    private static final int setDay = 1;
    private static final int setWeek = 1;
    /*1900年的1月1日是星期一*/

    private final int year; //年
    private final int month; //月期
    private final int day; //日期
    private final int week; //星期

    MyDate(int year, int month, int day) {
        if (!IfDateLegal(year, month, day)) throw new IllegalArgumentException("输入的日期不合法"); //检测年月日三个信息是否合法
        this.year = year;
        this.month = month;
        this.day = day;
        this.week = CalWeek(year, month, day); //调用递归计算该天是星期几
    }

    /**
     * 判断是否闰年,闰年返回true，否则返回false
     * https://zh.wikipedia.org/wiki/%E9%97%B0%E5%B9%B4
     *
     * @param year
     * @return
     */
    static boolean IfLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0 && year % 3200 != 0))
            return true;
        return false;
    }

    /**
     * 通过年份和月份计算该月的天数
     *
     * @param year
     * @param month
     * @return
     */
    static int DayOfMonth(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            return 31; //公历:一三五七八十腊，三十一天永不差
        else if (month == 2) { //二月特殊处理，闰年返回29，平年返回28
            if (IfLeapYear(year)) {
                return 29;
            }
            return 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) //剩下的月份4，6，9，11都是一个月有30天
            return 30;
        throw new IllegalArgumentException("错误的月期参数");
    }

    int DayOfMonth() {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            return 31; //公历:一三五七八十腊，三十一天永不差
        else if (month == 2) { //二月特殊处理，闰年返回29，平年返回28
            if (IfLeapYear(year)) {
                return 29;
            }
            return 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) //剩下的月份4，6，9，11都是一个月有30天
            return 30;
        throw new IllegalArgumentException("错误的月期参数");
    }

    /**
     * 计算星期几，参数为年月日
     */
    static int CalWeek(int year, int month, int day) {
        if (!IfDateLegal(year, month, day)) throw new IllegalArgumentException("输入的日期不合法"); //检测年月日三个信息是否合法
        if (year == setYear && month == setMonth && day == setDay) //如果传入参数是上面设置的起始计算日信息，则直接返回已经设置好星期信息
            return setWeek;
        else { //如果传入参数不是上面设置的起始计算日信息，则调用Yesterday方法生成一个包含昨天信息的MyDate对象，向其获取昨天的星期信息
            int yesterdayWeek = Yesterday(year, month, day).getWeek();
            return (yesterdayWeek < 7 ? yesterdayWeek + 1 : 1); //通过昨天的星期信息即可推算出今天是星期几
        }
    }

    int CalWeek() {
        if (!IfDateLegal(year, month, day)) throw new IllegalArgumentException("输入的日期不合法"); //检测年月日三个信息是否合法
        if (year == setYear && month == setMonth && day == setDay) //如果传入参数是上面设置的起始计算日信息，则直接返回已经设置好星期信息
            return setWeek;
        else { //如果传入参数不是上面设置的起始计算日信息，则调用Yesterday方法生成一个包含昨天信息的MyDate对象，向其获取昨天的星期信息
            int yesterdayWeek = Yesterday(year, month, day).getWeek();
            return (yesterdayWeek < 7 ? yesterdayWeek + 1 : 1); //通过昨天的星期信息即可推算出今天是星期几
        }
    }

    static int CalWeek(MyDate today) {
        if (!IfDateLegal(today.year, today.month, today.day)) throw new IllegalArgumentException("输入的日期不合法"); //检测年月日三个信息是否合法
        if (today.year == setYear && today.month == setMonth && today.day == setDay) {//如果传入参数是上面设置的起始计算日信息，则直接返回已经设置好星期信息
            return setWeek;
        } else { //如果传入参数不是上面设置的起始计算日信息，则调用Yesterday方法生成一个包含昨天信息的MyDate对象，向其获取昨天的星期信息
            int yesterdayWeek = CalWeek(Yesterday(today));
            return (yesterdayWeek < 7 ? yesterdayWeek + 1 : 1);//通过昨天的星期信息即可推算出今天是星期几
        }
    }

    /**
     * 计算昨天
     * 返回一个包含昨天日期信息的MyDate对象
     */
    static MyDate Yesterday(MyDate today) {
        if (!IfDateLegal(today.year, today.month, today.day)) throw new IllegalArgumentException("输入的日期不合法"); //检测年月日三个信息是否合法
        if (today.day > 1) //如果当天日期日不为1，那么昨天的日期信息，只需要在日上减1
            return new MyDate(today.year, today.month, today.day - 1);
        else if (today.month > 1) { //如果当日的日为1，而月份不为一，那么昨天的日期信息，月为当月减1，日为这个月最后一天
            return new MyDate(today.year, today.month - 1, DayOfMonth(today.year, today.month - 1));
        } else { //如果当日的日为1，月份也为1，那么昨天的年份减1，月为12，日为31
            return new MyDate(today.year - 1, 12, 31);
        }
    }

    static MyDate Yesterday(int year, int month, int day) {
        if (!IfDateLegal(year, month, day)) throw new IllegalArgumentException("输入的日期不合法"); //检测年月日三个信息是否合法
        if (day > 1) //如果当天日期日不为1，那么昨天的日期信息，只需要在日上减1
            return new MyDate(year, month, day - 1);
        else if (month > 1) {//如果当日的日为1，而月份不为一，那么昨天的日期信息，月为当月减1，日为这个月最后一天
            return new MyDate(year, month - 1, DayOfMonth(year, month - 1));
        } else {//如果当日的日为1，月份也为1，那么昨天的年份减1，月为12，日为31
            return new MyDate(year - 1, 12, 31);
        }
    }

    MyDate Yesterday() {
        if (!IfDateLegal(year, month, day)) throw new IllegalArgumentException("输入的日期不合法"); //检测年月日三个信息是否合法
        if (day > 1) //如果当天日期日不为1，那么昨天的日期信息，只需要在日上减1
            return new MyDate(year, month, day - 1);
        else if (month > 1) {//如果当日的日为1，而月份不为一，那么昨天的日期信息，月为当月减1，日为这个月最后一天
            return new MyDate(year, month - 1, DayOfMonth(year, month - 1));
        } else {//如果当日的日为1，月份也为1，那么昨天的年份减1，月为12，日为31
            return new MyDate(year - 1, 12, 31);
        }
    }

    /**
     * 日期是否合法
     */
    static boolean IfDateLegal(int year, int month, int day) {
        if (year < setYear) return false; //年份超出程序设计范围
        if (month < 1 || 12 < month) return false; //月份不符合定义
        if (day < 1 || DayOfMonth(year, month) < day) return false; //日期不符合定义
        return true;
    }

    boolean equals(MyDate date) {
        if(date.day == this.day && date.month == this.month && date.year == this.year)
            return true;
        return false;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getWeek() {
        return week;
    }
}