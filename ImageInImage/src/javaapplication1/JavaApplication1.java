/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import com.sun.xml.internal.fastinfoset.EncodingConstants;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;

/**
 *
 * @author Amr
 */
public class JavaApplication1 { // the class contains a small image to be stored, large image to store into.
public  BufferedImage image=null  , smallimage= null , largeimage=null; // image to be used in encyrption/decryption.
    private String fileContent;      // filecontent that contains text.
    public void Encrypt(String textPath,String imgPath) throws IOException
    {
       
        //Test();
       // HideTextSize();
       
       // Test();

    }
    public void imageinimage()    // this function inserts an image inside a bigger image ..the ja.smallimage into ja.largeimage
            // the large image bits are changed in 3 places ..for example if we have a small image with RGB at pixel x , y.
            // the function takes the R and inserts it into pixels of x , y ...x + x , y + y , .. x+ 2*x , y+ 2*y..thus it stores the 8 bits of R in three
            // R bit-pixels in the larger image.
    { 
        for (int i=0; i<smallimage.getHeight(); i++ )
        {
            for (int j=0; j<smallimage.getWidth(); j++)
            {
                largeimage.setRGB
        (i, j, change(new Color(smallimage.getRGB(i, j)) , (new Color(largeimage.getRGB(i, j))) , 0));
                largeimage.setRGB
        (i, j+smallimage.getWidth(), change(new Color(smallimage.getRGB(i, j)) 
                , (new Color(largeimage.getRGB(i, j+smallimage.getWidth()))) , 1));
                largeimage.setRGB(i, j+smallimage.getWidth()+smallimage.getWidth(), j);
            }
        }
        
        
    }
   public int change (Color small , Color big   , int pick  ) //this is the core function that changes the bits of the large image into bits of small image
           // by using shifting methods 
   {
       int redsmall = small.getRed();  // 1111110
       int greensmall = small.getGreen(); 
       int bluesmall = small.getBlue(); 
       int redbig = big.getRed(); 
       int greenbig=big.getGreen(); 
       int bluebig = big.getBlue(); 
       Color answer; 
       if (pick ==1)
       {
           redsmall = redsmall >> 3; 
           bluesmall = bluesmall >> 3; 
           greensmall = greensmall >>3; 
       }
        if (pick ==2)
       {
           redsmall = (redsmall >> 6 ) & 3 ; 
           bluesmall = (bluesmall >> 6) & 3; 
           greensmall = (greensmall >>6) & 3;
           redbig = redbig & (~3); 
           redbig = redbig | redsmall ; 
           bluebig &= (~3); 
           bluebig|=bluesmall; 
           greenbig = greenbig & (~3); 
           greenbig= greenbig  | greensmall; 
           answer = new Color(redbig , greenbig , bluebig); 
           return answer.getRGB(); 
       }
       redsmall = redsmall & 7 ;  // 00000110 
       redbig = redbig & (~7); 
       redbig = redbig | redsmall;
       
       // 00000110 
        bluesmall = bluesmall & 7 ;  
       bluebig = bluebig & (~7); 
       bluebig = bluebig | bluesmall; 
       
      // 00000110 
       greensmall = greensmall & 7 ;
       greenbig = greenbig & (~7); 
       greenbig= greenbig  | greensmall; 
        answer = new Color(redbig , greenbig , bluebig); 
           return answer.getRGB(); 
   }
  
    public BufferedImage display () // in this function the bits that contains the small image bits are extracted and a buffferedimage is returned
            // this bufferedimage contains the small image that has been used 
    { 
        BufferedImage answer; 
        int rgb,red,blue,green;
        answer = new BufferedImage(smallimage.getWidth(),smallimage.getHeight() , BufferedImage.TYPE_INT_RGB);
        for (int rows =0; rows < smallimage.getHeight(); rows++){
   for (int cols =0; cols <smallimage.getWidth(); cols ++){
       Color c = new Color(largeimage.getRGB(rows, cols));
       
       
       
       red= c.getRed() & 7; 
       green = c.getGreen() & 7 ; 
       blue = c.getBlue() & 7 ; 
        c = new Color(largeimage.getRGB(rows, cols+smallimage.getWidth()));
       
       
       
       red=red | ((c.getRed()  & 7)<<3); 
       green |= ((c.getRed()  & 7)<<3) ; 
       blue |= ((c.getRed()  & 7)<<3) ;
        c = new Color(largeimage.getRGB(rows, cols+smallimage.getWidth()*2));
       
       
       
       red=red | ((c.getRed()  & 3)<<6); 
       green |= ((c.getRed()  & 3)<<6) ; 
       blue |= ((c.getRed()  & 3)<<6) ; 
       Color setter = new Color(red, green, blue);
       answer.setRGB(rows , cols, setter.getRGB());
       /* Display_Red [rows][cols]= final_red_frame[rows][cols].substring(5,3)+final_red_frame[rows][cols+small_width].substring(5,3)+final_red_frame[rows][cols+2*small_width].substring(6,2);
   Display_Green[rows][cols] = final_green_frame[rows][cols].substring(5,3)+final_green_frame[rows][cols+small_width].substring(5,3)+final_green_frame[rows][cols+2*small_width].substring(6,2);
   Display_Blue[rows][cols] = final_blue_frame[rows][cols].substring(5,3)+final_blue_frame[rows][cols+small_width].substring(5,3)+final_blue_frame[rows][cols+2*small_width].substring(6,2);
   */}
   }
        return answer; 
        
    }
    public static BufferedImage resizeImage(BufferedImage originalImage, int type){
	BufferedImage resizedImage = new BufferedImage(500, 500, type);
	Graphics2D g = resizedImage.createGraphics();
	g.drawImage(originalImage, 0, 0, 500, 500, null);
	g.dispose();

	return resizedImage;
    }
    
    public static void main(String[] args) throws IOException
    {
        
        JavaApplication1 ja = new JavaApplication1();  
        File small = new File ("C:\\Users\\Amr\\Desktop\\test.png"); // file of the small image
        ja.smallimage = ImageIO.read(small);  
        File big = new File ("C:\\Users\\Amr\\Desktop\\123.jpg");
        ja.largeimage = ImageIO.read(big); 
        BufferedImage originalImage = ImageIO.read(new File("C:\\Users\\Amr\\Desktop\\123.jpg"));
        int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
        
       //up we use file funcitons to create buffered objects containing the small and large image to be used.
        ja.imageinimage();
        BufferedImage answer= null; 
        answer= ja.display();
       // answer = resizeImage(originalImage, type);
        File out = new File ("C:\\Users\\Amr\\Desktop\\saved.jpg");  // place to produce the result image from display function .
         ImageIO.write(ja.largeimage, "jpg", out);
      System.out.println();
      
     
    
    }
    
}
