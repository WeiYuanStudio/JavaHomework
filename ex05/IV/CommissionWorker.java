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
    private double fixed_salary = 100; //固定工资
    private double floating_wage = 200; //浮动工资

    @Override
    double Earnings() {
        return fixed_salary + floating_wage;
    }
}
