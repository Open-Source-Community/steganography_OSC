/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steganography.pkg01;


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 *
 * @author Millennium
 */

public class EncryptionManager {
    
    private BufferedImage image=null  , smallimage= null , largeimage=null; // image to be used in encyrption/decryption.
    private String fileContent;      // filecontent that contains text.
    public void Encrypt(String textPath,String imgPath) throws IOException
    {
        fileContent=FileManager.ReadFile(textPath);
        image = ImageManager.GetImage(imgPath); 
        
       
       // HideTextSize();
        HideTextInsideImage();
       // Test();

    }
   
  
    public BufferedImage GetEncryptedImage() // returns an image.
    {
        return this.image;
    }
    public BufferedImage display ()
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
        return null ; 
        
    }
   
    private void HideTextInsideImage() // in this function we loop over the text size and store each character in a pixel (encryption)
    {
        int imageWidth = image.getWidth();
        int imageHeight = image.getHeight();
        int textSize= fileContent.length(),idx=0; // idx is a counter to count till the text ends.
        
  
        for (int i=0 ; i<imageWidth && idx<textSize; i++)
        {
	    for (int j=0 ; j<imageHeight && idx<textSize; j++)
            {
                
               image.setRGB(i, j,GetNewRGB(new Color(image.getRGB(i, j))
                                ,fileContent.charAt(idx)));
               idx++; 
            }
         
          
        }   	
    }
    private int GetNewRGB(Color color,char c) // in this function a character from the text is taken and changed to integar value
            // then it is changed into bits and stored inside a pixel ..it is then called up 
    {
        
        System.out.println("is this infinity dude ?"); 
        String s =Integer.toBinaryString((int)c);
        
        while(s.length()!=8)
        {
           s='0'+s;
        }
       int binarystring = c;
       int red = color.getRed(); 
       int green = color.getGreen(); 
       int blue = color.getBlue(); 
       int temp = binarystring ; 
       temp = temp & (7); 
       red = red & (~7); 
       red = red | temp ; 
       
       temp = binarystring ; 
       temp = temp >> 3; 
       temp = temp & (7); 
        green = green & (~7); 
        green = green | temp ; 
        
        temp = binarystring ; 
        temp = temp >> 6; 
        temp = temp & 3; 
        blue = blue & (~3); 
        blue = blue | temp; 
        
       
        System.out.println(s);
        String rr="",gg="",bb="";
        int size=s.length()-1;
        int r=color.getRed(),
            g=color.getGreen(),
            b=color.getBlue();
        // 01100001;
         for (int i = size;i>size-3 ; i--)
        {
            rr=s.charAt(i)+rr;
        }
        for(int i=size-3;i>size-6;i--)
        {
            gg=s.charAt(i)+gg;
        }
        for(int i=size-6;i>=0;i--)
        {
            bb=s.charAt(i)+bb;
        }
         r=Integer.parseInt(rr, 2);
         g=Integer.parseInt(gg, 2);
         b=Integer.parseInt(bb, 2);
  /*
/*int edit =(((int)c)&7)+((((int)c)&(7<<3))<<5)+((((int)c)&(3<<6))<<10);
 return (pixil&(~(7+(7<<8)+(3<<16))))+edit;*/
	/*
	//gets the first three bits of the character
        rr=((int)c&7);
        //gets the second three bits of the character
        gg=((int)c&(7<<3));
        //gets the last two bits of the charater
        bb=((int)c&(3<<6));
        
        // clear already used bits
        r=r&(~7);
        g=g&(~7);
        b=b&(~3);
        
        // add new bits
        r=r+rr;
        g=g+gg;
        b=b+bb;
        
        Color newColor = new Color(r,g,b);
        
	return newColor.getRGB();
*/
         Color answer= new Color(red, green , blue);
          System.out.println("yes it is!"); 
        return answer.getRGB(); 
 
    }
private int  StringToInt(String s)
{
    
    return 0; 
}
    private void HideTextSize() {
        
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

 
