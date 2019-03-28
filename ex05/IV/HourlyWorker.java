package ex05.IV;

/**
 * HourlyWorker 类
 * 根据工作时间长短发放工资
 *
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public final class HourlyWorker extends Employee {
    private int work_hours = 248; //工作时长
    private double hourly_wage = 10; //时薪

    @Override
    double Earnings() {
        return work_hours * hourly_wage;
    }
}
