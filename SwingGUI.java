import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SwingGUI {
    JFrame  topLevel;
    JPanel  jPanel;
    JTextField jTextField;
    JList<String>   jList;
    JButton b1;
    JButton b2;
    Container contentPane;
    String listData[] = {
        new String("First selection"),
        new String("Second selection"),
        new String("Third selection"),
    };
    public static void main(String argv[]){
        SwingGUI sgui = new SwingGUI();
        sgui.go();

    }

    public void go() {
        topLevel = new JFrame("Swing GUi");
        jPanel = new JPanel();
        jTextField = new JTextField(20);
        jList = new JList<String>(listData);
        contentPane = topLevel.getContentPane();
        contentPane.setLayout(new BorderLayout());
        b1 = new JButton("1");
        b2 = new JButton("2");
        contentPane.add(b1,BorderLayout.NORTH);
        contentPane.add(b2,BorderLayout.SOUTH);
        jPanel.setLayout(new FlowLayout());
        jPanel.add(jTextField);
        jPanel.add(jList);
        contentPane.add(jPanel,BorderLayout.CENTER);
        topLevel.pack();
        topLevel.setVisible(true);
        topLevel.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }


}
