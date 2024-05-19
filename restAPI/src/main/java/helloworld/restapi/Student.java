package helloworld.restapi;

public class Student {
    int id;
    String name;
    Double grade;

    public Student(int id, String name, Double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Double getGrade() {
        return grade;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
