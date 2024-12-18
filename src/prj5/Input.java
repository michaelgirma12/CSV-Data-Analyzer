/**
 * // Virginia Tech Honor Code Pledge:
 * //
 * // As a Hokie, I will conduct myself with honor and integrity at all times.
 * // I will not lie, cheat, or steal, nor will I accept the actions of those
 * who do.
 * // -- Maria Sherer (mariasherer)
 * // -- Ved Soolgiri (vedSoolgiri)
 * // -- Michael Girma (gmichael22)
 */
package prj5;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;

/**
 * This class is essentially the project runner. It displays data on the console
 * as well as calls the DataReader class
 *
 * @author Maria Sherer (mariasherer)
 * @version 2023.04.20
 */
public class Input {
    // ~ Fields ................................................................

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length > 0) {
            DataReader dr = new DataReader(args[0]);
            displayData(dr.getListOfAccounts());

        }
        else {
            DataReader dr = new DataReader("SampleInput1_2022.csv");
            displayData(dr.getListOfAccounts());
        }

    }


    /**
     * This method displays data on the console
     *
     * @param listOfAccounts
     *            A doubly linked list of Account objects
     */
    public static void displayData(DLList<Account> listOfAccounts) {
        String pattern = "#.#";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);

        listOfAccounts.sort(new CompareByChannelName());
        for (int x = 0; x < listOfAccounts.size(); x++) {
            System.out.println(listOfAccounts.get(x).getChannel());
            if (listOfAccounts.get(x).getFQData()
                .calculatorTER() == -Double.MAX_VALUE) {
                System.out.println("traditional: N/A");
                System.out.println("==========");
            }
            else {
                String TER = decimalFormat.format(listOfAccounts.get(x)
                    .getFQData().calculatorTER());
                System.out.println("traditional: " + TER);
                System.out.println("==========");
            }

        }

        listOfAccounts.sort(new CompareByReach("First Quarter (Jan - March)"));
        System.out.println("**********");
        System.out.println("**********");
        for (int x = 0; x < listOfAccounts.size(); x++) {
            System.out.println(listOfAccounts.get(x).getChannel());
            if (listOfAccounts.get(x).getFQData()
                .calculatorRER() == -Double.MAX_VALUE) {
                System.out.println("reach: N/A");
                System.out.println("==========");
            }
            else {
                String ERR = decimalFormat.format(listOfAccounts.get(x)
                    .getFQData().calculatorRER());
                System.out.println("reach: " + ERR);
                System.out.println("==========");
            }

        }

    }

}
