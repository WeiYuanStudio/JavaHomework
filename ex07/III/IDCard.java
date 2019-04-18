package ex07.III;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class IDCard {
    private String str;

    IDCard(String str) {
        this.str = str;
    }

    /**
     * 判断是否广东卡，44开头
     * @return
     */
    boolean ifGuangDongID() {
        return str.substring(0, 2).equals("44");
    }

    @Override
    public String toString() {
        return str;
    }
}
