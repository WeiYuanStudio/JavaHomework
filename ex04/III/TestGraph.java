package ex04.III;

/**
 * @author 04181010魏源
 * @version 0.1
 * @since JDK 11.8.2 MacOS 10.11.6
 */

public class TestGraph {
    public static void main(String[] args) {
        System.out.println("----NEW Square & Length:2----");
        Square s1 = new Square(2);
        System.out.println("The Square:  Length:" + s1.getLength() + "  Aria:" + s1.getAria());
        System.out.println("SetLength: 4");
        s1.setLength(4);
        System.out.println("The Square:  Length:" + s1.getLength() + "  Aria:" + s1.getAria());
        System.out.println("SetAria: 32");
        s1.setAria(32);
        System.out.println("The Square:  Length:" + s1.getLength() + "  Aria:" + s1.getAria());
        System.out.println("\n\n");

        System.out.println("----NEW Triangle & Length = 3, 4, 5----");
        Triangle t1 = new Triangle(3, 4, 5);
        System.out.println("The Triangle:  Length:" + t1.getLengthA() + " " + t1.getLengthB() + " " + t1.getLengthC() + "  Aria:" + t1.getAria());
        System.out.println("SetLength: 6, 8, 10");
        t1.setLengthA(6);
        t1.setLengthB(8);
        t1.setLengthC(10);
        System.out.println("The Triangle:  Length:" + t1.getLengthA() + t1.getLengthB() + t1.getLengthC() + "  Aria:" + t1.getAria());
        System.out.println("\n\n");

        System.out.println("----NEW Cicular & Radius = 2");
        Circular c1 = new Circular(2);
        System.out.println("The Cicular:  Radius:" + c1.getRadius() + "  Aria:" + c1.getAria());
        System.out.println("SetRadius: 4");
        c1.setRadius(4);
        System.out.println("The Cicular:  Radius:" + c1.getRadius() + "  Aria:" + c1.getAria());
        System.out.println("\n\n");

        System.out.println("----NEW Pentagon & Length:2----");
        Pentagon p1 = new Pentagon(2);
        System.out.println("The Pentagon:  Length:" + p1.getLength() + "  Aria:" + p1.getAria());
        System.out.println("SetLength: 5");
        p1.setLength(5);
        System.out.println("The Pentagon:  Length:" + p1.getLength() + "  Aria:" + p1.getAria());

    }
}