import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class Calculator {
    final private JButton v_jb[];
    final private JTextField v_jt[];
    private JFrame jFrame;
    private Container contentpane;
    public Calculator() {
        v_jb = new JButton[5];
        v_jt = new JTextField[5];
        String te1[] = {"","","","=",""};
        for (int i = 0; i < 5; i++) {
            v_jt[i] = new JTextField(te1[i]);
            v_jt[i].setFont(new Font("Arial",Font.ITALIC,20));
            v_jt[i].setHorizontalAlignment(JTextField.CENTER);
        }

        String te[] = {"+","-","*","/","OK"};
        for (int i = 0; i < 5; i++) {
            v_jb[i] = new JButton(te[i]);
            v_jb[i].setFont(new Font("Arial",Font.ITALIC,20));
        }

        jFrame = new JFrame("Calculator");
        contentpane = jFrame.getContentPane();
        contentpane.setLayout(new GridLayout(2,5,10,10));
        for (int i = 0; i < 5; i++) {
            contentpane.add(v_jt[i]);
        }
        for (int i = 0; i < 5; i++) {
            contentpane.add(v_jb[i]);
        }
        jFrame.setSize(500,200);
        jFrame.setVisible(true);
    }


    public void go() {
        v_jt[0].addFocusListener(new FocusAdapter(){
            public void focusGained(FocusEvent e) {
              System.out.println("你正在编辑第 一个数字");
            }
            public void  focusLost(FocusEvent e) {
              
            }
        }); 
        
        v_jt[2].addFocusListener(new FocusAdapter(){
            public void focusGained(FocusEvent e) {
              System.out.println("你正在编辑第二个数字");
            }
            public void  focusLost(FocusEvent e) {
              
            }
        });
        v_jt[1].setEnabled(false);
        v_jt[1].setBackground(Color.gray);
        v_jt[1].setBorder(BorderFactory.createBevelBorder(0));
        v_jt[3].setEnabled(false);
        v_jt[3].setBackground(Color.gray);
        v_jt[4].setEnabled(false);
        v_jt[4].setBackground(Color.gray);
        for (int i = 0; i < 5; i++) {
           v_jb[i].addMouseListener(new MouseAdapter(){
               public void mouseClicked(MouseEvent e) {
                   switch ((((JButton)e.getComponent()).getText()).charAt(0)) {
                       case '+':
                           v_jt[1].setText((((JButton)e.getComponent()).getText()));
                           break;
                       case '-':
                           v_jt[1].setText((((JButton)e.getComponent()).getText()));
                           break;
                       case '*':
                           v_jt[1].setText((((JButton)e.getComponent()).getText()));
                           break;
                       case '/':
                           v_jt[1].setText((((JButton)e.getComponent()).getText()));
                           break;
                       default:
                           if (v_jt[0].getText().equals("") || v_jt[1].getText().equals("")|| v_jt[2].getText().equals("")) {
                               break;
                           } else {
                               char x = (v_jt[1].getText()).charAt(0);
                               int a = Integer.parseInt(v_jt[0].getText());
                               int b = Integer.parseInt(v_jt[2].getText());
                               int c = 0;
                               System.out.println(a);
                               System.out.println(b);
                               System.out.println(x);
                               if (x == '+') {
                                   c = a + b;
                               }
                               if (x == '-') {
                                   c = a - b;
                               }
                               if (x == '*') {
                                   c = a * b;
                               }
                               if (x == '/') {
                                   c = a / b;
                               }
                               v_jt[4].setText(String.valueOf(c));
                           }
                           break;

                   }
                   /**
                   if (v_jt[0].getText().equals("") || v_jt[1].getText().equals("")|| v_jt[2].getText().equals("")) {
                       v_jb[4].setEnabled(false);                     
                    } else {
                       v_jb[4].setEnabled(true);
                    }
                    */

                   
               }
           
           });
       
       }


        jFrame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] argv){
        Calculator ca = new Calculator();
        ca.go();
    }

}
