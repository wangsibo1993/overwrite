package collection.set;

import collection.AbstractCollection;
import collection.Iterator;

/**
 * Created by sibo.wang on 2017/8/23.
 */
public abstract class AbstractSet<T> extends AbstractCollection<T> implements Set<T>{

    protected AbstractSet () {
    }

    public boolean equals(Object object) {
        if(object == this) {
            return true;
        } else {
            if(!(object instanceof Set)){
                return false;
            } else {
                Set<T> set = (Set<T>)object;
                int size = set.size();
                if(size != size()) {
                    return false;
                } else {
                    try {
                        return containsAll(set);
                    } catch (NullPointerException npe) {
                        return false;
                    } catch (ClassCastException cce) {
                        return false;
                    }
                }
            }
        }
    }

    public int hashCode() {
        int hashCode = 0;
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            T object = iterator.next();
            hashCode += object.hashCode();
        }
        return hashCode;
    }
}
