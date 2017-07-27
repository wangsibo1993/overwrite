package collection.map;

/**
 * Created by sibo.wang on 17/7/26.
 */
public interface Map<K,V> {

    interface Entry<K,V> {

        K getKey();

        V getValue();

        V setValue(V value);

        boolean equals(Object o);

        int hashCode();
    }
}
