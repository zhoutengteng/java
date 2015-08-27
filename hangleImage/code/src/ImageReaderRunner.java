// ImagaReaderRunner.java
import imagereader.Runner;
import javax.swing.*;
import java.awt.*;
import imagereader.*;
import java.awt.Image;
import javax.imageio.*;
import java.io.*;
import java.awt.Toolkit;
import java.awt.image.*;
import java.awt.*;



 
public class ImageReaderRunner {
    public static void main(String[] args) {


       // ImplementImageIO IOTest  = new ImplementImageIO();

       // ImplementImageProcesser ProcessTest = new ImplementImageProcesser();

        ImplementImageIO imageioer = new ImplementImageIO();
       // BufferedImage tes = ProcessTest.toBufferedImage(IOTest.myRead("1.bmp"));
        //JFrame f = new JFrame();
        //f.setVisiable(true);
        //Image image = imageioer.myRead("1.bmp");
        //f.getContentPane().add(image);
        ImplementImageProcesser processor = new ImplementImageProcesser();
        Runner.run(imageioer, processor);
    }
 }
