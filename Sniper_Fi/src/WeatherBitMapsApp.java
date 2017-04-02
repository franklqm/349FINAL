// Java Library
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

// Multimedia Library
import app.*;
import io.*;
import visual.*;
import visual.dynamic.described.Stage;
import visual.statik.described.*;
import visual.statik.sampled.BufferedImageOpFactory;
import visual.statik.sampled.Content;
import visual.statik.sampled.ContentFactory;
import visual.statik.sampled.ImageFactory;

// WeatherBitmaps Library
import map.io.*;
import weather.*;
import weather.io.*;
import weather.visual.*;


/**
 * The "app" for a partial solution to programming assignment 5
 *
 * @author  Prof. David Bernstein, James Madison University
 * @version 1.0
 */
public class      WeatherBitMapsApp 
       extends    AbstractMultimediaApp 
       implements ActionListener
{
    private JButton                        button;
    private Stage                          stage;  
    VisualizationView                      stageView;    
    Main_menu                                 main_menu;
    Game_panel                             game_panel;

    
    private static final Color BACKGROUND_COLOR = new Color(204,204,255, 255/2);
    

    /**
     * Handle actionPerformed messages
     *
     * @param ae  The ActionEvent that generated the message
     */
    public void actionPerformed(ActionEvent ae)
    {
       String       ac;
       
       ac = ae.getActionCommand();
       
//      remove(showing.iterator());
//       if (showing == observations)
//       {
//          add(forecasts.iterator());
//          showing = forecasts;          
//       }
//       else
//       {
//          add(observations.iterator());
//          showing = observations;          
//       }
    }
    
    /**
     * Add a collection of WeatherDatumContent objects to
     * the Visualization
     */
    private void add(Iterator<WeatherDatumContent> i)
    {
       while (i.hasNext())
       {
          stage.add(i.next());          
       }
//       stage.add(stormCloud);
    }
    

    /**
     * Remove a collection of WeatherDatumContent objects from
     * the Visualization
     */
    private void remove(Iterator<WeatherDatumContent> i)
    {
       while (i.hasNext())
       {
          stage.remove(i.next());          
       }
//       stage.remove(stormCloud);
    }

    /**
     * Create a collection of WeatherDatumContent objects
     */
    private ArrayList<WeatherDatumContent> createContent(
                                                     WeatherPattern pattern,
                                                     Color color)
    {
       ArrayList<WeatherDatumContent>   result;       
       Iterator<WeatherDatum>           i;
       WeatherDatum                     datum;
       WeatherDatumContent              content;
          

       result = new ArrayList<WeatherDatumContent>();
       
       i = pattern.iterator();

       while (i.hasNext())
       {
          datum   = i.next();
//          content = wdContentFactory.createContent(datum, color);
//          result.add(content);          
       }

       return result;       
    }
          



    /**
     * The entry-point
     */
    public void init()
    {
       BaseMapReader                 mapReader;       
       BufferedReader                in;       
//       BufferedImage                 logo, watermarkImage;       
       BufferedImageOpFactory        bioFactory;       
       BufferedImageOp               op;       
//       visual.statik.sampled.Content watermark;     
       
       ContentFactory                contentFactory;    
//       HashMap<String,Image>         images;
//       HashMap<String,Point2D>       locations;
       ImageFactory                  imageFactory;       
       InputStream                   is;       
       int                           height, width;       
       JPanel                        contentPane;     
       Rectangle2D                   watermarkBounds;       
       io.ResourceFinder                finder;       
       StationLocationReader         stationLocationReader;       
       String                        grayWatermark, useWatermark;
//       TransformableContent          map, storm_cloud1500, storm_cloud4000;
//       visual.statik.described.Content     storm_cloud500;
//       visual.statik.sampled.TransformableContent snowflake_png;
       WeatherIconReader             iconReader;       
       WeatherPattern                pattern;
       WeatherPatternReader          weatherReader;  

       width  = 1250;
       height = 750;

       button = new JButton("Change");
       button.setBounds(25,height+10,100,50);
       button.addActionListener(this);       
       

       finder                = io.ResourceFinder.createInstance(this);       
       mapReader             = new BaseMapReader(finder);       
       stationLocationReader = new StationLocationReader(finder);
       iconReader            = new WeatherIconReader(finder);     
       



       try
       {
          // Read the map
//          map = mapReader.read("harrisonburg.map");
//          
//          // Read the storms
//          storm_cloud500 = mapReader.read("track-500.map");
//          storm_cloud1500 = mapReader.read("track-1500.map");
//          storm_cloud4000 = mapReader.read("track-4000.map");
//       
//          // Read the locations
//          locations = stationLocationReader.read("stations.loc");
//
//          // Read the icons
//          images    = iconReader.read();       
//
//          wdContentFactory = new WeatherDatumContentFactory(locations,
//                                                          images);

          // Construct the Visualization
          stage        = new Stage(50);
          stage.setRestartTime(4500);
          stage.setBackground(Color.GREEN); 

//          stageView          = stage.getView();
//          stageView.setBounds(0,0,width,height); 
//          stageView.setSize(width,height);
//          stageView.setBackground(BACKGROUND_COLOR);  
          
                   
          //Create and add main menu
          //main_menu = stage.getView();
          main_menu = new Main_menu();
          
          game_panel = new Game_panel();

          

          // Add the watermark to the Visualization
          useWatermark    = rootPaneContainer.getParameter("0");
          grayWatermark   = rootPaneContainer.getParameter("1");
          
          //if (useWatermark != null)
          //{
             contentFactory  = new ContentFactory(finder);
             imageFactory    = new ImageFactory(finder);
//             logo            = imageFactory.createBufferedImage("logoWeatherBits.png",
//                                                                4);
//             watermarkImage  = logo;

             if (grayWatermark != null)
             {
                bioFactory = BufferedImageOpFactory.createFactory();
                op         = bioFactory.createGrayOp();
//                op.filter(logo, watermarkImage);                
             }
//             watermark       = contentFactory.createContent(watermarkImage, 
//                                                            false);
//             watermarkBounds = watermark.getBounds2D();          
//             watermark.setLocation(width/2-watermarkBounds.getWidth()/2, 
//                                   height-watermarkBounds.getHeight());
            
             
             // The Stage
             //stageView = stage.getView();
             //stageView.setBounds(0,0,500,200); 
             
             // The Sprite
             //snowflake_png   = contentFactory.createContent("snowflake.png", 4, false);
             //snowflake  = new FloatingSprite(snowflake_png, width, height);
                          
//             stage.add(watermark);          
          //}
          


          // Add the map to the Visualization
//          stage.add(map);

          // Read the forecasts
          weatherReader = new WeatherPatternReader(finder);          
          pattern = weatherReader.read("30August2013","for","Forecasts");

          // Create the Content for the forecasts
//          forecasts = createContent(pattern, Color.BLUE);
          
          // Read the observations
          pattern = weatherReader.read("current","obs","Observations");

          // Create the Content for the observations
//          observations = createContent(pattern, Color.RED);
//
//          showing = forecasts;
//          add(forecasts.iterator());
          

          // Setup the content pane
          contentPane = (JPanel)rootPaneContainer.getContentPane();
          
//          stormCloud = new StormCloud();
//          stage.add(stormCloud);

          contentPane.add(main_menu);
          
          contentPane.add(game_panel);

          

//          contentPane.add(stageView);
          contentPane.add(button);
          
          
          stage.start();
          
          
       }
       catch (Exception exception)
       {
          exception.printStackTrace();          
       }
    }
}
