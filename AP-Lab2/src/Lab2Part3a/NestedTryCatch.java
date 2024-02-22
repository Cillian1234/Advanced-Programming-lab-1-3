package Lab2Part3a;

public class NestedTryCatch {
    public static void main(String[] args) {
        try {
            String s = "Chicken";
            s=null;
            System.out.println(s.charAt(10));
        } catch (NullPointerException e) {
            System.out.println("catch 1");
            e.printStackTrace();
            try {
                String s = "Chicken";
                System.out.println(s.charAt(10));
            } catch (StringIndexOutOfBoundsException ex) {
                System.out.println("catch 2");
                e.printStackTrace();
            }
        }
    }
}
