package ex05.IV;

/**
 * PieceWorker 类
 * 按其生产的产品数发放工资
 *
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public final class PieceWorker extends Employee {
    private double single_piece_wages = 5; //单件工资
    private int production_quantity = 1000; //生产数量

    @Override
    double Earnings() {
        return single_piece_wages * production_quantity;
    }
}
