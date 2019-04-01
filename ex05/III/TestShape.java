package ex05.III;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class TestShape {
    public static void main(String[] args) {
        //测试用类暂时没有完整的编写
        //请选择需要的测试用例并去除注释标记运行


        /********正方形********/

        //正方形测试用例一，用矩形座标信息构建正方形，按照程序设定应该抛出错误

//        Dot A = new Dot(0, 0);
//        Dot B = new Dot(2, 0);
//        Dot C = new Dot(2, 1);
//        Dot D = new Dot(0, 1);

        //正方形测试用例二，不规则四边形，按设定应抛出错误
//        Dot A = new Dot(-1, 0);
//        Dot B = new Dot(2, 0);
//        Dot C = new Dot(2, 1);
//        Dot D = new Dot(0, 1);

        //正方形测试用例三，AC点重复，应抛出错误
//        Dot A = new Dot(0, 3);
//        Dot B = new Dot(2, 0);
//        Dot C = new Dot(0, 3);
//        Dot D = new Dot(2, 3);

        //正方形测试用例四，正常正方形，对象创建成功
        Dot A = new Dot(1, 0);
        Dot B = new Dot(2, 1);
        Dot C = new Dot(1, 2);
        Dot D = new Dot(0, 1);

        Square s = new Square(A, B, C, D);

        /********矩形********/

        //矩形测试用例一，不规则四边形按设定应抛出错误
//        Dot E = new Dot(-1, 0);
//        Dot F = new Dot(2, 0);
//        Dot G = new Dot(2, 1);
//        Dot H = new Dot(0, 1);

        //矩形测试用例二，EG点重复，应抛出错误
//        Dot E = new Dot(0, 3);
//        Dot F = new Dot(2, 0);
//        Dot G = new Dot(0, 3);
//        Dot H = new Dot(2, 3);

        //矩形测试用例三,正常矩形对象创建成功
        Dot E = new Dot(0, 0);
        Dot F = new Dot(2, 0);
        Dot G = new Dot(2, 1);
        Dot H = new Dot(0, 1);

        Rectangle r = new Rectangle(E, F, G, H);

        /********三角形********/

        //三角形测试用例一，IK点重复,应抛出错误
//        Dot I = new Dot(0, 3);
//        Dot J = new Dot(2, 0);
//        Dot K = new Dot(0, 3);

        //三角形测试用例二，三点一线,应抛出错误
//        Dot I = new Dot(0, 0);
//        Dot J = new Dot(1, 1);
//        Dot K = new Dot(2, 2);

        //三角形测试用例三，正常三角形
        Dot I = new Dot(0, 1);
        Dot J = new Dot(1, 0);
        Dot K = new Dot(2, 1);

        Triangle t = new Triangle(I, J, K);

        Shape[] shapes = {s, r, t};
        for (Shape i : shapes) {
            i.PrintPerimeter();
            i.PrintAria();
        }
    }
}