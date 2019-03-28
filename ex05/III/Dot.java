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
    public double x, y;

    public Dot(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @param dots
     * @return
     */
    public static boolean IfRepeat(Dot... dots) {
        for (int i = 0; i < dots.length; i++) {
            for (int j = i + 1; j < dots.length; j++) {
                if (CalDistance(dots[i], dots[j]) <= 1E-10)
                    return false;
            }
//            if (CalDistance(dots[i], dots[i + 1]) - 0 <= 1E-10)
//                return false;
        }
        return true;
    }

    public double CalDistance(Dot dot) {
        return Math.sqrt((dot.x - x) * (dot.x - x) + (dot.y - y) * (dot.y - y));
    } //该点到dot的距离

    public static double CalDistance(Dot dotA, Dot dotB) {
        return Math.sqrt((dotA.x - dotB.x) * (dotA.x - dotB.x) + (dotA.y - dotB.y) * (dotA.y - dotB.y));
    } //两点dotA dotB 之间距离

    public String CalSlope(Dot dot) {
        if (Math.abs(dot.x - this.x) - 0 <= 1E-10) {
            if (CalDistance(dot) - 0 <= 1E-10) {
                throw new RuntimeException("点重复");
            } else {
                return "notExist"; //斜率不存在
            }
        }
        return Double.toString(Math.abs(dot.y - y) / Math.abs(dot.x - x));
    }


//    public double CalSlope(Dot dot) {
//        if (CalDistance(dot) <= 1E-10) {
//            throw new RuntimeException("点重复");
//        } else {
//            return (Math.abs(dot.y - y) / Math.abs(dot.x - x));
//        }
//    } //该点到dot所成直线斜率
//
//    public static double CalSlope(Dot dotA, Dot dotB) {
//        if (Math.abs(dotA.x - dotB.x) - 0 <= 1E-10) {
//            if (CalDistance(dotA, dotB) - 0 <= 1E-10) {
//                throw new RuntimeException("点重复");
//            } else {
//                throw new RuntimeException("斜率不存在");
//            }
//        }
//        return (Math.abs(dotA.y - dotB.y) / Math.abs(dotA.x - dotB.x));
//        // 两点dotA dotB所成直线的斜率
//    }
}