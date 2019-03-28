# 实验二实验报告

## I.练习分支结构

定义一个学生的JAVA成绩为n（0到100的整数），编写一个程序输出这个学生成绩的等级，比如76为“中”。（优：>=90;良：>=80;中：>=70;及格：>=60;不及格：<60)

代码部分截取，完整代码在src文件夹中

```Java
public static void main(){
    Scanner sc = new Scanner(System.in);
    double n = sc.nextDouble();
    if (n >= 90) {
        System.out.println("分数为" + n + "分，成绩优秀！");
    }else if (n >= 80) {
        System.out.println("分数为" + n + "分，成绩良好！");
    }else if (n >= 70) {
        System.out.println("分数为" + n + "分，成绩中等！");
    }else if (n >= 60) {
        System.out.println("分数为" + n + "分，成绩及格！");
    }else {
        System.out.println("分数为" + n + "分，成绩不及格！");
    }
}
```

运行效果如下

```
89
分数为89.0分，成绩良好！

Process finished with exit code 0
```

## II.练习循环结构

### 用一个for循环找出n以内的偶数

代码部分截取，完整代码在src文件夹中
```Java
public static void main() {
    int counter = 0; //换行计数器
    System.out.println("请输入0～n范围，将输出该范围内的偶数");
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i <= n; i++) {
        if (i%2 == 0) {
            System.out.print(i + "   ");
            counter++;
        }
        if (counter == 10) {
            System.out.print('\n');
            counter = 0;
        } //十个数换一行
    }
}
```

运行效果如下

```
请输入0～n范围，将输出该范围内的偶数
100
0   2   4   6   8   10   12   14   16   18   
20   22   24   26   28   30   32   34   36   38   
40   42   44   46   48   50   52   54   56   58   
60   62   64   66   68   70   72   74   76   78   
80   82   84   86   88   90   92   94   96   98   
100   
Process finished with exit code 0
```

### III.计算并输出n！

代码部分截取，完整代码在src文件夹中

```Java
public static void main() {
    System.out.println("请输入一个整数，将计算n！即n的阶乘");
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    double sum = 1; //使用double类型，防止阶乘过大超出预期范围
    for (int i = 1; i <= n; i++) {
        sum *= i;
    }
    System.out.println(n + "的阶乘为" + sum);
}
```

运行效果如下

```
请输入一个整数，将计算n！即n的阶乘
17
17的阶乘为3.55687428096E14

Process finished with exit code 0
```

### IV.输出三角形

代码部分截取，完整代码在src文件夹中

```Java
public static void main() {
    for (int line = 0; line <= 4; line ++){
        PrintBlankSpace(line);
        PrintDot(line);
        System.out.println();
    }
    for (int line = 3; line >=0; line--) {
        PrintBlankSpace(line);
        PrintDot(line);
        System.out.println();
    }
}

private static void PrintBlankSpace(int line) {
    int SpaceNum = 4 - line;
    for (int i = 0; i < SpaceNum; i++) {
        System.out.print(' ');
    }
}

private static void PrintDot(int line) {
    int DotNum = line + (line -1);
    for (int i = 0; i < DotNum; i++){
        System.out.print('*');
    }
}
```

运行效果如下

```
   *
  ***
 *****
*******
 *****
  ***
   *
    

Process finished with exit code 0
```

## 选做部分

### 1、输入下列应用程序，了解如何从命令行中输入参数。应用程序中main方法的参数String类型的数组args能接受用户从命令行键入的参数。

```Java
public class Test_Three{    
	
	public static void main(String args[]){
		double n,sum=0;
		for(int i=0;i<args.length;i++){
			sum=sum+Double.valueOf(args[i]).doubleValue();
			
		}
		n=sum/args.length;
		System.out.print("average"+n);
	}       
}
```

如何输入命令行参数： 12.34   34.45   21212121？

**答**

> 首先为将要运行的Test_Three Class创建一个Main Class，作为运行时的入口。Main.java代码如下
>
>```Java
>import ex02.Test_Three;
>
>public class Main {
>    public static void main(String args[]){
>        Test_Three.main(args);//调用目标类的目标方法，并将参数字符串数组args传入
>    }
>}
>```
>
>编译下项目，接下来去**out文件夹**中找Main类的编译后文件**Main.class**。使用cd命令移步至该目录。执行如下命令
>
>`java Main <参数1> <参数2> <参数3> <参数4> ...`

### V.编写一个程序：定义两个整数，一个字符变量，当这个字符变量分别是‘+’、‘-’、‘*’、‘/’时，用switch 语句输出这两个数的运算结果。(可以练习从控制台上输入两个数以及运算符，进行运算)—IntegerCompute.java

代码部分截取，完整代码在src文件夹中

```Java
public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("请输入变量A");
    int a = sc.nextInt();
    System.out.println("请输入变量B");
    int b = sc.nextInt();
    System.out.println("请输入运算方式 + - * /");
    char op = sc.next().charAt(0);
    switch (op) {
        case '+':
            System.out.println("A+B:"+ (a+b));
            break;
        case '-':
            System.out.println("A-b" + (a-b));
            break;
        case '*':
            System.out.println("A*B:" + (a*b));
            break;
        case '/':
            System.out.println("A/B:" + (a/b));
            break;
    }
}
```

运行效果如下

```
请输入变量A
12
请输入变量B
2
请输入运算方式 + - * /
*
A*B:24

Process finished with exit code 0
```