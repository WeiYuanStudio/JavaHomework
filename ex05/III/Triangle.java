package ex05.III;

/**
 * 三角形类
 * 含有三个座标点信息
 * 判断是否是一个三角形
 * 检测是否点重复
 * <p>
 * 还缺少检测三点一线的算法
 *
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class Triangle extends Shape {

    private Dot A, B, C; //三角形三点座标
    private double lengthA, lengthB, lengthC;

    public Triangle(Dot A, Dot B, Dot C) {
        if (A.CalDistance(B) == 0 || B.CalDistance(C) == 0 || C.CalDistance(A) == 0) {
            throw new RuntimeException("创建三角形失败，点重复");
        } else if (false) {
            //判断三点一线
        } else {
            this.A = A;
            this.B = B;
            this.C = C;

            CalPerimeter();
            CalAria();
        }
    } //构造方法,构造时计算Perimeter，Aria

//    public static boolean ifTriangle(Dot A, Dot B, Dot C) {
//        return true;
//    }//判断符合三角形的定义，待完善

    private void CalLength() {
        lengthA = B.CalDistance(C);
        lengthB = C.CalDistance(A);
        lengthC = A.CalDistance(B);
    } //构造时调用该方法计算各边边长

    @Override
    public double CalPerimeter() {
        CalLength();
        return perimeter = lengthA + lengthB + lengthC;
    } //依赖CalLength,计算perimeter

    /**
     * 计算三角形面积
     * 使用海伦-秦九韶公式计算面积
     * https://zh.wikipedia.org/wiki/%E6%B5%B7%E4%BC%A6%E5%85%AC%E5%BC%8F
     *
     * @return aria
     */
    @Override
    public double CalAria() {
        CalLength();
        double S = (lengthA + lengthB + lengthC) / 2; //半周长
        return aria = Math.sqrt(S * (S - lengthA) * (S - lengthB) * (S - lengthC));
    }
}
