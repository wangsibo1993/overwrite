package collection.map;

import collection.Collection;
import collection.set.Set;

/**
 * Created by sibo.wang on 17/7/26.
 */
public interface Map<K,V> {
    int size();

    boolean isEmpty();

    K getKey();

    V getValue();

    V put(K key,V value);

    void putAll(Map<? extends K,? extends V> map);

    boolean containsKey(K key);

    boolean containsValue(V value);

    V remove(K key);

    void clear();

    Collection<V> values();

    Set<Entry<K,V>> entrySet();

    Set<K> keySet();

    boolean equals(Object o);

    int hashCode();
    interface Entry<K,V> {

        K getKey();

        V getValue();

        V setValue(V value);

        boolean equals(Object o);

        int hashCode();
    }
}
