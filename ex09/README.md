# Java实验报告九

## I.编写程序DivideExcpe.java

计算两数相除。使用**两个catch**语句，捕捉除书为0的异常和参数输入有误异常。编译并运行，当输入除数为0的时候，将有异常出现，当输入的不是整数，如将30输成了3o，出现的是另一种异常

**DivideExcpe.java**

```Java
package ex09.I;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class DivideExcep {
    public static void main(String[] args) {
        try {
            divide();
        } catch (InputMismatchException e) {
            System.err.println("Input Mistake, Please Input Double");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void divide() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input 2 Num to Cal, And Out A/B");
        System.out.println("Input A Now");
        double a = scanner.nextDouble();
        System.out.println("Input B Now");
        double b = scanner.nextDouble();
        if (b == 0) {
            throw new IllegalArgumentException("B Can't Be 0");
        }
        System.out.println("A / B = " + a / b);
    }
}

```

### 运行结果

正常测试用例
```
[adam@ChromeBook JavaHomework]$ java ex09.I.DivideExcep 
Input 2 Num to Cal, And Out A/B
Input A Now
20
Input B Now
10
A / B = 2.0
```

输入异常测试

```
[adam@ChromeBook JavaHomework]$ java ex09.I.DivideExcep 
Input 2 Num to Cal, And Out A/B
Input A Now
2o
Input Mistake, Please Input Double
```

除数为0异常测试

```
[adam@ChromeBook JavaHomework]$ java ex09.I.DivideExcep 
Input 2 Num to Cal, And Out A/B
Input A Now
20
Input B Now
0
B Can't Be 0
```

## II.编写一个程序IntegerExcep.java

从命令行输入一个字符串，将该字符串转为double型数据，当数据不在0-100之间时抛出一个异常，采用适当的机制来捕获可以用现成的异常也可以用自定义异常

**IntegerExcep.java**

```Java
package ex09.II;

import java.util.Scanner;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class IntegerExcep {
    public static void main(String[] args) {
        System.out.println("Please Input A Num String");
        Scanner scaner = new Scanner(System.in);
        String numString = scaner.next();
        double numDouble = 0;
        try {
            stringToDouble(numString);
        } catch (NumberFormatException e) {
            System.err.println("Input Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void stringToDouble(String numString) {
        double numDouble = Double.parseDouble(numString);
        if (numDouble < 0 || numDouble > 100) {
            throw new IllegalArgumentException("Out Of Range 0-100");
        }
        System.out.println("Num Double is " + numDouble);
    }
}
```

##运行结果

正常测试用例

```
[adam@ChromeBook JavaHomework]$ java ex09.II.IntegerExcep
Please Input A Num String
20
Num Double is 20.0
```

错误输入异常

```
[adam@ChromeBook JavaHomework]$ java ex09.II.IntegerExcep
Please Input A Num String
2o
Input Error: For input string: "2o"
```

## III.自定义一个三角形类Triangle.java

 - 成员a, b, c作为三角形的三边长
 - 构造方法通过参数分别对a, b, c赋值
 - 两个方法getArea求面积，showInfo显示三角形信息，这两个方法中当三条边不构成三角形要抛出自定义异常

**Triangle.java**

```Java
package ex09.III;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
class Triangle {
    private double a, b, c, aria, perimeter; // 三角形三边长,不按照实验要求以xyz命名

    public Triangle(double a, double b, double c) {
        double calDeviation = 1E-5;
        if (a <= 0 || b <= 0 || c <= 0)
            throw new NotTriangleException("Input Num < 0");
        if (c > (a + b) - calDeviation)
            throw new NotTriangleException("c >= a + b");
        if (a > (b + c) - calDeviation)
            throw new NotTriangleException("a >= b + c");
        if (b > (a + c) - calDeviation)
            throw new NotTriangleException("b >= a + c");

        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getAria() {
        double s = (this.a + this.b + this.c) / 2;
        return aria = Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public double getPerimeter() {
        return perimeter = a + b + c;
    }

    public void printInfo() {
        System.out.println("A: " + a + " B: " + b + " C: " + c + " Aria: " + getAria());
    }
}
```

NotTriangleException.java

```Java
package ex09.III;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class NotTriangleException extends IllegalArgumentException {
    public NotTriangleException(String message) {
        super("Can't Creat A Triangle: " + message);
    }
}
```

**TestTriangle.java**

```Java
package ex09.III;

import java.util.Scanner;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class TestTriangle {
    public static void main(String[] args) {
        Triangle triangle = null;
        do {
            System.out.println("Please Input Triangle A B C Length");
            Scanner scanner = new Scanner(System.in);
            double a = scanner.nextDouble();
            double b = scanner.nextDouble();
            double c = scanner.nextDouble();
            try {
                triangle = new Triangle(a, b, c);
            } catch (NotTriangleException e) {
                System.err.println("New Triangle Failed: " + e.getMessage());
            }
        } while (triangle == null);
        triangle.printInfo();
    }
}
```

## 运行结果

正常测试用例

```
[adam@ChromeBook JavaHomework]$ java ex09.III.TestTriangle
Please Input Triangle A B C Length
3 4 5
A: 3.0 B: 4.0 C: 5.0 Aria: 6.0
```

非法三角形信息测试

```
[adam@ChromeBook JavaHomework]$ java ex09.III.TestTriangle
Please Input Triangle A B C Length
3 6 10
New Triangle Failed: Can't Creat A Triangle: c >= a + b
Please Input Triangle A B C Length
3 10 6
New Triangle Failed: Can't Creat A Triangle: b >= a + c
Please Input Triangle A B C Length
10 3 6
New Triangle Failed: Can't Creat A Triangle: a >= b + c
Please Input Triangle A B C Length
...
```

## IV.编写MyExcep.java包含自定义异常，当输入值为13和4的时候抛出该异常

**MyExcep.java**

```Java
package ex09.IV;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
class MyExcep extends RuntimeException {
    public MyExcep(int value) {
        super("非法值" + value);
    }
}
```

**MyNum.java**

```Java
package ex09.IV;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
class MyNum {
    private int value;
    public MyNum(int value) {
        if (value == 13 || value == 4)
            throw new MyExcep(value);
        this.value = value;
        System.out.println("构造成功，value = " + value);
    }
}
```

**TestMyExcep.java**

```Java
package ex09.IV;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
class TestMyExcep {
    public static void main(String[] args) {
        for (int i = 0; i <= 20; i++) {
            try {
                new MyNum(i);
            } catch (MyExcep e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
```

运行结果

```
[adam@ChromeBook JavaHomework]$ java ex09.IV.TestMyExcep
构造成功，value = 0
构造成功，value = 1
构造成功，value = 2
构造成功，value = 3
非法值4
构造成功，value = 5
构造成功，value = 6
构造成功，value = 7
构造成功，value = 8
构造成功，value = 9
构造成功，value = 10
构造成功，value = 11
构造成功，value = 12
非法值13
构造成功，value = 14
构造成功，value = 15
构造成功，value = 16
构造成功，value = 17
构造成功，value = 18
构造成功，value = 19
构造成功，value = 20
```