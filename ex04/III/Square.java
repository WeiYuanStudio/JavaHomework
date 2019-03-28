/**
 * @author 04181010魏源
 * @version 0.1
 * @since JDK 11.8.2 MacOS 10.11.6
 */
package ex04.III;

import java.lang.Math;

public class Square {
    private double length, aria; //边长

    public Square() {
        length = 0;
        calAria();
    } //无参构造

    public Square(double length) {
        this.length = length;
        calAria();
    } //边长参数构造

    private double calAria() {
        return aria = length * length;
    } //由边长求面积方法，每次set边长后，调用一次以更新面积

    private double calLength() {
        return length = Math.sqrt(aria);
    } //由面积求边长方法，每次set面积后，调用一次以更新面积

    public double getLength() {
        return length;
    } // get边长

    public double getAria() {
        return aria;
    } //get面积

    public void setLength(double length) {
        this.length = length;
        calAria();
    } //set边长

    public void setAria(double aria) {
        this.aria = aria;
        calLength();
    } //set面积
}
