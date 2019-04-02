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
    private double singlePieceWages; //单件工资
    private int productionQuantity; //生产数量

    public PieceWorker(double singlePieceWages, int productionQuantity) {
        this.singlePieceWages = singlePieceWages;
        this.productionQuantity = productionQuantity;
    }

    @Override
    double Earnings() {
        return singlePieceWages * productionQuantity;
    }

    public double getSinglePieceWages() {
        return singlePieceWages;
    }

    public void setSinglePieceWages(double singlePieceWages) {
        this.singlePieceWages = singlePieceWages;
    }

    public int getProductionQuantity() {
        return productionQuantity;
    }

    public void setProductionQuantity(int productionQuantity) {
        this.productionQuantity = productionQuantity;
    }
}
