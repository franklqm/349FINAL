package weather;


/**
 * An encapsulation of a temperature that includes degrees
 * and units/scale (e.g., Celsius or Fahrenheit).
 *
 * @version 1.0
 * @author  Prof. David Bernstein, James Madison University
 */
public class Temperature implements Comparable<Temperature>
{
    private Scale  scale;
    private double degrees;


    /**
     * Default Constructor
     */
    public Temperature()
    {
       this(0.0, Scale.F);
    }


    /**
     * Explicit Value Constructor
     *
     * @param degrees   The number of degrees (in Fahrenheit)
     */
    public Temperature(double degrees)
    {
       this(degrees, Scale.F);
    }


    /**
     * Explicit Value Constructor
     *
     * @param degrees   The number of degrees
     * @param scale     The scale (e.g., "C" or "F")
     */
    public Temperature(double degrees, String scale)
    {
       this(degrees, Scale.parseScale(scale));
    }


    /**
     * Explicit Value Constructor
     *
     * @param degrees   The number of degrees
     * @param scale     The scale (e.g., Scale.C or Scale.F)
     */
    public Temperature(double degrees, Scale scale)
    {
       this.degrees = degrees;
       this.scale   = scale;       

       if (this.scale == null) this.scale = Scale.F;       
    }



    /**
     * Create a Temperature object from a String representation
     *
     * @param  s   The String representation (e.g., 32.0F or 100.0C)
     * @return     A new Temperature object
     */
    public static Temperature createTemperature(String s)
    {
       Temperature   temp;


       temp = new Temperature();
       temp.fromString(s);

       return temp;
    }



    /**
     * Compares this Temperature to another Temperature
     *
     * @param other   The other Temperature
     * @return        1 if this > other, -1 if this < other, 0 if ==
     */
    public int compareTo(Temperature other)
    {
       double     thisF, otherF;
       int        comp;


       thisF  = getDegrees(Scale.F);
       otherF = other.getDegrees(Scale.F);

       comp = 0;
       if      (thisF > otherF) comp =  1;
       else if (thisF < otherF) comp = -1;

       return comp;
    }



    /**
     * Decrease this temperature by the given temperature
     * (accounting for scale differences)
     *
     * @param amount   The amount of the decrease
     */
    public void decreaseBy(Temperature amount)
    {
       degrees -= amount.getDegrees(scale);
    }


    /**
     * Parse a String representation of a Temperature (and stores the
     * values in this Temperature).  If there is a problem with the
     * String representation, leave this String unchanged.
     *
     * @param  s   The String representation
     */
    private void fromString(String s)
    {
       int      endIndex;
       Scale    t;       
       String   sScale, sTemperature;
       


       endIndex = s.length() - 1;

       sScale       = s.substring(endIndex);
       sTemperature = s.substring(0, endIndex);
       t            = Scale.parseScale(sScale);
       
       if (t != null)
       {
          try 
          {
             degrees = Double.parseDouble(sTemperature);
             scale   = t;
          } 
          catch (NumberFormatException nfe) 
          {
             // Don't change the degrees
          }
       }
    }


    /**
     * Get the degrees in the requested scale
     *
     * @param scale   The scale to use
     * @return        The temperature in the requested scale
     */
    private double getDegrees(Scale scale)
    {
       double        t;

       t = 0.0;
       if      (scale == this.scale) t = degrees;
       else if (scale == Scale.C)    t = 5.0/9.0 * (degrees - 32.0); // F to C
       else if (scale == Scale.F)    t = 9.0/5.0 * degrees + 32.0;   // C to F

       return   t;
    }


    /**
     * Increase this temperature by the given temperature
     * (accounting for scale differences)
     *
     * @param amount   The amount of the increase
     */
    public void increaseBy(Temperature amount)
    {
       degrees += amount.getDegrees(scale);
    }


    /**
     * Return a String representation of this Temperature
     * (using its scale)
     *
     * @return  The String representation
     */
    public String toString()
    {
       return toString(this.scale);
    }



    /**
     * Return a String representation of this Temperature
     * using the given scale
     *
     * @param  scale The scale to use
     * @return       The String representation
     */
    public String toString(Scale scale)
    {
       String      s;

       s = "" + getDegrees(scale) + scale.toString();
       return s;
    }
}
