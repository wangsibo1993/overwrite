package collection;

/**
 * Created by sibo.wang on 2017/8/8.
 */
public interface ListIterator<T> extends Iterator<T>{

    boolean hasNext();

    boolean hasPrevious();

    T next();

    T previous();

    int nextIndex();

    int previousIndex();

    void add();

    void remove();

    void set();
}
