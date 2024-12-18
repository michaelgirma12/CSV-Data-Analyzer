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

/**
 * 
 * @author Michael Girma (gmichael22)
 * @author Maria Sherer (mariasherer)
 * @version 2023.04.19
 *
 */
public class MonthData {
    private String channelName;
    private String month;
    private double likes;
    private double posts;
    private double followers;
    private double comments;
    private double views;

    /**
     * constructor
     * 
     * @param cN
     *            in this method
     * @param mon
     *            in this method
     * @param lik
     *            in this method
     * @param po
     *            in this method
     * @param fol
     *            in this method
     * @param comms
     *            in this method
     * @param vie
     *            in this method
     */
    public MonthData(
        String cN,
        String mon,
        double lik,
        double po,
        double fol,
        double comms,
        double vie) {
        channelName = cN;
        likes = lik;
        posts = po;
        followers = fol;
        comments = comms;
        views = vie;
        month = mon;
    }


    /**
     * 
     * @return the channel name
     */
    public String getChannelName() {
        return channelName;
    }


    /**
     * 
     * @return the number of likes in a given month
     */
    public double getLikes() {
        return likes;
    }


    /**
     * 
     * @return the number of posts in a given month
     */
    public double getPosts() {
        return posts;
    }


    /**
     * 
     * @return the number of followers in a given month
     */
    public double getFollowers() {
        return followers;
    }


    /**
     * 
     * @return the number of comments in a given month
     */
    public double getComments() {
        return comments;
    }


    /**
     * 
     * @return the number of viewers in a given month
     */
    public double getViews() {
        return views;
    }


    /**
     * calculate TER
     * 
     * @return the calculated Value for TER
     */
    public double calculatorTER() {
        if (followers == 0) {
            return -Double.MAX_VALUE;
        }
        else {
            return (double)((((double)comments + likes) / followers) * 100);
        }

    }


    /**
     * calculate ERR
     * 
     * @return calculated value for ERR
     */
    public double calculatorRER() {
        if (views == 0) {
            return -Double.MAX_VALUE;
        }
        else {
            return (double)((((double)comments + likes) / views) * 100);
        }

    }


    /**
     * 
     * @return a month object
     */
    public String getMonth() {
        return month;
    }

}
