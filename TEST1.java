import java.awt.*;
import java.awt.event.*;

public class TEST1 extends Frame {
    private TextField tf;
    public static void main(String arvs[]) {
        TEST1 obj = new TEST1();
        obj.go();

    }
    public void go() {
        Frame f;
        f = new Frame("Anonymous class examples");
        f.add(new Label("click and drag the " +  "mouse"), BorderLayout.NORTH);
        tf = new TextField(30);
        f.add(tf,BorderLayout.SOUTH);
        f.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent  e) {
                String  s = "Mouse dragging: X = " + e.getX() + " Y = " + e.getY();

                tf.setText(s);

            }
        });
        f.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                System.out.println("clicked");                

            }
        
        });
        f.setSize(300,200);
        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.out.println("ddddddddddddddddddddddddd");
                System.exit(0);
            }
        });
        f.setVisible(true);
    
    }
        
        
}
