package ex05.III;

public class Square extends Shape {
    Dot A, B, C, D;

    /**
     * 正方形
     * 判断是否有点重复
     * 判断是否两线长度一致
     * 判断是否两线成垂直
     * B点需是正方形边AB，BC的交点
     *
     * @author WeiYuan
     * @version 0.1
     * @since JDK 11.0.2
     */
    public Square(Dot A, Dot B, Dot C, Dot D) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
        if (Dot.IfRepeat(A, B, C, D)) { //判断是否有点重复
            throw new RuntimeException("点重复");
        } else if ( //判断AB和BC边是否相等
                !((Dot.CalDistance(A,B) - Dot.CalDistance(B,C)) <= Dot.deviation) ||
                //判断三角是否垂直，根据四边形定义，三角垂直则第四角也垂直
                !Dot.IfVertical(A, B, C) ||
                !Dot.IfVertical(B, C, D) ||
                !Dot.IfVertical(C, D, A)){
            throw new RuntimeException("点座标不符合正方形的定义");
        } else {
            Perimeter();
            Aria();
        }
    }

    @Override
    public double Perimeter() {
        return perimeter = Dot.CalDistance(A, B) * 4;
    }

    @Override
    public double Aria() {
        return aria = Dot.CalDistance(A, B) * Dot.CalDistance(B, C);
    }
}
