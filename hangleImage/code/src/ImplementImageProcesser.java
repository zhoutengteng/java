import imagereader.*;
import java.awt.Image;
import javax.imageio.*;
import java.io.*;
import java.awt.Toolkit;
import java.awt.image.*;
import java.awt.*;


public class ImplementImageProcesser implements IImageProcessor {
    public Image showChanelR(Image sourth) {
        BufferedImage img = toBufferedImage(sourth);
        for (int i = 0; i < img.getWidth(null); i++) {
            for (int j = 0; j <  img.getHeight(null); j++) {
                int RGB = img.getRGB(i,j);
                img.setRGB(i,j, RGB & 0xffff0000);                
            }
        }        
        return img;
    }
    public Image showChanelG(Image sourth) {
        BufferedImage img = toBufferedImage(sourth);
        for (int i = 0; i < img.getWidth(null); i++) {
            for (int j = 0; j <  img.getHeight(null); j++) {
                int RGB = img.getRGB(i,j);
                img.setRGB(i,j, RGB & 0xff00ff00);                
            }
        }        
        return img;
    }
    public Image showChanelB(Image sourth) {
        BufferedImage img = toBufferedImage(sourth);
        for (int i = 0; i < img.getWidth(null); i++) {
            for (int j = 0; j <  img.getHeight(null); j++) {
                int RGB = img.getRGB(i,j);
                img.setRGB(i,j, RGB & 0xff0000ff);                
            }
        }        
        return img;
    }
    public Image showGray(Image sourth) {
        BufferedImage img = toBufferedImage(sourth);
        for (int i = 0; i < img.getWidth(null); i++) {
            for (int j = 0; j <  img.getHeight(null); j++) {
                int RGB = img.getRGB(i,j);
                int red = (int)(((double)((RGB & 0xff0000) >> 16)) * 0.299);
                int green = (int)(((double)((RGB & 0x00ff00) >> 8)) * 0.587);
                int black = (int)(((double)(RGB & 0x0000ff) +0.0) * 0.114);
		int temp = red+green+black;
                int newRGB = (0xff000000) + (temp << 16) + (temp << 8) + temp;
                img.setRGB(i,j, newRGB);                
            }
        }        
        return img;
    }


    public static BufferedImage toBufferedImage(Image img)
    {
        if (img instanceof BufferedImage)
        {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }


}
