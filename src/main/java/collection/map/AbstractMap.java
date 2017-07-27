package collection.map;

import java.util.Set;

/**
 * Created by sibo.wang on 17/7/26.
 */
public abstract class AbstractMap<K,V> implements Map<K,V>{

    public abstract Set<Entry<K,V>> entrySet();


    public int size() {
        return entrySet().size();
    }
}
