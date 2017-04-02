import java.awt.*;
import java.awt.geom.*;
import java.io.IOException;
import java.io.InputStream;


import io.ResourceFinder;
import visual.statik.described.*;

public class StormCloudAgg extends AggregateContent
{
  public StormCloudAgg(String file_name) throws IOException
  {
     super();
     ResourceFinder                finder;       

     Path2D.Float       body;
     BasicStroke     stroke;
     Color           gray;
     Content         cloud;
     finder                = ResourceFinder.createInstance(this);       
    
     gray   = new Color(170, 170, 170, 128);
     stroke = new BasicStroke();
    
     InputStream stream = finder.findInputStream(file_name);
     String[]                 names = finder.loadResourceNames(file_name);
     
     boolean flag = true; 
     body = new Path2D.Float();
     
     String[] cordArray = names[0].split(",");
     body.moveTo(Integer.parseInt(cordArray[1]), Integer.parseInt(cordArray[2])); 
     for (int i = 1; i < names.length; i++)
     {
         cordArray = names[i].split(",");
         body.lineTo(Integer.parseInt(cordArray[1]), Integer.parseInt(cordArray[2]));
     }
     body.closePath();
     
     cloud = new Content(body, gray, gray, stroke);
     add(cloud);
     stream.close();
  }
}
