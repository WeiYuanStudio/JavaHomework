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