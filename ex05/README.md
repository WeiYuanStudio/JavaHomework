# 实验五实验报告

**已进行Code Review，当前实验报告已不是最新代码，请在上方查看最新代码和CodeReview报告(REVIEW.md)**  
**第III旧代码存在严重问题，请直接查看上方III文件中的.java文件**

## I. 测试接口的用法

创建一个Vehicle接口，在接口中定义2个抽象方法：启动start()和刹车stop()。

定义两个类Car和Bike，实现Vehicle接口,并具体实现接口start()和stop()方法 。

创建另一个类Test_Vehicle，在main主方法中分别通过使用Vehicle接口创建关于Car 与Bike类的引用对象audi与yongjiu。

使用接口Vehicle的两个引用对象分别调用各自的启动start()与刹车stop()，显示不同运输工具的多态性。  

**Vehicle.java**

```Java
package ex05;

/**
 * Vehicle 接口
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public interface Vehicle {
    public void start();
    public void stop();
}
```

**Car.java**

```Java
package ex05;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car Start!");
    }

    @Override
    public void stop() {
        System.out.println("Car Stop!");
    }
}
```
**Bike.java**

```Java
package ex05;

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
```

**Test_Vehicle**

```Java
package ex05;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class Test_Vehicle {
    public static void main(String[] args) {
        Car audi;
        Bike yongjiu;
        Vehicle v[] = {audi = new Car(), yongjiu = new Bike()};
        for (Vehicle i:v) {
            i.start();
            i.stop();
        }
    }
}
```

运行结果如下

```
Car Start!
Car Stop!
Bike Start!
Bike Stop!

Process finished with exit code 0
```

## II.多态

建立一个抽象类Shape，其中包含一个抽象方法draw()

```Java
package ex05.II;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public abstract class Shape {
    public abstract void draw();
}
```

建立两个子类J_Circle和J_Square，继承Shape,分别实现Shape中的抽象方法draw()

**J_Circle**

```Java
package ex05.II;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class J_Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("This is circle");
    }
}
```

**J_Square**

```Java
package ex05.II;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class J_Square extends Shape {
    @Override
    public void draw() {
        System.out.println("This is square");
    }
}
```

建立Test_Shape类，创建一个J_Square类的对象sqare，再创建一个Shape关于J_Circle的引用对象circle；

```Java
package ex05.II;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class Test_Shape {
    public static void main(String[] args) {
        J_Circle circle = new J_Circle();
        J_Square square = new J_Square();

        circle.draw();
        square.draw();
    }
}
```

通过circle对象调用方法draw(),观察如何实现Shape类的多态性。

运行结果
```
This is circle
This is square

Process finished with exit code 0
```

问题：square对象是否实现多态性？Circle对象是否实现多态性？为什么？

>实现了多态性，子类中的draw()成功覆写。







## III.第三章第9题，除课文要求还要满足
定义一个形状类（做成抽象类或接口皆可），有周长和面积两个域变量，三个抽象方法：计算周长，计算其面积及输出周长和面积的抽象方法  

定义一个测试操作类，只有一个主方法，运用多态思想，生成两个数据类型是形状类但其引用的分别是矩形类和正方形类的对象，并分别输出结果。  

提示：书上要求在任意位置构造图形，但也要注意能否构造图形，比如三角形三点成一线就无法创建。

**Dot**

```Java
package ex05.III;

/**
 * 点类
 * x,y座标
 * 计算点点距离 CalDistance
 * 计算点点成线，该线斜率
 *
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class Dot {
    public double x, y;

    public Dot(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 检测是否有点重复，不定参数。
     * 若有点重复则返回true，若无点重复则返回false
     *
     * @param dots
     * @return
     */
    public static boolean IfRepeat(Dot... dots) {
        for (int i = 0; i < dots.length; i++) {
            for (int j = i + 1; j < dots.length; j++) {
                if (CalDistance(dots[i], dots[j]) <= 1E-10)
                    return true;
            }
        }
        return false;
    }

    /**
     * 检测由AB和BC构成的直线是否垂直
     * 若垂直返回true，不垂直返回false
     *
     * @param dotA
     * @param dotC
     * @param dotB
     * @return
     */
    public static boolean IfVertical(Dot dotA, Dot dotB, Dot dotC) {
        if (CalSlope(dotA, dotB) == "notExist" || CalSlope(dotB, dotC) == "notExist") {
            if ((CalSlope(dotA, dotB) == "notExist" && Double.valueOf(CalSlope(dotB, dotC)) <= 1E-10) || (CalSlope(dotB, dotC) == "notExist" && Double.valueOf(CalSlope(dotA, dotB)) <= 1E-10)) {
                return true; //两线其中一线斜率不存在，特殊处理
            }
        } else if (Double.valueOf(CalSlope(dotA, dotB)) * Double.valueOf(CalSlope(dotB, dotC)) + 1 <= 1E-10) {
            return true;
        }
        return false;
    }

    public double CalDistance(Dot dot) {
        return Math.sqrt((dot.x - x) * (dot.x - x) + (dot.y - y) * (dot.y - y));
    } //该点到dot的距离

    public static double CalDistance(Dot dotA, Dot dotB) {
        return Math.sqrt((dotA.x - dotB.x) * (dotA.x - dotB.x) + (dotA.y - dotB.y) * (dotA.y - dotB.y));
    } //两点dotA dotB 之间距离

    public String CalSlope(Dot dot) {
        if (Math.abs(dot.x - this.x) - 0 <= 1E-10) {
            if (CalDistance(dot) <= 1E-10) {
                throw new RuntimeException("点重复");
            } else {
                return "notExist"; //斜率不存在
            }
        }
        return Double.toString((dot.y - y) / (dot.x - x));
    }

    public static String CalSlope(Dot dotA, Dot dotB) {
        if (Math.abs(dotA.x - dotB.x) <= 1E-10) {
            if (CalDistance(dotA, dotB) <= 1E-10) {
                throw new RuntimeException("点重复");
            } else {
                return "notExist"; //斜率不存在
            }
        }
        return Double.toString((dotA.y - dotB.y) / (dotA.x - dotB.x));
    }
}
```

**Shape**

```Java
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

    public abstract double CalPerimeter();

    public abstract double CalAria();

    public void PrintPerimeter(){
        System.out.println(this.getClass().getSimpleName() + " Perimeter is " + perimeter);
    }

    public void PrintAria(){
        System.out.println(this.getClass().getSimpleName() + " Aria is " + aria);
    }
}
```

**Rectangle**

```Java
package ex05.III;

public class Rectangle extends Shape {
    Dot A, B, C, D;

    /**
     * 矩形类
     */

    public Rectangle(Dot A, Dot B, Dot C, Dot D) {
        if (Dot.IfRepeat(A, B, C, D)) { //判断是否有点重复
            throw new RuntimeException("点重复");
        } else if ((Dot.CalDistance(A, C) != Dot.CalDistance(B, D)) || !Dot.IfVertical(A, B, C) || !Dot.IfVertical(B, C, D) || !Dot.IfVertical(C, D, A)) {
            //上方语句判断是否符合矩形的定义，先判断一下是否对角线相等，
            throw new RuntimeException("点座标不符合矩形的定义");
        } else {
            this.A = A;
            this.B = B;
            this.C = C;
            this.D = D;
            CalPerimeter();
            CalAria();
        }


    }

    @Override
    public double CalPerimeter() {
        return perimeter = Dot.CalDistance(A, B) + Dot.CalDistance(B, C) + Dot.CalDistance(C, D) + Dot.CalDistance(D, A);
    }

    @Override
    public double CalAria() {
        return aria = Dot.CalDistance(A, B) * Dot.CalDistance(B, C);
    }
}
```

**Square**

```Java
package ex05.III;

public class Square extends Shape {
    Dot A, B, C, D;

    /**
     * 判断是否有点重复
     * 判断是否两线长度一致
     * 判断是否两线成垂直
     * B点需是正方形边AB，BC的交点
     *
     * @author WeiYuan
     * @version 0.1
     * @since JDK 11.0.2
     */
    public Square(Dot A, Dot B, Dot C, Dot D) {
        if (Dot.IfRepeat(A, B, C, D)) { //判断是否有点重复
            throw new RuntimeException("点重复");
        } else if ((Dot.CalDistance(A, B) != Dot.CalDistance(B, C)) || !Dot.IfVertical(A, B, C) || !Dot.IfVertical(B, C, D) || !Dot.IfVertical(C, D, A)) {
            //上方语句判断是否符合正方形的定义，先判断一下是否对角线相等，如果相等
            throw new RuntimeException("点座标不符合正方形的定义");
        } else {
            this.A = A;
            this.B = B;
            this.C = C;
            this.D = D;
            CalPerimeter();
            CalAria();
        }
    }

    @Override
    public double CalPerimeter() {
        return perimeter = Dot.CalDistance(A, B) * 4;
    }

    @Override
    public double CalAria() {
        return aria = Dot.CalDistance(A, B) * Dot.CalDistance(B, C);
    }
}
```

**Triangle**

```Java
package ex05.III;

/**
 * 三角形类
 * 含有三个座标点信息
 * 判断是否是一个三角形
 * 检测是否点重复
 * <p>
 * 还缺少检测三点一线的算法
 *
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class Triangle extends Shape {

    private Dot A, B, C; //三角形三点座标
    private double lengthA, lengthB, lengthC;

    public Triangle(Dot A, Dot B, Dot C) {
        CalLength();
        if (Dot.IfRepeat(A, B, C)) {
            throw new RuntimeException("创建三角形失败，点重复");
        } else if (lengthA + lengthB <= lengthC || lengthB + lengthC <= lengthA || lengthC + lengthA <= lengthB) {
            throw new RuntimeException("不符合三角形定义");
        } else {
            this.A = A;
            this.B = B;
            this.C = C;

            CalPerimeter();
            CalAria();
        }
    } //构造方法,构造时计算Perimeter，Aria

    private void CalLength() {
        lengthA = B.CalDistance(C);
        lengthB = C.CalDistance(A);
        lengthC = A.CalDistance(B);
    } //构造时调用该方法计算各边边长

    @Override
    public double CalPerimeter() {
        return perimeter = lengthA + lengthB + lengthC;
    } //计算perimeter

    /**
     * 计算三角形面积
     * 使用海伦-秦九韶公式计算面积
     * https://zh.wikipedia.org/wiki/%E6%B5%B7%E4%BC%A6%E5%85%AC%E5%BC%8F
     *
     * @return aria
     */
    @Override
    public double CalAria() {
        CalLength();
        double S = (lengthA + lengthB + lengthC) / 2; //半周长
        return aria = Math.sqrt(S * (S - lengthA) * (S - lengthB) * (S - lengthC));
    }
}
```

**TestShape**
```Java
package ex05.III;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class TestShape {
    public static void main(String[] args) {
        //测试用类暂时没有完整的编写
        //请选择需要的测试用例并去除注释标记运行


        /********正方形********/

        //正方形测试用例一，用矩形座标信息构建正方形，按照程序设定应该抛出错误

//        Dot A = new Dot(0, 0);
//        Dot B = new Dot(2, 0);
//        Dot C = new Dot(2, 1);
//        Dot D = new Dot(0, 1);

        //正方形测试用例二，不规则四边形，按设定应抛出错误
//        Dot A = new Dot(-1, 0);
//        Dot B = new Dot(2, 0);
//        Dot C = new Dot(2, 1);
//        Dot D = new Dot(0, 1);

        //正方形测试用例三，AC点重复，应抛出错误
//        Dot A = new Dot(0, 3);
//        Dot B = new Dot(2, 0);
//        Dot C = new Dot(0, 3);
//        Dot D = new Dot(2, 3);

        //正方形测试用例四，正常正方形，对象创建成功
        Dot A = new Dot(1, 0);
        Dot B = new Dot(2, 1);
        Dot C = new Dot(1, 2);
        Dot D = new Dot(0, 1);

        Square s = new Square(A, B, C, D);

        /********矩形********/

        //矩形测试用例一，不规则四边形按设定应抛出错误
//        Dot E = new Dot(-1, 0);
//        Dot F = new Dot(2, 0);
//        Dot G = new Dot(2, 1);
//        Dot H = new Dot(0, 1);

        //矩形测试用例二，EG点重复，应抛出错误
//        Dot E = new Dot(0, 3);
//        Dot F = new Dot(2, 0);
//        Dot G = new Dot(0, 3);
//        Dot H = new Dot(2, 3);

        //矩形测试用例三,正常矩形对象创建成功
        Dot E = new Dot(0, 0);
        Dot F = new Dot(2, 0);
        Dot G = new Dot(2, 1);
        Dot H = new Dot(0, 1);

        Rectangle r = new Rectangle(E, F, G, H);

        /********三角形********/

        //三角形测试用例一，IK点重复,应抛出错误
//        Dot I = new Dot(0, 3);
//        Dot J = new Dot(2, 0);
//        Dot K = new Dot(0, 3);

        //三角形测试用例二，三点一线,应抛出错误
//        Dot I = new Dot(0, 0);
//        Dot J = new Dot(1, 1);
//        Dot K = new Dot(2, 2);

        //三角形测试用例三，正常三角形
        Dot I = new Dot(0, 1);
        Dot J = new Dot(1, 0);
        Dot K = new Dot(2, 1);

        Triangle t = new Triangle(I, J, K);

        Shape[] shapes = {s, r, t};
        for (Shape i : shapes) {
            i.PrintPerimeter();
            i.PrintAria();
        }
    }
}
```

运行效果

```
Square Perimeter is 5.656854249492381
Square Aria is 2.0000000000000004
Rectangle Perimeter is 6.0
Rectangle Aria is 2.0
Triangle Perimeter is 4.82842712474619
Triangle Aria is 0.9999999999999996

Process finished with exit code 0
```

## IV.多态在工资系统中的应用

设计一个根据雇员类型利用abstract方法和多态性完成工资单计算的程序

Employee是抽象类

```Java
package ex05.IV;

/**
 * 抽象类Employee类
 * Earnings返回该职员所挣得总数
 *
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public abstract class Employee {
    abstract double Earnings();
}

```

Employee的子类有Boss（每星期发给他固定工资，而不计工作时间）、CommissionWorker（除基本工资外还根据销售额发放浮动工资）、PieceWorker（按其生产的产品数发放工资）、HourlyWorker（根据工作时间长短发放工资）。
该例的Employee的每个子类都声明为final，因为不需要再继承它们生成子类。

**Boss**

```Java
package ex05.IV;

/**
 * Boss类
 * 每星期发给他固定工资，而不计工作时间
 *
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public final class Boss extends Employee {
    private double fixed_salary = 100; //固定工资

    @Override
    double Earnings() {
        return fixed_salary;
    }
}
```

**CommissionWorker**

```Java
package ex05.IV;

/**
 * CommissionWorker 类
 * 除基本工资外还根据销售额发放浮动工资
 *
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public final class CommissionWorker extends Employee {
    private double fixed_salary = 100; //固定工资
    private double floating_wage = 200; //浮动工资

    @Override
    double Earnings() {
        return fixed_salary + floating_wage;
    }
}

```

**PieceWorker**

```Java
package ex05.IV;

/**
 * PieceWorker 类
 * 按其生产的产品数发放工资
 *
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public final class PieceWorker extends Employee {
    private double single_piece_wages = 5; //单件工资
    private int production_quantity = 1000; //生产数量

    @Override
    double Earnings() {
        return single_piece_wages * production_quantity;
    }
}

```

**HourlyWorker**

```Java
package ex05.IV;

/**
 * HourlyWorker 类
 * 根据工作时间长短发放工资
 *
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public final class HourlyWorker extends Employee {
    private int work_hours = 248; //工作时长
    private double hourly_wage = 10; //时薪

    @Override
    double Earnings() {
        return work_hours * hourly_wage;
    }
}
```

在超类中声明earnings()为抽象方法，，并且对于每个子类都提供恰当的earnings()的实现方法。对所有雇员类型都使用earnings()方法，但每个人挣的工资按他所属的雇员类计算，所有雇员类都是从超类Earnings()派出生的。

为了计算雇员的工资，程序仅仅使用雇员对象的一个超类引导 并调用earnings()方法。

一个实际的工资系统中，各种Employee对象的引用可以通过一个Employee引用数组来实现。程序依次使用数组的每个元素（Employee引用）调用每个对象的employee()方法。

**TestEarn**

```Java
package ex05.IV;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class TestEarn {
    public static void main(String[] args) {
        Employee Oracle[] = {new Boss(), new CommissionWorker(), new PieceWorker(), new HourlyWorker()};

        for (Employee i : Oracle) {
            System.out.println(i.getClass().getSimpleName() + "  Earns:" + i.Earnings());
        }
    }
}
```

运行效果如下

```
Boss  Earns:100.0
CommissionWorker  Earns:300.0
PieceWorker  Earns:5000.0
HourlyWorker  Earns:2480.0

Process finished with exit code 0
```