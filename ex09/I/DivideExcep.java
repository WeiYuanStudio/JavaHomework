package ex09.I;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class DivideExcep {
    public static void main(String[] args) {
        try {
            divide();
        } catch (InputMismatchException e) {
            System.err.println("Input Mistake, Please Input Double");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void divide() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input 2 Num to Cal, And Out A/B");
        System.out.println("Input A Now");
        double a = scanner.nextDouble();
        System.out.println("Input B Now");
        double b = scanner.nextDouble();
        if (b == 0) {
            throw new IllegalArgumentException("B Can't Be 0");
        }
        System.out.println("A / B = " + a / b);
    }
}
