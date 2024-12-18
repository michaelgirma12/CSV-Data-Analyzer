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

import java.awt.Color;
import java.text.DecimalFormat;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

/**
 * This class is the GUI. It contains all the functionality for the buttons and
 * is interactive. It allows the user to display data in numerous ways.
 * 
 * @author Maria Sherer (mariasherer)
 * @version 2023.04.25
 *
 */
public class GUI {
    // ~ Fields ................................................................
    private Window window;
    private Button jan;
    private Button feb;
    private Button mar;
    private Button firstQuarter;
    private Button quit;
    private Button sortChannel;
    private Button sortER;
    private Button ter;
    private Button rer;

    private String engagementRateType;
    private String sortMethod;
    private String currentData;

    private TextShape firstRow;
    private TextShape secondRow;
    private TextShape thirdRow;

    private TextShape name1;
    private TextShape data1;
    private TextShape name2;
    private TextShape data2;
    private TextShape name3;
    private TextShape data3;
    private TextShape name4;
    private TextShape data4;

    private Shape bar1;
    private Shape bar2;
    private Shape bar3;
    private Shape bar4;

    private DLList<Account> listOfAccounts;
    private Account[] sortedAccounts;
    /**
     * MAX_ACCOUNTS is the maximum size of the sortedAccounts array
     */
    public static final int MAX_ACCOUNTS = 4;

    /**
     * Creates a new GUI window
     * 
     * @param listOfAccounts
     *            a doubly linked list of account objects
     */
    public GUI(DLList<Account> listOfAccounts) {
        window = new Window("Title");
        window.setTitle("mariasherer vedSoolgiri gmichael22");

        jan = new Button("January");
        window.addButton(jan, WindowSide.SOUTH);
        jan.onClick(this, "clickedJan");
        feb = new Button("February");
        window.addButton(feb, WindowSide.SOUTH);
        feb.onClick(this, "clickedFeb");
        mar = new Button("March");
        window.addButton(mar, WindowSide.SOUTH);
        mar.onClick(this, "clickedMar");
        firstQuarter = new Button("First Quarter (Jan - March");
        window.addButton(firstQuarter, WindowSide.SOUTH);
        firstQuarter.onClick(this, "clickedFirstQuarter");

        sortChannel = new Button("Sort by Channel Name");
        window.addButton(sortChannel, WindowSide.NORTH);
        sortChannel.onClick(this, "clickedSortChannel");
        sortER = new Button("Sort by Engagement Rate");
        window.addButton(sortER, WindowSide.NORTH);
        sortER.onClick(this, "clickedSortER");
        quit = new Button("Quit");
        window.addButton(quit, WindowSide.NORTH);
        quit.onClick(this, "clickedQuit");

        ter = new Button("Traditional Engagement Rate");
        window.addButton(ter, WindowSide.WEST);
        ter.onClick(this, "clickedTER");
        rer = new Button("Reach Engagement Rate");
        window.addButton(rer, WindowSide.WEST);
        rer.onClick(this, "clickedRER");

        currentData = "First Quarter (Jan - March)";
        engagementRateType = "Traditional Engagement Rate";
        sortMethod = "Sorting by Channel Name";

        firstRow = new TextShape(10, 10, currentData);
        window.addShape(firstRow);
        secondRow = new TextShape(10, 30, engagementRateType);
        window.addShape(secondRow);
        thirdRow = new TextShape(10, 50, sortMethod);
        window.addShape(thirdRow);

        name1 = new TextShape(10, 250, "");
        window.addShape(name1);
        data1 = new TextShape(10, 270, "");
        window.addShape(data1);
        name2 = new TextShape(110, 250, "");
        window.addShape(name2);
        data2 = new TextShape(110, 270, "");
        window.addShape(data2);
        name3 = new TextShape(210, 250, "");
        window.addShape(name3);
        data3 = new TextShape(210, 270, "");
        window.addShape(data3);
        name4 = new TextShape(310, 250, "");
        window.addShape(name4);
        data4 = new TextShape(310, 270, "");
        window.addShape(data4);

        this.listOfAccounts = listOfAccounts;
        sortedAccounts = sortIntoArray();
        setBarColors(sortedAccounts);
        adjust(sortedAccounts);

    }


    /**
     * This method is called when January is clicked
     * 
     * @param button
     */
    public void clickedJan(Button button) {
        clearBars();
        currentData = "January";
        firstRow.setText(currentData);
        adjust(sortedAccounts);

    }


    /**
     * This method is called when February is clicked
     * 
     * @param button
     */
    public void clickedFeb(Button button) {
        clearBars();
        currentData = "February";
        firstRow.setText(currentData);
        adjust(sortedAccounts);

    }


    /**
     * This method is called when March is clicked
     * 
     * @param button
     */
    public void clickedMar(Button button) {
        clearBars();
        currentData = "March";
        firstRow.setText(currentData);
        adjust(sortedAccounts);

    }


    /**
     * This method is called when First Quarter is clicked
     * 
     * @param button
     */
    public void clickedFirstQuarter(Button button) {
        clearBars();
        currentData = "First Quarter (Jan - March)";
        firstRow.setText(currentData);
        adjust(sortedAccounts);

    }


    /**
     * This method is called when Traditional is clicked
     * 
     * @param button
     */
    public void clickedTER(Button button) {
        clearBars();
        engagementRateType = "Traditional Engagement Rate";
        secondRow.setText(engagementRateType);
        adjust(sortedAccounts);

    }


    /**
     * This method is called when Reach is clicked
     * 
     * @param button
     */
    public void clickedRER(Button button) {
        clearBars();
        engagementRateType = "Reach Engagement Rate";
        secondRow.setText(engagementRateType);
        adjust(sortedAccounts);

    }


    /**
     * This method is called when January is clicked
     * 
     * @param button
     */
    public void clickedSortChannel(Button button) {
        clearBars();
        sortMethod = "Sorting by Channel Name";
        thirdRow.setText(sortMethod);
        sortedAccounts = sortIntoArray();
        adjust(sortedAccounts);

    }


    // sortER is clicked
    public void clickedSortER(Button button) {
        clearBars();
        sortMethod = "Sorting by Engagement Rate";
        thirdRow.setText(sortMethod);
        sortedAccounts = sortIntoArray();
        adjust(sortedAccounts);

    }


    // quit is clicked
    public void clickedQuit(Button button) {
        System.exit(0);

    }


    public void adjust(Account[] sortedAccounts) {
        if (engagementRateType.equals("Traditional Engagement Rate")) {
            name1.setText(sortedAccounts[0].getChannel());
            data1.setText(getData(0, sortedAccounts));
            bar1 = new Shape(10, 240 - (int)getTER(0, sortedAccounts), 30,
                (int)getTER(0, sortedAccounts), sortedAccounts[0]
                    .getBarColor());
            window.addShape(bar1);
            name2.setText(sortedAccounts[1].getChannel());
            data2.setText(getData(1, sortedAccounts));
            bar2 = new Shape(110, 240 - (int)getTER(1, sortedAccounts), 30,
                (int)getTER(1, sortedAccounts), sortedAccounts[1]
                    .getBarColor());
            window.addShape(bar2);
            name3.setText(sortedAccounts[2].getChannel());
            data3.setText(getData(2, sortedAccounts));
            bar3 = new Shape(210, 240 - (int)getTER(2, sortedAccounts), 30,
                (int)getTER(2, sortedAccounts), sortedAccounts[2]
                    .getBarColor());
            window.addShape(bar3);
            name4.setText(sortedAccounts[3].getChannel());
            data4.setText(getData(3, sortedAccounts));
            bar4 = new Shape(310, 240 - (int)getTER(3, sortedAccounts), 30,
                (int)getTER(3, sortedAccounts), sortedAccounts[3]
                    .getBarColor());
            window.addShape(bar4);
        }
        else {
            name1.setText(sortedAccounts[0].getChannel());
            data1.setText(getData(0, sortedAccounts));
            bar1 = new Shape(10, 240 - (int)getRER(0, sortedAccounts), 30,
                (int)getRER(0, sortedAccounts), sortedAccounts[0]
                    .getBarColor());
            window.addShape(bar1);
            name2.setText(sortedAccounts[1].getChannel());
            data2.setText(getData(1, sortedAccounts));
            bar2 = new Shape(110, 240 - (int)getRER(1, sortedAccounts), 30,
                (int)getRER(1, sortedAccounts), sortedAccounts[1]
                    .getBarColor());
            window.addShape(bar2);
            name3.setText(sortedAccounts[2].getChannel());
            data3.setText(getData(2, sortedAccounts));
            bar3 = new Shape(210, 240 - (int)getRER(2, sortedAccounts), 30,
                (int)getRER(2, sortedAccounts), sortedAccounts[2]
                    .getBarColor());
            window.addShape(bar3);
            name4.setText(sortedAccounts[3].getChannel());
            data4.setText(getData(3, sortedAccounts));
            bar4 = new Shape(310, 240 - (int)getRER(3, sortedAccounts), 30,
                (int)getRER(3, sortedAccounts), sortedAccounts[3]
                    .getBarColor());
            window.addShape(bar4);

        }
    }


    public void clearBars() {
        window.removeShape(bar1);
        window.removeShape(bar2);
        window.removeShape(bar3);
        window.removeShape(bar4);

    }


    public double getTER(int index, Account[] sortedAccounts) {
        if (sortedAccounts[index].getMonthData(currentData) == null) {
            return -Double.MAX_VALUE;
        }
        else {
            return sortedAccounts[index].getMonthData(currentData)
                .calculatorTER();
        }

    }


    public double getRER(int index, Account[] sortedAccounts) {
        if (sortedAccounts[index].getMonthData(currentData) == null) {
            return -Double.MAX_VALUE;
        }
        else {
            return sortedAccounts[index].getMonthData(currentData)
                .calculatorRER();
        }

    }


    public String getData(int index, Account[] sortedAccounts) {
        String pattern = "#.#";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        if (engagementRateType.equals("Traditional Engagement Rate")) {
            if (getTER(index, sortedAccounts) == -Double.MAX_VALUE) {
                return "N/A";
            }
            else {
                return decimalFormat.format(getTER(index, sortedAccounts));
            }
        }
        else {
            if (getRER(index, sortedAccounts) == -Double.MAX_VALUE) {
                return "N/A";
            }
            else {
                return decimalFormat.format(getRER(index, sortedAccounts));
            }
        }
    }


    // sorts listOfAccoutns then places each account object into
    // sortedAccounts[]
    public Account[] sortIntoArray() {
        Account[] newArray = new Account[MAX_ACCOUNTS];
        if (sortMethod.equals("Sorting by Channel Name")) {
            listOfAccounts.sort(new CompareByChannelName());
        }
        else {
            if (engagementRateType.equals("Traditional Engagement Rate")) {
                listOfAccounts.sort(new CompareByTrad(currentData));
            }
            else {
                listOfAccounts.sort(new CompareByReach(currentData));
            }
        }
        // go through listOfAccounts and add each account object to newArray
        for (int x = 0; x < listOfAccounts.size(); x++) {
            newArray[x] = listOfAccounts.get(x);
        }
        return newArray;
    }


    public void setBarColors(Account[] sortedAccounts) {
        sortedAccounts[0].setBarColor(Color.blue);
        sortedAccounts[1].setBarColor(Color.pink);
        sortedAccounts[2].setBarColor(Color.orange);
        sortedAccounts[3].setBarColor(Color.magenta);
    }

}
