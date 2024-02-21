package Lab2Part3a;

public class MulticatchUsingOr {
    public static void main(String[] args) {
        try {
            String s = "Chicken";
            System.out.println(s.charAt(10));
        } catch (NullPointerException | StringIndexOutOfBoundsException e) {
            System.out.println("catch");
            e.printStackTrace();
        }
    }
}
