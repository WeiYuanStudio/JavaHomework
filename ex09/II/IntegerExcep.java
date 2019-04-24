package ex09.II;

import java.util.Scanner;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class IntegerExcep {
    public static void main(String[] args) {
        System.out.println("Please Input A Num String");
        Scanner scaner = new Scanner(System.in);
        String numString = scaner.next();
        double numDouble = 0;
        try {
            stringToDouble(numString);
        } catch (NumberFormatException e) {
            System.err.println("Input Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void stringToDouble(String numString) {
        double numDouble = Double.parseDouble(numString);
        if (numDouble < 0 || numDouble > 100) {
            throw new IllegalArgumentException("Out Of Range 0-100");
        }
        System.out.println("Num Double is " + numDouble);
    }
}