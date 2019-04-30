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