package flik;
import org.junit.Test;

import static org.junit.Assert.*;

public class FilkTest {

    @Test
    public void SimpleTest() {
        Integer tmp = Integer.valueOf(0);
        Integer tmp1 = Integer.valueOf(0);
        assertTrue(Flik.isSameNumber(tmp, tmp1));
        Integer a = Integer.valueOf(151615165);
        Integer b = Integer.valueOf(151615165);
        assertTrue(Flik.isSameNumber(a, b));
    }
}
