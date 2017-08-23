package collection.set;

import collection.Collection;
import collection.Iterator;


/**
 * Created by sibo.wang on 2017/7/27.
 */
public interface Set<T> extends Collection<T> {

    int size();

    boolean isEmpty();

    Iterator<T> iterator();

    boolean contain(T object);

    boolean containAll(Collection<T> collection);

    boolean retainAll(Collection<T> collection);

    boolean add(T object);

    boolean addAll(Collection<? extends T> collection);

    boolean remove(T object);

    boolean removeAll(Collection<T> collection);

    boolean equals(Object object);

    void clear();

    int hashCode();

}
