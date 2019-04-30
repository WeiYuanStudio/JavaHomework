package ex10.II;

import javax.swing.text.Style;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2   gson 2.8.5
 */
public class TestStudentDataBase {
    static String dataBasePath;
    /**
     * 获取学生信息并构建成StudentInfo对象
     * @return 学生信息对象
     */
    private static StudentInfo getFormatStudent() {
        System.out.println("Please Input Student Info");
        System.out.println("StudentNum | StudentName | Sex | Grade | GPA");
        Scanner sc = new Scanner(System.in);
        String tempNum = sc.next();
        String tempName = sc.next();
        String tempSex = sc.next();
        int tempGrade = sc.nextInt();
        int tempGPA = sc.nextInt();
        return new StudentInfo(tempNum, tempName, tempSex, tempGrade, tempGPA);
    }

    /**
     * 写入学生信息方法，供main方法调用
     */
    private static void getStudentMenu() {
        StudentDataBase jluzh = new StudentDataBase(dataBasePath, "WeiYuanStudio");
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                jluzh.addStudent(getFormatStudent());
            } catch (InputMismatchException e) {
                System.out.println("Error Input");
            }
            System.out.println("Input Y or y Continue Add Student");
        } while (scanner.next().equals("Y") || scanner.next().equals("y"));

        try {
            jluzh.writeFile();
        } catch (IOException e) {
            System.out.println("Write File Failed ! " + e.getMessage());
        }
    }

    /**
     * 打印所有学生信息
     */
    private static void printStudentMenu() {
        StudentDataBase jluzh = new StudentDataBase(dataBasePath, "WeiYuanStudio");
        try {
            jluzh.readFile();
        } catch (IOException e) {
            System.out.println("Read File Failed ! " + e.getMessage());
        }
        System.out.println("StudentNum | StudentName | Sex | Grade | GPA");
        for (StudentInfo i : jluzh.getDataBaseJson().studentInfos) {
            System.out.print(i.getStudentNum() + "     ");
            System.out.print(i.getStudentName() + "     ");
            System.out.print(i.getStudentSex() + "     ");
            System.out.print(i.getStudentGrade() + "     ");
            System.out.print(i.getStudentGPA() + "     \n");
        }
    }

    public static void main(String[] args) {
        dataBasePath = args[0];
        while (true) {
            System.out.println("Please Input Number To Choose Menu, You Have Set File Path: " + dataBasePath);
            System.out.println("1. Write Data");
            System.out.println("2. Print Data");
            System.out.println("3. Exit");
            Scanner sc = new Scanner(System.in);
            int menuNum = sc.nextInt();
            switch (menuNum) {
                case 1:
                    getStudentMenu();
                    break;
                case 2:
                    printStudentMenu();
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}