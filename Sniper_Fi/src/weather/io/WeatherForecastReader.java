package weather.io;

import java.io.*;
import java.util.*;

import weather.*;

/**
 * A class for reading WeatherForecast information
 * from a BufferedReader
 *
 * @author  Prof. David Bernstein, James Madison University
 * @version 1.0
 *
 */
public class WeatherForecastReader extends WeatherDatumReader
{



    /**
     * Explicit Value Constructor
     *
     * @param reader   The BufferedReader to use
     */
    public WeatherForecastReader(BufferedReader reader)
    {
	super(reader);
    }



    /**
     * Read a WeatherForecast
     * (Uses the createWeatherForecast method in the WeatherForecast class)
     *
     * @return The next WeatherForecast object
     */
    public WeatherDatum readWeatherDatum()  throws IOException,
                                                   NoSuchElementException
    {
	WeatherForecast   wf;
	String            line;


	line = reader.readLine();
	if (line == null) return null;

	return WeatherForecast.createWeatherForecast(line);
    }


}
