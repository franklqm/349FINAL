package weather.io;

import java.io.*;
import java.util.*;

import weather.*;

/**
 * A class for reading WeatherObservation information
 * from a BufferedReader
 *
 *
 * @version 1.0
 * @author  CS349, James Madison University
 *
 */
public class WeatherObservationReader extends WeatherDatumReader
{



    /**
     * Explicit Value Constructor
     *
     * @param reader   The BufferedReader to use
     */
    public WeatherObservationReader(BufferedReader reader)
    {
	super(reader);
    }



    /**
     * Read a WeatherObservation
     * Calls the createWeatherObservation method in the WeatherObservation
     * class
     *
     * @return The next WeatherObservation object
     */
    public WeatherDatum readWeatherDatum()  throws IOException,
                                                   NoSuchElementException
    {
	String      line;


	line = reader.readLine();
	if (line == null) return null;

	return WeatherObservation.createWeatherObservation(line);
    }


}
