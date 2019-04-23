package ex08.II;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class TestWeekDay {
    public static void main(String[] args) {
        for(WeekDay i : WeekDay.values()) {
            System.out.print(i.toString() + "  ");
        }
    }
}