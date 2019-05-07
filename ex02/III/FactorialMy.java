package ex02.III;

import java.util.Scanner;

/**
 * 计算并输出n！
 * @author 04181010魏源
 * @version 0.1
 * @since JDK 11.8.2 MacOS 10.11.6
 */
public class FactorialMy {
    public static void main() {
        System.out.println("请输入一个整数，将计算n！即n的阶乘");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double sum = 1; //使用double类型，防止阶乘过大超出预期范围
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        System.out.println(n + "的阶乘为" + sum);
    }
}
