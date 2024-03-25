public class Circle {
    int radius;
    public static void main(String args[]) {
        Circle circle = new Circle();
        circle.radius = 8;
        System.out.println(circle.area(circle.radius));
    }
    double area(int r) { return r * r * 3.14; }
}
