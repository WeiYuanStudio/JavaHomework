package ex08.I;

import java.util.Scanner;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class TestStudent {
    public static void main(String[] args) {
        Student[] jluzhStu = new Student[3];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("Please Input Student Info");
            System.out.println("StudentNum | Name | Chinese | Math | English");
            jluzhStu[i] = new Student(
                    scanner.next(),
                    scanner.next(),
                    scanner.nextDouble(),
                    scanner.nextDouble(),
                    scanner.nextDouble()
            );
        }

        for (Student i : jluzhStu) {
            System.out.println(i.getStuNum() + "  " + i.getStuName() + "  " + i.getAverageScore());
        }
    }
}
