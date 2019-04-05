package ex06.II;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class TestRandomNum {
    public static void main(String[] args) {
        int num[] = new int[10000];
        RandomNum.fillRandomArray(num);

        for (int i = 0; i <= 20; i++) {
            System.out.println("含有" + Statis.count(num, i) + "个" + i);
        }
    }
}
