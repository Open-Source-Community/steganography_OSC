/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steganography.pkg01;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 *
 * @author Millennium
 */
public class ImageManager {  // this class for reading an image from a specified file
                             // and returns that image in a bufferedimage variable form.
    
    public static  BufferedImage GetImage(String imagePath) throws IOException
    {
        File file = new File(imagePath);
        BufferedImage image = null;
        image = ImageIO.read(file);
        return image;
    }
}
