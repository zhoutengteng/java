import imagereader.*;
import java.awt.Image;
import javax.imageio.*;
import java.io.*;
import java.awt.Toolkit;
import java.awt.image.*;
import java.awt.*;

public class ImplementImageIO  implements IImageIO {

    public Image myRead(String  pathStr) { 
       try { 
        File file = new File(pathStr);
        InputStream in = null;
        in = new FileInputStream(file);
        int n = 2;

        int allLength = in.available(); 
        byte buffer[] = new byte[allLength];   
        // 读取输入流   
        System.out.println(in.available());
        if ((in.read(buffer, 0, allLength) != -1) && (n > 0)) {   
            //System.out.print(new String(buffer));   
        }
    
       //    for (int i = 0; i < 40; i++) {
          //  System.out.print(buffer[i]);

        //}
        in.close();
        //System.out.println(buffer.length);
        String bufferStr = new String(buffer);
        //System.out.println(bufferStr.charAt(0));
        //System.out.println((int)buffer[10]);
        int offsetBMP = ((buffer[10] + 256) % 256 ) | (((buffer[11] + 256) % 256)  << 8)  | (((buffer[12] + 256) % 256) << 16) | (((buffer[13] + 256) % 256) << 24);        
        System.out.println(offsetBMP);
        int widthBMP = ((buffer[18] + 256) % 256 ) | (((buffer[19] + 256) % 256)  << 8)  | (((buffer[20] + 256) % 256) << 16) | (((buffer[21] + 256) % 256) << 24);        
        System.out.println(widthBMP);
        int heightBMP = ((buffer[22] + 256) % 256 ) | (((buffer[23] + 256) % 256)  << 8)  | (((buffer[24] + 256) % 256) << 16) | (((buffer[25] + 256) % 256) << 24);        
        System.out.println(heightBMP);
        int weiBMP = (((buffer[28] + 256) % 256 ) | (((buffer[29] + 256) % 256)  << 8)) / 8;
        int pixTotal = widthBMP * heightBMP;        
        System.out.println(weiBMP);
        int pix[] = new int[widthBMP*heightBMP];
        int index = offsetBMP;
        //index = 54;
        //int widthBytes = (widthBMP * weiBMP+31)/32*4
	int pad = 0;
                

	if (widthBMP * weiBMP % 4 != 0) {
		pad = 4 - widthBMP * weiBMP % 4;
        }
      System.out.println(pad);
      if (weiBMP == 3) {
           for (int y = heightBMP - 1; y >= 0; y--) {
               for (int x = 0; x  < widthBMP; x++) {
       
                    int black = (buffer[index++] + 256) % 256;
                    int green = (buffer[index++] + 256) % 256;
                    int red =   (buffer[index++] + 256)  % 256;
                    pix[y*widthBMP + x] = (255 << 24) | (red << 16) | (green << 8) | (black);
                    //System.out.println(y*widthBMP + x);
                }
                index += pad;
            }
        } else {
           for (int y = heightBMP - 1; y >= 0; y--) {
               for (int x = 0; x  < widthBMP; x++) {
      /*
                int grayRgb = (int)((buffer[index++] + 256) % 256  * 0.114);
                pix[y*widthBMP + x] = grayRgb + (grayRgb << 16) + ( grayRgb << 8) + 0xff00000;
                //System.out.println(y*widthBMP + x);
        */


                //    int black = ((buffer[index] + 256) % 256) & 0x03;
                 //  int green = ((buffer[index] + 256) % 256) & 0x0c;
                 //   int red =   ((buffer[index++] + 256)  % 256) & 0x30;
                  //  pix[y*widthBMP + x] = (255 << 24) | (red << 16) | (green << 8) | (black);
                      int cc = (buffer[index++] + 256) % 256;
                      pix[y*widthBMP + x] = cc + cc * 256 + cc * 256 * 256 + 255*256*256*256;
                      // pix[y*widthBMP + x] = cc + cc << 8 + cc << 16 + 0xff << 24;
                      // pix[y*widthBMP + x] = 
                }
                index += pad;
            }

        }
      Image img = Toolkit.getDefaultToolkit().createImage(new MemoryImageSource(widthBMP, heightBMP, pix, 0, widthBMP));
      //Image img = Toolkit.getDefaultToolkit().createImage(new MemoryImageSource(w, h, pix, 0, w));
                    int cc = 1;
                    //System.out.println(" ddd" + (cc + cc * 256 + cc * 256 * 256 + 255*256*256*256));
                    //System.out.println((cc + cc << 8 + cc << 16 + 0xff << 24 ));
                    System.out.println(" ddd" + (cc + cc * 256 ));
                    System.out.println((cc & 0xff) +( cc << 8));
                      // pix[y*widthBMP + x] = cc + cc << 8 + cc << 16 + 0xff << 24;
      
      return img;
      
     
       
        } catch (IOException ioe) {   
            System.out.println("ssssssssssS");   
        } catch (Exception e) {   
            System.out.println("aaaaaaaaaaa");   
        }

        return null;
   }

    public Image myWrite(Image image, String pathStr) {
        try {
             File imgFile = new File(pathStr);
             BufferedImage bi = new BufferedImage(image.getWidth(null),image.getHeight(null), BufferedImage.TYPE_INT_RGB);
             Graphics2D g = bi.createGraphics();
             g.drawImage(image,0,0,null);
             g.dispose();
             ImageIO.write(bi,"jpg", imgFile);
             return image;
         } catch (Exception e) {

             
         }
      return image;
    }

}
