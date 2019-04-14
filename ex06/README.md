# 实验六实验报告

## I.编写应用程序Sort.java，按升序顺序输出一维数组中的元素

**Sort.java**

```Java
package ex06.I;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class Sort {
    /**
     * 升序排序
     * 拷贝传入数组，并将拷贝数组升序排序返回,不修改传入的数组
     *
     * @param num
     * @return
     */
    public static int[] ascend(int[] num) {
        int sortNum[] = num.clone();
        for (int i = 0; i < sortNum.length; i++) {
            for (int j = i; j < sortNum.length; j++) {
                if (sortNum[j] < sortNum[i]) {
                    int swap = sortNum[j];
                    sortNum[j] = sortNum[i];
                    sortNum[i] = swap;
                }
            }
        }
        return sortNum;
    }
}
```

**TestSort.java**

```Java
package ex06.I;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class TestSort {
    public static void main(String[] args) {
        System.out.println("--------随机测试用例--------");
        int randomNum[] = new int[10];
        for (int i = 0; i < randomNum.length; i++) {
            randomNum[i] = (int) (Math.random() * 100);
            System.out.print(randomNum[i] + "  ");
        }

        System.out.println("\n--------输出升序结果--------");
        for (int i : Sort.ascend(randomNum)) {
            System.out.print(i + "  ");
        }
    }
}
```

**运行结果**

```
--------随机测试用例--------
16  51  82  28  68  59  90  42  86  88  
--------输出升序结果--------
16  28  42  51  59  68  82  86  88  90  
Process finished with exit code 0
```

## 教材第四章课后习题第５或６题

### II.第五題

**RandomNum.java**

```Java
package ex06.II;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
class RandomNum {
    /**
     * 用0-20的随机int填充int数组num
     *
     * @param num
     */
    static void fillRandomArray(int[] num) {
        for (int i = 0; i < num.length; i++) {
            num[i] = (int) (Math.random() * 20 + 0.5);
        }
    }
}
```

**Statis.java**

```Java
package ex06.II;

/**
 * 统计
 *
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
class Statis {
    /**
     * 统计数组num中数字i的出现次数
     *
     * @param num
     * @param i
     * @return sum
     */
    static int count(int num[], int i) {
        int sum = 0;
        for (int j : num) {
            if (j == i) sum++;
        }
        return sum;
    }
}
```

**TestRandom.java**

```Java
package ex06.II;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class TestRandomNum {
    public static void main(String[] args) {
        int num[] = new int[10000];
        RandomNum.fillRandomArray(num);

        for (int i = 0; i <= 20; i++) {
            System.out.println("含有" + Statis.count(num, i) + "个" + i);
        }
    }
}
```

运行效果
```
含有242个0
含有483个1
含有525个2
含有512个3
含有464个4
含有494个5
含有490个6
含有530个7
含有497个8
含有498个9
含有487个10
含有511个11
含有479个12
含有504个13
含有497个14
含有507个15
含有511个16
含有499个17
含有546个18
含有478个19
含有246个20

Process finished with exit code 0
```

### III.第六題

**MyRandom.java**

生成范围内随机数

```Java
package ex06.III;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class MyRandom {
    public static int getRadomIntByRange(int min, int max){
        if(min >max) throw new IllegalArgumentException("min > max"); //如果min大于max抛出错误
        int x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }
}
```

**TestRandomChar.java**

```Java
package ex06.III;

import ex06.I.Sort; //下面需要复用第一题的升序排序方法

import java.util.Vector;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class TestRadomChar {
    public static void main(String[] args) {
        int[] chars = new int[10];
        char randomChar;
        for (int i = 0; i < chars.length; i++) {
            do {
                randomChar = (char) MyRandom.getRadomIntByRange('a', 'z');
            } while (ifCharRepeat(chars, randomChar)); //生成随机数，直到与已有数据不重复
            chars[i] = randomChar;
        }

        System.out.println("Random Char Range From 'a' to 'z'");
        for (int i : chars) System.out.print((char) i + "  ");

        System.out.println("\nAfter Ascend Sort");
        for (int i : Sort.ascend(chars)) System.out.print((char) i + "  "); //这里复用了第一题的升序排序方法
    }

    static boolean ifCharRepeat(int[] chars, char testChar) {
        for (int i : chars) {
            if (i == testChar)
                return true;
        }
        return false;
    }
}
```

运行效果

```
Random Char Range From 'a' to 'z'
f  z  g  w  m  o  j  t  e  a  
After Ascend Sort
a  e  f  g  j  m  o  t  w  z  
Process finished with exit code 0
```

## IV.教材第四章课后习题４题

**MyDate.java**

```Java
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
```

**MonthPrinter.java**

```Java
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
        MyDate.IfDateLegal(year, month, 1);
        int lineBreakCount = 0;
        int startWeek = MyDate.CalWeek(year, month, 1);
        System.out.println("         " + MonthPrinter.monthName[month - 1]);
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
```

**TestCalendar.java**

```Java
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
```

**运行效果**

```
[adam@mibookpro IDEA]$ java -Xss32M ex06.IV.TestCalendar
请输入年月日，将计算出星期几，格式示范 (1900 1 1)
2019 4 10
这天是星期3
请输入年月，打印该月日历
2019 4  
         Apr
Mo Tu We Th Fr Sa Su
 1  2  3  4  5  6  7 
 8  9 10 11 12 13 14 
15 16 17 18 19 20 21 
22 23 24 25 26 27 28 
29 30 
2008年各位数与相应星期相等的天
12月7日 星期7
12月6日 星期6
12月5日 星期5
12月4日 星期4
12月3日 星期3
12月2日 星期2
12月1日 星期1
9月7日 星期7
9月6日 星期6
9月5日 星期5
9月4日 星期4
9月3日 星期3
9月2日 星期2
9月1日 星期1
8月17日 星期7
8月16日 星期6
8月15日 星期5
8月14日 星期4
8月13日 星期3
8月12日 星期2
8月11日 星期1
7月27日 星期7
7月26日 星期6
7月25日 星期5
7月24日 星期4
7月23日 星期3
7月22日 星期2
7月21日 星期1
4月27日 星期7
4月26日 星期6
4月25日 星期5
4月24日 星期4
4月23日 星期3
4月22日 星期2
4月21日 星期1
3月31日 星期1
2月17日 星期7
2月16日 星期6
2月15日 星期5
2月14日 星期4
2月13日 星期3
2月12日 星期2
2月11日 星期1
1月27日 星期7
1月26日 星期6
1月25日 星期5
1月24日 星期4
1月23日 星期3
1月22日 星期2
1月21日 星期1
50

```