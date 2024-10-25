package src;

class main {
  public static void main(String[] args) {
    Student3 s = new Student3();
    s.setId("123456");
    s.setName("電通 太郎");
    s.setGrade(100);
    s.setCourse("メディア情報学コース");
    s.print();
  }
}

class Student {
  private String id;    // 学籍番号
  private String name;  // 名前
  private int grade;    // 成績

  public void setId(String id){
    this.id=id;
  }
  public void setName(String name){
    this.name=name;
  }
  public void setGrade(int grade){
    this.grade=grade;
  }

  public void print() {
    System.out.println("ID   : "+this.id);
    System.out.println("Name : "+this.name);
    System.out.println("Grade: "+this.grade);
  }
}

class Student3 extends Student {
  private String course; // コース名

  public void setCourse(String course){
    this.course = course;
  }
  public void setId(String id){
    super.setId(id);
  }

  public void print() {
    super.print();  // 親クラスの出力
    System.out.println("Course: "+this.course); // コース名の表示の追加
  }
}
