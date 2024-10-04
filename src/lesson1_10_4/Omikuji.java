package lesson1_10_4;

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
