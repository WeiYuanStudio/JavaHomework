/**
 * @author 04181010魏源
 * @version 0.1
 * @since JDK 11.8.2 MacOS 10.11.6
 */
package ex04.I;

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