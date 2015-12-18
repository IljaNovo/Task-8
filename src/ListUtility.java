import java.util.*;

public class ListUtility {

    public static <T> List<T> filter(List<? extends T> elems, Predicate<? super T> pred) {
        if (elems == null) {
            return new ArrayList<T>();
        }
        List<T> foundItems = new ArrayList();

        for (T item : elems) {
            if (pred.checkCondition(item)) {
                foundItems.add(item);
            }
        }
        return foundItems;
    }

    public static Double findMiddleValue(Collection<Double> elems) {
        if (elems == null) {
            return 0.0;
        }
        Double sum = 0.0;

        for (Double item : elems) {
            sum += item;
        }
        return sum / elems.size();
    }
}


