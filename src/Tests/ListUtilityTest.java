import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ListUtilityTest {

    @Test
    public void testFilter() throws Exception {
        List<Integer> elems = new ArrayList<>();
        List<Integer> patternAnswer = new ArrayList<>();

        patternAnswer.add(2);
        patternAnswer.add(4);

        elems.add(1);
        elems.add(2);
        elems.add(3);
        elems.add(4);

        List<Integer> answer = ListUtility.filter(elems, new Predicate<Integer>() {
            @Override
            public boolean checkCondition(Integer obj) {
                return (obj % 2) == 0;
            }
        });
        assertTrue(answer.containsAll(patternAnswer));
    }

    @Test
    public void testFindMiddleValue() throws Exception {
        List<Integer> elems = new ArrayList<>();

        elems.add(1);
        elems.add(2);
        elems.add(3);
        elems.add(4);
        elems.add(5);

        int middleElem = ListUtility.findMiddleValue(elems, new SearchMiddleValue<Integer>() {
            @Override
            public Integer find(Collection<Integer> elems) {
                int sum = 0;

                for (Integer item : elems) {
                    sum += item;
                }
                return sum / elems.size();
            }
        });
        assertEquals(middleElem, 3);
    }

    @Test
    public void testNullInParams() throws Exception {
        List<Integer> searchElems = ListUtility.filter(null, new Predicate<Integer>() {
            @Override
            public boolean checkCondition(Integer obj) {
                return (obj % 2) == 0;
            }
        });
        Integer middleElem = ListUtility.findMiddleValue(null, new SearchMiddleValue<Integer>() {
            @Override
            public Integer find(Collection<Integer> elems) {
                int sum = 0;

                for (Integer item : elems) {
                    sum += item;
                }
                return sum / elems.size();
            }
        });
        assertTrue(searchElems == null);
        assertTrue(middleElem == null);
    }
}