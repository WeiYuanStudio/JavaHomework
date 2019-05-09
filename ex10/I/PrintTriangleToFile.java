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