// Applet/Application which shows an image of Duke in
// surfing mode
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class AppletApp extends Applet {
  
 Date date;
 
 // An application will require a main()
 public static void main (String args[]) {
    
    // Create a Frame to house the applet
    Frame frame = new Frame("Application");
    
    // Create an instance of the class (applet)
    AppletApp app = new AppletApp();
    
    // Add it to the center of the frame
    frame.add(app, BorderLayout.CENTER);
    frame.setSize (250, 150);
    
    // Register the AppletApp class as the
    // listener for a Window Destroy event
    frame.addWindowListener (new WindowAdapter() {
     public void windowClosing (WindowEvent e) {
         System.exit(0);
         }
     } );
    
    // Call the applet methods
   app.init();
   app.start();
   frame.setVisible(true); // Invokes paint()
   }
  
  public void init() {
    date = new Date();
    }
  
  public void paint (Graphics g) {
   g.drawString("This Java program started at", 25, 25);
   g.drawString(date.toString(), 25, 60);
   }
  }
