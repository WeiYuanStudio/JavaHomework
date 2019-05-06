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
class StudentDataBase {
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
    }

    /**
     * 序列化Json
     */
    private String getJsonText() {
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
    DataBaseJson getDataBaseJson() {
        return dataBaseJson;
    }
}