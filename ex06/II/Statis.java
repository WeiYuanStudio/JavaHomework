package ex06.II;

/**
 * 统计
 *
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
class Statis {
    /**
     * 统计数组num中数字i的出现次数
     *
     * @param num
     * @param i
     * @return sum
     */
    static int count(int num[], int i) {
        int sum = 0;
        for (int j : num) {
            if (j == i) sum++;
        }
        return sum;
    }
}
