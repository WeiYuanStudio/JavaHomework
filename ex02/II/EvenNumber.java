package ex02.II;

import java.util.Scanner;

/**
 * 用一个for循环找出n以内的偶数。
 * @author 04181010魏源
 * @version 0.1
 * @since JDK 11.8.2 MacOS 10.11.6
 */
public class EvenNumber {
    public static void main() {
        int counter = 0; //换行计数器
        System.out.println("请输入0～n范围，将输出该范围内的偶数");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            if (i%2 == 0) {
                System.out.print(i + "   ");
                counter++;
            }
            if (counter == 10) {
                System.out.print('\n');
                counter = 0;
            } //十个数换一行
        }
    }
}
