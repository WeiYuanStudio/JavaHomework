package ex07.I;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class Test {
    public static void main(String[] args) {
        MyString url = new MyString("www.google.com");
        System.out.println(url + " length :" + url.length());
        System.out.println(url + " have " + url.calChar('o') + " o have " + url.calChar('g') + " g");
    }
}
