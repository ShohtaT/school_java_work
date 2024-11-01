import java.awt.*;
import javax.swing.*;

class CombiFrame extends JFrame {
  public CombiFrame() {
    this.setTitle("Panel Combination");

    JTextArea t = new JTextArea(10, 6);

    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();

    p1.setLayout(new GridLayout(1, 10));
    p2.setLayout(new GridLayout(5, 1));

    for(int n=0; n < 10; n++){
      JButton button = new JButton(String.valueOf(n + 1));
      p1.add(button);
    }
    for(int n=10; n < 15; n++){
      p2.add(new JButton("<html><span style='color: red;'>" + (n + 1) + "</span></html>"));
    }

    this.add(p1, BorderLayout.NORTH);
    this.add(p2, BorderLayout.WEST);
    this.add(t, BorderLayout.CENTER);
    this.pack();
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  public static void main(String argv[]) {
    new CombiFrame();
  }
}
