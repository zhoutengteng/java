import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.io.*;  
import javax.swing.*; 
import java.awt.Image;
import java.awt.*;
import java.lang.Exception.*;
import java.awt.image.*;
import javax.imageio.*;
import imagereader.IImageIO;

public class ImageTest {
  private Image img1;
  private Image img2;
  private static ImplementImageProcesser processor = new ImplementImageProcesser();

  @Before
  public void setUp() {
    img1 = null;
    img2 = null;
  }

  @Test
  public void ChanelRTest() throws IOException{
   Image sourceImage1 = ImageIO.read(new File("1.bmp"));
    Image sourceImage2 = ImageIO.read(new File("2.bmp"));

    img1 = processor.showChanelR(sourceImage1);
    img2 = processor.showChanelR(sourceImage2);
    Image testImg1 = ImageIO.read(new File("1_red_goal.bmp"));
    Image testImg2 = ImageIO.read(new File("2_red_goal.bmp"));
    assertEquals("RTest1:width is not equal", testImg1.getWidth(null), img1.getWidth(null));
    assertEquals("RTest2:width is not equal", testImg2.getWidth(null), img2.getWidth(null));
    assertEquals("RTest1:height is not equal", testImg1.getHeight(null), img1.getHeight(null));
    assertEquals("RTest2:height is not equal", testImg2.getHeight(null), img2.getHeight(null));

    BufferedImage bi1 = new BufferedImage(img1.getWidth(null), img1.getHeight(null),BufferedImage.TYPE_3BYTE_BGR);
    Graphics g1 = bi1.getGraphics();
    g1.drawImage(img1, 0, 0, null);

    BufferedImage testbi1 = new BufferedImage(testImg1.getWidth(null), testImg1.getHeight(null),BufferedImage.TYPE_3BYTE_BGR);
    Graphics testg1 = testbi1.getGraphics();
    testg1.drawImage(testImg1, 0, 0, null);

    BufferedImage bi2 = new BufferedImage(img2.getWidth(null), img2.getHeight(null),BufferedImage.TYPE_3BYTE_BGR);
    Graphics g2 = bi2.getGraphics();
    g2.drawImage(img2, 0, 0, null);

    BufferedImage testbi2 = new BufferedImage(testImg2.getWidth(null), testImg2.getHeight(null),BufferedImage.TYPE_3BYTE_BGR);
    Graphics testg2 = testbi2.getGraphics();
    testg2.drawImage(testImg2, 0, 0, null);

    for (int i = 0; i < img1.getHeight(null); i++) {
      for (int j = 0; j < img1.getWidth(null); j++) {
        assertEquals("RTest1:pixels are not equal", testbi1.getRGB(j, i), bi1.getRGB(j, i));
      }
    }

    for (int i = 0; i < img2.getHeight(null); i++) {
      for (int j = 0; j < img2.getWidth(null); j++) {
        assertEquals("RTest2:pixels are not equal", testbi2.getRGB(j, i), bi2.getRGB(j, i));
      }
    }

  }

}
