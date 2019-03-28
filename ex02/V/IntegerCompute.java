package ex02.V;

import java.util.Scanner;

/**
 * @author 04181010魏源
 * @version 1.0
 * @since JDK 11.8.2 MacOS 10.11.6
 */

public class IntegerCompute {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入变量A");
        int a = sc.nextInt();
        System.out.println("请输入变量B");
        int b = sc.nextInt();
        System.out.println("请输入运算方式 + - * /");
        char op = sc.next().charAt(0);
        switch (op) {
            case '+':
                System.out.println("A+B:"+ (a+b));
                break;
            case '-':
                System.out.println("A-b" + (a-b));
                break;
            case '*':
                System.out.println("A*B:" + (a*b));
                break;
            case '/':
                System.out.println("A/B:" + (a/b));
                break;
        }
    }
}
