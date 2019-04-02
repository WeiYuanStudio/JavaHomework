package ex05.III;

/**
 * 点类
 * x,y座标
 * 计算点点距离 CalDistance
 * 计算点点成线，该线斜率
 *
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class Dot {
    private double x, y;

    static final double deviation = 1E-5; //浮点计算误差

    Dot(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 检测是否有点重复，不定参数。
     * 若有点重复则返回true，若无点重复则返回false
     *
     * @param dots
     * @return
     */
    public static boolean IfRepeat(Dot... dots) {
        for (int i = 0; i < dots.length; i++) {
            for (int j = i + 1; j < dots.length; j++) {
                if (CalDistance(dots[i], dots[j]) <= deviation) return true;
            }
        }
        return false;
    }

    /**
     * 检测由AB和BC构成的直线是否垂直
     * 若垂直返回true，不垂直返回false
     *
     * @param dotA
     * @param dotC
     * @param dotB
     * @return
     */
    public static boolean IfVertical(Dot dotA, Dot dotB, Dot dotC) {
        if ((CalSlope(dotA, dotB) == "notExist" && Double.valueOf(CalSlope(dotB, dotC)) <= deviation) ||
            (CalSlope(dotB, dotC) == "notExist" && Double.valueOf(CalSlope(dotA, dotB)) <= deviation)) return true;
        //一边斜率为零，另一边斜率不存在
        else if (Math.abs(Double.valueOf(CalSlope(dotA, dotB)) * Double.valueOf(CalSlope(dotB, dotC)) + 1) <= deviation) return true;
        //斜率相乘为零

        return false;
    }

    public double CalDistance(Dot dot) {
        return Math.sqrt((dot.x - x) * (dot.x - x) + (dot.y - y) * (dot.y - y));
    } //该点到dot的距离

    public static double CalDistance(Dot dotA, Dot dotB) {
        return Math.sqrt((dotA.x - dotB.x) * (dotA.x - dotB.x) + (dotA.y - dotB.y) * (dotA.y - dotB.y));
    } //两点dotA dotB 之间距离

    public static String CalSlope(Dot dotA, Dot dotB) {
        if (Math.abs(dotA.x - dotB.x) <= deviation) {
            if (CalDistance(dotA, dotB) <= deviation) throw new RuntimeException("点重复");
            else return "notExist"; //斜率不存在
        }
        return Double.toString((dotA.y - dotB.y) / (dotA.x - dotB.x));
    }
}