package ex08.III;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class ShapeAPI<T extends Shape> {
    private T shape;

    public void printAria(T shape) {
        System.out.println("Aria is " + shape.getAria());
    }

    public void printPerimeter(T shape) {
        System.out.println("Perimeter is " + shape.getPerimeter());
    }

    public void printAllInfo(T shape) {
        System.out.println(shape.getClass().getSimpleName());
        printPerimeter(shape);
        printAria(shape);
    }
}
