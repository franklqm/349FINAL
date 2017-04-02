import java.awt.geom.Point2D;
import java.io.IOException;

import io.ResourceFinder;
import map.io.BaseMapReader;
import visual.dynamic.described.*;
import visual.statik.described.*;


public class StormCloud extends DescribedSprite
{
///  ResourceFinder                finder;       
//  BaseMapReader                 mapReader;  
  StormCloudAgg          storm_cloud500, storm_cloud1500, storm_cloud4000;


  /**
   * Default Constructor
   * @throws IOException 
   *
   */
  public StormCloud() throws IOException
  {
      super();
///                = ResourceFinder.createInstance(this);       
      //mapReader             = new BaseMapReader(finder); 
      
      storm_cloud500 = new StormCloudAgg("track-500.map");
      storm_cloud1500 = new StormCloudAgg("track-1500.map");
      storm_cloud4000 = new StormCloudAgg("track-4000.map");

      addKeyTime( 500,   0.0, 0.0,  0.00, storm_cloud500);
      addKeyTime( 1500,   0.0, 0.0,  0.00, storm_cloud1500);
      addKeyTime( 4000,   0.0, 0.0,  0.00, storm_cloud4000);       
      
      setEndState(REMAIN);
  }

  /**
   * Add a key time
   *
   * @param time    The key time
   * @param x       The x position
   * @param y       The y position
   * @param r       The rotation angle
   * @param content The static visual content
   */
  private void addKeyTime(int time, double x, double y,
                           double r, AggregateContent content)
  {
     addKeyTime(time, new Point2D.Double(x, y), new Double(r), 
                new Double(1.0), content);
  }

}
