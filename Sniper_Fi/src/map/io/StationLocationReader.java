package map.io;

import java.awt.*;
import java.awt.geom.*;
import java.io.*;
import java.util.*;

import io.*;


/**
 * A class for reading weather station location information 
 *
 *
 * @version 1.0
 * @author  CS349, James Madison University
 */
public class StationLocationReader
{
    private ResourceFinder       finder;
    

    /**
     * Explicit Value Constructor
     *
     * @param finder2   The ResourceFinder to use
     */
    public StationLocationReader(ResourceFinder finder2)
    {
       this.finder = finder2;       
    }
    


    /**
     * Read a map of weather station locations
     *
     * @param name  The name of the resource
     * @return      A HashMap containing weather station locations
     */
    public HashMap<String,Point2D> read(String name) throws IOException
    {
       BufferedReader             reader;       
       HashMap<String,Point2D>    map;        
       int                        x, y;
       Point2D                    p;
       String                     code, line, token;
       StringTokenizer            tokenizer;

        
       reader = new BufferedReader(
                    new InputStreamReader(finder.findInputStream(name)));
       map = new HashMap<String,Point2D>();
       while ((line=reader.readLine()) != null)
       {
          tokenizer = new StringTokenizer(line, ",");

          try
          {
             code  = tokenizer.nextToken();

             token = tokenizer.nextToken();
             x = Integer.parseInt(token);
               
             token = tokenizer.nextToken();
             y = Integer.parseInt(token);
               
             p = new Point2D.Double(x, y);

             map.put(code, p);
          }
          catch (NoSuchElementException nsee)
          {
             nsee.printStackTrace();               
          }
          catch (NumberFormatException nfe)
          {
             nfe.printStackTrace();               
          }            
       }

       return map;
    }

}
