package ex06.I;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class Sort {
    /**
     * 升序排序
     * 拷贝传入数组，并将拷贝数组升序排序返回,不修改传入的数组
     *
     * @param num
     * @return
     */
    public static int[] ascend(int[] num) {
        int sortNum[] = num.clone();
        for (int i = 0; i < sortNum.length; i++) {
            for (int j = i; j < sortNum.length; j++) {
                if (sortNum[j] < sortNum[i]) {
                    int swap = sortNum[j];
                    sortNum[j] = sortNum[i];
                    sortNum[i] = swap;
                }
            }
        }
        return sortNum;
    }
}
