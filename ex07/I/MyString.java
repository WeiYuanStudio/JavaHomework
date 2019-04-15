package ex07.I;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class MyString {
    private String str;

    MyString(String str) {
        this.str = str;
    }

    int calChar(char ch) {
        int cal = 0;
        for (int i = 0; i < str.length(); i++) {
            if(ch == str.charAt(i))
                cal++;
        }
        return cal;
    }

    public int length() {
        return str.length();
    }

    public String toString() {
        return str;
    }
}
