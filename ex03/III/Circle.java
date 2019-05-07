package ex03.III;

/**
 * 矩形类
 *
 * @author 04181010魏源
 * @version 0.1
 * @since JDK 11.8.2 MacOS 10.11.6
 */

public class Circle {
    private final double PI = 3.14;
    private double radius, perimeter, area;

    public Circle(double radius) {
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getPerimeter() {
        return perimeter = 2 * PI * radius;
    }

    public double getArea() {
        return area = PI * radius * radius;
    }
}