package weather.io;

// Java Library
import java.io.*;
import java.util.*;

// Multimedia Library
import io.*;

// WeatherBits Library
import weather.*;


/**
 * A class that can be used to read weather patterns
 *
 * @author  Prof. David Bernstein, James Madison University
 * @version PA5
 */
public class WeatherPatternReader
{
    private ResourceFinder          finder;
    

    /**
     * Default Constructor
     */
    public WeatherPatternReader()
    {
       this(null);       
    }


    /**
     * Explicit Value Constructor
     *
     * @param finder  The ResourceFinder to use to find the WeatherPattern
     */
    public WeatherPatternReader(ResourceFinder finder)
    {
       this.finder = finder;       
    }

    /**
     * Read WeatherDatum objects from a file into an existing WeatherPattern
     *
     * @param date          The date (e.g., "30August2010" or "current")
     * @param type          The type ("for" or "obs")
     * @param pattern       The WeatherPattern to add the Flow objects to
     */
    public void read(String         date, 
                     String         type, 
                     WeatherPattern pattern) throws IOException
    {
       BufferedReader           br;       
       InputStream      is;       
       String                   fn;
       WeatherDatumReader       in;       
       
       // Construct the Reader
       fn = date + "." + type;

       if (finder == null)
          br = new BufferedReader(new FileReader(fn));
       else
       {
          is = finder.findInputStream(fn);
          if (is == null) throw(new IOException());          
          br = new BufferedReader(new InputStreamReader(is));
       }
        

       if (type.equals("for"))
          in = new WeatherForecastReader(br);
       else
          in = new WeatherObservationReader(br);

       
       // Read the WeatherPattern
       in.readWeatherPattern(pattern);

       // Close the BufferedReader
       br.close();             
    }
    

    /**
     * Read WeatherDatum objects from a file into a new WeatherPattern
     *
     * @param date          The date (e.g., "30August2010" or "current")
     * @param type          The type ("for" or "obs")
     * @param description   The description
     * @return              A WeatherPattern containing the WeatherDatum objects
     */
    public WeatherPattern read(String date, 
                               String type,
                               String description) throws IOException
    {
       WeatherPattern          pattern;

       pattern = new WeatherPattern(description);
       read(date, type, pattern);       

       return pattern;       
    }
    
}
