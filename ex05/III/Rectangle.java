package ex05.III;

public class Rectangle extends Shape {
    Dot A, B, C, D;

    /**
     * 矩形类
     */

    public Rectangle(Dot A, Dot B, Dot C, Dot D) {
        if (Dot.IfRepeat(A, B, C, D)) { //判断是否有点重复
            throw new RuntimeException("点重复");
        } else if ((Dot.CalDistance(A, C) != Dot.CalDistance(B, D)) || !Dot.IfVertical(A, B, C) || !Dot.IfVertical(B, C, D) || !Dot.IfVertical(C, D, A)) {
            //上方语句判断是否符合矩形的定义，先判断一下是否对角线相等，
            throw new RuntimeException("点座标不符合矩形的定义");
        } else {
            this.A = A;
            this.B = B;
            this.C = C;
            this.D = D;
            CalPerimeter();
            CalAria();
        }


    }

    @Override
    public double CalPerimeter() {
        return perimeter = Dot.CalDistance(A, B) + Dot.CalDistance(B, C) + Dot.CalDistance(C, D) + Dot.CalDistance(D, A);
    }

    @Override
    public double CalAria() {
        return aria = Dot.CalDistance(A, B) * Dot.CalDistance(B, C);
    }
}
