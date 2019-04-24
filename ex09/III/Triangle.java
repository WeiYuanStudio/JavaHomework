package ex09.III;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
class Triangle {
    private double a, b, c, aria, perimeter; // 三角形三边长,不按照实验要求以xyz命名

    public Triangle(double a, double b, double c) {
        double calDeviation = 1E-5;
        if (a <= 0 || b <= 0 || c <= 0)
            throw new NotTriangleException("Input Num < 0");
        if (c > (a + b) - calDeviation)
            throw new NotTriangleException("c >= a + b");
        if (a > (b + c) - calDeviation)
            throw new NotTriangleException("a >= b + c");
        if (b > (a + c) - calDeviation)
            throw new NotTriangleException("b >= a + c");

        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getAria() {
        double s = (this.a + this.b + this.c) / 2;
        return aria = Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public double getPerimeter() {
        return perimeter = a + b + c;
    }

    public void printInfo() {
        System.out.println("A: " + a + " B: " + b + " C: " + c + " Aria: " + getAria());
    }
}