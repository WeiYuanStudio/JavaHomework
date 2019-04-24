package ex09.IV;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
class MyExcep extends RuntimeException {
    public MyExcep(int value) {
        super("非法值" + value);
    }
}