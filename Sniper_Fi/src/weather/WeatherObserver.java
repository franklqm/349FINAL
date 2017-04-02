package weather;

/**
 * Requirements of an object that is informed of 
 * new/changed WeatherDatum objects
 *
 * @author  Prof. David Bernstein, James Madison University
 * @version 1.0
 */
public interface WeatherObserver
{
    /**
     * Handle a new/changed WeatherDatum object
     *
     * @param weather   The new/changed WeatherDatum object
     */
    public abstract void handleWeatherDatum(WeatherDatum weather);    
}
