package ex03.IIII;

import ex03.III.Circle;
import ex03.III.Rect;

/**
 * @author 04181010魏源
 * @version 0.1
 * @since JDK 11.8.2 MacOS 10.11.6
 */

public class TestShape {
    public static void main(String args[]) {
        Rect R1 = new Rect(100, 20);
        Circle C1 = new Circle(4);
        System.out.println("矩形的面积为" + R1.getArea() + "周长为" + R1.getPerimeter());
        System.out.println("圆的面积为" + C1.getArea() + "周长为" + C1.getPerimeter());
    }
}