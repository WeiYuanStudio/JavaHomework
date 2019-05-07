package ex03.III;

/**
 * 矩形类
 *
 * @author 04181010魏源
 * @version 0.1
 * @since JDK 11.8.2 MacOS 10.11.6
 */

public class Rect {

    private double length, width, perimeter, area;//长，宽，周长，面积

    /**
     * 构造方法，初始化内部变量
     *
     * @param length
     * @param width
     */
    public Rect(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getPerimeter() {
        return perimeter = 2 * (length + width);
    }

    public double getArea() {
        return area = length * width;
    }
}