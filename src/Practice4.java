
// 機能限定版

interface Photo {
  void TakePhoto();
}

class Cellular implements Photo {
  public void MakeCall() {
    System.out.println("携帯電話で電話を掛けました．");
  }

  public void TakePhoto() {
    System.out.println("携帯電話で写真を撮りました．");
  }
}

class Camera implements Photo {
  public void TakePhoto() {
    System.out.println("デジカメで写真を撮りました．");
  }
}

class VideoCam implements Photo {
  public void RecordMovie() {
    System.out.println("ビデオカメラで動画を撮影しました．");
  }

  public void TakePhoto() {
    System.out.println("ビデオカメラで写真を撮りました．");
  }
}

class IPhone implements Photo {
  public void TakePhoto() {
    System.out.println("IPhoneで写真を撮りました．");
  }
}

class Photographer {
  final static int MAX = 20; // final static int は定数の定義です．
  private Photo camera[] = new Photo[MAX];
  private int num = 0;

  public void add(Photo p) {
    if (num >= MAX) return;
    camera[num++] = p;
  }

  public void TakeAll() {
    for (int i = 0; i < num; i++) {
      System.out.print("[" + (i + 1) + "] ");
      camera[i].TakePhoto();
    }
  }

  public static void main(String argv[]) {
    Photographer p = new Photographer();
    for (int i = 0; i < 20; i++) {
      // 乱数を生成させて，値によって，
      // Celluar,iPhone,Camera,VideoCamera の1つを選択して，
      // p.add(new (クラス名)()); を実行してください．
      int random = (int) (Math.random() * 4);
      switch (random) {
        case 0:
          p.add(new Cellular());
          break;
        case 1:
          p.add(new IPhone());
          break;
        case 2:
          p.add(new Camera());
          break;
        case 3:
          p.add(new VideoCam());
          break;
      }
    }
    p.TakeAll();
  }
}
