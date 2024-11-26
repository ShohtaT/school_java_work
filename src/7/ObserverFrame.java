import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class TimeObservable extends Observable implements ActionListener {
  private javax.swing.Timer timer;
  private LocalTime currentTime; // ローカルの時刻を保持

  TimeObservable() {
    timer = new javax.swing.Timer(1000, this); // 1秒毎にactionPerformedを呼び出し
    currentTime = LocalTime.now();
    timer.start();
  }

  public String getValue(int diff) {
    LocalTime adjustedTime = currentTime.plusHours(diff);
    return adjustedTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
  }

  public void actionPerformed(ActionEvent e) {
    currentTime = LocalTime.now();
    setChanged();
    notifyObservers();
  }
}

class ClockPanel extends JPanel implements Observer{
  private TimeObservable timeObservable;
  private String place_name;
  private int diff;
  private JLabel label_place,label_time;

  public ClockPanel(TimeObservable to,String s,int d) {
    timeObservable = to;
    place_name=s; diff=d;
    timeObservable.addObserver(this);
    this.setLayout(new GridLayout(1,2));
    Font font = new Font(Font.SANS_SERIF,Font.BOLD,32);
    label_place=new JLabel(place_name,JLabel.CENTER);
    label_time=new JLabel(to.getValue(diff),JLabel.CENTER);
    label_place.setFont(font);
    label_time.setFont(font);
    this.add(label_place);
    this.add(label_time);
  }

  public void update(Observable o,Object arg) {
    label_time.setText(timeObservable.getValue(diff));
  }
}

class ObserverFrame extends JFrame {
  public ObserverFrame() {
    this.setTitle("Observer Frame");
    this.setLayout(new GridLayout(6, 1));
    TimeObservable t = new TimeObservable();
    this.add(new ClockPanel(t,"Tokyo",0));
    this.add(new ClockPanel(t,"Beijing",-1));
    this.add(new ClockPanel(t,"Paris",-8));
    this.add(new ClockPanel(t,"London",-7));
    this.add(new ClockPanel(t,"New York",-14));
    this.add(new ClockPanel(t,"Los Angels",-17));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();
    this.setVisible(true);
  }

  public static void main(String argv[]) {
    new ObserverFrame();
  }
}
