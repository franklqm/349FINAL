package weather;

import java.util.*;
import java.util.concurrent.*;


/**
 * A type safe ordered collection of WeatherDatum objects. 
 *
 * @author  Prof. David Bernstein, James Madison University
 * @version PA3
 */
public class WeatherPattern implements Iterable<WeatherDatum>, WeatherSubject
{
    protected String                   description;
    protected List<WeatherDatum>       data;
    protected List<WeatherObserver>    observers;
    

    /**
     * Default Constructor
     */
    public WeatherPattern()
    {
	this("");
    }

    /**
     * Explicit Value Constructor
     *
     * Note: The description must follow a specific format.
     *
     *
     * @param description  A description of the WeatherPattern 
     */
    public WeatherPattern(String description)
    {
       // A CopyOnWriteArrayList is used so that the underlying
       // collection can be changed without causing a 
       // ConcurrentModificationException when using the Iterator
       data      = new CopyOnWriteArrayList<WeatherDatum>();
       
       // A CopyOnWriteArrayList is used so that 
       // observers can be notified while the collection is being modified
       observers = new CopyOnWriteArrayList<WeatherObserver>();        

       this.description = description;
    }

    /**
     * Add an element to the end of this WeatherPattern
     *
     * @param element   The element to add
     */
    public void addElement(WeatherDatum element)
    {
	data.add(element);
        notifyObservers(element);        
    }

    /**
     * Add a WeatherObserver to the list of observers
     * (required by WeatherSubject)
     *
     * @param observer   The WeatherObserver to add
     */
    public void addObserver(WeatherObserver observer)
    {
          observers.add(observer);
    }
 
    /**
     * Get the description of this WeatherPattern
     *
     * @return  The description
     */
    public String getDescription()
    {
	return description;
    }

    /**
     * Get a WeatherDatum in this WeatherPattern
     *
     * @param  index   The index of the WeatherDatum
     * @return         The WeatherDatum
     */
    public WeatherDatum getElement(int index)
    {
	return data.get(index);
    }

    /**
     * Returns an Iterator of the elements of this WeatherPattern
     *
     * @return    The Iterator of the elements
     */
    public Iterator<WeatherDatum> iterator()
    {
	return data.iterator();
    }

    /**
     * Notify all registered WeatherObserver objects of a 
     * new/changed Weather object (required by WeatherSubject).
     *
     * @param weather   The new/changed WeatherDatum
     */
    public void notifyObservers(WeatherDatum weather)
    {
        WeatherObserver               observer;       
        Iterator<WeatherObserver>     i;

        i = observers.iterator();
        while (i.hasNext())
        {
            observer = i.next();
            observer.handleWeatherDatum(weather);          
        }
    }

    /**
     * Remove a WeatherObserver to the list of observers
     * (required by WeatherSubject)
     *
     * @param observer   The WeatherObserver to remove
     */
    public void removeObserver(WeatherObserver observer)
    {
          observers.remove(observer);       
    }

    /**
     * Get the size of this WeatherPattern
     *
     * @return  The size
     */
    public int size()
    {
       return data.size();       
    }
}
    
