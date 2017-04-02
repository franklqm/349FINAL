package weather;

import java.awt.*;
import java.util.*;




/**
 * A weather forecast
 *
 *
 * @version 1.0
 * @author  CS349, James Madison University
 *
 */
public class WeatherForecast extends WeatherDatum
{
    protected Temperature       high, low;
    

    /**
     * Default Constructor
     */
    public WeatherForecast()
    {
       this("XXX", "Unknown", new Temperature(0.0), new Temperature(0.0));
    }


    /**
     * Explicit Value Constructor
     *
     * @param location       The location
     * @param condition      The weather condition (e.g., "Sunny")
     * @param low            The forecasted low Temperature
     * @param high           The forecasted high Temperature
     */
    public WeatherForecast(String location, String condition,
                           Temperature low, Temperature high)
    {
       super(location, condition);

       this.low  = low;
       this.high = high;
    }



    /**
     * Create a WeatherForecast object from a String representation
     *
     * @param s   The String representation
     * @return    A new WeatherForecast object
     */
    public static WeatherForecast createWeatherForecast(String s)
    {
       WeatherForecast   wf;


       wf = new WeatherForecast();
       wf.fromString(s);

       return wf;
    }



    /**
     * Parse a String representation of a WeatherForecast into 
     * its components.
     *
     * This method is used by static methods that create Flow
     * objects (e.g., createWeatherForecast).
     *
     * @param s    The String representation
     * @return     The StringTokenizer used (in case more parsing is needed)
     */
    protected StringTokenizer fromString(String s) 
                              throws NoSuchElementException
    {
       String           temp;       
       StringTokenizer  tokenizer;

       // Call the parent's fromString method to parse the
       // common elements
       tokenizer = super.fromString(s);

       temp  = tokenizer.nextToken();
       low   = Temperature.createTemperature(temp);

       temp  = tokenizer.nextToken();
       high  = Temperature.createTemperature(temp);

       return tokenizer;
    }



    /**
     * Return the forecasted high temperature
     *
     * @return    The high temperature
     */
    public Temperature getHigh()
    {
       return high;
    }
 



    /**
     * Return the forecasted low temperature
     *
     * @return    The low temperature
     */
    public Temperature getLow()
    {
       return low;
    }
 
    /**
     * Get either a verbose or terse String representation of this 
     * WeatherDatum.
     *
     * The terse representation is in a format that can be
     * processed by the fromString() method.  The verbose representation
     * is tab-delimited and includes descriptions of the various 
     * attributes (e.g., "Low: 75   High: 89")
     *
     * @param   verbose   true for a verbose String; false for a terse String
     * @return            The String representation
     */
    public String toString(boolean verbose)
    {
       String    result;

       result = super.toString(verbose);

       if (verbose)
       {
          result += "\t" + "Low:  " + low;
          result += "\t" + "High: " + high;
       }
       else
       {
          result += "," + low;
          result += "," + high;
      }
       
       return result;
    }
}
