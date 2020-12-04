package Practice_25_26;

import java.util.ArrayList;

public interface HashMapInterface<K,V> extends Iterable<ArrayList<Node<K, V>>> {
    void add(K key, V value);
    V get(K key);
    V remove(K key);
}
