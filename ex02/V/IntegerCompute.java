package ex02.V;

import java.util.Scanner;

/**
 * @author 04181010魏源
 * @version 1.0
 * @since JDK 11.8.2 MacOS 10.11.6
 */

public class IntegerCompute {

    private static void Option(int a, int b, char op) {
        switch (op) {
            case '+':
                System.out.println("A+B:"+ (a+b));
                break;
            case '-':
                System.out.println("A-B" + (a-b));
                break;
            case '*':
                System.out.println("A*B:" + (a*b));
                break;
            case '/':
                System.out.println("A/B:" + (a/b));
                break;
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入变量A");
        int a = scanner.nextInt();
        System.out.println("请输入变量B");
        int b = scanner.nextInt();
        System.out.println("请输入运算方式 + - * /");
        char option = scanner.next().charAt(0);
        Option(a, b, option);
    }
}
