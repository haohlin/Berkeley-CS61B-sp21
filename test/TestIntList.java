import org.junit.Test;

import static org.junit.Assert.*;

public class TestIntList {

    @Test
    public static void testSize() {
        IntList l = new IntList(1, null);
        l.rest = new IntList(2, null);
        l.rest.rest = new IntList(3, null);

        int s_gt = 3;
        int s_pred = l.size();



        String errMsg = String.format("Size incorrect. Should be %d but got %d", s_gt, s_pred);
        assertEquals(errMsg, s_gt, s_pred);
    }
}