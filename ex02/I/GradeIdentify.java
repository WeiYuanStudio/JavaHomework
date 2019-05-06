package ex02.I;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 练习分支结构
 * 定义一个学生的JAVA成绩为n（0到100的整数），编写一个程序输出这个学生成绩的等级，比如76为“中”。（优：>=90;良：>=80;中：>=70;及格：>=60;不及格：<60)
 * @author 04181010魏源
 * @version 0.1
 * @since JDK 1.8.0
 */

public class GradeIdentify {
    private static void printGrade(double score) {
        if(score > 100 || score < 0)
            throw new IllegalArgumentException("超出分数范围");
        System.out.print("分数为" + score + "分,");
        switch ((int) (score / 10)) {
            case 9:
                System.out.println("成绩优秀！");
                break;
            case 8:
                System.out.println("成绩良好！");
                break;
            case 7:
                System.out.println("成绩中等！");
                break;
            case 6:
                System.out.println("成绩及格！");
                break;
            default:
                System.out.println("不及格");
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double score = 0;
        try {
            score = sc.nextDouble();
        } catch (InputMismatchException e) {
            System.err.println("请输入Double");
            System.exit(-1);
        }
        try {
            printGrade(score);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
