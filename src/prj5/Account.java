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

/**
 * 
 * @author Michael Girma (gmichael22)
 * @author Maria Sherer (mariasherer)
 * @version 2023.04.19
 *
 */
public class Account {
    // ~ Fields ................................................................
    private String userName;
    private String channel;
    private String country;
    private String mainTopic;
    private MonthData[] month;
    private Color barColor;
    /**
     * MAX_MONTHS is the maximum number of MonthData objects
     */
    public static final int MAX_MONTHS = 12;

    private int monthCount;
    private MonthData invalidMonth;

    /**
     * Constructor
     * 
     * @param un
     *            in this method
     * @param chan
     *            in this method
     * @param coun
     *            in this method
     * @param mainT
     *            in this method
     * 
     */
    public Account(String un, String chan, String coun, String mainT) {
        userName = un;
        channel = chan;
        country = coun;
        mainTopic = mainT;
        month = new MonthData[MAX_MONTHS];
        monthCount = 0;
        barColor = Color.black;
        invalidMonth = new MonthData("", "", 0.0, 0.0, 0.0, 0.0, 0.0);
    }


    /**
     * used to make sure that the channel
     * name is the same as the one in month data
     * 
     * @return the channel name
     */
    public String getUserName() {
        return userName;
    }


    /**
     * used to make sure that the channel
     * name is the same as the one in month data
     * 
     * @return the channel name
     */
    public String getCountry() {
        return country;
    }


    /**
     * used to make sure that the channel
     * name is the same as the one in month data
     * 
     * @return the channel name
     */
    public String getMainTopic() {
        return mainTopic;
    }


    /**
     * used to make sure that the channel
     * name is the same as the one in month data
     * 
     * @return the channel name
     */
    public String getChannel() {
        return channel;
    }


    /**
     * setter method that sets the color
     */
    public void setBarColor(Color color) {
        barColor = color;
    }


    /**
     * 
     * @return the color of the bar
     */
    public Color getBarColor() {
        return barColor;
    }


    /**
     * 
     * @return the a MonthData object based on monthName
     * @param monthName
     *            is the name of the month data that is to be retrieved
     */
    public MonthData getMonthData(String monthName) {
        if (monthName.equals("First Quarter (Jan - March)")) {
            return getFQData();
        }
        for (int i = 0; i < month.length; i++) {
            if (month[i] == null) {
                break;
            }
            if (month[i].getMonth().equals(monthName)) {
                return month[i];
            }
        }
        return invalidMonth;
    }


    /**
     * 
     * @return the first quarter data
     */
    public MonthData getFQData() {
        String channelName = channel;
        String monthName = "first quarter data";
        int totalLikes = 0;
        int totalPosts = 0;
        int totalFollowers = 0;
        int totalComments = 0;
        int totalViews = 0;
        for (int i = 0; i < month.length; i++) {
            if (month[i] == null) {
                break;
            }
            if (month[i].getMonth().equals("January") || month[i].getMonth()
                .equals("February") || month[i].getMonth().equals("March")) {
                totalLikes += month[i].getLikes();
                totalPosts += month[i].getPosts();
                totalFollowers = (int)month[i].getFollowers();
                totalComments += month[i].getComments();
                totalViews += month[i].getViews();
            }
        }
        MonthData firstQuarterData = new MonthData(channelName, monthName,
            totalLikes, totalPosts, totalFollowers, totalComments, totalViews);
        return firstQuarterData;
    }


    /**
     * adding the month to the array
     * 
     * @param monthData
     *            in this method
     */
    public void addMonthToArray(MonthData monthData) {
        month[monthCount] = monthData;
        monthCount++;
    }

}
