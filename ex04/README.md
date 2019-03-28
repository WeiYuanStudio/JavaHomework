# 实验四实验报告

## I.理解隐式类型转换和显式类型转换的区别

### 隐式类型转换
> 将类型为**子类型**的数据转换成为类型为**父类型**的数据。**无需强制类型转换运算符**`()`

### 显式类型转换
> 将**父类型**的数据转换为**子类型**的数据。**需要使用强制类型转换运算符**`()`

如果两个类型不存在子类型父类型之间的关系，则一般不能进行类型转换。

## 尝试创建一个Student类，根据类的继承特点，试问该类是否可以继承J_Employee？如果不能，可否设置一个Student类和Teacher类所共有的父类？编程实现

> 答：  
> **Employee类**为职员类，学生不属于职员，不需要**Employee类中的部分属性**，原则上不应该让**Student类**继承**Employee类**。如果要设置一个Student类和Teacher类共有的父类，原则上这个父类应该包含且仅包含子类所共有的域。例如建立一个**People类**，域可以有性别，年龄，姓名....

代码片段，完整代码在上面src文件夹中

```Java
public class People {
    public String name;
    public int age;
    public String sex;

    public People() {
        name = null;
        age = -1;
        sex = null;
    } //无参构造方法

    public People(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    } //含参构造方法
}
```

### II.练习包的建立和使用

生成一个类Employee,域变量为name和age;类包为asia.china  

生成一个类Teacher, 继承Employee类；类包为asia.china.guangdong ，域变量为工作年限（workYears）和职称(jobTitle)；成员方法包括构造方法与getter方法

生成测试类TestTeacher, 类包为asia.china.guangdong.zhuhai;在main主方法中创建Teacher类的对象jilinTeacher_zhangsan, 初始化姓名、年龄，工作年限和职称，并测试修改职称信息并显示  

**Employee.java:**

```Java
/**
 * @author 04181010魏源
 * @version 0.1
 * @since JDK 11.8.2 MacOS 10.11.6
 */
package ex04.asia.china;

public class Employee {

    public String name;
    public int age;

    public Employee() {
        name =null;
        age = -1;
    } //无参构造方法

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    } //含参构造方法

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
```

**Teacher:**

```Java
/**
 * @author 04181010魏源
 * @version 0.1
 * @since JDK 11.8.2 MacOS 10.11.6
 */
package ex04.asia.china.guangdong;

import ex04.asia.china.Employee;

public class Teacher extends Employee {

    public int workYears;
    public String jobTitle;

    public Teacher() {
        super();
        workYears = -1;
        jobTitle = null;
    }

    public Teacher(String name, int age, int workYears, String jobTitle) {
        super(name, age);
        this.workYears = workYears;
        this.jobTitle = jobTitle;
    }

    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getWorkYears() {
        return workYears;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWorkYears(int workYears) {
        this.workYears = workYears;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
```

**TestTeacher:**

```Java
/**
 * @author 04181010魏源
 * @version 0.1
 * @since JDK 11.8.2 MacOS 10.11.6
 */
package ex04.asia.china.asia.china.guangdong.zhuhai;

import ex04.asia.china.guangdong.Teacher;

public class TestTeacher {
    public static void main(String[] args) {
        Teacher jilinTeacher_zhangsan = new Teacher("Zhangsan",28,10,"Master");

        System.out.println("Name:" + jilinTeacher_zhangsan.getName());
        System.out.println("Age:"+jilinTeacher_zhangsan.getAge());
        System.out.println("WorkYears:" + jilinTeacher_zhangsan.getWorkYears());
        System.out.println("JobTitle:" + jilinTeacher_zhangsan.getJobTitle());

        System.out.println("\n");

        System.out.println("Start Setting JobTitle");

        System.out.println("\n");

        jilinTeacher_zhangsan.setJobTitle("Teacher");

        System.out.println("Name:" + jilinTeacher_zhangsan.getName());
        System.out.println("Age:"+jilinTeacher_zhangsan.getAge());
        System.out.println("WorkYears:" + jilinTeacher_zhangsan.getWorkYears());
        System.out.println("JobTitle:" + jilinTeacher_zhangsan.getJobTitle());
    }
}
```

**运行效果：**

```
/Library/Java/JavaVirtualMachines/jdk-11.0.2.jdk/Contents/Home/bin/java "-javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=49363:/Applications/IntelliJ IDEA CE.app/Contents/bin" -Dfile.encoding=UTF-8 -classpath /Users/weiyuan/IdeaProjects/weiyuan04181010/out/production/weiyuan04181010 ex04.asia.china.asia.china.guangdong.zhuhai.TestTeacher
Name:Zhangsan
Age:28
WorkYears:10
JobTitle:Master


Start Setting JobTitle


Name:Zhangsan
Age:28
WorkYears:10
JobTitle:Teacher

Process finished with exit code 0
```

### 判断教程中P117页习题中4题和5题中的错误，并编程测试判断是否正确

#### 第四题

> **问题：** `mb_square()`方法进行重载的时候，参数列表相同，发生歧义。编译器无法处理。
> **修正：** 将第二个重载`mb_square()`的参数类型由**int**修改为**double**

#### 第五题

##### 第一小题

```Java
public int mb_divide(int x, int y) {
    int result;
    if (y==0)
        result = 0;
    else result = x/y;
}
```

> 没有return任何返回值

修改后：

```Java
public int mb_divide(int x, int y) {
    int result;
    if (y==0)
        return result = 0;
    else return result = x/y;
}
```

##### 第二小题 

##### 第三小题

> 方法内定义方法，将该方法声明定义写到该方法外部，通过调用来访问。

##### 第四小题

```Java
public static void mb_fun(int x) {
    System.out.println("x=" + x);
    int x = x * x;
    System.out.println("x*x=" + x);
    {
        int x = x * x * x;
        System.out.println("x*x*x=" + x);
    }
}
```

> 在前面`int x = x*x` 已经将x重新声明（将会被编译器指出重复声明报错）并定义，后面的`x = x*x*x`将得出错误的结果，实际上 `x= (x*x)*(x*x)*(x*x)`

修改后如下

```Java
public static void mb_fun(int x) {
    System.out.println("x=" + x);
    int sum = x * x;
    System.out.println("x*x=" + sum);
    {
        sum = x*x*x;
        System.out.println("x*x*x=" + sum);
    }
}
```

运行效果如下

```
/Library/Java/JavaVirtualMachines/jdk-11.0.2.jdk/Contents/Home/bin/java "-javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=50250:/Applications/IntelliJ IDEA CE.app/Contents/bin" -Dfile.encoding=UTF-8 -classpath /Users/weiyuan/IdeaProjects/weiyuan04181010/out/production/weiyuan04181010 Test.Test
2
x=2
x*x=4
x*x*x=8

Process finished with exit code 0
```

## III.第三章第9题

**TestGraph**

```Java
/**
 * @author 04181010魏源
 * @version 0.1
 * @since JDK 11.8.2 MacOS 10.11.6
 */
package Graph;

public class TestGraph {
    public static void main(String[] args) {
        System.out.println("----NEW Square & Length:2----");
        Square s1 = new Square(2);
        System.out.println("The Square:  Length:" + s1.getLength() + "  Aria:" + s1.getAria());
        System.out.println("SetLength: 4");
        s1.setLength(4);
        System.out.println("The Square:  Length:" + s1.getLength() + "  Aria:" + s1.getAria());
        System.out.println("SetAria: 32");
        s1.setAria(32);
        System.out.println("The Square:  Length:" + s1.getLength() + "  Aria:" + s1.getAria());
        System.out.println("\n\n");

        System.out.println("----NEW Triangle & Length = 3, 4, 5----");
        Triangle t1 = new Triangle(3, 4, 5);
        System.out.println("The Triangle:  Length:" + t1.getLengthA() + " " + t1.getLengthB() + " " + t1.getLengthC() + "  Aria:" + t1.getAria());
        System.out.println("SetLength: 6, 8, 10");
        t1.setLengthA(6);
        t1.setLengthB(8);
        t1.setLengthC(10);
        System.out.println("The Triangle:  Length:" + t1.getLengthA() + t1.getLengthB() + t1.getLengthC() + "  Aria:" + t1.getAria());
        System.out.println("\n\n");

        System.out.println("----NEW Cicular & Radius = 2");
        Circular c1 = new Circular(2);
        System.out.println("The Cicular:  Radius:" + c1.getRadius() + "  Aria:" + c1.getAria());
        System.out.println("SetRadius: 4");
        c1.setRadius(4);
        System.out.println("The Cicular:  Radius:" + c1.getRadius() + "  Aria:" + c1.getAria());
        System.out.println("\n\n");

        System.out.println("----NEW Pentagon & Length:2----");
        Pentagon p1 = new Pentagon(2);
        System.out.println("The Pentagon:  Length:" + p1.getLength() + "  Aria:" + p1.getAria());
        System.out.println("SetLength: 5");
        p1.setLength(5);
        System.out.println("The Pentagon:  Length:" + p1.getLength() + "  Aria:" + p1.getAria());

    }
}
```

**Triangle**

```Java
/**
 * @author 04181010魏源
 * @version 0.1
 * @since JDK 11.8.2 MacOS 10.11.6
 */
package Graph;

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
```

**Square:** 

```Java
/**
 * @author 04181010魏源
 * @version 0.1
 * @since JDK 11.8.2 MacOS 10.11.6
 */
package Graph;

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
```

**Pentagon:**

```Java
/**
 * @author 04181010魏源
 * @version 0.1
 * @since JDK 11.8.2 MacOS 10.11.6
 */
package Graph;

public class Pentagon {
    private double length, aria;

    public Pentagon() {

    }

    public Pentagon(double length) {
        this.length = length;
        calAria();
    }

    /**
     * 五边形面积计算
     * https://zh.wikipedia.org/wiki/%E4%BA%94%E8%BE%B9%E5%BD%A2
     *
     * @return aria
     */
    public double calAria() {
        return aria = 5 * length * length * Math.tan((Math.toRadians(54))) / 4;
    }

    public double getLength() {
        return length;
    }

    public double getAria() {
        return aria;
    }

    public void setLength(double length) {
        this.length = length;
        calAria();
    }
}
```

**Circular:**

```Java
/**
 * @author 04181010魏源
 * @version 0.1
 * @since JDK 11.8.2 MacOS 10.11.6
 */
package Graph;

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
```

运行效果

```
----NEW Square & Length:2----
The Square:  Length:2.0  Aria:4.0
SetLength: 4
The Square:  Length:4.0  Aria:16.0
SetAria: 32
The Square:  Length:5.656854249492381  Aria:32.0



----NEW Triangle & Length = 3, 4, 5----
The Triangle:  Length:3.0 4.0 5.0  Aria:6.0
SetLength: 6, 8, 10
The Triangle:  Length:6.08.010.0  Aria:24.0



----NEW Cicular & Radius = 2
The Cicular:  Radius:2.0  Aria:12.566370614359172
SetRadius: 4
The Cicular:  Radius:4.0  Aria:50.26548245743669



----NEW Pentagon & Length:2----
The Pentagon:  Length:2.0  Aria:6.881909602355867
SetLength: 5
The Pentagon:  Length:5.0  Aria:43.011935014724166

Process finished with exit code 0
``` 