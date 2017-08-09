package collection;

/**
 * Created by sibo.wang on 17/7/26.
 */
public interface Collection<T> extends Iterable<T> {

    int size();

    boolean isEmpty();

    boolean contain(T object);

    boolean containAll(Collection<T> collection);

    Object[] toArray();

    T[] toArray(T[] targetArray);

    boolean add(T object);

    boolean addAll(Collection<? extends T> collection);

    boolean remove(T object);

    boolean removeAll(Collection<?> collection);

    boolean retainAll(Collection<T> collection);

    void clear();

    boolean equals(Object object);
}
