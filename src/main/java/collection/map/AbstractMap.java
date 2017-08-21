package collection.map;


import collection.Iterator;
import collection.set.Set;

import java.io.Serializable;

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

    public V remove(K key) {
        V oldValue;
        Iterator<Entry<K,V>> iterator = entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<K,V> entry = iterator.next();
            K currentKey = entry.getKey();
            if(key == null) {
                if(currentKey == null) {
                    oldValue = entry.getValue();
                    iterator.remove();
                    return oldValue;
                }
            } else {
                if(key.equals(currentKey)) {
                    oldValue = entry.getValue();
                    iterator.remove();
                    return oldValue;
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

    public int hashCode() {
        int hashCode = 0;
        Iterator<Entry<K,V>> iterator = entrySet().iterator();
        while (iterator.hasNext()) {
            hashCode += iterator.next().hashCode();
        }
        return hashCode;
    }

    public class SimplyEntry<K,V> implements Entry<K,V>,Serializable{

        private static final long serialVersionUID = 7868506522601365820L;

        private final K key;

        private V value;

        public SimplyEntry(K key,V value) {
            this.key = key;
            this.value = value;
        }

        public SimplyEntry(Entry<? extends K,? extends V> entry) {
            this.key = entry.getKey();
            this.value = entry.getValue();
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        /**
         * @param value
         * @return oldValue
         */
        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        public boolean equals(Object object) {
            if(!(object instanceof Entry)) {
                return false;
            } else {
                Entry<K,V> entry = (Entry<K,V>) object;
                return eq(entry.getKey(),this.key) && eq(entry.getValue(),this.value);
            }
        }

        public int hashCode() {
            return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
        }

        public String toString() {
            return key + "=" +value;
        }

    }

    public class SimplyImmutableEntry<K,V> implements Entry<K,V> , Serializable{

        private static final long serialVersionUID = 6242472238239092643L;

        private K key;

        private V value;

        public SimplyImmutableEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public SimplyImmutableEntry(Entry<? extends K,? extends V> entry) {
            this.key = entry.getKey();
            this.value = entry.getValue();
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            throw new UnsupportedOperationException();
        }

        public boolean equals(Object object) {
            if(!(object instanceof Map)) {
                return false;
            } else {
                Entry<K,V> entry = (Entry<K,V>)object;
                return (eq(key,entry.getKey()) && eq(value,entry.getValue()));
            }
        }

        public int hashCode() {
            return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
        }

        public String toString() {
            return key + "=" + value;
        }
    }

    private boolean eq(Object object1,Object object2) {
        if(object1 == null) {
            return object2 == null;
        } else {
            return object1.equals(object2);
        }
    }

}