# 实验八实验报告

## I.for语句的简化

 - 新建一个学生Student类，属性包括学号、姓名、3门课程成绩及平均分
 - 生成一个学生数组，包括3名学生，从键盘中输入学生信息，计算学生平均分并最终输出每位学生的学号、姓名、平均分

**Student.java**

```Java
package ex08.I;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class Student {
    private String stuNum;
    private String stuName;
    private double chScore; //语文成绩
    private double mathScore; //数学成绩
    private double enScore; //英语成绩
    private double averageScore;

    public Student() {
    }

    public Student(String stuNum, String stuName, double chScore, double mathScore, double enScore) {
        this.stuNum = stuNum;
        this.stuName = stuName;
        this.chScore = chScore;
        this.mathScore = mathScore;
        this.enScore = enScore;
    }

    public void setAllInfo(String stuNum, String stuName, double chScore, double mathScore, double enScore) {
        this.stuNum = stuNum;
        this.stuName = stuName;
        this.chScore = chScore;
        this.mathScore = mathScore;
        this.enScore = enScore;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public double getChScore() {
        return chScore;
    }

    public void setChScore(double chScore) {
        this.chScore = chScore;
    }

    public double getMathScore() {
        return mathScore;
    }

    public void setMathScore(double mathScore) {
        this.mathScore = mathScore;
    }

    public double getEnScore() {
        return enScore;
    }

    public void setEnScore(double enScore) {
        this.enScore = enScore;
    }

    public double getAverageScore() {
        return averageScore = (chScore + mathScore + enScore) / 3;
    }
}
```

**TestStudent.java**

```Java
package ex08.I;

import java.util.Scanner;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class TestStudent {
    public static void main(String[] args) {
        Student[] jluzhStu = new Student[3];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("Please Input Student Info");
            System.out.println("StudentNum | Name | Chinese | Math | English");
            jluzhStu[i] = new Student(
                    scanner.next(),
                    scanner.next(),
                    scanner.nextDouble(),
                    scanner.nextDouble(),
                    scanner.nextDouble()
            );
        }

        for (Student i : jluzhStu) {
            System.out.println(i.getStuNum() + "  " + i.getStuName() + "  " + i.getAverageScore());
        }
    }
}
```

 运行结果

```
Please Input Student Info
StudentNum | Name | Chinese | Math | English
04180001 Miku 90 95 100
Please Input Student Info
StudentNum | Name | Chinese | Math | English
04180002 Mashiro 90 91 92
Please Input Student Info
StudentNum | Name | Chinese | Math | English
04180003 Alice 80 81 82
04180001  Miku  95.0
04180002  Mashiro  91.0
04180003  Alice  81.0

Process finished with exit code 0
```

# II.P177页第五章3

**WeekDay.java**

```Java
package ex08.II;

public enum WeekDay {
    Mon,Tue,Wen,Thu,Fri,Sat,Sun
}
```

**TestWeekDay.java**

```Java
package ex08.II;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class TestWeekDay {
    public static void main(String[] args) {
        for(WeekDay i : WeekDay.values()) {
            System.out.print(i.toString() + "  ");
        }
    }
}
```

运行结果

```
Mon  Tue  Wen  Thu  Fri  Sat  Sun  
Process finished with exit code 0
```

# III.P177页第2题

**Shape.java**

```Java
package ex08.III;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class Circle implements Shape {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getAria() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
```

**Circle.java**

```Java
package ex08.III;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class Circle implements Shape {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getAria() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
```

**ShapeAPI.java**

```Java
package ex08.III;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class ShapeAPI<T extends Shape> {
    private T shape;

    public void printAria(T shape) {
        System.out.println("Aria is " + shape.getAria());
    }

    public void printPerimeter(T shape) {
        System.out.println("Perimeter is " + shape.getPerimeter());
    }

    public void printAllInfo(T shape) {
        System.out.println(shape.getClass().getSimpleName());
        printPerimeter(shape);
        printAria(shape);
    }
}
```

**Square.java**

```Java
package ex08.III;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }


    @Override
    public double getAria() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }
}
```

**TestShape.java**

```Java
package ex08.III;

import java.util.Vector;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class TestShape {
    public static void main(String[] args) {
        Circle circle = new Circle(2);

        ShapeAPI<Circle> cAPI = new ShapeAPI<Circle>();
        cAPI.printAllInfo(circle);

        Square square = new Square(2);

        ShapeAPI<Square> sAPI = new ShapeAPI<Square>();
        sAPI.printAllInfo(square);
    }
}
```

运行结果

```
Circle
Perimeter is 12.566370614359172
Aria is 12.566370614359172
Square
Perimeter is 8.0
Aria is 4.0

Process finished with exit code 0
```