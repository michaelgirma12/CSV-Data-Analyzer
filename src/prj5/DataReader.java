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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class takes in the file and parses the data into first MonthData objects
 * and then into Account objects
 *
 * @author Maria Sherer (mariasherer)
 * @version 2023.04.19
 */
public class DataReader {
    // ~ Fields ................................................................
    private DLList<Account> listOfAccounts;
    private MonthData[] months;
    private String[] channelNames;
    /**
     * MONTHS_CAPACITY is the maximum possible number of MonthData objects
     */
    public static final int MONTHS_CAPACITY = 48;
    /**
     * ACCOUNTS_CAPACITY is the maximum possible number of Account objects
     */
    public static final int ACCOUNTS_CAPACITY = 4;

    // Constructor ..........................................................

    // ----------------------------------------------------------
    /**
     * Constructor for DataReader
     *
     * @param songsFileName
     *            The name of the songs file
     * @throws FileNotFoundException
     */
    public DataReader(String fileName) throws FileNotFoundException {
        months = new MonthData[MONTHS_CAPACITY];
        channelNames = new String[ACCOUNTS_CAPACITY];
        listOfAccounts = new DLList<Account>();
        listOfAccounts = readFile(fileName);
        // IMPORTANT
        GUI window = new GUI(listOfAccounts);

    }


    /**
     * This method reads the specified data file
     *
     * @param fileName
     *            A string that is the name of the file
     * @return listOfAccounts A doubly linked list that contains four Account
     *         objects
     */
    private DLList<Account> readFile(String fileName)
        throws FileNotFoundException {
        Scanner file = new Scanner(new File(fileName));
        int lineCounter = 0;
        int channelNameIndex = 0;
        int monthsIndex = 0;
        while (file.hasNextLine()) {
            if (lineCounter == 0) {
                file.nextLine();
            }
            String thisLine = file.nextLine();
            Scanner line = new Scanner(thisLine).useDelimiter(",\\s*");
            String[] things = new String[10];
            int tokenCount = 0;
            while (line.hasNext()) {
                things[tokenCount] = line.next();
                tokenCount++;
            }
            line.close();
            String month = things[0];
            String userName = things[1];
            String channelName = things[2];
            String country = things[3];
            String mainTopic = things[4];
            int likes = Integer.valueOf(things[5]);
            int posts = Integer.valueOf(things[6]);
            int followers = Integer.valueOf(things[7]);
            int comments = Integer.valueOf(things[8]);
            int views = Integer.valueOf(things[9]);
            if (isValidMonth(month)) {
                MonthData newMonth = new MonthData(channelName, month, likes,
                    posts, followers, comments, views);
                months[monthsIndex] = newMonth;
                monthsIndex++;
                if (!alreadyIsAnAccount(channelName)) {
                    channelNames[channelNameIndex] = channelName;
                    channelNameIndex++;
                    Account newAccount = new Account(userName, channelName,
                        country, mainTopic);
                    listOfAccounts.add(newAccount);
                }

            }
            lineCounter++;
        }
        file.close();
        placeMonthsInAccounts();
        return listOfAccounts;

    }


    /**
     * This helper method checks if the month is valid
     * 
     * @param month
     *            The string of the month to be checked
     * @return boolean
     *         Returns true if the month is valid, false if not
     */
    private boolean isValidMonth(String month) {
        return (month.equals("January") || month.equals("February") || month
            .equals("March") || month.equals("April") || month.equals("May")
            || month.equals("June") || month.equals("July") || month.equals(
                "August") || month.equals("September") || month.equals(
                    "October") || month.equals("November") || month.equals(
                        "December"));
    }


    /**
     * This helper method checks if this Account has already been created
     * 
     * @param channelName
     *            The string of the channelName to be checked
     * @return boolean
     *         Returns true if it is already an Account, false if not
     */
    private boolean alreadyIsAnAccount(String channelName) {
        for (int i = 0; i < channelNames.length; i++) {
            if (channelName.equals(channelNames[i])) {
                return true;
            }
        }
        return false;

    }


    /**
     * This method places every MonthData object into the correct Account object
     */
    private void placeMonthsInAccounts() {
        for (int i = 0; months[i] != null; i++) {
            if (months[i].getChannelName().equals(listOfAccounts.get(0)
                .getChannel())) {
                listOfAccounts.get(0).addMonthToArray(months[i]);
            }
            else if (months[i].getChannelName().equals(listOfAccounts.get(1)
                .getChannel())) {
                listOfAccounts.get(1).addMonthToArray(months[i]);
            }
            else if (months[i].getChannelName().equals(listOfAccounts.get(2)
                .getChannel())) {
                listOfAccounts.get(2).addMonthToArray(months[i]);
            }
            else {
                listOfAccounts.get(3).addMonthToArray(months[i]);
            }

        }
    }


    /**
     * This method gets the listOfAccounts
     * 
     * @return listOfAccounts The listOfAccounts
     */
    public DLList<Account> getListOfAccounts() {
        return listOfAccounts;
    }

}
