package collection.map;


import collection.Iterator;
import collection.set.Set;

/**
 * Created by sibo.wang on 17/7/26.
 */
public abstract class AbstractMap<K,V> implements Map<K,V>{

    protected AbstractMap () {

    }

    public abstract Set<Entry<K,V>> entrySet();

    public int size() {
        return entrySet().size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsKey(K key) {
        Iterator<Entry<K,V>> iterator = entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<K,V> entry = iterator.next();
            if(key == null) {
                if(entry.getKey() == null) {
                    return true;
                }
            } else {
                if(key.equals(entry.getKey())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsValue(V value) {
        Iterator<Entry<K,V>> iterator = entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<K,V> entry = iterator.next();
            if(value == null) {
                if(entry.getValue() == null) {
                    return true;
                }
            } else {
                if(value.equals(entry.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    public V put(K key,V value) {
        throw new UnsupportedOperationException();
    }

    public void putAll(Map<? extends K,? extends V> map) {
        Iterator<? extends Entry<? extends K, ? extends V>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<? extends K,? extends V> entry = iterator.next();
            put(entry.getKey(),entry.getValue());
        }
    }

    public V get(K key) {
        Iterator<Entry<K,V>> iterator = entrySet().iterator();
        if(key == null) {
            while (iterator.hasNext()) {
                Entry<K,V> entry = iterator.next();
                K entryKey = entry.getKey();
                if(entryKey == null) {
                    return entry.getValue();
                }
            }
        } else {
            while (iterator.hasNext()) {
                Entry<K,V> entry = iterator.next();
                K entryKey = entry.getKey();
                if(key.equals(entryKey)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public boolean equals(Object object) {
        if(!(object instanceof Map)) {
            return false;
        } else {
            Map<K,V> map = (Map)object;
            Iterator<Entry<K,V>> iterator = entrySet().iterator();
            while (iterator.hasNext()) {
                Entry<K,V> entry = iterator.next();
                K key = entry.getKey();
                V value = entry.getValue();
                if(!map.containsKey(key)) {
                    return false;
                } else {
                    if(!value.equals(map.get(key))) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }
            return true;
        }
    }

}