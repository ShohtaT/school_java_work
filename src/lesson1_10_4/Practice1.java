package lesson1_10_4;

public class Practice1 {
  public static void main(String[] args) {
    double r = Math.random();

    Omikuji omikuji = new Omikuji();
    omikuji.tellFortune(r);
  }
}
