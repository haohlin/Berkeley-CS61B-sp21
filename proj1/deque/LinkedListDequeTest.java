package deque;

import org.junit.Test;
import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

    @Test
    /*
    Test if addFirst(), addLast(), isEmpty(), size() are correct by adding random stuff to the Deque
     */
    public void addEmptySizeTest() {
        LinkedListDeque<Integer> listTest = new LinkedListDeque<>(); // Create new list

        assertEquals("Deque should be empty", true, listTest.isEmpty()); // Test isEmpty()
        assertEquals("Size should be zero", 0, listTest.size());// Test size()

        listTest.addFirst(1); // Add item one
        assertEquals("Deque should NOT be empty", false, listTest.isEmpty());
        assertEquals("Size should be 1", 1, listTest.size()); // Test isEmpty() and size()

        listTest.addLast(2); // Item two
        assertEquals("Size should be 2", 2, listTest.size()); // Test size()

        // Print Deque
        listTest.printDeque();
    }


    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */

    public void addIsEmptySizeTest() {
        /*
        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
		lld1.addFirst("front");

		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

		lld1.addLast("middle");
		assertEquals(2, lld1.size());

		lld1.addLast("back");
		assertEquals(3, lld1.size());

		System.out.println("Printing out deque: ");
		lld1.printDeque();
        */
    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty
		assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty
		assertFalse("lld1 should contain 1 item", lld1.isEmpty());

		lld1.removeFirst();
		// should be empty
		assertTrue("lld1 should be empty after removal", lld1.isEmpty());

    }

    @Test
    /*
    Removing from an empty Deque
     */
    public void removeEmptySizeTest() {
        LinkedListDeque<String> listTest = new LinkedListDeque<> ();

        listTest.addLast("item1");
        assertEquals(1, listTest.size());

        String item1 = listTest.removeFirst();
        assertEquals("item1", item1);
        assertEquals(0, listTest.size());

        String item2 = listTest.removeLast();
        assertEquals(null, item2);

        String item3 = listTest.removeFirst();
        assertEquals(null, item3);
        assertEquals(0, listTest.size());
    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {
/*
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);
*/
    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {

        LinkedListDeque<String>  lld1 = new LinkedListDeque<String>();
        LinkedListDeque<Double>  lld2 = new LinkedListDeque<Double>();
        LinkedListDeque<Boolean> lld3 = new LinkedListDeque<Boolean>();

        String item1 = "string";
        Double item2 = 3.14159;
        Boolean item3 = true;

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        assertEquals("Wrong removed string", "string", s);
        double d = lld2.removeFirst();
        assertEquals(3.14159, d, 0.001);
        boolean b = lld3.removeFirst();
        assertEquals("Wrong removed boolean", true, b);
    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());
    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }
    }

    @Test
    /*
    Test get() and getRecursive()
     */
    public void getTest() {
        LinkedListDeque<Integer> listTest = new LinkedListDeque<>();

        Integer getEmpty = listTest.get(0);// Test empty Deque
        assertEquals("Empty list gets null", null, getEmpty);

        listTest.addLast(0);
        listTest.addLast(1);
        listTest.addLast(2);
        listTest.addLast(3);

        int getFirst = listTest.get(0);
        assertEquals(0, getFirst);

        int getFirstRecur = listTest.getRecursive(0);
        assertEquals(0, getFirstRecur);

        int getLast = listTest.get(3);
        assertEquals(3, getLast);

        int getLastRecur = listTest.getRecursive(3);
        assertEquals(3, getLastRecur);

        Integer getOutOfRange = listTest.get(100);
        assertEquals(null, getOutOfRange); // Test out of range

        Integer getOutOfRangeRecur = listTest.getRecursive(100);
        assertEquals(null, getOutOfRangeRecur); // Test out of range

    }

}
