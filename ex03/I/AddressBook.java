package ex03.I;

import java.util.Scanner;

/**
 * @author 04181010魏源
 * @version 0.1
 * @since JDK 11.8.2 MacOS 10.11.6
 */

public class AddressBook {
    private String name, addr, tel;

    public AddressBook(){}

    public AddressBook(String name, String addr, String tel) {
        this.name = name;
        this.addr = addr;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void printAllInfo() {
        System.out.println("姓名：" + getName());
        System.out.println("地址：" + getAddr());
        System.out.println("电话：" + getTel());
    }
}