/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steganography.pkg01;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**d
 *
 * @author Millennium
 */
public class FileManager {   // this class reads a file to be used as the text 
                             // and returns it in a string with the data to be used in hiding.
    
    
    public static String ReadFile(String filePath) throws IOException
    {
        File f = new File(filePath);
        byte[] bytes = Files.readAllBytes(f.toPath());
        return new String(bytes,"UTF-8");
    }
}
