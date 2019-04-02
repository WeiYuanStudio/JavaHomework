package ex05.IV;

/**
 * Boss类
 * 每星期发给他固定工资，而不计工作时间
 *
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public final class Boss extends Employee {
    private double fixedSalary; //固定工资

    public Boss(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    @Override
    double Earnings() {
        return fixedSalary;
    }

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }
}
