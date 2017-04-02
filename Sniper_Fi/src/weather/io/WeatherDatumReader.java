package weather.io;

import java.io.*;
import java.util.*;

import weather.*;

/**
 * An abstract class for reading WeatherDatum information
 * from a BufferedReader
 *
 * @author  Prof. David Bernstein, James Madison University
 * @version 1.0
 *
 */
public abstract class WeatherDatumReader
{
    protected BufferedReader   reader;


    /**
     * Explicit Value Constructor  (called by the constructor of a
     * a derived class)
     */
    public WeatherDatumReader(BufferedReader reader)
    {
	this.reader = reader;
    }





    /**
     * Read a WeatherDatum
     *
     * @return The next WeatherDatum object
     */
    public abstract WeatherDatum readWeatherDatum() throws 
                                                    IOException,
                                                    NoSuchElementException;



    /**
     * Read all (until the BufferedReader returns null) WeatherDatum
     * objects into the given WeatherPattern.
     *
     * Note: This method uses the readWeatherDatum() method of the derived
     * class.
     *
     * @param pattern  The WeatherPattern to read into
     */
    public void readWeatherPattern(WeatherPattern pattern) throws IOException,
                                                          NoSuchElementException
    {
	WeatherDatum          w;


	while ( (w=readWeatherDatum()) != null) 
        {
	    pattern.addElement(w);
	}
    }
}
