package ex10.I;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class PrintTriangleToFile {
    public static void printTriangle(FileOutputStream fileOutputStream, int size) throws IOException {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size - i; j++) {
                fileOutputStream.write(' ');
            }
            for (int j = 1; j <= ((i - 1) * 2 + 1); j++) {
                fileOutputStream.write('*');
            }
            fileOutputStream.write('\n');
        }
        fileOutputStream.close();
    }

    public static void main(String[] args) {
        String filePath = "/disk2/playground/JavaFileIO";
        try {
            FileOutputStream outFile = new FileOutputStream(filePath);
            printTriangle(outFile, 10);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}