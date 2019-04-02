package ex05.II;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class Test_Shape {
    public static void main(String[] args) {
        J_Square square = new J_Square(); //没有体现多态

        Shape circle = new J_Circle(); //体现了多态
        //多态三条件
        //1.继承 2.子类重写父类方法 3.父类引用指向子类的对象
        circle.draw();
        square.draw();
    }
}