package parttwo;

import partone.Lab1Part1;
import java.util.Scanner;

public class Lab1Part2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter name:");
        System.out.println(Lab1Part1.getStudentInitialFromName(sc.nextLine()));
    }
}
