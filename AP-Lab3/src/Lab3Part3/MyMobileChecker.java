package Lab3Part3;

import Lab3Part3.Exceptions.BalanceTooLowException;
import Lab3Part3.Exceptions.NotMyNetworkException;

import java.util.Scanner;

public class MyMobileChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter network: ");
        try {
            checkMyMobileNetwork(sc.nextLine());
        } catch (NotMyNetworkException e) {
            e.printStackTrace();
        }

        System.out.println("Enter balance: ");
        try {
            checkMyBalance(Integer.parseInt(sc.nextLine()));
        } catch (BalanceTooLowException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method checks the user has entered the correct network
     * @param inputNetworks
     * @throws NotMyNetworkException
     */
    public static void checkMyMobileNetwork(String inputNetworks) throws NotMyNetworkException {
        if (inputNetworks.toLowerCase().equals("three")) {
            System.out.println("Network connected!");
        } else
            throw new NotMyNetworkException();
    }

    /**
     * This method checks the users balance is greater than 0
     * @param balance
     * @throws BalanceTooLowException
     */
    public static void checkMyBalance(int balance) throws BalanceTooLowException {
        if (balance>0) {
            System.out.println("Balance sufficient!");
        } else
            throw new BalanceTooLowException();
    }
}
