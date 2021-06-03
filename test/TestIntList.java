import org.junit.Test;

import static org.junit.Assert.*;

public class TestIntList {
    @Test
    public void testRecurrSize() {
        IntList l = new IntList(1, null);
        l = new IntList(2, l);
        l = new IntList(3, l);
        int s_gt = 3;
        int s_pred = l.size();
        String errMsg = String.format("Recursion size incorrect. Should be %d but got %d", s_gt, s_pred);
        assertEquals(errMsg, s_gt, s_pred);
    }

    @Test
    public void testIterSize() {
        IntList l = new IntList(1, null);
        l = new IntList(2, l);
        l = new IntList(3, l);
        int s_gt = 3;
        int s_pred = l.iterSize();
        String errMsg = String.format("Iterative size incorrect. Should be %d but got %d", s_gt, s_pred);
        assertEquals(errMsg, s_gt, s_pred);
    }

    @Test
    public void testGet() {
        IntList l = new IntList(1, null);
        l = new IntList(2, l);
        l = new IntList(3, l);
        int s_gt = 3;
        int i = 0;
        int s_pred = l.get(i);
        String errMsg = String.format("Get(#%d) incorrect. Should be %d but got %d", i, s_gt, s_pred);
        assertEquals(errMsg, s_gt, s_pred);
    }

    @Test
    public void testRecurGet() {
        IntList l = new IntList(1, null);
        l = new IntList(2, l);
        l = new IntList(3, l);
        int s_gt = 3;
        int i = 0;
        int s_pred = l.recurGet(i);
        String errMsg = String.format("Get(#%d) incorrect. Should be %d but got %d", i, s_gt, s_pred);
        assertEquals(errMsg, s_gt, s_pred);
    }
}