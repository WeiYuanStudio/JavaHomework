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
    private int workHours; //工作时长
    private double hourlyWage; //时薪

    public HourlyWorker(int workHours, double hourlyWage) {
        this.workHours = workHours;
        this.hourlyWage = hourlyWage;
    }

    @Override
    double Earnings() {
        return workHours * hourlyWage;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }
}
