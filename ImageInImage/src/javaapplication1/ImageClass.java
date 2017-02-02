/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author taher
 */
public class ImageClass {
   public  BufferedImage image  = null ; 
  public   boolean  encry = false;
  public File file ;
  public int width , height ; 
  ImageClass(String path) throws IOException
          {
             file= new File(path); 
             image = ImageIO.read(file); 
             width = image.getWidth(); 
             height = image.getHeight();
             
          }
  void set_encrypt()
  {
   encry = true;    
  }
  
}
