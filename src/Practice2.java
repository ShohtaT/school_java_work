//import java.util.Arrays;
//
//class main2 {
//  public static void main(String argv[]) {
//    Lesson pro = new Lesson("Pro Enshu", "Yanai", 100);
//    pro.add(new Student("3", "Dentsu Taro", 80));
//    pro.add(new Student("1", "Dentsu Hanako", 70));
//    pro.add(new Student("2", "Dentsu Yuki", 90));
//
//    pro.sort_name(); // ここでソートの種類を指定する（id or name or grade）
//
//    pro.print();
//  }
//}
//
//class Student {
//  private String id;
//  private String name;
//  private int grade;
//
//  String getId() {
//    return this.id;
//  }
//
//  String getName() {
//    return this.name;
//  }
//
//  int getGrade() {
//    return this.grade;
//  }
//
//  public Student(String id, String name, int grade) {
//    this.id = id;
//    this.name = name;
//    // grade は範囲チェック
//    if (grade < 0) {
//      this.grade = 0;
//    } else if (grade > 100) {
//      this.grade = 100;
//    } else {
//      this.grade = grade;
//    }
//  }
//
//  public void print() {
//    System.out.println("ID: " + this.id);
//    System.out.println("Name: " + this.name);
//    System.out.println("Grade: " + this.grade);
//  }
//}
//
//// 複数の受講生(Student)の情報を保持する授業クラス
//class Lesson {
//  private String name;    // 授業名
//  private String teacher; // 担当者
//  private int max;        // 最大履修者数
//  private int num;        // 登録履修者数
//  private Student st[];   // Student class の配列
//
//  public Lesson(String name, String teacher, int max) {
//    this.name = name;
//    this.teacher = teacher;
//    this.max = max;
//    this.num = 0;          // num は 0 に初期化．
//    st = new Student[max]; // 配列の確保(オブジェクトは別に生成する必要がある)
//  }
//
//  public void add(Student s) {
//    st[this.num++] = s;
//  }
//
//  // id の昇順に並べ替える
//  void sort_id() {
//    Arrays.sort(
//            this.st, (a, b) -> {
//              if (a == null && b == null) return 0;
//              if (a == null) return 1; // null は後ろに移動
//              if (b == null) return -1; // null は後ろに移動
//              return a.getId().compareTo(b.getId()); // 文字列の比較
//            }
//    );
//  }
//
//  // name の昇順に並び替える
//  void sort_name() {
//    Arrays.sort(
//            this.st, (a, b) -> {
//              if (a == null && b == null) return 0;
//              if (a == null) return 1; // null は後ろに移動
//              if (b == null) return -1; // null は後ろに移動
//              return a.getName().compareTo(b.getName()); // 文字列の比較
//            }
//    );
//  }
//
//  //  grade の昇順に並べ替える
//  void sort_grade() {
//    Arrays.sort(
//            this.st, (a, b) -> {
//              if (a == null && b == null) return 0;
//              if (a == null) return 1; // null は後ろに移動
//              if (b == null) return -1; // null は後ろに移動
//              return a.getGrade() - b.getGrade(); // int なので引き算により比較
//            }
//    );
//  }
//
//  public void print() {
//    System.out.println("授業名：" + this.name);
//    System.out.println("担当者：" + this.teacher);
//    System.out.println("最大履修者数：" + this.max);
//    // Student class の配列を順に表示
//    for (int i = 0; i < this.num; i++) {
//      System.out.println(i + 1 + "人目----------");
//      st[i].print();
//    }
//    System.out.println("FINISHED.");
//  }
//}
