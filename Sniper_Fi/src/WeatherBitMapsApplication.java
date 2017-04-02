import java.io.*;
import java.net.*;
import javax.swing.*;
	
import app.*;
	
/**
 * The application for PA5
 */
public class   WeatherBitMapsApplication
       extends MultimediaApplication
{
    /**
     * The entry-point of the application
     *
     * @param args    The command-line arguments
     */
    public static void main(String[] args) throws Exception
    {
       SwingUtilities.invokeAndWait(
          new WeatherBitMapsApplication(args, 1250, 750));
    }
	
    /**
     * Explicit Value Constructor
     *
     * @param args    The command-line arguments
     * @param width   The width of the content (in pixels)
     * @param height  The height of the content (in pixels)
     */
    public WeatherBitMapsApplication(String[] args,
                                    int width, int height)
    {
       super(args, new WeatherBitMapsApp(), width, height);
    }
}
