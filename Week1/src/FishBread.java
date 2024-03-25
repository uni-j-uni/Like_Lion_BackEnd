public class FishBread {
    int size;
    String taste;

    public void fishPrint() {
        System.out.println("붕어빵의 크기는 " + size + "cm");
        System.out.println("붕어빵의 맛은 " + taste);
    }

    public static void main(String args[]) {
        FishBread fish1 = new FishBread();
        fish1.size = 10;
        fish1.taste = "팥";

        FishBread fish2 = new FishBread();
        fish2.size = 15;
        fish2.taste = "슈크림";

        fish1.fishPrint();
        fish2.fishPrint();
    }
}
