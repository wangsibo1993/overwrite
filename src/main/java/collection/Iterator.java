package collection;

/**
 * Created by sibo.wang on 17/7/26.
 */
public interface Iterator<T> {

    boolean hasNext();

    T next();

    void remove();
}
