package structures;
import java.util.Iterator;

// Defines all methods that lists must implement
public interface MyList<T> extends Iterable<T>{
    void add( T element);
    T get(int index);
    T remove(int index);
    int size();
    boolean isEmpty();
}
