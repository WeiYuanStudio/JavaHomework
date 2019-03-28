package ex03.II;

import ex03.I.AddressBook;

import java.util.Scanner;

/**
 * @author 04181010魏源
 * @version 0.1
 * @since JDK 11.8.2 MacOS 10.11.6
 */

public class TestAddressBook {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        AddressBook zhangsan_addr = new AddressBook();
        String info;

        System.out.println("请输入你的姓名");
        info = scan.next();
        zhangsan_addr.setter('N', info);
        System.out.println("请输入你的地址");
        info = scan.next();
        zhangsan_addr.setter('A', info);
        System.out.println("请输入你的电话");
        info = scan.next();
        zhangsan_addr.setter('T', info);
        zhangsan_addr.getAllInfo();
    }

}
