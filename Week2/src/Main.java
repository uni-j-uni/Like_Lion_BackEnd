import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int mostIndex = 0;
        ArrayList<Student> students = new ArrayList<Student>();

        students.add(new Student("홍길동", 175, 75));
        students.add(new Student("이서경", 180, 78));
        students.add(new Student("이영희", 155, 49));
        students.add(new Student("김멋사", 182, 82));

        for (int i = 1; i < students.size(); i++) {
            if (students.get(mostIndex).getBMI() < students.get(i).getBMI()) mostIndex = i;
        }

        students.remove(mostIndex);

        for (int i = 0; i < students.size(); i++) {
            students.get(i).printIntro();
            students.get(i).say();
        }
    }
}