package weather;

import java.awt.Image;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;


/**
 * An abstract piece of weather information
 *
 *
 * @version 1.0
 * @author  CS349, James Madison University
 *
 */
public abstract class WeatherDatum
{
    protected String              condition, location;


    /**
     * Default Constructor
     */
    private WeatherDatum()
    {
       this("XXX","Unknown");
    }
    


    /**
     * Common explicit value constructor for all derived classes
     *
     * @param location       The location
     * @param condition      The weather condition (e.g., "Sunny")
     */
    public WeatherDatum(String location, String condition)
    {
       this.location  = location;
       this.condition = condition;
    }



    /**
     * Return the weather condition
     *
     * @return    The condition
     */
    public String getCondition()
    {
       return condition;
    }


    
    /**
     * Return the location
     *
     * @return    The location
     */
    public String getLocation()
    {
       return location;
    }



    /**
     * Parse a String representation of a WeatherDatum into 
     * its components.  This is only useful for derived classes.
     *
     * This method is used by static methods that create WeatherDatum
     * objects (e.g., createWeatherForecast).
     *
     * @param s    The String representation
     * @return     The StringTokenizer used (in case more parsing is needed)
     */
    protected StringTokenizer fromString(String s) throws 
                                                   NoSuchElementException
    {
       StringTokenizer  tokenizer;

       tokenizer = new StringTokenizer(s,",");

       location  = tokenizer.nextToken();
       condition = tokenizer.nextToken();

       return tokenizer;
    }


    /**
     * Get either a verbose or terse String representation of this 
     * WeatherDatum.
     *
     * The terse representation is in a format that can be
     * processed by the fromString() method.  The verbose representation
     * is tab-delimited and includes descriptions of the various 
     * attributes (e.g., "Location: CVA01    Condition: Sunny")
     *
     * @param   verbose   true for a verbose String; false for a terse String
     * @return            The String representation
     */
    public String toString(boolean verbose)
    {
       String    result;
       
       result = "";       
       if (verbose)
       {
          result +=        "Location:  " + location;
          result += "\t" + "Condition: " + condition;
       }
       else
       {
          result +=       location;
          result += "," + condition;
      }
       
       return result;
    }


    /**
     * Return a terse String representation of this WeatherDatum
     *
     * @return   The String representation
     */
    public String toString()
    {
       return toString(false);
    }
}
