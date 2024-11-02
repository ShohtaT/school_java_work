import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class CirclePanel extends JPanel implements MouseListener {
  private int   radius = 5;
  private Color color  = Color.red;
  private int   x[],y[],r[];
  private Color c[];
  private int   num=0;
  final static int MAX=5000;
  
  public CirclePanel(){
    x=new int[MAX];
    y=new int[MAX];
    r=new int[MAX];
    c=new Color[MAX];
    this.addMouseListener(this);
  }
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    for(int i=0;i<num;i++){
      g.setColor(c[i]);
      g.fillOval(x[i]-r[i],y[i]-r[i],r[i]*2,r[i]*2);
    }
  }
  private void addCircle(int x0,int y0){
    if (num>=MAX) return; 
    x[num]=x0; y[num]=y0;
    r[num]=radius; c[num]=color;
    num++;
    this.repaint();
  }

  public void setRadius(int r) {
    radius = r;
  }

  public void setPanelColor(Color c) {
    color = c;
  }
     
  public void mousePressed(MouseEvent e) {
     addCircle(e.getX(),e.getY());
  }
  public void mouseClicked(MouseEvent e) { }
  public void mouseReleased(MouseEvent e){ }
  public void mouseEntered(MouseEvent e) { }
  public void mouseExited(MouseEvent e)  { }
}

class CircleFrame extends JFrame implements ActionListener {
  private CirclePanel panel;
  private JButton redButton, blueButton, greenButton;
  private JButton radius5Button, radius10Button;
  private JTextField radiusInput;

  public CircleFrame() {
    this.setTitle("CircleFrame");
    this.setSize(500, 500);
    panel = new CirclePanel();
    this.add(panel, BorderLayout.CENTER);

    // 色ボタン
    JPanel colorButtonPanel = new JPanel();
    colorButtonPanel.setLayout(new GridLayout(3, 1));

    redButton = new JButton("Red");
    blueButton = new JButton("Blue");
    greenButton = new JButton("Green");

    redButton.addActionListener(this);
    blueButton.addActionListener(this);
    greenButton.addActionListener(this);

    colorButtonPanel.add(redButton);
    colorButtonPanel.add(blueButton);
    colorButtonPanel.add(greenButton);

    this.add(colorButtonPanel, BorderLayout.WEST);

    // 半径ボタン
    JPanel radiusButtonPanel = new JPanel();
    radiusButtonPanel.setLayout(new GridLayout(3, 1));

    radius5Button = new JButton("Radius 5");
    radius10Button = new JButton("Radius 10");

    radius5Button.addActionListener(this);
    radius10Button.addActionListener(this);

    radiusButtonPanel.add(radius5Button);
    radiusButtonPanel.add(radius10Button);

    this.add(radiusButtonPanel, BorderLayout.EAST);

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == redButton) {
      panel.setPanelColor(Color.RED);
    } else if (e.getSource() == blueButton) {
      panel.setPanelColor(Color.BLUE);
    } else if (e.getSource() == greenButton) {
      panel.setPanelColor(Color.GREEN);
    } else if (e.getSource() == radius5Button) {
      panel.setRadius(5);
    } else if (e.getSource() == radius10Button) {
      panel.setRadius(10);
    }
    panel.repaint();
  }

  public static void main(String[] argv) {
    new CircleFrame();
  }
}
