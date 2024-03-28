public class Person {
    private float height, weight;

    public Person(float h, float w) {
        this.height = h; this.weight = w;
    }
    public float getHeight() {
        return height;
    }
    public float getWeight() {
        return weight;
    }
    public float getBMI() {
        return weight / (height * height) * 10000;
    }

    public void say() {
        System.out.println("응애");
    }
}
