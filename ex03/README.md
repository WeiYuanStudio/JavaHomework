# 实验三实验报告

**已进行第一次Review，实验报告已经过时，请查阅源码**

## 编码实现一个地址簿类

### I. 编码实现一个地址簿类（AddressBook)

在该类中定义“姓名（name）”、“地址(address)”、“电话(tel)”三个域变量.通过getter方法和setter方法分别获取和设置对象的三个信息  
通过getAllInfo()来进行对象所有三个信息的输入与输出。  

所有完整代码在上面src文件夹中，下面的为代码片段

```Java
private String name, addr, tel;

/**
 * 该方法通过输入type（即信息类型）以返回对象的相应信息
 *
 * @param type
 */
public void getter(char type) {
    switch (type) {
        case 'N':
            System.out.println("姓名：" + name);
            break;
        case 'A':
            System.out.println("地址:" + addr);
            break;
        case 'T':
            System.out.println("电话:" + tel);
            break;
    }
}

/**
 * 该方法通过输入type, info参数设定对象的相应信息。
 *
 * @param type
 * @param info
 */
public void setter(char type, String info) {
    switch (type) {
        case 'N':
            name = info;
            break;
        case 'A':
            addr = info;
            break;
        case 'T':
            tel = info;
            break;
    }
}

public void
getAllInfo() {
    getter('N');
    getter('A');
    getter('T');
}
```

### II. 编码实现另一个类（TestAddressBook）

在该类中的main主方法中创建AddressBook对象:zhangsan_addr(通过默认的构造方法 创建对象)  
通过张三地址簿对象（zhangsan_addr）分别设置他的姓名，地址和电话，并通过 getAllInfo() 方法来显示设置结果。  
通过setTel()方法来修改电话号码，并使用getTel()方法显示修改后的结果。  

```Java
public class TestAddressBook {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        AddressBook zhangsan_addr = new AddressBook();
        String info;

        System.out.println("请输入你的姓名");
        info = scan.next();
        zhangsan_addr.setter('N', info);
        System.out.println("请输入你的地址");
        info = scan.next();
        zhangsan_addr.setter('A', info);
        System.out.println("请输入你的电话");
        info = scan.next();
        zhangsan_addr.setter('T', info);
        zhangsan_addr.getAllInfo();
    }

}
```

运行结果如下

```
请输入你的姓名
张三
请输入你的地址
吉林大学珠海学院
请输入你的电话
10086
姓名：张三
地址:吉林大学珠海学院
电话:10086

Process finished with exit code 0
```

### III. 编写一个矩形类（Rect)与圆类(Circle) 

在矩形类中定义长、宽、周长和面积四个域变量；在圆类中定义半径、周长和面积三个域变量  
在构造方法里对其进行初始化  
设计getter方法能求出矩形与圆的面积（area_S）和周长(perimeter)。  

```Java
public class Rect {

    double length, width, perimeter, area;//长，宽，周长，面积

    public Rect(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getter(char type) {
        switch (type) {
            case 'A':
                return area = length * width;
            case 'P':
                return perimeter = 2 * (length + width);
            default:
                return -1;//返回异常
        }
    }
}
```


```Java
public class Circle {

    double radius, perimeter, area, pi = 3.14;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getter(char type) {
        switch (type) {
            case 'A':
                return area = pi * radius * radius;
            case 'P':
                return perimeter = 2 * pi * radius;
            default:
                return -1; //返回异常
        }
    }
}
```
### IIII.再建一个主类TestShape

生成一个圆形对象和一个矩形对象  
打印出两个对象的相关信息。

```Java
public class TestShape {
    public static void main(String args[]) {
        Rect R1 = new Rect(100, 20);
        Circle C1 = new Circle(4);
        System.out.println("矩形的面积为" + R1.getter('A') + "周长为" + R1.getter('P'));
        System.out.println("圆的面积为" + C1.getter('A') + "周长为" + C1.getter('P'));
    }
}
```

运行结果如下

```
矩形的面积为2000.0周长为240.0
圆的面积为50.24周长为25.12

Process finished with exit code 0
```