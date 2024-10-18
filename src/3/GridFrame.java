import javax.swing.*;
import java.awt.*;

class GridFrame extends JFrame {
  public GridFrame(){
    this.setSize(1000,200);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new GridLayout(2,10));
    for(int i=1;i<=20;i++)
      add(new JButton("No. "+i));
    this.setVisible(true);
  }

  public static void main(String argv[]) {
    new GridFrame();
  }
}
