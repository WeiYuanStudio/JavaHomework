package ex02.IV;

/**
 * @author 04181010魏源
 * @version 1.0
 * @since JDK 11.8.2 MacOS 10.11.6
 */

public class Pascal_Triangle {
    public static void main() {
        for (int line = 0; line <= 4; line ++){
            PrintBlankSpace(line);
            PrintDot(line);
            System.out.println();
        }
        for (int line = 3; line >=0; line--) {
            PrintBlankSpace(line);
            PrintDot(line);
            System.out.println();
        }
    }

    private static void PrintBlankSpace(int line) {
        int SpaceNum = 4 - line;
        for (int i = 0; i < SpaceNum; i++) {
            System.out.print(' ');
        }
    }

    private static void PrintDot(int line) {
        int DotNum = line + (line -1);
        for (int i = 0; i < DotNum; i++){
            System.out.print('*');
        }
    }
}