package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrime1() {
        IntList lst = IntList.of(1, 2, 3, 1);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("1 -> 4 -> 9 -> 1", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrime2() {
        IntList lst = IntList.of(4, 4, 4);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("4 -> 4 -> 4", lst.toString());
        assertFalse(changed);
    }

    @Test
    public void testSquarePrime3() {
        IntList lst = IntList.of(1, 1);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("1 -> 1", lst.toString());
        assertFalse(changed);
    }
}
