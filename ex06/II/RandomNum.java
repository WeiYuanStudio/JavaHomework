package ex06.II;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
class RandomNum {
    /**
     * 用0-20的随机int填充int数组num
     *
     * @param num
     */
    static void fillRandomArray(int[] num) {
        for (int i = 0; i < num.length; i++) {
            num[i] = (int) (Math.random() * 20 + 0.5);
        }
    }
}
