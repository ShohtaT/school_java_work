import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class HelloLabelFrame extends JFrame implements ActionListener {
  private JLabel label;
  private Timer timer;

  public HelloLabelFrame() {
    this.setSize(300, 200);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // ボタンを押すとおみくじが引かれるようにする（actionPerformedが呼び出される）
    JButton b = new JButton("おみくじを引いてみる！");
    this.add(b, BorderLayout.SOUTH);

    // 結果を表示するラベル
    label = new JLabel("　", JLabel.CENTER);
    this.add(label, BorderLayout.CENTER);
    b.addActionListener(this);

    // timerオブジェクトを生成して，startする。それにより自動的に1秒間隔で(永久に) おみくじボタンが押されるようにする。
    timer = new Timer(1000, this);
    timer.start(); // 一度，スタートすると，stopメソッドを呼ぶまでactionPerformedが定期的に呼ばれ続ける。
    this.setVisible(true);
  }

  // JButton は，押されると，あらかじめそのJButtonに登録しておいたオブジェクトの actionPerformedというメソッドを実行することになっています
  public void actionPerformed(ActionEvent ev) {
    double r = Math.random();

    Fourtune omikuji = new Fourtune();
    String result = omikuji.tell(r);

    label.setText(result);
  }

  public static void main(String argv[]) {
    new HelloLabelFrame();
  }
}

class Fourtune {
  public String tell(double val) {
    if (val > 0.7) {
      return "<html><span style='font-size: 20px; color: green; font-weight: bold;'>Good!!</span></html>";
    } else if (val > 0.2) {
      return "<html><span style='font-size: 20px; color: yellow; font-weight: bold;'>So so.</span></html>";
    } else {
      return "<html><span style='font-size: 20px; color: blue; font-weight: bold;'>Bad...</span></html>";
    }
  }
}
