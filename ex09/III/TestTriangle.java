package ex09.III;

import java.util.Scanner;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class TestTriangle {
    public static void main(String[] args) {
        Triangle triangle = null;
        do {
            System.out.println("Please Input Triangle A B C Length");
            Scanner scanner = new Scanner(System.in);
            double a = scanner.nextDouble();
            double b = scanner.nextDouble();
            double c = scanner.nextDouble();
            try {
                triangle = new Triangle(a, b, c);
            } catch (NotTriangleException e) {
                System.err.println("New Triangle Failed: " + e.getMessage());
            }
        } while (triangle == null);
        triangle.printInfo();
    }
}