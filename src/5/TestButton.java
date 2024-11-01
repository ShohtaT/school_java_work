import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ButtonPanel extends JPanel implements ActionListener {
  private JButton b1,b2,b3;
  private JLabel l;

  ButtonPanel(){
    b1 = new JButton("Button 1");
    b2 = new JButton("Button 2");
    b3 = new JButton("Button 3");
    l =  new JLabel("0",JLabel.CENTER);
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b1.setActionCommand("1");
    b2.setActionCommand("2");
    b3.setActionCommand("3");
    setLayout(new GridLayout(2,2));
    add(b1); add(b2); add(b3); add(l);
  }

  @Override
  public void actionPerformed(ActionEvent e){
    String es=e.getActionCommand();
    l.setText(es);
  }
}

class TestButton extends JFrame{
  public TestButton(){
    ButtonPanel b=new ButtonPanel();
    this.setTitle("Test Button");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.add(b);
    this.pack();
    this.setVisible(true);
  }
  public static void main(String argv[]) {
    new TestButton();
  }
}
