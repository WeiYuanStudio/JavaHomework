# 实验十二实验报告

**已更新代码，实验报告内代码已经过时，请查看上方源码**

## I.完成一个计算器

**Calculator.java**
```Java
package ex12.I;
import javax.swing.*; //https://docs.oracle.com/en/java/javase/12/docs/api/java.desktop/javax/swing/package-summary.html
import java.awt.*; //https://docs.oracle.com/en/java/javase/12/docs/api/java.desktop/java/awt/event/package-summary.html
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Logger;


/**
 * 计算器
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class Calculator extends JFrame implements ActionListener, KeyListener {
    private JTextField numATextField, numBTextField;
    private JLabel result;

    Calculator() {
        super("Calculator"); //Set Window Navbar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Set close operation
        setLayout(new FlowLayout(FlowLayout.LEFT)); //Set layout method
        setSize(400, 100); //Set window size

        JLabel text = new JLabel("Addition Operation");
        add(text); //Add text

        numATextField = new JTextField(5);
        add(numATextField); //Add num input field

        JLabel plusSymbol = new JLabel("+");
        add(plusSymbol); // Add text

        numBTextField = new JTextField(5);
        add(numBTextField); //Add num input field


        JButton additionButton = new JButton("=");
        add(additionButton); //Add additionButton

        result = new JLabel();
        add(result); //Add result Label

        additionButton.addActionListener(this); //Add Button "=" to ActionListener

        //Add HotKey listener when focus on these element
        numATextField.addKeyListener(this);
        numBTextField.addKeyListener(this);
        additionButton.addKeyListener(this);

        setVisible(true);
    }

    /**
     * Listen button "=", and run AdditionCal()
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        additionCal();
        Logger.getGlobal().info("Action by button"); //Logging
    }

    private void additionCal() {
        double additionResult = 0;
        try {
            additionResult = Double.valueOf(numATextField.getText())
                    + Double.valueOf(numBTextField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "NumberFormatException,Plese input legal number");
            Logger.getGlobal().info("Error: " + e.getMessage());
        }

        result.setText(String.valueOf(additionResult));
    }

    /**
     * Listen Enter Key type event, and run AdditionCal()
     *
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == '\n') {
            additionCal();
            Logger.getGlobal().info("Action by Enter Key"); //Logging
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
```

**TestGUI.java**
```Java
package ex12.I;

public class TestGUI {
    public static void main(String[] args) {
        new Calculator();
    }
}
```

运行界面如图（微博图床已经成为历史过去时，本次使用imgur图床，如果是GitHub直接访问该图将被GitHub反向代理，请确保拥有良好的网络连接环境，否则由于某些强国特色原因将无法加载图片

![](https://i.imgur.com/LK7elty.png)

还加入了日志记录特性。

下面是异常处理测试

![](https://i.imgur.com/1A4flNX.png)

遇到错误的输入，执行计算时会弹窗提示

还有一个快捷键特性，加入了KeyEvent键盘时间监听，当聚集在两个输入框或者是计算按钮上时，直接按下Enter，即可执行计算