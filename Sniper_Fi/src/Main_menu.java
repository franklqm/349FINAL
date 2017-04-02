import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Main_menu extends JPanel
{
  int width = 1250;
  int height = 750;
  
  JButton start, easy, medium, hard, insane, training;
  
  public Main_menu()
  {
    super();
    setBounds(50, 50, width - 100, height - 100);
    setSize(width - 100, height - 100);
    setBackground(new Color(150, 150, 150, 255/2));
    
    
    start = new JButton("START");
    start.setBounds(0, 0, 100, 50);
    start.setSize(100, 50);
    
    add(start);
  }
  
}
