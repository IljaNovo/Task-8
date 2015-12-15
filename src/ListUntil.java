import java.util.*;

public class ListUntil {

    public static <T> ArrayList<T> filter(List<? extends T> list, Predicate<? super T> pred) {
        ArrayList<T> foundItems = new ArrayList();

        for (T item : list) {
            if (pred.checkCondition(item)) {
                foundItems.add(item);
            }
        }
        return (ArrayList)foundItems.clone();
    }
}
