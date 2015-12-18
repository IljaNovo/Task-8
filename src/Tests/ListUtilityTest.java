import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
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
        List<Double> elems = new ArrayList<>();

        elems.add(1.0);
        elems.add(2.0);
        elems.add(3.0);
        elems.add(4.0);
        elems.add(5.0);

        Double middleElem = ListUtility.findMiddleValue(elems);
        assertTrue(Math.abs(Math.abs(middleElem) - 3) < 0.001);
    }

    @Test
    public void testNullInParams() throws Exception {
        List<Integer> searchElems = ListUtility.filter(null, new Predicate<Integer>() {
            @Override
            public boolean checkCondition(Integer obj) {
                return (obj % 2) == 0;
            }
        });
        Double middleElem = ListUtility.findMiddleValue(null);

        assertTrue(searchElems.size() == 0);
        assertTrue(Math.abs(Math.abs(middleElem) - 0) < 0.001);
    }
}