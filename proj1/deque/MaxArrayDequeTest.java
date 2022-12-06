package deque;

import org.junit.Test;

import java.sql.Array;
import java.util.Comparator;
import java.util.Iterator;

import static org.junit.Assert.*;

public class MaxArrayDequeTest {

    @Test
    public void simpleTest() {
        MaxArrayDeque<Integer> mad1 = new MaxArrayDeque<>((c1, c2) -> c1 - c2);
        mad1.addLast(3);
        mad1.addLast(1);
        mad1.addLast(2);
        assertEquals((Integer)3, mad1.max());
        assertEquals((Integer)1, mad1.max((c1, c2) -> c2 - c1));
        MaxArrayDeque<String> mad2 = new MaxArrayDeque<>((c1, c2) -> c1.compareTo(c2));
        mad2.addLast("abc");
        mad2.addLast("def");
        mad2.addLast("ghi");
        assertEquals("String max error", "ghi", mad2.max());
        assertEquals("String min error", "abc", mad2.max((c1, c2) -> c2.compareTo(c1)));
    }
}
