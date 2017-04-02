import java.awt.Color;

import javax.swing.JPanel;

public class Game_panel extends JPanel
{
  int width = 1250;
  int height = 750;
  
  public Game_panel()
  {
    super();
    setBounds(0, 0, width, height);
    setSize(width, height);
    setBackground(Color.blue);
  }
}
