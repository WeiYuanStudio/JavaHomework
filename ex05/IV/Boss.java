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
    private double fixed_salary = 100; //固定工资

    @Override
    double Earnings() {
        return fixed_salary;
    }
}
