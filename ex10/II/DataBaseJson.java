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