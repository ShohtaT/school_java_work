import java.util.ArrayList;

class main2 {
  public static void main(String argv[]) {
    Lesson pro = new Lesson("Pro Enshu", "Yanai", 100);
    pro.add(new Student("3", "Dentsu Taro", 80));
    pro.add(new Student("1", "Dentsu Hanako", 70));
    pro.add(new Student("2", "Dentsu Yuki", 90));

    pro.print();
  }
}

class Student {
  private String id;
  private String name;
  private int grade;

  String getId() {
    return this.id;
  }

  public Student(String id, String name, int grade) {
    this.id = id;
    this.name = name;
    // grade は範囲チェック
    if (grade < 0) {
      this.grade = 0;
    } else if (grade > 100) {
      this.grade = 100;
    } else {
      this.grade = grade;
    }
  }

  public void print() {
    System.out.println("ID: " + this.id);
    System.out.println("Name: " + this.name);
    System.out.println("Grade: " + this.grade);
  }
}

// 複数の受講生(Student)の情報を保持する授業クラス
class Lesson {
  private String name;    // 授業名
  private String teacher; // 担当者
  private int max;        // 最大履修者数
  private int num;        // 登録履修者数
  private ArrayList<Student> st;   // Student class の配列

  public Lesson(String name, String teacher, int max) {
    this.name = name;
    this.teacher = teacher;
    this.max = max;
    this.num = 0;
    this.st = new ArrayList<>();
  }

  public void add(Student s) {
    st.add(s);
    this.num++;
    for(int i=0; i<st.size(); i++){
      Student s0=st.get(i);
      if (s.getId().compareTo(s0.getId())<0){  // sのidより大きいIDを発見
        // ★ 引数が2つのaddで，i番目にsを挿入．
        st.add(i, s);
        return;
      }
    }
  }

  public void print() {
    System.out.println("授業名：" + this.name);
    System.out.println("担当者：" + this.teacher);
    System.out.println("最大履修者数：" + this.max);
    // Student class の配列を順に表示
    for (int i = 0; i < this.num; i++) {
      System.out.println(i + 1 + "人目----------");
      st.get(i).print();
    }
    System.out.println("FINISHED.");
  }
}
