import java.util.*;

public class ListUtility {

    public static <T> ArrayList<T> filter(List<? extends T> elems, Predicate<? super T> pred) {
        if (elems == null) {
            return null;
        }
        ArrayList<T> foundItems = new ArrayList();

        for (T item : elems) {
            if (pred.checkCondition(item)) {
                foundItems.add(item);
            }
        }
        return (ArrayList)foundItems.clone();
    }

    public static <T> T findMiddleValue(Collection<T> elems, SearchMiddleValue<T> smv) {
        if (elems == null) {
            return null;
        }
        return smv.find(elems);
    }
}
