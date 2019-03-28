import java.util.Scanner;

/**
 * 练习分支结构
 * 定义一个学生的JAVA成绩为n（0到100的整数），编写一个程序输出这个学生成绩的等级，比如76为“中”。（优：>=90;良：>=80;中：>=70;及格：>=60;不及格：<60)
 * @author 04181010魏源
 * @version 0.1
 * @since JDK 1.8.0
 */

public class GradeIdentify {
    public static void main(){
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        if (n >= 90) {
            System.out.println("分数为" + n + "分，成绩优秀！");
        }else if (n >= 80) {
            System.out.println("分数为" + n + "分，成绩良好！");
        }else if (n >= 70) {
            System.out.println("分数为" + n + "分，成绩中等！");
        }else if (n >= 60) {
            System.out.println("分数为" + n + "分，成绩及格！");
        }else {
            System.out.println("分数为" + n + "分，成绩不及格！");
        }
    }
}
