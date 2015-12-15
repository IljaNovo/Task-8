import java.util.Collection;

public interface SearchMiddleValue<T> {
    public T find(Collection<T> elems);
}