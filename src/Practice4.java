public class Practice4 {
  public static void main(String argv[]) {
    Student3 st3 = new Student3();
    Student4 st4 = new Student4();

    st3.setId("123456");
    st3.setName("電通 太郎");
    st3.setGrade(80);
    st3.setCourse("メディア情報学");

    st4.setId("654321");
    st4.setName("電通 次郎");
    st4.setGrade(90);
    st4.setCourse("セキュリティ情報学");
    st4.setSupervisor("電通 三郎");

    System.out.println("[3年生]");
    st3.print();
    System.out.println("[4年生]");
    st4.print();
  }
}

class Student {
  private String id;    // 学籍番号
  private String name;  // 名前
  private int grade;    // 成績

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setGrade(int grade) {
    this.grade = grade;
  }

  public void print() {
    System.out.println("ID   : " + this.id);
    System.out.println("Name : " + this.name);
    System.out.println("Grade: " + this.grade);
  }
}

class Student3 extends Student {
  private String course; // コース名

  public void setCourse(String course) {
    this.course = course;
  }

  public void print() {
    super.print();  // 親クラスの出力
    System.out.println("Course: " + this.course); // コース名の表示の追加
  }
}

class Student4 extends Student {
  private String course; // コース名
  private String supervisor; // 指導教員名

  public void setCourse(String course) {
    this.course = course;
  }
  public void setSupervisor(String supervisor) {
    this.supervisor = supervisor;
  }

  public void print() {
    super.print();  // 親クラスの出力
    System.out.println("Course: " + this.course); // コース名の表示の追加
    System.out.println("Supervisor: " + this.supervisor); // 指導教員名の表示の追加
  }
}
