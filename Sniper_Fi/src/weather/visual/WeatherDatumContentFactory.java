package weather.visual;


// Java Library
import java.awt.*;
import java.awt.geom.*;
import java.io.*;
import java.util.*;


// WeatherBitmaps Library
import weather.*;


/**
 * A factory that can be used to construct WeatherDatumContent objects
 *
 * @author  Prof. David Bernstein, James Madison University
 * @version 1.0
 */
public class WeatherDatumContentFactory
{
    private HashMap<String, Image>   images;
    private HashMap<String,Point2D>  locations;


    /**
     * Explicit Value Constructor
     *
     * @param locations   The locations of the weather stations
     * @param images      The Image objects associated with weather conditions
     */
    public  WeatherDatumContentFactory(HashMap<String,Point2D> locations,
                                       HashMap<String,Image>   images)
    {
       this.locations = locations;
       this.images    = images;
    }
    
    /**
     * Create a WeatherDatumContent
     *
     * @param datum   The relevant WeatherDatum object
     * @param color   The Color to use for the text
     */
    public WeatherDatumContent createContent(WeatherDatum datum, Color color)
    {
       Image     image;       
       Point2D   location;       
       
       location  = locations.get(datum.getLocation());
       image     = images.get(datum.getCondition());

       return new WeatherDatumContent(datum, color, 
                                      location, image);
       
    }
}
