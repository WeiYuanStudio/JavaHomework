package ex09.IV;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
class MyNum {
    private int value;
    public MyNum(int value) {
        if (value == 13 || value == 4)
            throw new MyExcep(value);
        this.value = value;
        System.out.println("构造成功，value = " + value);
    }
}