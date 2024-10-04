class Tsamp {
  static final int N = 20; // N角形

  public static void main(String[] args) {
    TurtleFrame f;             // TurtleFrame型の変数 f の宣言
    f = new TurtleFrame();    // TurtleFrame(表示フレーム)を生成しfに代入
    Turtle m = new Turtle();   // Turtle(亀)を生成し，m の初期値として代入
    f.add(m);                  // f(表示フレーム) に m(亀) を追加

    int i = 1;
    final int angle = 360 / N;
    while (i++ <= N) {
      m.rt(angle);
      m.fd(50);
    }
  }
}   
