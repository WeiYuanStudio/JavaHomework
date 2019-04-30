package ex10.I;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class PrintTriangleToFile {
    /**
     * 打印三角形到文件
     * @param fileOutputStream 文件输出目录
     * @param size 三角形大小
     */
    public static void printTriangle(FileOutputStream fileOutputStream, int size) throws IOException {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size - i; j++) {
                fileOutputStream.write(' '); //打印空格
            }
            for (int j = 1; j <= ((i - 1) * 2 + 1); j++) {
                fileOutputStream.write('*'); //打印点
            }
            fileOutputStream.write('\n'); //换行
        }
        fileOutputStream.close(); //关闭文件
    }

    public static void main(String[] args) {
        System.out.println("Please Input Your Target File Path");
        Scanner sc = new Scanner(System.in);
        String filePath = sc.next(); //读取目标目录路径
        try {
            FileOutputStream outFile = new FileOutputStream(filePath);
            printTriangle(outFile, 10);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}