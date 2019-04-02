package ex05.IV;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class TestEarn {
    public static void main(String[] args) {
        Employee Oracle[] = {
                new Boss(30000), //老板总工资
                new CommissionWorker(20000, 3000), //固定工资 + 奖金
                new HourlyWorker(288, 100), //996工作，时新100的程序猿
                new PieceWorker(0.5, 10000), //计件工，单件0.5，数量10000
        };

        for (Employee i : Oracle) {
            System.out.println(i.getClass().getSimpleName() + "  Earns:" + i.Earnings());
        }
    }
}