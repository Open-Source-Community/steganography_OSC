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
public class DecryptionManager {
    private BufferedImage image=null;
    public String outputText="";
    public void Decrypt(String imagePath) throws IOException
    {
       image =ImageManager.GetImage(imagePath);
        //Test();
       GetTextFromImage();
      // Test();
    }
 
    private void GetTextFromImage() { // decrytion is done over here... a loop over the image pixels and a function is called to extract
        //characrers from each pixel..characters are stored after each other. the character extracted is then changed from integar to char.
        // a delimeter "#" is used to specify the end of the text.
       int counter =0 ; 
       boolean checker = true; 
        for(int i=0;i<image.getHeight();i++) 
        {
            for (int j=0; j<image.getWidth(); j++)
            {
            Color color = new Color(image.getRGB(i, j));
            int value = GetCharacterFromPixel(color);
            
            char value2= (char) value; 
            if (value2 == '#')
                counter++; 
            if (counter==2)
            {
                checker = false; 
                break;
            }
            outputText+=value2;
        }
            if (checker == false)
                break;
        }
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 private char GetCharacterFromPixel(Color color)// a conversion of bits to character
 {
     
    int r=color.getRed();
    int g=color.getGreen();
    int b=color.getBlue();
    
    int rr=r&(7);
    int gg=g&(7);
    int bb=b&(3);
    /*System.out.println(Integer.toBinaryString(rr)+" "+
            Integer.toBinaryString(gg)+" "+
            Integer.toBinaryString(bb));
*/
    int res=rr|(gg<<3)|(bb<<6);
    System.out.println(Integer.toBinaryString(res));
     return (char)res;
 }
 
}
