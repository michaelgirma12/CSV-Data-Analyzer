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

import java.util.Comparator;

/**
 * 
 * @author Ved Soolgiri (vedSoolgiri)
 * @version 2023.04.21
 *
 */
public class CompareByChannelName implements Comparator<Account> {
    /**
     * compare method in this class
     * 
     * @param o1
     *            in this method
     * @param o2
     *            in this method
     */
    @Override
    public int compare(Account o1, Account o2) {
        return o1.getChannel().toLowerCase().compareTo(o2.getChannel()
            .toLowerCase());
    }

}
