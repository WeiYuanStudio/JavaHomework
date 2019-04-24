package ex09.III;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class NotTriangleException extends IllegalArgumentException {
    public NotTriangleException(String message) {
        super("Can't Creat A Triangle: " + message);
    }
}