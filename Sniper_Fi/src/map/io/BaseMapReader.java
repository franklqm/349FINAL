package map.io;

// Java Library
import java.awt.*;
import java.awt.geom.*;
import java.io.*;
import java.util.*;

// Multimedia Library
import io.*;
import visual.statik.described.*;

// WeatherBitmaps Library


/**
 * A class for reading BaseMap information
 * from a BufferedReader
 *
 *
 * @author  Prof. David Bernstein, James Madison University
 * @version 1.0
 *
 */
public class BaseMapReader
{
    private PolygonReader  reader;    
    

    /**
     * Explicit Value Constructor
     *
     * @param finder   The ResourceFinder to use
     */
    public BaseMapReader(ResourceFinder finder)
    {
       this.reader = new PolygonReader(finder);       
    }
    


    /**
     * Read a BaseMap
     *
     * @param  name    The name of the map
     * @return         A Content object encapsulating the BaseMap
     */
    public Content read(String name) throws IOException
    {
       Content           map;       
       Shape             polygon;
       
       polygon = reader.read(name);

       map   = new Content(polygon, 
                           Color.BLACK, Color.WHITE, new BasicStroke());
       map.setLocation(0,0);

       return map;
    }


}
