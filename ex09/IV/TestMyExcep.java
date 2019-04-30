package ex09.IV;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
class TestMyExcep {
    public static void main(String[] args) {
        for (int i = 0; i <= 20; i++) {
            try {
                new MyNum(i);
            } catch (MyExcep e) {
                System.err.println(e.getMessage());
            }
        }
    }
}