public class ExceptionTryCatchTest {
    public static void main(String[] args) {
        String name = "Smee";
        try {
            char c = name.charAt(4);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("String index bounds error caught");
            e.printStackTrace();
        } finally {
            System.out.println("Smee");
        }

        try {
            System.out.println("Test text try block");
        } finally {
            System.out.println("Test text finally block");
        }
    }
}
