import javax.swing.*;
import java.awt.*;
import java.util.*;

class Figure {
  protected int x,y,size;
  protected Color color;
  private final static Color cl[]={Color.RED, Color.BLUE, Color.GREEN, Color.BLACK};
  Figure() {
    x = (int)(Math.random()*450);
    y = (int)(Math.random()*450);
    size=(int)(Math.random()*30+20);
    color=cl[(int)(Math.random() * cl.length)];
  }
  void draw(Graphics g) {}
}

class Circle extends Figure {
  void draw(Graphics g) {
    g.setColor(color);
    g.drawOval(x,y,size,size);
  }
}

class Box extends Figure {
  void draw(Graphics g) {
    g.setColor(color);
    g.drawRect(x,y,size,size);
  }
}

class Cross extends Figure {
  void draw(Graphics g) {
    g.setColor(color);
    // 線を二本引く
    g.drawLine(x, y, x + size, y + size);
    g.drawLine(x + size, y, x, y + size);
  }
}

class Triangle extends Figure {
  void draw(Graphics g) {
    g.setColor(color);
    // 3点を指定して三角形を描画
    int[] xpoints = {x, x + size, x + size / 2};
    int[] ypoints = {y + size, y + size, y};
    g.drawPolygon(xpoints, ypoints, 3);
  }
}

class RandomPanel extends JPanel {
  private final static int NUM=50;
  private ArrayList<Figure> fig;
  RandomPanel(){
    fig=new ArrayList<Figure>();
    for(int i=0;i<NUM;i++){
      fig.add(new Box());
      fig.add(new Circle());
      fig.add(new Cross());
      fig.add(new Triangle());
    }
  }
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    for(Figure f: fig){
      f.draw(g); 
    }
  }
}

class RandomFrame extends JFrame {
    public RandomFrame(){
      this.setTitle("Random Frame");
      this.setSize(500,530);
      this.add(new RandomPanel());
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);
    }
    public static void main(String argv[]) {
      new RandomFrame();
   }
}
