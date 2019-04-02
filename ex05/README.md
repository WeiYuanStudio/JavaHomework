# 实验五实验报告

**因为Code Review，当前实验报告已不是最新代码，请在上方查看最新代码和CodeReview报告(REVIEW.md)**

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

**基本完成该课程需要理解的面向对象的学习目标，还在写以点构建形状是否符合定义的判断部分，进度可以在上面III文件夹找到目前进度的源码**

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