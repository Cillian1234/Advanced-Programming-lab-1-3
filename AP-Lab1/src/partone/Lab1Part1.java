package partone;

import java.util.Scanner;

public class Lab1Part1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Cillian Smee \n B00154414");

        System.out.println("Enter initial: ");
        System.out.println(getStudentNameFromInitial(sc.nextLine()));
    }

    /**
     * This method returns my name if provided my correct initials.
     * "Cillian Smee" if initial is "cs", else "INPUT INITIAL NOT CORRECT"
     * @param initial, Any string in any case
     * @return String
     */
    public static String getStudentNameFromInitial(String initial) {
        if(initial.toLowerCase().equals("cs")) {
            return "Cillian Smee";
        }
        return "INPUT INITIAL NOT CORRECT";
    }

    /**
     * This method returns my initials if provided my correct name.
     * "Cs" if name is "Cillian Smee", else "INPUT NAME NOT CORRECT"
     * @param name, Any string in any case
     * @return String
     */
    public static String getStudentInitialFromName(String name) {
        if(name.toLowerCase().equals("cillian smee")) {
            return "Cs";
        }
        return "INPUT NAME NOT CORRECT";
    }
}
