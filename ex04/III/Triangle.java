/**
 * @author 04181010魏源
 * @version 0.1
 * @since JDK 11.8.2 MacOS 10.11.6
 */
package ex04.III;

import java.lang.Math;

public class Triangle {

    private double lengthA, lengthB, lengthC, aria;

    public Triangle() {
    }

    public Triangle(double lengthA, double lengthB, double lengthC) {
        this.lengthA = lengthA;
        this.lengthB = lengthB;
        this.lengthC = lengthC;
        calTriangleAria();
    }

    /**
     * 海伦-秦九韶公式
     * https://zh.wikipedia.org/wiki/%E6%B5%B7%E4%BC%A6%E5%85%AC%E5%BC%8F
     * @return aria
     */

    public double calTriangleAria() {
        double S = (lengthA + lengthB + lengthC) / 2; //半周长
        return aria = Math.sqrt(S * (S - lengthA) * (S - lengthB) * (S - lengthC));
    }

    public double getLengthA() {
        return lengthA;
    }

    public double getLengthB() {
        return lengthB;
    }

    public double getLengthC() {
        return lengthC;
    }

    public double getAria() {
        return aria;
    }

    public void setLengthA(double lengthA) {
        this.lengthA = lengthA;
        calTriangleAria();
    }

    public void setLengthB(double lengthB) {
        this.lengthB = lengthB;
        calTriangleAria();
    }

    public void setLengthC(double lengthC) {
        this.lengthC = lengthC;
        calTriangleAria();
    }
}