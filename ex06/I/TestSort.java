package ex06.I;

import ex06.III.MyRandom;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class TestSort {
    public static void main(String[] args) {
        System.out.println("--------随机测试用例--------");
        int randomNum[] = new int[10];
        for (int i = 0; i < randomNum.length; i++) {
            randomNum[i] = MyRandom.getRadomIntByRange(0, 100);
            System.out.print(randomNum[i] + "  ");
        }

        System.out.println("\n--------输出升序结果--------");
        for (int i : Sort.ascend(randomNum)) {
            System.out.print(i + "  ");
        }
    }
}