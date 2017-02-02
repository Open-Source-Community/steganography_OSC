/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  javaapplication1;;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author taher
 */
public class JavaApplication1 {
public  BufferedImage image=null  , smallimage= null , largeimage=null , result = null; // image to be used in encyrption/decryption.
      
  
    public void imageinimage()    // this function inserts an image inside a bigger image ..the ja.smallimage into ja.largeimage
            // the large image bits are changed in 3 places ..for example if we have a small image with RGB at pixel x , y.
            // the function takes the R and inserts it into pixels of x , y ...x + x , y + y , .. x+ 2*x , y+ 2*y..thus it stores the 8 bits of R in three
            // R bit-pixels in the larger image.
    { 
        for (int i=0; i<smallimage.getWidth(); i++ )
        {
            for (int j=0; j<smallimage.getHeight(); j++)
            {
                largeimage.setRGB
        (i, j, change(new Color(smallimage.getRGB(i, j)) , (new Color(largeimage.getRGB(i, j))) , 0));
                
                
                largeimage.setRGB
        (i, j+smallimage.getHeight(), change(new Color(smallimage.getRGB(i, j)) 
                , (new Color(largeimage.getRGB(i, j+smallimage.getHeight()))) , 1));
                
                
                largeimage.setRGB(i, j+smallimage.getHeight()+smallimage.getHeight(), change(new Color(smallimage.getRGB(i, j)) 
                ,(new Color(largeimage.getRGB(i, j+smallimage.getHeight()+smallimage.getHeight()))) , 2)); // wtf is j over here ????
            }
        }
        
        
    }
   
   public int change (Color small , Color big   , int pick  ) //this is the core function that changes the bits of the large
           //image into bits of small image
           // by using shifting methods 
   {
       int redsmall = small.getRed(); 
       int greensmall = small.getGreen(); 
       int bluesmall = small.getBlue(); 
       int redbig = big.getRed(); 
       int greenbig=big.getGreen(); 
       int bluebig = big.getBlue(); 
       Color answer; 
       // pick is used to identify wether we are gonna take the first 3 bits , pick =0, or 3 bits in middle
       // then pick =1 , or the last 2 bits , pick =2 in the smallimage pixels
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
           bluebig =bluebig & (~3); 
           bluebig=bluebig | bluesmall; 
           greenbig = greenbig & (~3); 
           greenbig= greenbig  | greensmall; 
           answer = new Color(redbig , greenbig , bluebig , 255); 
           return answer.getRGB();   
       }
        // if the pick == to 2 then the function will return and will not execute the part below
        
       redsmall = redsmall & 7 ;   
       redbig = redbig & (~7); 
       redbig = redbig | redsmall;
       
      
        bluesmall = bluesmall & 7 ;  
       bluebig = bluebig & (~7); 
       bluebig = bluebig | bluesmall; 
       
     
       greensmall = greensmall & 7 ;
       greenbig = greenbig & (~7); 
       greenbig= greenbig  | greensmall; 
        answer = new Color(redbig , greenbig , bluebig , 255); 
           return answer.getRGB(); 
   }
  
    public BufferedImage display () // in this function the bits that contains the 
   //small image bits are extracted and a buffferedimage is returned as an answer 
            // this bufferedimage contains the small image that has been used 
    { 
        
        BufferedImage answer; 
        int red,blue,green;
        
        answer = new BufferedImage(smallimage.getWidth(),smallimage.getHeight(), smallimage.TYPE_INT_RGB);
        
        result  = new BufferedImage(smallimage.getWidth(),smallimage.getHeight(), smallimage.TYPE_INT_RGB);
       
        for (int rows =0; rows < smallimage.getWidth(); rows++){
   for (int cols =0; cols <smallimage.getHeight(); cols ++){
       Color c = new Color(largeimage.getRGB(rows, cols));
       
       
       red = (c.getRed() & 7 ) ;
       green = c.getGreen() & 7 ; 
       blue = c.getBlue() & 7; 
       
      
        c = new Color(largeimage.getRGB(rows, cols+smallimage.getHeight()));
       
       
       
       red=red | ((c.getRed()  & 7)<<3); 
       green |= ((c.getGreen()  & 7)<<3) ; 
       blue |= ((c.getBlue()  & 7)<<3) ;
        c = new Color(largeimage.getRGB(rows, cols+smallimage.getHeight()*2));
       
       
       
       red=red | ((c.getRed()  & 3)<<6); 
       green |= ((c.getGreen()  & 3)<<6) ; 
       blue |= ((c.getBlue()  & 3)<<6) ; 
       Color setter = new Color(red, green, blue);
       setter=new Color(red, green, blue, 255);
       
       answer.setRGB(rows , cols, setter.getRGB());
       result.setRGB(rows , cols, setter.getRGB());
       
      
   }
   }
        return answer; 
        
    }
    
    
    
    public static void main(String[] args) throws IOException {
        JavaApplication1 ja = new JavaApplication1();  // an object from the class we called it ja.
        File small = new File ("/home/taher/Desktop/mohab_small.jpg"); // file of the small image
        ja.smallimage = ImageIO.read(small);  // reading the small image to be hided
        File big = new File ("/home/taher/Desktop/huge.jpg"); // file of the big image
        BufferedImage testo = ImageIO.read(big); // reading the image that will act as a storage image for our secret small image
        ja.largeimage = ImageIO.read(big); 
       
      
        ja.imageinimage(); // stores the small image in the large one
        BufferedImage answer= null; 
        BufferedImage test = null ; 
        answer= ja.display();
     
        
        
        File out = new File ("/home/taher/Desktop/secret_image.jpg"); 
        File ou2t = new File ("/home/taher/Desktop/big_image.jpg");
          
         
         ImageIO.write(answer, "jpg", out);
         ImageIO.write(ja.largeimage, "jpg", ou2t);
         System.out.println();
        
    
      
        
       
         
     
    }
    
}
 