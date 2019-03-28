package ex05.I;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class Bike implements Vehicle {

    @Override
    public void start() {
        System.out.println("Bike Start!");
    }

    @Override
    public void stop() {
        System.out.println("Bike Stop!");
    }
}