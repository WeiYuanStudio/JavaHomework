package ex05.III;

public class Square {
    Dot A, B, C, D;

    /**
     * 判断是否有点重复
     * 判断是否两线长度一致
     * 判断是否两线成垂直
     * B点需是正方形边AB，BC的交点
     *
     * @param A
     * @param B
     * @param C
     */
    public Square(Dot A, Dot B, Dot C, Dot D) {
        if (A.CalDistance(B) == 0 || B.CalDistance(C) == 0 || C.CalDistance(D) == 0 || D.CalDistance(A) == 0) {
            try {
                throw new Exception("创建正方形失败，有重复的点");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if ((Double.valueOf(A.CalSlope(B)) * Double.valueOf(B.CalDistance(C)) + 1) <= 1E-10) {
            try {
                throw new Exception("创建正方形失败，两线非垂直");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            this.A = A;
            this.B = B;
            this.C = C;
        }
    }
}
