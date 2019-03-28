/**
 * @author 04181010魏源
 * @version 0.1
 * @since JDK 11.8.2 MacOS 10.11.6
 */
package ex04.II;

import ex04.II.Teacher;

public class TestTeacher {
    public static void main(String[] args) {
        Teacher jilinTeacher_zhangsan = new Teacher("Zhangsan",28,10,"Master");

        System.out.println("Name:" + jilinTeacher_zhangsan.getName());
        System.out.println("Age:"+jilinTeacher_zhangsan.getAge());
        System.out.println("WorkYears:" + jilinTeacher_zhangsan.getWorkYears());
        System.out.println("JobTitle:" + jilinTeacher_zhangsan.getJobTitle());

        System.out.println("\n");

        System.out.println("Start Setting JobTitle");

        System.out.println("\n");

        jilinTeacher_zhangsan.setJobTitle("Teacher");

        System.out.println("Name:" + jilinTeacher_zhangsan.getName());
        System.out.println("Age:"+jilinTeacher_zhangsan.getAge());
        System.out.println("WorkYears:" + jilinTeacher_zhangsan.getWorkYears());
        System.out.println("JobTitle:" + jilinTeacher_zhangsan.getJobTitle());
    }
}