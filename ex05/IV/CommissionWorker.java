package ex05.IV;

/**
 * CommissionWorker 类
 * 除基本工资外还根据销售额发放浮动工资
 *
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public final class CommissionWorker extends Employee {
    private double fixedSalary; //固定工资
    private double floatingWage; //浮动工资

    public CommissionWorker(double fixedSalary, double floatingWage) {
        this.fixedSalary = fixedSalary;
        this.floatingWage = floatingWage;
    }

    @Override
    double Earnings() {
        return fixedSalary + floatingWage;
    }

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public double getFloatingWage() {
        return floatingWage;
    }

    public void setFloatingWage(double floatingWage) {
        this.floatingWage = floatingWage;
    }
}
