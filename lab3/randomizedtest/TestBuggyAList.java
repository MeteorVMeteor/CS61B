package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> rightlist = new AListNoResizing();
        BuggyAList<Integer> wronglist = new BuggyAList<>();
        for(int i = 0; i < 3; i++){
            rightlist.addLast(i);
            wronglist.addLast(i);
        }
        assertEquals(rightlist.size(), wronglist.size());
        assertEquals(rightlist.removeLast(), wronglist.removeLast());
        assertEquals(rightlist.removeLast(), wronglist.removeLast());
        assertEquals(rightlist.removeLast(), wronglist.removeLast());
    }
    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> BL = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                BL.addLast(randVal);
//                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int size1 = BL.size();
                assertEquals(size, size1);
//                System.out.println("size: " + size);
            }
            else {
                // getLast
                assertEquals(L.size(), BL.size());
                if (L.size() == 0 || BL.size() == 0) {
                    continue;
                }
                int itemL = L.removeLast();
                int itemBL = BL.removeLast();
                assertEquals(itemBL, itemL);
            }
        }
    }
}
