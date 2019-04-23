package ex08.III;

import java.util.Vector;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class TestShape {
    public static void main(String[] args) {
        Circle circle = new Circle(2);

        ShapeAPI<Circle> cAPI = new ShapeAPI<Circle>();
        cAPI.printAllInfo(circle);

        Square square = new Square(2);

        ShapeAPI<Square> sAPI = new ShapeAPI<Square>();
        sAPI.printAllInfo(square);
    }
}
