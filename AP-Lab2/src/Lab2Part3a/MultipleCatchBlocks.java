package Lab2Part3a;

public class MultipleCatchBlocks {
    public static void main(String[] args) {
        try {
            int[] test = {1,2,3};
            System.out.println(test[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index catch");
            e.printStackTrace();
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic exception catch");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception catch");
            e.printStackTrace();
        }
    }
}
