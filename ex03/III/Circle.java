package ex03.III;

/**
 * 矩形类
 *
 * @author 04181010魏源
 * @version 0.1
 * @since JDK 11.8.2 MacOS 10.11.6
 */

public class Circle {

    double radius, perimeter, area, pi = 3.14;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getter(char type) {
        switch (type) {
            case 'A':
                return area = pi * radius * radius;
            case 'P':
                return perimeter = 2 * pi * radius;
            default:
                return -1; //异常
        }
    }
}