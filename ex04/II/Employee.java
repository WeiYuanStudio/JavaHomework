package ex04.II;

/**
 * @author 04181010魏源
 * @version 0.1
 * @since JDK 11.8.2 MacOS 10.11.6
 */

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
