package weather.visual;

// Java
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;

// Multimedia
import visual.*;
import visual.statik.*;

// Weatherbits
import weather.*;

/**
 * A visual.statik.SimpleContent object that presents the information in
 * a WeatherDatum object
 *
 * @author  Prof. David Bernstein, James Madison University
 * @version 1.0
 */
public class      WeatherDatumContent 
       implements SimpleContent
{

    protected Color          color;
    protected Image          image;    
    protected Point2D        location;
    protected WeatherDatum   datum;
    
    

    private static final Font FONT = new Font(Font.SANS_SERIF, Font.PLAIN, 14);

    /**
     * Explicit Value Constructor
     *
     * @param datum    The WeatherDatum
     * @param color    The Color to use for the text
     * @param location The location of this content
     * @param Image    The Image to use
     */
    public WeatherDatumContent(WeatherDatum datum, Color color, 
                               Point2D location, Image image)
    {
       this.datum    = datum;       
       this.color    = color;       
       this.location = location;       
       this.image    = image;       
    }

    /**
     * Render this WeatherDatumContent
     * 
     * @param g   The rendering engine to use
     */
    public void render(Graphics g)
    {
       Color                 oldColor;       
       double                x, y;
       FontRenderContext     frc;       
       Graphics2D            g2;
       LineMetrics           lm;      
       Rectangle2D           textBounds;       
       String                text;
       

       g2       = (Graphics2D)g;

       oldColor = g2.getColor();
       g2.setColor(color);       

       // Render the Image
       y = location.getY() - image.getHeight(null)/2.0;       
       x = location.getX() - image.getWidth(null)/2.0;
       g.drawImage(image, (int)x, (int)y, null);       

       // Render the text
       frc        = g2.getFontRenderContext();
       text       = datum.toString();       
       lm         = FONT.getLineMetrics(text, frc);
       textBounds = FONT.getStringBounds(text, frc);
       x          = location.getX() - textBounds.getWidth()/2.0;
       y          = location.getY() + image.getHeight(null)/2.0 +
                    textBounds.getHeight();
       g2.drawString(text, (float)x, (float)y);       

       g2.setColor(oldColor);       
    }
    
    
}
