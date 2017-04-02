package map.io;

// Java Library
import java.awt.*;
import java.awt.geom.*;
import java.io.*;
import java.util.*;

// Multimedia Library
import io.*;


/**
 * A class for reading Polygon information using a 
 * ResourceFinder
 *
 *
 * @author  Prof. David Bernstein, James Madison University
 * @version 1.0
 *
 */
public class PolygonReader
{
    private ResourceFinder          finder;    
    

    /**
     * Explicit Value Constructor
     *
     * @param finder   The ResourceFinder to use
     */
    public PolygonReader(ResourceFinder finder)
    {
       this.finder = finder;       
    }
    


    /**
     * Read a Polygon
     *
     * @param  name    The name of the resource containing the polygon
     * @return         A Shape object encapsulating the polygon
     */
    public Shape read(String name) throws IOException
    {
       BufferedReader    reader;
       float             x, y;
       GeneralPath       gp;
       InputStream       is;       
       int               type;
       String            line, token;
       StringTokenizer   tokenizer;


       is = finder.findInputStream(name);
       reader = new BufferedReader(new InputStreamReader(is));
        
       // This implementation uses a GeneralPath so that it will work
       // on OS X.  In  Java 6, you can use a Path2D.Float instead
       gp = new GeneralPath();

       while ( (line = reader.readLine()) != null)
       {
          try
          {
             tokenizer = new StringTokenizer(line, ",");
          
             token = tokenizer.nextToken();
             type  = Integer.parseInt(token);
             
             token = tokenizer.nextToken();
             x     = Float.parseFloat(token);
             
             token = tokenizer.nextToken();
             y     = Float.parseFloat(token);
             
             if (type == 4) gp.moveTo(x, y);
             else           gp.lineTo(x, y);
          }
          catch (NumberFormatException nfe)
          {
             nfe.printStackTrace();
          }
          catch (NoSuchElementException nsee)
          {
             nsee.printStackTrace();
          }
       }
       gp.closePath();       

       return gp;
    }


}
