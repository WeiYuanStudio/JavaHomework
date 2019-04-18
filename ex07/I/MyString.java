package ex07.I;

/**
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class MyString {
    private String str;

    /**
     * 构造方法
     */
    public MyString(String str) {
        this.str = str;
    }

    /**
     * 计算字符串内含有char个数
     */
    public int calChar(char ch) {
        int cal = 0;
        for (int i = 0; i < str.length(); i++) {
            if (ch == str.charAt(i))
                cal++;
        }
        return cal;
    }

    /**
     * 替换字符串
     */
    public void replace(String target, String replaceStr) {
        str.replace(target, replaceStr);
    }

    public int length() {
        return str.length();
    }

    /**
     *重载toString
     */
    public String toString() {
        return str;
    }
}
