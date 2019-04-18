package ex07.IV;

import java.lang.reflect.Array;
import java.util.Scanner;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class Test {
    public static void main(String[] args) {
        String target = "AB-C-ABC";
        System.out.println(target);

        /*替换掉A*/
        String afterReplace = target.replace("A", "First");
        System.out.println(afterReplace);

        /*切分*/
        for (String i : afterReplace.split("-")) {
            System.out.println(i);
        }

        /*字典对比两字符串*/
        System.out.println("Please Input 2 String Format:(Hello Hi)");
        Scanner scan = new Scanner(System.in);
        String aString = scan.next();
        String bString = scan.next();
        System.out.println(aString + " " + bString + " Compare Result " + aString.compareTo(bString));

        /*字符串转字符数组*/
        String cString = "ABCDEFG";
        char[] cStringToChar = cString.toCharArray();

        StringBuffer cStringHEAD = new StringBuffer();

        /*字符数组填充Buffer*/
        for(int i = 0 ; i<3;i++) {
            cStringHEAD.append(cStringToChar[i]);
        }
        System.out.println(cStringHEAD);
    }
}