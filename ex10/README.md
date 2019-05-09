# 实验十实验报告

## I.编写程序实现在控制台用*输出一个倒立的等边三角型，并写到文件

**PrintTriangleToFile.java**

```Java
package ex10.I;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class PrintTriangleToFile {
    /**
     * 打印三角形到文件
     *
     * @param out 输出流对象
     * @param size 三角形大小
     */
    public static void printTriangle(OutputStream out, int size) throws IOException {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size - i; j++) {
                out.write(' '); //打印空格
            }
            for (int j = 1; j <= ((i - 1) * 2 + 1); j++) {
                out.write('*'); //打印点
            }
            out.write('\n'); //换行
        }
        out.close(); //关闭文件
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Input Your Target File Path");
        String filePath = scanner.next(); //读取目标目录路径

        System.out.println("Please Input Triangle Size");
        int size = scanner.nextInt();

        try {
            FileOutputStream outFile = new FileOutputStream(filePath);
            printTriangle(outFile, size); //Print to File
            printTriangle(System.out, size); //Print to Console
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
```

测试结果

```
[adam@mibookpro JavaHomework]$ java ex10.I.PrintTriangleToFile
Please Input Your Target File Path
/disk2/playground/JavaFileIO
Please Input Triangle Size
10
         *
        ***
       *****
      *******
     *********
    ***********
   *************
  ***************
 *****************
*******************
```

看到命令行已经打印出了一个三角形

现在按照理想的运行情况，该文件已经成功的写入到我的笔记本第二块硬盘/disk2/playground/JavaFileIO文件中下。（这里注意，本人主力为Linux环境，这里填写的是Linux目录）  

那么现在用`cat`命令让系统将文件内容打印到命令行中

```bash
[adam@mibookpro JavaHomework]$ cat /disk2/playground/JavaFileIO
         *
        ***
       *****
      *******
     *********
    ***********
   *************
  ***************
 *****************
*******************
```

为什么不使用记事本截图发上来呢，因为在学校实验室上机没有网络代理（你懂的网络原因）的环境下发现，GitHub仓库内图片全部都无法显示，尽管我是用的是微博图床作为图片来源，但是经过对响应网页的源码查看，发现应该是GitHub出于隐私保护原因，反代了README.md中的图片链接，避免浏览器直接加载图床链接造成隐私泄漏的可能性。但这也导致了大陆用户因网络原因直接无法查看图片。。。。

## II.课后习题第四题

这一题受到了前几个星期帮同学开发一个[刷评论软件](https://github.com/WeiYuanStudio/AutoYiBan)时解析服务器Ajax响应json信息的一点启发，所以这次直接利用了一个Google开发的Gson类包格式化学生数据，然后将该数据存入文件系统。曾经在[C++作业](https://github.com/WeiYuanStudio/CPPHomework/tree/master/Homework3)上也使用过空格换行大法作为数据储存做了一个仓库管理软件。实在是一个很接地气的方法。在xml，yml等一系列格式中，选择了json，json的话方便解析反序列，易读性也强。

**DataBaseJson.java**

```Java
package ex10.II;

import java.util.ArrayList;
import java.util.List;

/**
 * 该类用于给Gson构建Json，加入题目以外的其他信息以测试复杂的Json构建
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
class DataBaseJson {
    String lastChangeTime; //最后修改时间
    String author; //修改者信息
    List<StudentInfo> studentInfos; //学生信息数组

    /**
     * 构造
     * @param lastChangeTime 最后修改时间
     * @param author 修改作者
     */
    DataBaseJson(String lastChangeTime, String author) {
        this.lastChangeTime = lastChangeTime;
        this.author = author;
        this.studentInfos = new ArrayList<>(); //构造时初始化List
    }

/**
 * 添加学生
 * @param studentInfo 需要添加的学生信息
 */
    public DataBaseJson addStudent(StudentInfo studentInfo) {
        studentInfos.add(studentInfo);
        return this;
    }
}
```

**StudentDataBase.java**

```Java
package ex10.II;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * GitHub: https://github.com/google/gson
 * Docs: https://google.github.io/gson/apidocs/com/google/gson/Gson.html
 */
import com.google.gson.Gson;


/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class StudentDataBase {
    private String dataBasePath; //文件储存路径
    private DataBaseJson dataBaseJson; //对象储存Json
    private String textFormJson; //序列化Json

    /**
     * 构造 记录写入时间与作者
     * @param dataBasePath 文件目录
     * @param author 作者
     */
    StudentDataBase(String dataBasePath, String author) {
        dataBaseJson = new DataBaseJson(new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date()), author); //获取系统时间
        this.dataBasePath = dataBasePath;
    }

    /**
     * 添加学生
     * @param studentInfo 需要添加的学生信息
     */
    void addStudent(StudentInfo studentInfo) {
        dataBaseJson.addStudent(studentInfo);
    }

    /**
     * 写入文件
     */
    void writeFile() throws IOException {
        File file = new File(dataBasePath); //建立文件对象
        BufferedWriter writer = new BufferedWriter(new FileWriter(file)); //建立Writer
        writer.write(getJsonText()); //写入序列化Json
        writer.flush(); //清除缓存
        writer.close(); //关闭文件
        System.out.println("Write To File Success !");
    }

    /**
     * 读取文件
     */
    void readFile() throws IOException {
        File file = new File(dataBasePath); //建立文件对象
        BufferedReader reader = new BufferedReader(new FileReader(file)); //建立reader
        textFormJson = reader.readLine(); // Read A Line
        fomatJsonFromText();
    }

    /**
     * 序列化Json
     */
    String getJsonText() {
        Gson gson = new Gson();
        return textFormJson = gson.toJson(dataBaseJson, DataBaseJson.class); //对Gson序列化为Json
    }

    /**
     * 反序列化Json
     */

    void fomatJsonFromText() {
        Gson gson = new Gson();
        dataBaseJson = gson.fromJson(textFormJson, DataBaseJson.class);
    }

    /**
     * @return 返回序列化后的Json
     */
    public DataBaseJson getDataBaseJson() {
        return dataBaseJson;
    }
}
```

**StudentInfo.java**

```Java
package ex10.II;

/**
 * 单个学生的信息，该类用于储存学生信息
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
class StudentInfo {
    private String studentNum;
    private String studentName;
    private String studentSex;
    private int studentGrade;
    private int studentGPA;

    StudentInfo(String studentNum, String studentName, String studentSex, int studentGrade, int studentGPA) {

        this.studentNum = studentNum;
        this.studentName = studentName;
        this.studentSex = studentSex;
        this.studentGrade = studentGrade;
        this.studentGPA = studentGPA;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public int getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(int studentGrade) {
        this.studentGrade = studentGrade;
    }

    public int getStudentGPA() {
        return studentGPA;
    }

    public void setStudentGPA(int studentGPA) {
        this.studentGPA = studentGPA;
    }
}
```

**TestStudentDataBase.java**

```Java
package ex10.II;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2   gson 2.8.5
 */
public class TestStudentDataBase {
    static String dataBasePath;
    /**
     * 获取学生信息并构建成StudentInfo对象
     * @return 学生信息对象
     */
    private static StudentInfo getFormatStudent() {
        System.out.println("Please Input Student Info");
        System.out.println("StudentNum | StudentName | Sex | Grade | GPA");
        Scanner sc = new Scanner(System.in);
        String tempNum = sc.next();
        String tempName = sc.next();
        String tempSex = sc.next();
        int tempGrade = sc.nextInt();
        int tempGPA = sc.nextInt();
        return new StudentInfo(tempNum, tempName, tempSex, tempGrade, tempGPA);
    }

    /**
     * 写入学生信息方法，供main方法调用
     */
    private static void getStudentMenu() {
        StudentDataBase jluzh = new StudentDataBase(dataBasePath, "WeiYuanStudio");
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                jluzh.addStudent(getFormatStudent());
            } catch (InputMismatchException e) {
                System.out.println("Error Input");
            }
            System.out.println("Input Y or y Continue Add Student");
        } while (scanner.next().equals("Y") || scanner.next().equals("y"));

        try {
            jluzh.writeFile();
        } catch (IOException e) {
            System.out.println("Write File Failed ! " + e.getMessage());
        }
    }

    /**
     * 打印所有学生信息
     */
    private static void printStudentMenu() {
        StudentDataBase jluzh = new StudentDataBase(dataBasePath, "WeiYuanStudio");
        try {
            jluzh.readFile();
        } catch (IOException e) {
            System.out.println("Read File Failed ! " + e.getMessage());
        }
        System.out.println("StudentNum | StudentName | Sex | Grade | GPA");
        for (StudentInfo i : jluzh.getDataBaseJson().studentInfos) {
            System.out.print(i.getStudentNum() + "     ");
            System.out.print(i.getStudentName() + "     ");
            System.out.print(i.getStudentSex() + "     ");
            System.out.print(i.getStudentGrade() + "     ");
            System.out.print(i.getStudentGPA() + "     \n");
        }
    }

    public static void main(String[] args) {
        dataBasePath = args[0];
        while (true) {
            System.out.println("Please Input Number To Choose Menu, You Have Set File Path: " + dataBasePath);
            System.out.println("1. Write Data");
            System.out.println("2. Print Data");
            System.out.println("3. Exit");
            Scanner sc = new Scanner(System.in);
            int menuNum = sc.nextInt();
            switch (menuNum) {
                case 1:
                    getStudentMenu();
                    break;
                case 2:
                    printStudentMenu();
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}
```

由于需要外部类包，所以使用IDE的话需要自行使用maven仓库管理构建项目。IDEA自带，eclipse貌似还得自己装插件。。。

这里写下命令行编译参数。

先放上我的项目目录结构

```
[adam@mibookpro IDEA]$ tree -d
.
├── JavaHomework   <------ 实验文件放在这里
│   ├── ex01
│   ├── ex02
│   ├── ex03
│   ├── ex04
│   ├── ex05
│   ├── ex06
│   ├── ex07
│   ├── ex08
│   ├── ex09
│   ├── ex10
│   └── ex12
├── lib             <----- 项目外部类包放在这里
└── out
```

编译时需要Gson类库的依赖，该类库下载到手是一个jar包，我将它放在lib内，现在进入JavaHomework目录。编译命令

```
java -cp ../lib/gson-2.8.5.jar:. ex10.II.TestStudentDataBase /disk2/playground/JLUZH
```

 ClassPath参数`-cp ../lib/:.` 表示lib目录，要包含上一级目录中的lib和当前目录。由于使用了-cp参数，javac将不会将当前目录自动的加入cp中所以还要加上当前目录用句点表示，Win中用`;`，Linux中用`:`分隔两个cp

相应的运行时也需要添加-cp参数，除非将整个程序包含依赖打包成jar包，否则运行到需要调用Gson的语句时就会直接报错

运行测试

```
[adam@mibookpro JavaHomework]$ java -cp ../lib/gson-2.8.5.jar:. ex10.II.TestStudentDataBase /disk2/playground/JLUZH
Please Input Number To Choose Menu, You Have Set File Path: /disk2/playground/JLUZH
1. Write Data
2. Print Data
3. Exit
1
Please Input Student Info
StudentNum | StudentName | Sex | Grade | GPA
04181010 WeiYuan Male 1 80
Input Y or y Continue Add Student
Y
Please Input Student Info
StudentNum | StudentName | Sex | Grade | GPA
0418XXXX HatsuneMiku Female 1 100
Input Y or y Continue Add Student
Y
Please Input Student Info
StudentNum | StudentName | Sex | Grade | GPA
0418XXXX wowaka Female 4 100 
Input Y or y Continue Add Student
Y
Please Input Student Info
StudentNum | StudentName | Sex | Grade | GPA
0418YYYY deco*27 Female 4 97 
Input Y or y Continue Add Student
n
Write To File Success !
Please Input Number To Choose Menu, You Have Set File Path: /disk2/playground/JLUZH
1. Write Data
2. Print Data
3. Exit
3
...
```

现在来看目标文件,已经获得了标准的格式化后的json信息，在文件系统中，该文件是压缩后的json，仅有一行，如下，网页可能被自动换行排版，仅供参考

```
[adam@mibookpro JavaHomework]$ cat /disk2/playground/JLUZH 
{"lastChangeTime":"2019年05月01日 01:45:32","author":"WeiYuanStudio","studentInfos":[{"studentNum":"04181010","studentName":"WeiYuan","studentSex":"Male","studentGrade":1,"studentGPA":80},{"studentNum":"0418XXXX","studentName":"HatsuneMiku","studentSex":"Female","studentGrade":1,"studentGPA":100},{"studentNum":"0418XXXX","studentName":"wowaka","studentSex":"Female","studentGrade":4,"studentGPA":100},{"studentNum":"0418YYYY","studentName":"deco*27","studentSex":"Female","studentGrade":4,"studentGPA":97}]}
```

通过[在线格式化工具](https://www.json.cn)格式化展开该保存文件的缩进，方便阅读，如下

```json
{
    "lastChangeTime":"2019年05月01日 01:45:32",
    "author":"WeiYuanStudio",
    "studentInfos":[
        {
            "studentNum":"04181010",
            "studentName":"WeiYuan",
            "studentSex":"Male",
            "studentGrade":1,
            "studentGPA":80
        },
        {
            "studentNum":"0418XXXX",
            "studentName":"HatsuneMiku",
            "studentSex":"Female",
            "studentGrade":1,
            "studentGPA":100
        },
        {
            "studentNum":"0418XXXX",
            "studentName":"wowaka",
            "studentSex":"Female",
            "studentGrade":4,
            "studentGPA":100
        },
        {
            "studentNum":"0418YYYY",
            "studentName":"deco*27",
            "studentSex":"Female",
            "studentGrade":4,
            "studentGPA":97
        }
    ]
}
```

重启程序，读取硬盘中文件信息测试，成功解析了json，并打印出文件中的数据

```
[adam@mibookpro JavaHomework]$ java -cp ../lib/gson-2.8.5.jar:. ex10.II.TestStudentDataBase /disk2/playground/JLUZH
Please Input Number To Choose Menu, You Have Set File Path: /disk2/playground/JLUZH
1. Write Data
2. Print Data
3. Exit
2
StudentNum | StudentName | Sex | Grade | GPA
04181010     WeiYuan     Male     1     80     
0418XXXX     HatsuneMiku     Female     1     100     
0418XXXX     wowaka     Female     4     100     
0418YYYY     deco*27     Female     4     97     
Please Input Number To Choose Menu, You Have Set File Path: /disk2/playground/JLUZH
1. Write Data
2. Print Data
3. Exit
3
```