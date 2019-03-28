package ex04.II;

/**
 * @author 04181010魏源
 * @version 0.1
 * @since JDK 11.8.2 MacOS 10.11.6
 */

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