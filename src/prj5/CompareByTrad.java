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
public class CompareByTrad implements Comparator<Account> {
    // ~ Fields ................................................................
    private String month;
    
    /**
     * Constructor
     * 
     * @param month
     *            the currentData
     * 
     */
    public CompareByTrad(String month) {
        this.month = month;
    }
    
    /**
     * compare method in this class
     * 
     * @param o1
     *            in this method
     * @param o2
     *            in this method
     */
    
    @Override
    public int compare(Account o2, Account o1) {
        int ret = 1;
        MonthData o2Data = o2.getMonthData(month);
        MonthData o1Data = o1.getMonthData(month);
        double x = o1Data.calculatorTER() - (o2Data.calculatorTER());
        if (x > 0) {
            return ret;
        }
        else {
            return ret - 2;
        }
        
        
        
    }

}