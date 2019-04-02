package ex05.III;

/**
 * 矩形
 *
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class Rectangle extends Shape {
    Dot A, B, C, D;

    public Rectangle(Dot A, Dot B, Dot C, Dot D) {
        if (Dot.IfRepeat(A, B, C, D)) { //判断是否有点重复
            throw new RuntimeException("点重复");
        } else if ( //是否三个角垂直，若三脚垂直，根据定义第四个角也垂直
                    !Dot.IfVertical(A, B, C) ||
                    !Dot.IfVertical(B, C, D) ||
                    !Dot.IfVertical(C, D, A)) {
            throw new RuntimeException("点座标不符合矩形的定义");
        } else {
            this.A = A;
            this.B = B;
            this.C = C;
            this.D = D;
            Perimeter();
            Aria();
        }
    }

    @Override
    public double Perimeter() {
        return perimeter = Dot.CalDistance(A, B) + Dot.CalDistance(B, C) + Dot.CalDistance(C, D) + Dot.CalDistance(D, A);
    }

    @Override
    public double Aria() {
        return aria = Dot.CalDistance(A, B) * Dot.CalDistance(B, C);
    }
}
