package ex05.I;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class Test_Vehicle {
    public static void main(String[] args) {
        Car audi;
        Bike yongjiu;

        Vehicle v[] = {
                audi = new Car(),
                yongjiu = new Bike()
        };

        for (Vehicle i : v) {
            i.start();
            i.stop();
        }
    }
}