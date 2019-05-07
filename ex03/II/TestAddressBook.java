package ex03.II;

import ex03.I.AddressBook;

import java.util.Scanner;

/**
 * @author 04181010魏源
 * @version 0.1
 * @since JDK 11.8.2 MacOS 10.11.6
 */

public class TestAddressBook {
    private static void inputName(AddressBook addressBook) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入你的姓名");
        String tempName = scan.next();
        addressBook.setName(tempName);
    }

    private static void inputAddr(AddressBook addressBook) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入你的地址");
        String tempAddr = scan.next();
        addressBook.setAddr(tempAddr);
    }

    private static void inputTel(AddressBook addressBook) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入你的电话");
        String tempTel = scan.next();
        addressBook.setTel(tempTel);
    }

    public static void main(String args[]) {
        AddressBook zhangSan = new AddressBook();

        inputName(zhangSan);
        inputAddr(zhangSan);
        inputTel(zhangSan);

        zhangSan.printAllInfo();
    }

}
