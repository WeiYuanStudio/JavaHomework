/**
 * @author 04181010魏源
 * @version 0.1
 * @since JDK 11.8.2 MacOS 10.11.6
 */
package ex04.III;

public class Circular {
    private double radius, aria;

    public Circular(){

    }

    public Circular(double radius) {
        this.radius = radius;
        calAria();
    }

    public double calAria(){
        return aria = Math.PI*radius*radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getAria() {
        return aria;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        calAria();
    }
}