/**
 * @author 04181010魏源
 * @version 0.1
 * @since JDK 11.8.2 MacOS 10.11.6
 */
package ex04.III;

public class Pentagon {
    private double length, aria;

    public Pentagon() {

    }

    public Pentagon(double length) {
        this.length = length;
        calAria();
    }

    /**
     * 五边形面积计算
     * https://zh.wikipedia.org/wiki/%E4%BA%94%E8%BE%B9%E5%BD%A2
     *
     * @return aria
     */
    public double calAria() {
        return aria = 5 * length * length * Math.tan((Math.toRadians(54))) / 4;
    }

    public double getLength() {
        return length;
    }

    public double getAria() {
        return aria;
    }

    public void setLength(double length) {
        this.length = length;
        calAria();
    }
}
