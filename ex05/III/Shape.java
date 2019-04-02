package ex05.III;

/**
 * 定义一个形状类（做成抽象类或接口皆可）
 * 有周长和面积两个域变量
 * 三个抽象方法：计算周长，计算其面积及输出周长和面积的抽象方法
 *
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public abstract class Shape {
    double perimeter, aria; //周长和面积

    public abstract double Perimeter();

    public abstract double Aria();

    void PrintPerimeter(){
        System.out.println(this.getClass().getSimpleName() + " Perimeter is " + perimeter);
    }

    void PrintAria(){
        System.out.println(this.getClass().getSimpleName() + " Aria is " + aria);
    }
}
