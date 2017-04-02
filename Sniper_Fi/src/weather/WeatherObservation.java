package weather;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;


/**
 * An observation of weather conditions for a particular location
 *
 * @version 1.0
 * @author  CS349, James Madison University
 *
 */
public class WeatherObservation extends WeatherDatum
{
    protected Temperature           temperature;    
    

    /**
     * Default Constructor
     */
    public WeatherObservation()
    {
       this("XXX", "Unknown", new Temperature(0.0));
    }


    /**
     * Explicit Value Constructor
     *
     * @param location       The location
     * @param condition      The weather condition (e.g., "Sunny")
     * @param temperature    The temperature
     */
    public WeatherObservation(String location, String condition, 
                              Temperature temperature)
    {
       super(location, condition);

       this.temperature = temperature;       
    }



    /**
     * Create a WeatherObservation object from a String representation
     *
     * @param s   The String representation
     * @return    A new WeatherObservation object
     */
    public static WeatherObservation createWeatherObservation(String s)
    {
       WeatherObservation    wo;

       wo = new WeatherObservation();
       wo.fromString(s);

       return wo;
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


       temp        = tokenizer.nextToken();       
       temperature = Temperature.createTemperature(temp);

       return tokenizer;
    }

    /**
     * Return the temperature
     *
     * @return    The temperature
     */
    public Temperature getTemperature()
    {
       return temperature;
    }

    /**
     * Get either a verbose or terse String representation of this 
     * WeatherDatum.
     *
     * The terse representation is in a format that can be
     * processed by the fromString() method.  The verbose representation
     * is tab-delimited and includes descriptions of the various 
     * attributes (e.g., "Temperature: 75")
     *
     * @param   verbose   true for a verbose String; false for a terse String
     * @return            The String representation
     */
    public String toString(boolean verbose)
    {
       String    result;

       result = super.toString(verbose);

       if (verbose) result += "\t" + "Temperature:  " + temperature;
       else         result += "," + temperature;
       
       return result;
    }
}
