package ex05.III;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class TestShape {
    public static void main(String[] args) {
        //测试用类暂时没有完整的编写，一直在调试形状类对形状定义的判断
        //为了测试正方形类是否能判断4点能否构成正方形，请选择需要的测试用例并去除注释标记运行

        //测试用例一，用矩形座标信息构建正方形，按照程序设定应该抛出错误

//        Dot A = new Dot(0, 0);
//        Dot B = new Dot(2, 0);
//        Dot C = new Dot(2, 1);
//        Dot D = new Dot(0, 1);

        //测试用例二，不规则四边形，按设定应抛出错误
//        Dot A = new Dot(-1, 0);
//        Dot B = new Dot(2, 0);
//        Dot C = new Dot(2, 1);
//        Dot D = new Dot(0, 1);

        //测试用例三，AB点重复，应抛出错误
//        Dot A = new Dot(2, 0);
//        Dot B = new Dot(2, 0);
//        Dot C = new Dot(2, 1);
//        Dot D = new Dot(0, 1);

        //测试用例四，正常正方形，对象创建成功
        Dot A = new Dot(1, 0);
        Dot B = new Dot(2, 1);
        Dot C = new Dot(1, 2);
        Dot D = new Dot(0, 1);
        Square s = new Square(A, B, C, D);
        s.PrintPerimeter();
        s.PrintAria();
    }
}