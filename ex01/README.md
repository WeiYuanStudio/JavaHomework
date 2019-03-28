# 实验一实验报告

## 在自用的计算机上安装Java环境

下图为在自用的MACOS系统上安装Java环境（台式机Mac MINI A1283）

![](https://ww1.sinaimg.cn/large/007i8nDUgy1g0mcosbr2pj31430lfwy8.jpg)

下图为在自用的Manjaro系统（一个Linux发行版）上安装配置Java环境（笔记本）

![](https://ww1.sinaimg.cn/large/007i8nDUgy1g0mcpm88jrj31hc0u0kjl.jpg)

由于主力系统为类Unix系统，所以Windows系统部分就不再放出。已经帮无数同学解决过Win上环境变量的配置问题了。（类Unix环境配置比Win方便，不需要自行配置系统的环境变量，包管理器会自行解决环境变量的问题）

## 搭建实验作业的工程及相关类包

编写一个Java应用程序MyFirstPrint.java，控制台上输出结果为：
```
**********

Hello 2018级**班自己姓名！

**********

这是你的第一个Java程序！
```

如图

![](https://ws1.sinaimg.cn/large/007i8nDUly1g0mdl2jnr3j30vc0k5gpi.jpg)

该程序源码放置在该实验的源码文件夹src下。（在页面顶部即可查看到）

## 阅读该程序，并在相应方法及语句上进行注释。

下面为完成注释后的代码

```Java
public class Hello {
    int HighLevel(int wide) { //该方法打印心形的上半部分
        int i = 0;
        int j = 0;
        int k = 0;
        int t = 0;
        int m = 0;
        int n = 0;
        int count = 1;

        m = (wide - 4) / 2;

        do {
            count++;

            m -= 4;
        } while (m > 4);

        if (((wide - 4) % 2) == 0) {
            n = 2 + (4 * (count - 1));

            m--;
        } else {
            n = 1 + (4 * (count - 1));
        }

        for (i = 0; i < count; i++) {
            for (j = (count - i) * 2; j > 0; j--)
                System.out.print(" ");

            for (k = 0; k < m; k++)
                System.out.print("*"); //输出心形左半边的＊号

            for (t = 0; t < n; t++)
                System.out.print(" "); //输出心形两边之间的空格符

            for (k = 0; k < m; k++)
                System.out.print("*"); //输出心形右半边的＊号

            m += 4;

            n -= 4;

            System.out.print("\n"); //输出换行符，进行下一行
        }

        return 0;
    }

    int LowLevel(int wide) { //该方法打印心形的下半部分
        int i = 0;
        int j = 0;
        int k = 0;

        int high = 0;
        int tmp = wide;

        do {
            high++; //计算下半部分的高度

            tmp -= 4;
        } while (tmp > 4);

        high += 1;

        for (i = 0; i < high; i++) {
            for (j = 0; j < (2 * i); j++)
                System.out.print(" "); //输出下半部分的空格

            for (k = wide - (4 * i); k > 0; k--) //输出下半部分图像的＊号
                System.out.print("*");

            System.out.print("\n"); //换行
        }

        return 0;
    }

    public static void main(String[] args) { //主函数
        System.out.println("hello world"); //控制台输出 hello world

        int wide = 30; //声明并定义wide变量＝30

        TestOne one = new TestOne(); //新建了一个名为one的TestOne类对象

        one.HighLevel(wide); //使用参数wide调用one对象中的HighLevel方法（打印心形的上半部分）

        one.LowLevel(wide); //使用参数wide调用one对象中的LowLevel方法（打印心形的下半部分）
    }
}

```

上述程序运行后将会在控制台输出一个心形。

```
      ****          ****
    ********      ********
  ************  ************
******************************
  **************************
    **********************
      ******************
        **************
          **********
            ******
              **
```

## 列举System.out.println和System.out.print的区别

System.out.println在最后输出了一个换行符，而System.out.print不在最后输出换行符

## 试着在控制台输出如下信息
```
**********************
**Practice makes perfect
**********************
```
这个和上面那个基本一模一样，就不放了。截图上传略麻烦

## 思考Java程序在控制台上输出语句是什么？如果要实现从键盘上输入要怎么做

**第一种：**
使用System.in.read()方法，但是一次只能读取一个字节的数据。

**第二种：**
使用java.util.Scanner类
```Java
import java.util.Scanner; //在程序头部声明所需要的java.util.Scanner类
Scanner scan = new Scanner(System.in); //新建一个名为scan的扫描器对象
n1 = scan.nextDouble(); //将从控制台读得的数据赋值给n1
```