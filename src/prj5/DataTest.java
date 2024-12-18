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
import java.util.Iterator;
import student.TestCase;

/**
 * 
 * @author Michael Girma (gmichael22)
 * @version 2023.04.21S
 *
 */
public class DataTest extends TestCase {
    private MonthData m1;
    private Account account;
    private DLList<String> list;
    private DLList<String> inventory;

    /**
     * setUp for this class
     */
    public void setUp() {
        m1 = new MonthData("idk", "idkReacts", 2000, 10, 3000, 200, 4000);
        account = new Account("username", "channel", "country", "mainTopic");
        list = new DLList<String>();
        inventory = new DLList<String>();
    }


    /**
     * tests get channel
     */
    public void testGetChannel() {
        assertEquals("channel", account.getChannel());
    }


    /**
     * testing get FQD
     */
    public void testGetFQData() {
        // Create some MonthData objects
        MonthData january = new MonthData("channel", "January", 10, 10, 10, 10,
            10);
        MonthData february = new MonthData("channel", "February", 20, 20, 20,
            20, 20);
        MonthData march = new MonthData("channel", "March", 30, 30, 30, 30, 30);
        MonthData april = new MonthData("channel", "April", 40, 40, 40, 40, 40);

        // Add the MonthData objects to the account
        account.addMonthToArray(january);
        account.addMonthToArray(february);
        account.addMonthToArray(march);
        account.addMonthToArray(april);

        // Test the getFQData method
        MonthData fqData = account.getFQData();
        assertEquals("channel", fqData.getChannelName());
        assertEquals("first quarter data", fqData.getMonth());
        assertEquals(60, fqData.getLikes(), 2);
        assertEquals(60, fqData.getPosts(), 2);
        assertEquals(30, fqData.getFollowers(), 2);
        assertEquals(60, fqData.getComments(), 2);
        assertEquals(60, fqData.getViews(), 2);
    }


    /**
     * testing getter methods
     */
    public void testingGetters() {
        assertEquals("idk", m1.getChannelName());
        assertEquals("idkReacts", m1.getMonth());
        assertEquals(2000, m1.getLikes(), 2);
        assertEquals(10, m1.getPosts(), 2);
        assertEquals(3000, m1.getFollowers(), 2);
        assertEquals(200, m1.getComments(), 2);
        assertEquals(4000, m1.getViews(), 2);
    }


    /**
     * testing The Traditional Engagement Rate
     */
    public void testCalculatorTER() {
        assertEquals(73, m1.calculatorTER(), 2);

        MonthData monthData = new MonthData("channel", "Jan", 100, 10, 0, 20,
            50);
        double ter = monthData.calculatorTER();
        assertEquals(-Double.MAX_VALUE, ter, 0.001);

    }


    /**
     * testing The Engagement Rate by Reach
     */
    public void testCalculatorERR() {
        assertEquals(55, m1.calculatorRER(), 2);

        MonthData monthData = new MonthData("channel", "Jan", 100, 10, 20, 30,
            0);
        double err = monthData.calculatorRER();
        assertEquals(-Double.MAX_VALUE, err, 0.001);
    }


    /**
     * Tests that an IndexOutOfBounds exception is thrown when the index is
     * greater than or equal to size and less than zero
     */
    public void testRemoveException() {
        list.add("A");
        Exception e = null;
        try {
            list.remove(2);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
        e = null;
        try {
            list.remove(-1);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests that objects can be removed at the beginning and end and that the
     * size is changed
     */
    public void testRemoveIndex() {
        list.add("A");
        list.add("B");
        assertTrue(list.remove(1));
        assertEquals(1, list.size());
        list.add("B");
        assertTrue(list.remove(0));
        assertEquals(1, list.size());
    }


    /**
     * Tests the add method. Ensures that it adds the object is added at the end
     * and the size is increased
     */
    public void testAdd() {
        assertEquals(0, list.size());
        list.add("A");
        assertEquals(1, list.size());
        list.add("B");
        assertEquals(2, list.size());
        assertEquals("B", list.get(1));

    }


    /**
     * Tests that objects can be added at the beginning and end and that they
     * are placed correctly
     */
    public void testAddIndex() {
        list.add("B");
        list.add(0, "A");
        assertEquals("A", list.get(0));
        assertEquals(2, list.size());
        list.add(2, "D");
        assertEquals("D", list.get(2));
        list.add(2, "C");
        assertEquals("C", list.get(2));
    }


    /**
     * This tests that the add method throws a null pointer exception when
     * adding null data to the list
     */
    public void testAddNullException() {
        Exception e = null;
        try {
            list.add(null);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }


    /**
     * This tests that the add method throws a Invalid argument when adding null
     * data to the list
     */
    public void testAddIndexNullException() {
        Exception e = null;
        try {
            list.add(0, null);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }


    /**
     * This tests when the add method is called and the index is greater than
     * size or less than zero
     */
    public void testAddException() {
        list.add("A");
        Exception e = null;
        try {
            list.add(2, "B");
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
        e = null;
        try {
            list.add(-1, "B");
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests removing a object changes the size appropiately and that you can
     * remove the first and last elements
     */
    public void testRemoveObj() {
        assertFalse(list.remove(null));
        list.add("A");
        list.add("B");
        assertTrue(list.remove("A"));
        assertEquals("B", list.get(0));
        assertEquals(1, list.size());
        list.add("C");
        assertTrue(list.remove("C"));
        assertEquals("B", list.get(0));
    }


    /**
     * Tests get when the index is greater than or equal to size and when the
     * index is less than zero
     */
    public void testGetException() {
        Exception exception = null;
        try {
            list.get(-1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        exception = null;
        list.add("A");
        try {
            list.get(1);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Test contains when it does and does not contain the object
     */
    public void testContains() {
        assertFalse(list.contains("A"));
        list.add("A");
        assertTrue(list.contains("A"));
        assertFalse(list.contains("B"));
        list.add("B");
        assertTrue(list.contains("B"));
    }


    /**
     * Test lastIndexOf when the list is empty, when the object is not in the
     * list, and when it is at the beginning or end
     */
    public void testLastIndexOf() {
        assertEquals(-1, list.lastIndexOf("A"));
        list.add("A");
        assertEquals(0, list.lastIndexOf("A"));
        list.add("A");
        assertEquals(1, list.lastIndexOf("A"));
        list.add("B");
        assertEquals(1, list.lastIndexOf("A"));
        assertEquals(2, list.lastIndexOf("B"));
        list.add("A");
        assertEquals(3, list.lastIndexOf("A"));
    }


    /**
     * Tests isEmpty when empty and full
     */
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add("A");
        assertFalse(list.isEmpty());
    }


    /**
     * Ensures that all of the objects are cleared and the size is changed
     */
    public void testClear() {
        list.add("A");
        list.clear();
        assertEquals(0, list.size());
        assertFalse(list.contains("A"));
    }


    /**
     * Tests the toString when there are 0, 1, and 2 objects in the list
     */
    public void testToString() {
        assertEquals("{}", list.toString());
        list.add("A");
        assertEquals("{A}", list.toString());
        list.add("B");
        assertEquals("{A, B}", list.toString());
    }


    /**
     * Tests removing from an empty list
     */
    public void testRemoveFromEmpty() {
        list.add("dance");
        list.add(0, "safety");
        list.clear();
        assertFalse(list.remove("safety"));
        Exception exception;
        exception = null;
        try {
            list.remove(0);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);

        DLList<String> emptyList = new DLList<String>();
        exception = null;
        try {
            emptyList.remove(0);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests removing from an empty list
     */
    public void testIterator() {

        inventory.add("a");
        inventory.add("b");
        inventory.add("c");
        inventory.add("d");
        Iterator<String> iter = inventory.iterator();
        assertTrue(iter.hasNext());
        assertEquals(iter.next(), "a");
        assertEquals(iter.next(), "b");
        assertEquals(iter.next(), "c");
        assertEquals(iter.next(), "d");
        assertFalse(iter.hasNext());
    }


    /**
     * test the sort method
     */
    public void testSort() {
        DLList<Integer> list2 = new DLList<Integer>();

        // add elements to the list in random order
        list2.add(4);
        list2.add(2);
        list2.add(6);
        list2.add(1);
        list2.add(3);
        list2.add(5);

        // create a comparator that sorts in ascending order
        Comparator<Integer> ascendingComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        // sort the list
        list2.sort(ascendingComparator);

        // check that the list is sorted in ascending order
        Iterator<Integer> it = list2.iterator();
        int previous = it.next();
        while (it.hasNext()) {
            int current = it.next();
            assertTrue(ascendingComparator.compare(previous, current) <= 0);
            previous = current;
        }

    }


    /**
     * testing getters
     */
    public void testGetter2() {
        assertEquals("username", account.getUserName());
        assertEquals("country", account.getCountry());
        assertEquals("mainTopic", account.getMainTopic());
    }

}
