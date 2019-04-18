package ex07.II;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class Test {
    public static void main(String[] args) {
        String str1 = "www.google.com";
        String str2 = "www.google.com";
        System.out.println("str1 use == compare str2 " + (str1 == str2));
        System.out.println("str1 use .equals() compare str2 " + str1.equals(str2));
        String str3 = new String("www.google.com");
        String str4 = new String("www.google.com");
        System.out.println("new str3 use == compare new str4 " + (str3 == str4));
        System.out.println("new str3 use .equals() compare new str4 " + str3.equals(str4));
    }
}
