package ex07.III;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class TestIDCard {
    public static void main(String[] args) {
        IDCard guangDongCard = new IDCard("441702XXXXXXXXXXXX");
        System.out.println("If " + guangDongCard + " is GuangDongCard? " + guangDongCard.ifGuangDongID());
    }
}
