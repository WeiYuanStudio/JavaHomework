package ex06.III;

import ex06.I.Sort; //下面需要复用第一题的升序排序方法

import java.util.Vector;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class TestRadomChar {
    public static void main(String[] args) {
        int[] chars = new int[10];
        char randomChar;
        for (int i = 0; i < chars.length; i++) {
            do {
                randomChar = (char) MyRandom.getRadomIntByRange('a', 'z');
            } while (ifCharRepeat(chars, randomChar)); //生成随机数，直到与已有数据不重复
            chars[i] = randomChar;
        }

        System.out.println("Random Char Range From 'a' to 'z'");
        for (int i : chars) System.out.print((char) i + "  ");

        System.out.println("\nAfter Ascend Sort");
        for (int i : Sort.ascend(chars)) System.out.print((char) i + "  "); //这里复用了第一题的升序排序方法
    }

    static boolean ifCharRepeat(int[] chars, char testChar) {
        for (int i : chars) {
            if (i == testChar)
                return true;
        }
        return false;
    }
}
