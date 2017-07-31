package collection;


import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by sibo.wang on 2017/7/27.
 */
public abstract class AbstractCollection<T> implements Collection<T>{

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    protected AbstractCollection() {

    }

    public boolean isEmpty() {
        return 0 == size();
    }

    public boolean contain(T object) {
        if(object == null) {
            return false;
        } else {
            Iterator<T> iterator = iterator();
            while (iterator.hasNext()) {
                if(object.equals(iterator.next())) {
                    return true;
                }
            }
            return false;
        }
    }

    public Object[] toArray() {
        Object[] array = new Object[size()];
        Iterator<T> iterator = iterator();
        for (int i = 0; i < size(); i++) {
            if (iterator.hasNext()) {
                array[i] = iterator.next();
            } else {
                return Arrays.copyOf(array, i);
            }
        }
        return iterator.hasNext() ? finishToArray((T[]) array, iterator) : array;
    }

    public T[] toArray(T[] targetArray) {
        int targetLength = targetArray.length;
        int size = size();
        T[] array = targetLength >= size ? targetArray : (T[]) Array.newInstance(targetArray.getClass().getComponentType(),size);
        Iterator<T> iterator = iterator();

        for (int i = 0; i < size; i++) {
            if(!iterator.hasNext()) {
                if(array == targetArray) {
                    //TODO 没理解后续内容
                    array[i] = null;
                } else if(targetLength < i) {
                    return Arrays.copyOf(array,i);
                } else {
                    System.arraycopy(array,0,targetArray,0,i);
                    if(targetLength > i) {
                        array[i] = null;
                    }
                }
                return targetArray;
            } else {
                array[i] = iterator.next();
            }
        }
        return null;
    }


    public boolean remove(T object) {
        if(object == null) {
            return false;
        } else {
            Iterator<T> iterator = iterator();
            while (iterator.hasNext()) {
                if(object.equals(iterator.next())) {
                    iterator.remove();
                    return true;
                }
            }
            return false;
        }
    }

    private static <T> T[] finishToArray(T[] array, Iterator<T> iterator) {
        int length = array.length;

        while (iterator.hasNext()) {
            int cap = array.length;
            if(cap == length) {
                int newCap = cap + cap >> 1 + 1;
                if(newCap > MAX_ARRAY_SIZE) {
                    newCap = hugeCapacity(newCap);
                }
                Arrays.copyOf(array,newCap);
                length = array.length;
            }
            array[length++] = iterator.next();
        }
        return array;
    }

    private static int hugeCapacity(int capacity) {
        if(capacity < 0) {
            throw new OutOfMemoryError("capacity can not be negative number");
        } else {
            return capacity > MAX_ARRAY_SIZE ? Integer.MAX_VALUE : capacity;
        }
    }
}