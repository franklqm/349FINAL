package weather.visual;

import java.awt.*;
import java.io.*;
import java.util.*;

// Multimedia Library
import io.*;
import visual.statik.sampled.*;

/**
 * A factory for creating weather icons
 *
 * @author  Prof. David bernstein, James Madison University
 * @version 1.0
 */
public class WeatherIconReader
{
    private ResourceFinder       finder;
    
    private static final String[] IMAGE_NAMES = {"PartlyCloudy","Rainy",
                                                 "Snowy","Sunny"};


    /**
     * Explicit Value Constructor
     *
     * @param finder   The ResourceFinder to use
     */
    public WeatherIconReader(ResourceFinder finder)
    {
       this.finder = finder;       
    }    


   /**
     * Read a collection of weather icons
     *
     * @return      A HashMap containing the icons
     */
    public HashMap<String,Image> read() throws IOException
    {
       HashMap<String,Image>   images;       
       Image                   image;       
       ImageFactory            imageFactory;
       
              
       images = new HashMap<String,Image>();
       imageFactory = new ImageFactory(finder);       

       for (int i=0; i<IMAGE_NAMES.length; i++)
       {
          image = imageFactory.createBufferedImage(IMAGE_NAMES[i]+".png",4);
          if (image != null) images.put(IMAGE_NAMES[i], image);             
       }      

       return images;       
    }
    
}
