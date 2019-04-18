# 实验七实验报告

## I.编写程序完成如下功能：输出字符串“www.google.com”的长度，并分别计算并显示出‘o’ 与‘g’的个数，截取其中“google”进行输出显示

**MyString.java**

```Java
package ex07.I;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class MyString {
    private String str;

    /**
     * 构造方法
     */
    public MyString(String str) {
        this.str = str;
    }

    /**
     * 计算字符串内含有char个数
     */
    public int calChar(char ch) {
        int cal = 0;
        for (int i = 0; i < str.length(); i++) {
            if (ch == str.charAt(i))
                cal++;
        }
        return cal;
    }

    /**
     * 替换字符串
     */
    public void replace(String target, String replaceStr) {
        str.replace(target, replaceStr);
    }

    public int length() {
        return str.length();
    }

    /**
     *重载toString
     */
    public String toString() {
        return str;
    }
}
```

**Test.java**

```Java
package ex07.I;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class Test {
    public static void main(String[] args) {
        MyString url = new MyString("www.google.com");
        System.out.println(url + " length :" + url.length());
        System.out.println(url + " have " + url.calChar('o') + " o have " + url.calChar('g') + " g");
    }
}
```

运行效果

```
www.google.com length :14
www.google.com have 3 o have 2 g

Process finished with exit code 0
```

## II.编写程序，尝试用“==”与equals()方法比较“Hello java”与“Hello java”是否相等

**Test.java**

```Java
package ex07.II;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class Test {
    public static void main(String[] args) {
        String str1 = "www.google.com";
        String str2 = "www.google.com";
        System.out.println("str1 use == compare str2 " + (str1 == str2));
        System.out.println("str1 use .equals() compare str2 " + str1.equals(str2));
        String str3 = new String("www.google.com");
        String str4 = new String("www.google.com");
        System.out.println("new str3 use == compare new str4 " + (str3 == str4));
        System.out.println("new str3 use .equals() compare new str4 " + str3.equals(str4));
    }
}

```

运行效果

```
str1 use == compare str2 true
str1 use .equals() compare str2 true
new str3 use == compare new str4 false
new str3 use .equals() compare new str4 true

Process finished with exit code 0
```

## III.用一个方法判断一个身份证号码是否是广东省身份证（提示：判断前缀“44”）

**IDCard.java**

```java
package ex07.III;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class IDCard {
    private String str;

    IDCard(String str) {
        this.str = str;
    }

    /**
     * 判断是否广东卡，44开头
     * @return
     */
    boolean ifGuangDongID() {
        return str.substring(0, 2).equals("44");
    }

    @Override
    public String toString() {
        return str;
    }
}

```

**TestIDCard.java**

```Java
package ex07.III;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class TestIDCard {
    public static void main(String[] args) {
        IDCard guangDongCard = new IDCard("441702XXXXXXXXXXXX");
        System.out.println("If " + guangDongCard + " is GuangDongCard? " + guangDongCard.ifGuangDongID());
    }
}
```

运行效果

```
If 441702XXXXXXXXXXXX is GuangDongCard? true

Process finished with exit code 0
```

## IV.编写一个应用程序，实现以下功能

 - 定义一个字符串为“AB-C-ABC”,请用“First”替换所有的A；再依据-将字符串进行分割成对应的子串
 - 从键盘中输入两个字符串，比较两个字符串的大小，规则是按照字典序
 - 将字符串转成对应的字符数组；将该字符数组的前3个元素创建成一个新字符串并输出

**Test.java**

```Java
package ex07.IV;

import java.lang.reflect.Array;
import java.util.Scanner;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class Test {
    public static void main(String[] args) {
        String target = "AB-C-ABC";
        System.out.println(target);

        /*替换掉A*/
        String afterReplace = target.replace("A", "First");
        System.out.println(afterReplace);

        /*切分*/
        for (String i : afterReplace.split("-")) {
            System.out.println(i);
        }

        /*字典对比两字符串*/
        System.out.println("Please Input 2 String Format:(Hello Hi)");
        Scanner scan = new Scanner(System.in);
        String aString = scan.next();
        String bString = scan.next();
        System.out.println(aString + " " + bString + " Compare Result " + aString.compareTo(bString));

        /*字符串转字符数组，将该字符数组的前3个元素创建成一个新字符串并输出*/
        String cString = "ABCDEFG";
        char[] cStringToChar = cString.toCharArray();

        StringBuffer cStringHEAD = new StringBuffer();

        /*字符数组填充Buffer*/
        for(int i = 0 ; i<3;i++) {
            cStringHEAD.append(cStringToChar[i]);
        }
        System.out.println(cStringHEAD);
    }
}
```

运行效果

```Java
AB-C-ABC
FirstB-C-FirstBC
FirstB
C
FirstBC
Please Input 2 String Format:(Hello Hi)
AAA BBB
AAA BBB Compare Result -1
ABC

Process finished with exit code 0
```