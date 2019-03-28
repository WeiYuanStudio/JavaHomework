package ex05.IV;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class TestEarn {
    public static void main(String[] args) {
        Employee Oracle[] = {new Boss(), new CommissionWorker(), new PieceWorker(), new HourlyWorker()};

        for (Employee i : Oracle) {
            System.out.println(i.getClass().getSimpleName() + "  Earns:" + i.Earnings());
        }
    }
}