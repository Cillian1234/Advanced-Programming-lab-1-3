import java.io.File;
import java.io.IOException;

public class CheckedVUncheckedExceptions {
    public static void main(String[] args) {
        System.out.println(capitaliseStrings("string"));


        /*
        this requires a try/catch because it is a checked exception which means it is checked at compile,
        checked exceptions are required to be handled or use the throws keyword.
        IOExceptions are checked exceptions
        NullPointerExceptions are unchecked exceptions, so they do not require the try/catch
         */
        try {
            openFile("file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String capitaliseStrings(String string) throws NullPointerException {
        return string.toUpperCase();
    }

    public static void openFile(String fileName) throws IOException {
        File file = new File(fileName);
        System.out.println(file.exists());
    }
}
