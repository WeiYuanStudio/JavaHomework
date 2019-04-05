package ex06.III;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class MyRandom {
    public static int getRadomIntByRange(int min, int max){
        if(min >max) throw new IllegalArgumentException("min > max"); //如果min大于max抛出错误
        int x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }
}
