package ex05.III;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class TestShape {
    public static void main(String[] args) {
        Dot A = new Dot(6, 0);
        Dot B = new Dot(2, 0);
        Dot C = new Dot(3, 0);

        Dot D = new Dot(2, 0);
        Dot E = new Dot(6, 0);
        System.out.println(Dot.IfRepeat(A, B, C, D, E));
    }
}