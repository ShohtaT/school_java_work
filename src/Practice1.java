public class Practice1 {
  public static void main(String[] args) {
    double r = Math.random();

    Omikuji omikuji = new Omikuji();
    omikuji.tellFortune(r);
  }
}

class Omikuji {
  public void tellFortune(double val) {
    if (val > 0.7) {
      System.out.println("Good!!");
    } else if (val > 0.2 && val <= 0.7) {
      System.out.println("So so.");
    } else {
      System.out.println("Bad...");
    }
  }
}
