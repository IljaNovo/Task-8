import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DemoProject {

    public static void main(String[] args) {
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
        System.out.format("Middle elem %d%n", middleElem);

        List<Integer> answer = ListUtility.filter(elems, new Predicate<Integer>() {

            @Override
            public boolean checkCondition(Integer obj) {
                return (obj % 2) == 0;
            }
        });
        int indexItem = 0;

        for (Integer item : answer) {
            System.out.format("Elem %d: %d%n", ++indexItem, item);
        }
    }
}
