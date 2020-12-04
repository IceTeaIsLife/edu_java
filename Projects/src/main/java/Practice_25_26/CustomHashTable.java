package Practice_25_26;

import java.util.ArrayList;
import java.util.Iterator;

public class CustomHashTable<K, V> implements HashMapInterface<K, V> {
    private final int size = 64;
    private ArrayList<ArrayList<Node<K, V>>> table = new ArrayList<>();

    public CustomHashTable()
    {
        for (int i = 0; i < size; i++) {
            table.add(new ArrayList<>());
        }
    }

    @Override
    public void add(K key, V value) {
        int index = key.hashCode() % size;
        Node<K, V> node = new Node<>(key, value);
        if (table.get(index).isEmpty()) {
            table.get(index).add(node);
            return;
        }
        for (int i = 0; i < table.get(index).size(); i++) //прогон отдельного списка
        {
            if (table.get(index)
                    .get(i)
                    .getKey()
                    .equals(key)
            ) {
                table.get(index).set(i, node);            //замена
            } else {
                table.get(index).add(node);
            }
        }
    }


    @Override
    public V get(K key) {
        int index = key.hashCode() % table.size();
        if (!table.get(index).isEmpty()) {
            for (int i = 0; i < table.get(index).size(); i++) //прогон отдельного списка
            {
                if (table.get(index)
                        .get(i)
                        .getKey()
                        .equals(key)
                ) {
                    return table.get(index).get(i).getValue();
                }
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = key.hashCode() % table.size();
        if (!table.get(index).isEmpty()) {
            for (int i = 0; i < table.get(index).size(); i++) //прогон отдельного списка
            {
                if (table.get(index)
                        .get(i)
                        .getKey()
                        .equals(key)
                ) {
                    V value = table.get(index).get(i).getValue();
                    table.get(index).remove(i);
                    return value;
                }
            }
        }
        return null;
    }

    @Override
    public Iterator<ArrayList<Node<K, V>>> iterator() {
        return new CustomIterator<ArrayList<Node<K, V>>>(this.table);
    }

    private class CustomIterator<T> implements Iterator<ArrayList<Node<K, V>>> {
        private int currentIndex;
        private ArrayList<ArrayList<Node<K, V>>> table;

        CustomIterator(ArrayList<ArrayList<Node<K, V>>> table) {
            this.table = table;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < table.size();
        }

        @Override
        public ArrayList<Node<K, V>> next() {
            return table.get(currentIndex++);
        }
    }
}
