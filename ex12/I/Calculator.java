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
 *
 * @author WeiYuan
 * @version 0.1
 * @since JDK 11.0.2
 */
public class Calculator extends JFrame {
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

        additionButton.addActionListener(new ButtonListenner()); //Add Button "=" to ActionListener

        //Add HotKey listener when focus on these element
        HotkeyListener hotkeyListener = new HotkeyListener();
        numATextField.addKeyListener(hotkeyListener);
        numBTextField.addKeyListener(hotkeyListener);
        additionButton.addKeyListener(hotkeyListener);

        setVisible(true);
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
     * Listen button "=", and run AdditionCal()
     */
    class ButtonListenner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            additionCal();
            Logger.getGlobal().info("Action by button"); //Logging
        }
    }

    /**
     * Listen Enter Key type event, and run AdditionCal()
     */
    class HotkeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent keyEvent) {
            if (keyEvent.getKeyChar() == '\n') {
                additionCal();
                Logger.getGlobal().info("Action by Enter Key"); //Logging
            }
        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {

        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {

        }
    }
}