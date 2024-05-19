package helloworld.restapi;

public class Employee {
    int id;
    String name;
    String department;
    int age;

    public Employee(int id, String name, String departement, int age) {
        this.id = id;
        this.name = name;
        this.department = departement;
        this.age = age;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDepartment() { return department; }
    public int getAge() { return age; }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department'" + department + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
