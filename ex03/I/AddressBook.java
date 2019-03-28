package ex03.I;

import java.util.Scanner;

/**
 * @author 04181010魏源
 * @version 0.1
 * @since JDK 11.8.2 MacOS 10.11.6
 */

public class AddressBook {
    private String name, addr, tel;

    /**
     * 该方法通过输入type（即信息类型）以返回对象的相应信息
     *
     * @param type
     */
    public void getter(char type) {
        switch (type) {
            case 'N':
                System.out.println("姓名：" + name);
                break;
            case 'A':
                System.out.println("地址:" + addr);
                break;
            case 'T':
                System.out.println("电话:" + tel);
                break;
        }
    }

    /**
     * 该方法通过输入type, info参数设定对象的相应信息。
     *
     * @param type
     * @param info
     */
    public void setter(char type, String info) {
        switch (type) {
            case 'N':
                name = info;
                break;
            case 'A':
                addr = info;
                break;
            case 'T':
                tel = info;
                break;
        }
    }

    public void
    getAllInfo() {
        getter('N');
        getter('A');
        getter('T');
    }
}